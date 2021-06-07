package ftn.sbnz.model.interview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.model.job_offer.JobOfferDifference;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "interview_suggestion_status")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class InterviewSuggestionStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "checked", unique = false, nullable = false)
	private boolean checked;
	
	@Column(name = "dateSuggested", unique = false, nullable = false)
	@NonNull
	private Date dateSuggested;
	
	@Column(name = "dateChecked", unique = false)
	private Date dateChecked;
	
	@ManyToOne
	private JobSeeker jobSeeker;
	
	@ManyToOne
	private JobOfferDifference jobOfferDifference;
	
	@ManyToMany
	private List<InterviewSuggestion> interviewSuggestions = new ArrayList<>();

}
