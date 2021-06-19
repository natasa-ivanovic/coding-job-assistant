package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;

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

import ftn.sbnz.events.InvalidLoginEvent;
import ftn.sbnz.events.UserLoginStatusEvent;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.user.JobSeekerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CEPAccountStatusTests {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;
	
	@Test 
	public void invalidPasswordThreeTimes() {
		KieSession session = setupSession();
		SessionPseudoClock clock = session.getSessionClock();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();
		
		
		for (int i = 0 ; i != 2; i++) {
			InvalidLoginEvent event = new InvalidLoginEvent(js.getId());
			session.insert(event);
			session.getAgenda().getAgendaGroup("user-login-check").setFocus();
			int firedRules = session.fireAllRules();
			assertEquals(0, firedRules);
			clock.advanceTime(5, TimeUnit.MINUTES);
		}

		UserLoginStatusEvent loginEvent = new UserLoginStatusEvent(js.getId());
		InvalidLoginEvent event = new InvalidLoginEvent(js.getId());
		session.insert(event);
		session.insert(loginEvent);
		session.getAgenda().getAgendaGroup("user-login-check").setFocus();
		int firedRules = session.fireAllRules();
		assertEquals(1, firedRules);
		
		assertEquals(false, loginEvent.isAllowed());
	}

	@Test 
	public void invalidPasswordTwoTimes() {
		KieSession session = setupSession();
		SessionPseudoClock clock = session.getSessionClock();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();
		
		
		for (int i = 0 ; i != 2; i++) {
			InvalidLoginEvent event = new InvalidLoginEvent(js.getId());
			session.insert(event);
			session.getAgenda().getAgendaGroup("user-login-check").setFocus();
			int firedRules = session.fireAllRules();
			assertEquals(0, firedRules);
			clock.advanceTime(5, TimeUnit.MINUTES);
		}

		UserLoginStatusEvent loginEvent = new UserLoginStatusEvent(js.getId());
		session.insert(loginEvent);
		session.getAgenda().getAgendaGroup("user-login-check").setFocus();
		int firedRules = session.fireAllRules();
		assertEquals(1, firedRules);
		
		assertEquals(true, loginEvent.isAllowed());
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
