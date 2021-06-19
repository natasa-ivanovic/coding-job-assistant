package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

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

import ftn.sbnz.events.DisabledUserEvent;
import ftn.sbnz.events.MaliciousReviewerEvent;
import ftn.sbnz.events.UserAccountStatusEvent;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.user.JobSeekerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CEPAccountStatusTests {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;
	
	@Test 
	public void userBanned() {
		KieSession session = setupSession();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();
		DisabledUserEvent event = new DisabledUserEvent(js.getId());
		session.insert(event);
		UserAccountStatusEvent statusEvent = new UserAccountStatusEvent(js.getId());		
		session.insert(statusEvent);	
		
		session.getAgenda().getAgendaGroup("user-account-status-check").setFocus();
		int firedRules = session.fireAllRules();
		assertEquals(1, firedRules);
		
		assertEquals(true, statusEvent.isBanned());
		assertEquals(false, statusEvent.isAllowed());
	}

	@Test 
	public void userReviewNotAllowed() {
		KieSession session = setupSession();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		MaliciousReviewerEvent event = new MaliciousReviewerEvent(js.getId());
		session.insert(event);
		UserAccountStatusEvent statusEvent = new UserAccountStatusEvent(js.getId());	
		session.insert(statusEvent);

		session.getAgenda().getAgendaGroup("user-account-status-check").setFocus();
		int firedRules = session.fireAllRules();
		assertEquals(1, firedRules);
		
		assertEquals(false, statusEvent.isBanned());
		assertEquals(false, statusEvent.isAllowed());
	}
	

	@Test 
	public void userAllowed() {
		KieSession session = setupSession();

		List<JobSeeker> seekers = jobSeekerRepo.findAll();
		for (JobSeeker js : seekers) {
			session.insert(js);
		}

		JobSeeker js = jobSeekerRepo.findById(2L).get();

		UserAccountStatusEvent statusEvent = new UserAccountStatusEvent(js.getId());	
		session.insert(statusEvent);

		session.getAgenda().getAgendaGroup("user-account-status-check").setFocus();
		int firedRules = session.fireAllRules();
		assertEquals(1, firedRules);
		
		assertEquals(false, statusEvent.isBanned());
		assertEquals(true, statusEvent.isAllowed());
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
