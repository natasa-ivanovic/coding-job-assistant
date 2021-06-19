package ftn.sbnz.tests;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.job_offer.JobOfferReview;
import ftn.sbnz.repository.company.CompanyRepository;
import ftn.sbnz.util.SessionUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyStatusRulesTests {
	@Autowired
	private CompanyRepository companyRepo;

	@Test
	public void companyStatusBronze() {
		KieSession session = setupSession();

		List<Company> companies = companyRepo.findAll();
		for (Company c : companies) {
			session.insert(c);
		}

		assertEquals(7, companies.size());

		Company company = companyRepo.findById(1L).get();
		
		assertEquals("Levi9", company.getName());
		assertEquals(MedalRank.NONE, company.getMedal());
		
		List<JobOfferReview> reviews = createReviews(2, company);
		for (JobOfferReview r: reviews) {
			session.insert(r);
		}

		session.getAgenda().getAgendaGroup("company-status").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);
		
		company = SessionUtil.getCompanyFromSession(company, session);
		
		assertEquals(MedalRank.BRONZE, company.getMedal());

		session.dispose();
	}

	@Test
	public void companyStatusSilver() {
		KieSession session = setupSession();

		List<Company> companies = companyRepo.findAll();
		for (Company c : companies) {
			session.insert(c);
		}

		assertEquals(7, companies.size());

		Company company = companyRepo.findById(1L).get();
		
		assertEquals("Levi9", company.getName());
		assertEquals(MedalRank.NONE, company.getMedal());
		
		List<JobOfferReview> reviews = createReviews(3, company);
		for (JobOfferReview r: reviews) {
			session.insert(r);
		}

		session.getAgenda().getAgendaGroup("company-status").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(2, firedRules);
		
		company = SessionUtil.getCompanyFromSession(company, session);
		
		assertEquals(MedalRank.SILVER, company.getMedal());

		session.dispose();
	}

	@Test
	public void companyStatusGold() {
		KieSession session = setupSession();

		List<Company> companies = companyRepo.findAll();
		for (Company c : companies) {
			session.insert(c);
		}

		assertEquals(7, companies.size());

		Company company = companyRepo.findById(1L).get();
		
		assertEquals("Levi9", company.getName());
		assertEquals(MedalRank.NONE, company.getMedal());
		
		List<JobOfferReview> reviews = createReviews(5, company);
		for (JobOfferReview r: reviews) {
			session.insert(r);
		}

		session.getAgenda().getAgendaGroup("company-status").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(3, firedRules);
		
		company = SessionUtil.getCompanyFromSession(company, session);
		
		assertEquals(MedalRank.GOLD, company.getMedal());

		session.dispose();
	}
	

	@Test
	public void companyStatusBronzeInvalid() {
		KieSession session = setupSession();

		List<Company> companies = companyRepo.findAll();
		for (Company c : companies) {
			session.insert(c);
		}

		assertEquals(7, companies.size());

		Company company = companyRepo.findById(1L).get();
		
		assertEquals("Levi9", company.getName());
		assertEquals(MedalRank.NONE, company.getMedal());
		
		List<JobOfferReview> reviews = createBadReviews(5, company);
		for (JobOfferReview r: reviews) {
			session.insert(r);
		}

		session.getAgenda().getAgendaGroup("company-status").setFocus();
		int firedRules = session.fireAllRules();

		assertEquals(1, firedRules);
		
		company = SessionUtil.getCompanyFromSession(company, session);
		
		assertEquals(MedalRank.BRONZE, company.getMedal());

		session.dispose();
	}
	
	private List<JobOfferReview> createReviews(int numberOfReviews, Company company) {
		List<JobOfferReview> list = new ArrayList<>();
		for (long i = 0; i != numberOfReviews; i++) {
			JobOfferReview review = new JobOfferReview();
			review.setCompany(company);
			Calendar rightNow = Calendar.getInstance();
			review.setDate(new Timestamp(rightNow.getTimeInMillis()));
			review.setStatus(ReviewStatus.APPROVED);
			review.setJobOffered(true);
			review.setRecommends(true);
			review.setHired(true);
			review.setRating(5);
			review.setRatedUseful(15);
			review.setRatedNotUseful(0);
			review.setId(i);
			list.add(review);
		}
		return list;
	}

	private List<JobOfferReview> createBadReviews(int numberOfReviews, Company company) {
		List<JobOfferReview> list = new ArrayList<>();
		for (long i = 0; i != numberOfReviews; i++) {
			JobOfferReview review = new JobOfferReview();
			review.setCompany(company);
			Calendar rightNow = Calendar.getInstance();
			review.setDate(new Timestamp(rightNow.getTimeInMillis()));
			review.setStatus(ReviewStatus.APPROVED);
			review.setJobOffered(true);
			review.setRecommends(true);
			review.setHired(true);
			review.setRating(1);
			review.setRatedUseful(15);
			review.setRatedNotUseful(0);
			review.setId(i);
			list.add(review);
		}
		return list;
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
