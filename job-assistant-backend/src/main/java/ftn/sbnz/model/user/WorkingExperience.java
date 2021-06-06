package ftn.sbnz.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.knowledge.Knowledge;
import ftn.sbnz.model.programming_language.ProgrammingLanguage;
import ftn.sbnz.model.technology.Technology;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "working_experiences")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class WorkingExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "months", unique = false, nullable = false)
	private int months;
	
	@Column(name = "seniority", unique = false, nullable = false)
	@NonNull
	private SeniorityLevel seniority;
		
	@ManyToMany
	private Set<Technology> technologies = new HashSet<>();
	
	@ManyToMany
	private Set<ProgrammingLanguage> progLanguages = new HashSet<>();
	
	@ManyToMany
	private Set<Knowledge> knowledge = new HashSet<>();
	
	@ManyToOne
	private JobPosition position;
	
}
