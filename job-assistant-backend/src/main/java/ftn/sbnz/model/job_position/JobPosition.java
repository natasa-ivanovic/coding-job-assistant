package ftn.sbnz.model.job_position;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ftn.sbnz.model.knowledge.Knowledge;
import ftn.sbnz.model.programming_language.ProgrammingLanguage;
import ftn.sbnz.model.technology.Technology;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_positions")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", unique = false, nullable = false)
	@NonNull
	private String title;
	
	@ManyToMany
	private Set<ProgrammingLanguage> programmingLanguages;

	@ManyToMany
	private Set<Knowledge> knowledge;

	@ManyToMany
	private Set<Technology> technologies;
}
