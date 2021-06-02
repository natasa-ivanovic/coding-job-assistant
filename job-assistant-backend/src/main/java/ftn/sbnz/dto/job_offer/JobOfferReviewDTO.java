package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.job_offer.JobOfferReview;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferReviewDTO {

	private Long offerId;
	private int rating;
	private String content;
	private float salary;
	private boolean hired;
	private boolean jobOffered;
	private boolean recommends;
	private int interviewComplexity;
	private int ratedUseful;
	private int ratedNotUseful;
	
	public JobOfferReviewDTO(JobOfferReview review) {
		this.offerId = review.getJobOffer().getId();
		this.rating = review.getRating();
		this.content = review.getContent();
		this.salary = review.getSalary();
		this.hired = review.isHired();
		this.jobOffered = review.isJobOffered();
		this.recommends = review.isRecommends();
		this.interviewComplexity = review.getInterviewComplexity();
		this.ratedUseful = review.getRatedUseful();
		this.ratedNotUseful = review.getRatedNotUseful();
	}
}
