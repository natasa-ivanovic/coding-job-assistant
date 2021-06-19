package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobPositionRulesTests {
	@Autowired
	private JobSeekerRepository jobSeekerRepo;

	@Autowired
	private JobPositionRepository jobPositionRepo;

	@Test
	public void jobPositionsRequest() {
		KieSession session = setupSession();

		List<JobSeeker> jobSeekers = jobSeekerRepo.findAll();
		for (JobSeeker js : jobSeekers) {
			session.insert(js);
		}

		assertEquals(1, jobSeekers.size());

		List<JobPosition> positions = jobPositionRepo.findAll();
		for (JobPosition jp : positions) {
			session.insert(jp);
		}
		assertEquals(25, positions.size());

		JobSeeker jobSeeker = jobSeekerRepo.findById(2L).get();

		assertNotNull(jobSeeker);

		Calendar rightNow = Calendar.getInstance();
		JobPositionSuggestion suggestion = new JobPositionSuggestion(new Timestamp(rightNow.getTimeInMillis()),
				jobSeeker);
		session.insert(suggestion);

		session.getAgenda().getAgendaGroup("jps-p4").setFocus();
		session.getAgenda().getAgendaGroup("jps-p3").setFocus();
		session.getAgenda().getAgendaGroup("jps-p2").setFocus();
		session.getAgenda().getAgendaGroup("jps-p1").setFocus();

		int firedRules = session.fireAllRules();

		// 40 rules fired for this example
		assertEquals(40, firedRules);
		assertEquals(4, suggestion.getPositionRatings().size());

		// sort ascending
		List<JobPositionRating> sortedRatings = suggestion.getPositionRatings().stream()
				.sorted((item1, item2) -> Long.compare(item1.getRating(), item2.getRating()))
				.collect(Collectors.toList());
		// first is 79 - Frontend Developer - JavaScript
		assertEquals(79, sortedRatings.get(0).getRating());
		assertEquals("Frontend Developer", sortedRatings.get(0).getTitle());
		assertEquals("JavaScript", sortedRatings.get(0).getSubtitle());
		
		// second is 189 - Backend Developer - JavaScript
		assertEquals(189, sortedRatings.get(1).getRating());
		assertEquals("Backend Developer", sortedRatings.get(1).getTitle());
		assertEquals("JavaScript", sortedRatings.get(1).getSubtitle());
		
		// third is 199 - Backend Developer - Python
		assertEquals(199, sortedRatings.get(2).getRating());
		assertEquals("Backend Developer", sortedRatings.get(2).getTitle());
		assertEquals("Python", sortedRatings.get(2).getSubtitle());
		
		// fourth is 209 - Backend Devloper - Java
		assertEquals(209, sortedRatings.get(3).getRating());
		assertEquals("Backend Developer", sortedRatings.get(3).getTitle());
		assertEquals("Java", sortedRatings.get(3).getSubtitle());
		
		session.dispose();
	}

	private KieSession setupSession() {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kieContainer = kieServices.getKieClasspathContainer();
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.setGlobal("programmingLanguageCoefficient", new Integer(10));
		kieSession.setGlobal("technologyCoefficient", new Integer(8));
		kieSession.setGlobal("knowledgeCoefficient", new Integer(5));
		kieSession.setGlobal("monthsExperienceCoefficient", new Float(1));
		return kieSession;
	}
}
