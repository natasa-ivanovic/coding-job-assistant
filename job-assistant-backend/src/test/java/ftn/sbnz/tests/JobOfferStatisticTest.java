package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JobOfferStatisticTest {

	@Autowired
	private JobSeekerRepository jobSeekerRepo;

	@Autowired
	private JobOfferRepository jobOfferRepo;

	@Test
	public void statisticRequest() {
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

		JobSeeker jobSeeker = jobSeekerRepo.findById(2L).get();
		assertNotNull(jobSeeker);

		Calendar rightNow = Calendar.getInstance();
		JobOfferStatistic statistic = new JobOfferStatistic(new Timestamp(rightNow.getTimeInMillis()));
		statistic.setJobOffer(offers.get(0));
		statistic.setJobSeeker(jobSeeker);
		
		session.insert(statistic);
		session.getAgenda().getAgendaGroup("job-seeker-statistic").setFocus();

		int firedRules = session.fireAllRules();
		//11
		assertEquals(11, firedRules);
		
		//Backend Developer
		assertEquals("Backend Developer", statistic.getJobOffer().getPosition().getTitle());
		
		//KnowledgeDifferences - 4
		assertEquals(4, statistic.getKnowledgeDifferences().size());
		
		//ProgrammingDifferences - 1
		assertEquals(1, statistic.getProgrammingDifferences().size());
		
		//TechnologyDifferences - 3
		assertEquals(3, statistic.getTechnologyDifferences().size());
		
		//SoftSkillDifferences - 2
		assertEquals(2, statistic.getSoftSkillDifferences().size());
		
		//LanguageDifferences - 1
		assertEquals(1, statistic.getLanguageDifferences().size());
		
		
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
