package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.company.CompanyReviewDTO;
import ftn.sbnz.events.UserAccountStatusEvent;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.company.CompanyReviewRepository;

@Service
public class CompanyReviewService {

	private CompanyReviewRepository repository;
	private JobOfferService offerService;
	private CompanyService companyService;
	private UserService userService;
	private KieSessionService kieSession;

	@Autowired
	public CompanyReviewService(CompanyReviewRepository repository, UserService userService,
			CompanyService companyService, JobOfferService offerService, KieSessionService kieSession) {
		this.repository = repository;
		this.userService = userService;
		this.kieSession = kieSession;
		this.companyService = companyService;
		this.offerService = offerService;
	}

	public void create(CompanyReviewDTO dto, JobSeeker jobSeeker) throws Exception {
		if (!userAllowedToReview(jobSeeker.getId()))
			throw new Exception("User blocked from reviewing due to too many declined reviews!");
		JobSeeker dbJobSeeker = (JobSeeker) userService.findByUsername(jobSeeker.getUsername());
		Calendar rightNow = Calendar.getInstance();
		Company company = companyService.getOne(dto.getCompanyId());
		CompanyReview review = new CompanyReview(dto, dbJobSeeker, company, new Timestamp(rightNow.getTimeInMillis()));
		repository.save(review);
	}

	public void approve(Long id) throws Exception {
		CompanyReview review = repository.getOne(id);
		if (!review.getStatus().equals(ReviewStatus.PENDING))
			throw new Exception("Review already accepted or declined!");
		review.setStatus(ReviewStatus.APPROVED);
		review = repository.save(review);

		executeSession(review);
	}

	public void decline(Long id) throws Exception {
		CompanyReview review = repository.getOne(id);
		if (!review.getStatus().equals(ReviewStatus.PENDING))
			throw new Exception("Review already accepted or declined!");
		review.setStatus(ReviewStatus.DECLINED);
		review = repository.save(review);

		executeSession(review);
	}

	private void executeSession(CompanyReview review) {
		kieSession.insert(review);
		kieSession.setAgendaFocus("job-offer-status");
		kieSession.setAgendaFocus("company-status");
		kieSession.setAgendaFocus("company-review-added");
		kieSession.fireAllRules();

		Company updated = companyService.updateDBFromRule(review.getCompany());
		if (updated != null)
			offerService.updateDBFromRule(updated);
	}

	private boolean userAllowedToReview(Long jobSeekerId) {
		UserAccountStatusEvent fact = new UserAccountStatusEvent(jobSeekerId);
		kieSession.insert(fact);
		kieSession.setAgendaFocus("user-account-status-check");
		kieSession.fireAllRules();
		return fact.isAllowed();
	}

	public List<CompanyReviewDTO> getAll() {
		List<CompanyReview> reviews = repository.findAll();
		return reviews.stream().map(this::toDTO).collect(Collectors.toList());
	}

	private CompanyReviewDTO toDTO(CompanyReview review) {
		return new CompanyReviewDTO(review);
	}
}
