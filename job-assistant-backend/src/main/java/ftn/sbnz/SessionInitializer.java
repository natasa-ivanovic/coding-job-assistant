package ftn.sbnz;

import java.util.List;

import org.springframework.context.ApplicationContext;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.job_offer.JobOfferReview;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.repository.company.CompanyRepository;
import ftn.sbnz.repository.job_offer.JobOfferReviewRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.service.KieSessionService;

public class SessionInitializer {
	public static void initializeSession(ApplicationContext context) {
		KieSessionService kieSession = context.getBean(KieSessionService.class);
		initializeGlobals(kieSession);
		addJobPositionsToContext(context, kieSession);
		addCompaniesToContext(context, kieSession);
		addOfferReviewsToContext(context, kieSession);
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
		}
	}
	
	private static void addCompaniesToContext(ApplicationContext context, KieSessionService session) {
		CompanyRepository repo = context.getBean(CompanyRepository.class);
		List<Company> companies = repo.findAll();
		for (Company c : companies) {
			session.insert(c);
		}
	}
	
	private static void addOfferReviewsToContext(ApplicationContext context, KieSessionService session) {
		JobOfferReviewRepository repo = context.getBean(JobOfferReviewRepository.class);
		List<JobOfferReview> list = repo.findAll();
		for (JobOfferReview r : list) {
			session.insert(r);
		}
	}
}
