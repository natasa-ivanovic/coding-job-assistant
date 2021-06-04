package ftn.sbnz.model.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ftn.sbnz.model.enums.EducationLevel;
import ftn.sbnz.model.job_offer.JobOfferReview;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.knowledge.KnowledgeProficiency;
import ftn.sbnz.model.language.LanguageProficiency;
import ftn.sbnz.model.programming_language.ProgrammingProficiency;
import ftn.sbnz.model.soft_skill.SoftSkillProficiency;
import ftn.sbnz.model.technology.TechnologyProficiency;
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
	
	@ManyToMany
	private Set<TechnologyProficiency> technologyProficiencies = new HashSet<>();

	@ManyToMany
	private Set<SoftSkillProficiency> softSkillProficiencies = new HashSet<>();
	
	@ManyToMany
	private Set<ProgrammingProficiency> programmingProficiencies = new HashSet<>();
	
	@ManyToMany
	private Set<LanguageProficiency> languageProficiencies = new HashSet<>();
	
	@ManyToMany
	private Set<KnowledgeProficiency> knowledgeProficiencies = new HashSet<>();
	
	@OneToMany//(mappedBy = "jobSeeker")
	private Set<WorkingExperience> workingExperience = new HashSet<>();
	
	@OneToMany
	private Set<JobOfferReview> reviews = new HashSet<>();
	
	@OneToMany
	private List<JobOfferSuggestion> offerSuggestions = new ArrayList<>();
	
	@OneToMany
	private List<JobPositionSuggestion> positionSuggestions = new ArrayList<>();
	
	@OneToMany
	private List<JobSeekerRanking> offerRankings = new ArrayList<>();
	
	@OneToMany
	private List<JobOfferStatistic> statistics = new ArrayList<>();
}
