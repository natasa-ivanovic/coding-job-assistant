package ftn.sbnz.model.knowledge;

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
@Table(name = "knowledge_importances")
@Data
@RequiredArgsConstructor
public class KnowledgeImportance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "optional", unique = false, nullable = false)
	private boolean optional;
	
	@Column(name = "importance", unique = false, nullable = false)
	private int importance;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "knowledge_proficiency_id", nullable = false, unique = false) 
	private KnowledgeProficiency knowledgeProficiency;

}
