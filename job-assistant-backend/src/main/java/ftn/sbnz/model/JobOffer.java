package ftn.sbnz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_offers")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOffer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "seniority", unique = false, nullable = false)
	@NonNull
	private SeniorityLevel seniority;

	@Column(name = "rank", unique = false, nullable = false)
	@NonNull
	private MedalRank medal;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private JobPosition position;
	
	@OneToMany
	private Set<ProgrammingImportance> programmingImportances;

	@OneToMany
	private Set<KnowledgeImportance> knowledgeImportances;

	@OneToMany
	private Set<TechnologyImportance> technologyImportances;

	@OneToMany
	private Set<SoftSkillImportance> softSkillImportances;

	@OneToMany
	private Set<LanguageImportance> languageImportances;
	
	@OneToMany
	private Set<JobOfferReview> reviews;
	
	@OneToMany
	private Set<JobSeekerRanking> rankings;
}
