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

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobOfferRulesTests {
	@Autowired
	private JobSeekerRepository jobSeekerRepo;

	@Autowired
	private JobOfferRepository jobOfferRepo;

	@Autowired
	private JobPositionRepository jobPositionRepo;

	@Test
	public void jobOfferRequest() {
		KieSession session = setupSession();

		List<JobSeeker> jobSeekers = jobSeekerRepo.findAll();
		for (JobSeeker js : jobSeekers) {
			session.insert(js);
		}

		assertEquals(1, jobSeekers.size());

		List<JobOffer> offers = jobOfferRepo.findAll();
		for (JobOffer jo : offers) {
			session.insert(jo);
		}

		List<JobPosition> positions = jobPositionRepo.findAll();
		for (JobPosition jp : positions) {
			session.insert(jp);
		}

		JobSeeker jobSeeker = jobSeekerRepo.findById(2L).get();
		assertNotNull(jobSeeker);

		// job positions
		Calendar rightNow = Calendar.getInstance();
		JobPositionSuggestion suggestion = new JobPositionSuggestion(new Timestamp(rightNow.getTimeInMillis()),
				jobSeeker);
		session.insert(suggestion);

		session.getAgenda().getAgendaGroup("jps-p4").setFocus();
		session.getAgenda().getAgendaGroup("jps-p3").setFocus();
		session.getAgenda().getAgendaGroup("jps-p2").setFocus();
		session.getAgenda().getAgendaGroup("jps-p1").setFocus();

		session.fireAllRules();

		// job offers
		rightNow = Calendar.getInstance();
		JobOfferSuggestion offerSuggestion = new JobOfferSuggestion(new Timestamp(rightNow.getTimeInMillis()),
				jobSeeker);

		session.insert(offerSuggestion);
		session.getAgenda().getAgendaGroup("jos-p7").setFocus();
		session.getAgenda().getAgendaGroup("jos-p6").setFocus();
		session.getAgenda().getAgendaGroup("jos-p5").setFocus();
		session.getAgenda().getAgendaGroup("jos-p4").setFocus();
		session.getAgenda().getAgendaGroup("jos-p3").setFocus();
		session.getAgenda().getAgendaGroup("jos-p2").setFocus();
		session.getAgenda().getAgendaGroup("jos-p1").setFocus();

		int firedRules = session.fireAllRules();

		// 38 rules fired for this example
		assertEquals(38, firedRules);
		assertEquals(3, offerSuggestion.getOfferRatings().size());

		// sort descending
		List<JobOfferRating> sortedRatings = offerSuggestion.getOfferRatings().stream()
				.sorted((item1, item2) -> Long.compare(item2.getRating(), item1.getRating()))
				.collect(Collectors.toList());

		// first is 89 - Backend Developer
		assertEquals(89, sortedRatings.get(0).getRating());
		assertEquals("Backend Developer", sortedRatings.get(0).getJobOffer().getPosition().getTitle());
		
		// second is 59 - Backend Developer
		assertEquals(59, sortedRatings.get(1).getRating());
		assertEquals("Backend Developer", sortedRatings.get(1).getJobOffer().getPosition().getTitle());

		// first is -6 - Frontend Developer
		assertEquals(-6, sortedRatings.get(2).getRating());
		assertEquals("Frontend Developer", sortedRatings.get(2).getJobOffer().getPosition().getTitle());

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
