package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.drools.core.time.SessionPseudoClock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ftn.sbnz.events.StudiedTodayEvent;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.user.JobSeekerRepository;
import ftn.sbnz.util.SessionUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CEPUserStudyTest {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;

	@Test
	public void studiedTwoAtSameTime() {
		KieSession session = setupSession();

		SessionPseudoClock clock = session.getSessionClock();

		long amount = LocalDateTime.now().toInstant(ZoneOffset.ofHours(2)).toEpochMilli() - clock.getCurrentTime();
		clock.advanceTime(amount, TimeUnit.MILLISECONDS);

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		session.insert(js);

		StudiedTodayEvent event = new StudiedTodayEvent(js.getId());

		StudiedTodayEvent event2 = new StudiedTodayEvent(js.getId());

		event.setDate(new Date(clock.getCurrentTime()));
		event.setEndDate(new Date(clock.getCurrentTime() + 10000));
		session.insert(event);

		clock.advanceTime(3, TimeUnit.SECONDS);

		event2.setDate(new Date(clock.getCurrentTime()));
		event2.setEndDate(new Date(clock.getCurrentTime() + 10000));

		session.insert(event2);

		session.getAgenda().getAgendaGroup("studied-today").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(StudiedTodayEvent.class, session);

		assertEquals(1, events.size());

		assertFalse(js.isContinuousLearning());

		session.dispose();
	}

	@Test
	public void studiedContinuous() {
		KieSession session = setupSession();

		SessionPseudoClock clock = session.getSessionClock();

		long amount = LocalDateTime.now().toInstant(ZoneOffset.ofHours(2)).toEpochMilli() - clock.getCurrentTime();
		clock.advanceTime(amount, TimeUnit.MILLISECONDS);

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		session.insert(js);

		for (int i = 0; i != 5; i++) {
			StudiedTodayEvent event = new StudiedTodayEvent(js.getId());
			event.setDate(new Date(clock.getCurrentTime()));
			event.setEndDate(new Date(clock.getCurrentTime() + 10000));

			session.insert(event);
			clock.advanceTime(20, TimeUnit.SECONDS);

		}
		session.getAgenda().getAgendaGroup("studied-today").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(StudiedTodayEvent.class, session);

		assertEquals(5, events.size());

		assertTrue(js.isContinuousLearning());

		session.dispose();
	}

	@Test
	public void studiedContinuousAndStopped() {
		KieSession session = setupSession();

		SessionPseudoClock clock = session.getSessionClock();

		long amount = LocalDateTime.now().toInstant(ZoneOffset.ofHours(2)).toEpochMilli() - clock.getCurrentTime();
		clock.advanceTime(amount, TimeUnit.MILLISECONDS);

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		session.insert(js);

		for (int i = 0; i != 5; i++) {
			StudiedTodayEvent event = new StudiedTodayEvent(js.getId());
			event.setDate(new Date(clock.getCurrentTime()));
			event.setEndDate(new Date(clock.getCurrentTime() + 10000));

			session.insert(event);
			clock.advanceTime(20, TimeUnit.SECONDS);

		}
		session.getAgenda().getAgendaGroup("studied-today").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);

		Collection<Object> events = SessionUtil.getObjectsFromSession(StudiedTodayEvent.class, session);

		assertEquals(5, events.size());

		assertTrue(js.isContinuousLearning());

		clock.advanceTime(1, TimeUnit.DAYS);

		firedRules = session.fireAllRules();

		assertEquals(1, firedRules);

		assertFalse(js.isContinuousLearning());

		session.dispose();
	}

	private KieSession setupSession() {
		KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
		config.setOption(ClockTypeOption.get("pseudo"));
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rulesSession", config);
		kieSession.setGlobal("programmingLanguageCoefficient", new Integer(10));
		kieSession.setGlobal("technologyCoefficient", new Integer(8));
		kieSession.setGlobal("knowledgeCoefficient", new Integer(5));
		kieSession.setGlobal("monthsExperienceCoefficient", new Float(1));
		return kieSession;
	}

}
