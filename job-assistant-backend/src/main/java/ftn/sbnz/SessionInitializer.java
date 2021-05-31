package ftn.sbnz;

import java.util.List;

import org.springframework.context.ApplicationContext;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.service.KieSessionService;

public class SessionInitializer {
	public static void initializeSession(ApplicationContext context) {
		KieSessionService kieSession = context.getBean(KieSessionService.class);
		initializeGlobals(kieSession);
		addJobPositionsToContext(context, kieSession);
		addJobOffersToContext(context, kieSession);
	}

	private static void initializeGlobals(KieSessionService session) {
		session.setGlobal("programmingLanguageCoefficient", new Integer(10));
		session.setGlobal("technologyCoefficient", new Integer(8));
		session.setGlobal("knowledgeCoefficient", new Integer(5));
		session.setGlobal("monthsExperienceCoefficient", new Float(1));
		
	}
	
	private static void addJobPositionsToContext(ApplicationContext context, KieSessionService session) {
		JobPositionRepository jobPositionRepo = context.getBean(JobPositionRepository.class);
		List<JobPosition> positions = jobPositionRepo.findAll();
		for (JobPosition jp : positions) {
			session.insert(jp);
//			System.out.println("Inserted Job Position " + jp.getTitle() + " into session.");
		}
	}
	
	private static void addJobOffersToContext(ApplicationContext context, KieSessionService session) {
		JobOfferRepository jobOfferRepo = context.getBean(JobOfferRepository.class);
		List<JobOffer> offers = jobOfferRepo.findAll();
		for (JobOffer jo : offers) {
			session.insert(jo);
		}
	}
}
