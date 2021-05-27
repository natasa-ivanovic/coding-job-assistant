package ftn.sbnz.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ftn.sbnz.model.enums.EducationLevel;
import ftn.sbnz.model.job_offer.JobOfferReview;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.knowledge.KnowledgeProficiency;
import ftn.sbnz.model.language.LanguageProficiency;
import ftn.sbnz.model.programming_language.ProgrammingProficiency;
import ftn.sbnz.model.soft_skill.SoftSkillProficiency;
import ftn.sbnz.model.technology.TechnologyProficiency;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("USER")
@Data
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<TechnologyProficiency> technologyProficiencies;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<SoftSkillProficiency> softSkillProficiencies;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<ProgrammingProficiency> programmingProficiencies;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<LanguageProficiency> languageProficiencies;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<KnowledgeProficiency> knowledgeProficiencies;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<WorkingExperience> experience;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobOfferReview> reviews;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobOfferSuggestion> offerSuggestions;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobPositionSuggestion> positionSuggestions;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobSeekerRanking> offerRankings;
	
}
