package ftn.sbnz.model.job_offer;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.dto.job_offer.JobOfferReviewDTO;
import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job_offer_reviews")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOfferReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rating", unique = false, nullable = false)
	private int rating;
	
	@Column(name = "content", unique = false, nullable = false)
	@NonNull
	private String content;
	
	@Column(name = "salary", unique = false, nullable = false)
	private float salary;
	
	@Column(name = "hired", unique = false, nullable = false)
	private boolean hired;
	
	@Column(name = "job_offered", unique = false, nullable = false)
	private boolean jobOffered;
	
	@Column(name = "interview_complexity", unique = false, nullable = false)
	private int interviewComplexity;
	
	@Column(name = "rated_useful", unique = false, nullable = false)
	private int ratedUseful;
	
	@Column(name = "rated_not_useful", unique = false, nullable = false)
	private int ratedNotUseful;
	
	@Column(name = "recommends", unique = false, nullable = false)
	private boolean recommends;
	
	@Column(name = "status", unique = false, nullable = false)
	private ReviewStatus status;

	@Column(name = "date")
	@NonNull
	private Timestamp date;
	
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "company_id", nullable = false, unique = false) 
	private Company company;
	
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "job_offer_id", nullable = false, unique = false) 
	private JobOffer jobOffer;
	
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "poster_id", nullable = false, unique = false) 
	private JobSeeker poster;
	
	public JobOfferReview(JobOfferReviewDTO dto, JobOffer offer, JobSeeker user, Timestamp time) {
		this.poster = user;
		this.jobOffer = offer;
		this.company = offer.getCompany();
		this.date = time;
		this.rating = dto.getRating();
		this.content = dto.getContent();
		this.salary = dto.getSalary();
		this.hired = dto.isHired();
		this.jobOffered = dto.isJobOffered();
		this.recommends = dto.isRecommends();
		this.interviewComplexity = dto.getInterviewComplexity();
		this.ratedUseful = dto.getRatedUseful();
		this.ratedNotUseful = dto.getRatedNotUseful();
		this.status = ReviewStatus.PENDING;
	}
}
