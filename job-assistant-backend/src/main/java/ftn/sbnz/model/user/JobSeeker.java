package ftn.sbnz.model.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ftn.sbnz.model.company.CompanyReview;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.EducationLevel;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("USER")
@Getter
@Setter
@NoArgsConstructor

public class JobSeeker extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "remote_work")
	private boolean remoteWork;
	
	@Column(name = "salary_expectation")
	private float salaryExpectation;
	
	@Column(name = "education")
	private EducationLevel education;
	
	@Column(name = "continuous_learning")
	private boolean continuousLearning;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CVElementProficiency> proficiencies = new HashSet<>();
	
	// nekada je bilo eager
	@OneToMany(fetch = FetchType.LAZY)
	private List<WorkingExperience> workingExperience = new ArrayList<>();
	
	@OneToMany(mappedBy = "poster")
	private List<CompanyReview> reviews = new ArrayList<>();
	
	@OneToMany
	private List<JobOfferSuggestion> offerSuggestions = new ArrayList<>();
	
	@OneToMany
	private List<JobPositionSuggestion> positionSuggestions = new ArrayList<>();
	
	@OneToMany
	private List<JobSeekerRanking> offerRankings = new ArrayList<>();
	
	@OneToMany
	private List<JobOfferStatistic> statistics = new ArrayList<>();
	
	@OneToMany
	private List<InterviewSuggestionStatus> interviewSuggestions = new ArrayList<>();
}
