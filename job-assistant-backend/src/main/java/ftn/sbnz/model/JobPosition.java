package ftn.sbnz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Column(name = "subtitle", unique = false, nullable = false)
	@NonNull
	private String subtitle; 
	
	@OneToMany
	private Set<ProgrammingImportance> programmingImportances;

	@OneToMany
	private Set<KnowledgeImportance> knowledgeImportances;

	@OneToMany
	private Set<TechnologyImportance> technologyImportances;
}
