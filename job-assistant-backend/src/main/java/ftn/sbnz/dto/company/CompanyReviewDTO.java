package ftn.sbnz.dto.company;

import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.enums.ReviewStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyReviewDTO {
	private Long id;
//	private Long offerId;
//	private String offerName;
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
	
	public CompanyReviewDTO(CompanyReview review) {
		this.id = review.getId();
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
