package ftn.sbnz.model.job_offer;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.model.company.Company;
import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
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

	@Column(name = "date")
	@NonNull
	private Timestamp date;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private JobOffer jobOffer;
	
	@ManyToOne
	private JobSeeker poster;
}
