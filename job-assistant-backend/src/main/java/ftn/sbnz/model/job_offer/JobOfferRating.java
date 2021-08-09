                                          package ftn.sbnz.model.job_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.enums.JobOfferCategory;
import ftn.sbnz.model.interview.InterviewSuggestion;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_offer_ratings")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOfferRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rating", unique = false, nullable = false)
	private int rating;

	@Column(name = "description", unique = false, nullable = false, columnDefinition="TEXT")
	@NonNull
	private String description;
	
	@Column(name = "category", unique = false, nullable = false)
	private JobOfferCategory category;
	
	@ManyToOne
	private JobOffer jobOffer;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<InterviewSuggestion> interviewSuggestions;

	@OneToMany
	private List<JobOfferStatistic> statistic = new ArrayList<>();
	
}
