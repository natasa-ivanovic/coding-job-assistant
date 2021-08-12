package ftn.sbnz.model.company;

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

import ftn.sbnz.dto.company.CompanyReviewDTO;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company_reviews")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class CompanyReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rating", unique = false, nullable = false)
	private int rating;
	
	@Column(name = "content", unique = false, nullable = false)
	@NonNull
	private String content;

	@Column(name = "job_title", unique = false, nullable = false)
	@NonNull
	private String jobTitle;
	
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
	@JoinColumn(name = "poster_id", nullable = false, unique = false) 
	private JobSeeker poster;

	public CompanyReview(CompanyReviewDTO dto, JobSeeker poster, Company company, Timestamp date) {
		this.poster = poster;
		this.date = date;
		this.company = company;
		this.status = ReviewStatus.PENDING;
		this.rating = dto.getRating();
		this.content = dto.getContent();
		this.jobTitle = dto.getJobTitle();
		this.salary = dto.getSalary();
		this.hired = dto.isHired();
		this.jobOffered = dto.isJobOffered();
		this.interviewComplexity = dto.getInterviewComplexity();
		this.ratedUseful = dto.getRatedUseful();
		this.ratedNotUseful = dto.getRatedNotUseful();
		this.recommends = dto.isRecommends();
	}

}
