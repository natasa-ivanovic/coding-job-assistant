package ftn.sbnz.model.job_offer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.enums.CVElement;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import lombok.Data;

@Entity
@Table(name = "job_offer_difference")
@Data
public class JobOfferDifference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "subject", unique = false, nullable = false)
	private String subject;
	
	@Column(name = "user_proficiency", unique = false, nullable = false)
	private SkillProficiency userProficiency;
	
	@Column(name = "job_offer_proficiency", unique = false, nullable = false)
	private SkillProficiency jobOfferProficiency;
	
	@Column(name = "cv_element")
	private CVElement cvElement;
	
	@ManyToOne
	private JobOfferStatistic statistic; 
	
	@OneToMany
	private List<InterviewSuggestionStatus> interviewSuggestionStatuses = new ArrayList<>();

}
