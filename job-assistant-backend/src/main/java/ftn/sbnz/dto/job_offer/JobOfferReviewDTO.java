package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.job_offer.JobOfferReview;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferReviewDTO {
	private Long id;
	private Long offerId;
	private String offerName;
	private String companyName;
	private int rating;
	private String content;
	private String jobSeekerName;
	private String jobSeekerUsername;
	private float salary;
	private boolean hired;
	private boolean jobOffered;
	private boolean recommends;
	private int interviewComplexity;
	private int ratedUseful;
	private int ratedNotUseful;
	private ReviewStatus status;
	
	public JobOfferReviewDTO(JobOfferReview review) {
		this.id = review.getId();
		this.offerId = review.getJobOffer().getId();
		this.offerName = review.getJobOffer().getPosition().getTitle();
		this.companyName = review.getCompany().getName();
		this.rating = review.getRating();
		this.content = review.getContent();
		this.jobSeekerName = review.getPoster().getFullName();
		this.jobSeekerUsername = review.getPoster().getUsername();
		this.salary = review.getSalary();
		this.hired = review.isHired();
		this.jobOffered = review.isJobOffered();
		this.recommends = review.isRecommends();
		this.interviewComplexity = review.getInterviewComplexity();
		this.ratedUseful = review.getRatedUseful();
		this.ratedNotUseful = review.getRatedNotUseful();
		this.status = review.getStatus();
	}
}
