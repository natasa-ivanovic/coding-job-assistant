package ftn.sbnz;

import java.util.List;

import org.springframework.context.ApplicationContext;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.company.CompanyRepository;
import ftn.sbnz.repository.company.CompanyReviewRepository;
import ftn.sbnz.repository.interview.InterviewSuggestionRepository;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;
import ftn.sbnz.repository.user.WorkingExperienceRepository;
import ftn.sbnz.service.KieSessionService;

public class SessionInitializer {
	public static void initializeSession(ApplicationContext context) {
		KieSessionService kieSession = context.getBean(KieSessionService.class);
		compileTemplates(context, kieSession);
		initializeGlobals(kieSession);
		addJobSeekersToContext(context, kieSession);
		addJobPositionsToContext(context, kieSession);
		addCompaniesToContext(context, kieSession);
		addJobOffersToContext(context, kieSession);
		addCompanyReviewsToContext(context, kieSession);
		addInterviewSuggestionsToContext(context, kieSession);
	}

	private static void compileTemplates(ApplicationContext context, KieSessionService session) {
		WorkingExperienceRepository repo = context.getBean(WorkingExperienceRepository.class);
		session.compileTemplateWorkingExperience(repo.findAll());
	}
	
	private static void initializeGlobals(KieSessionService session) {
		session.setGlobal("programmingLanguageCoefficient", new Integer(10));
		session.setGlobal("technologyCoefficient", new Integer(8));
		session.setGlobal("knowledgeCoefficient", new Integer(5));
		session.setGlobal("monthsExperienceCoefficient", new Float(1));
	}

	private static void addJobSeekersToContext(ApplicationContext context, KieSessionService session) {
		JobSeekerRepository repo = context.getBean(JobSeekerRepository.class);
		List<JobSeeker> jobSeekers = repo.findAll();
		for (JobSeeker js : jobSeekers) {
			session.insert(js);
		}
	}
	
	private static void addJobPositionsToContext(ApplicationContext context, KieSessionService session) {
		JobPositionRepository repo = context.getBean(JobPositionRepository.class);
		List<JobPosition> positions = repo.findAll();
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
	
	private static void addJobOffersToContext(ApplicationContext context, KieSessionService session) {
		JobOfferRepository jobOfferRepo = context.getBean(JobOfferRepository.class);
		List<JobOffer> offers = jobOfferRepo.findAll();
		for (JobOffer jo : offers) {
			session.insert(jo);
		}
	}
	
	private static void addCompanyReviewsToContext(ApplicationContext context, KieSessionService session) {
		CompanyReviewRepository repo = context.getBean(CompanyReviewRepository.class);
		List<CompanyReview> list = repo.findAll();
		for (CompanyReview r : list) {
			session.insert(r);
		}
	}
	
	private static void addInterviewSuggestionsToContext(ApplicationContext context, KieSessionService session) {
		InterviewSuggestionRepository interviewSuggestionRepo = context.getBean(InterviewSuggestionRepository.class);
		List<InterviewSuggestion> suggestions = interviewSuggestionRepo.findAll();
		for (InterviewSuggestion is : suggestions) {
			session.insert(is);
		}
	}
}
