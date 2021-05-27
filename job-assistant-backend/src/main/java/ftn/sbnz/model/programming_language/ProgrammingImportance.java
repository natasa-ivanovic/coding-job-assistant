package ftn.sbnz.model.programming_language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "programming_importances")
@Data
@RequiredArgsConstructor
public class ProgrammingImportance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "optional", unique = false, nullable = false)
	private boolean optional;
	
	@Column(name = "importance", unique = false, nullable = false)
	private int importance;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "programming_proficiency_id", nullable = false, unique = false) 
	private ProgrammingProficiency programmingProficiency;
}
