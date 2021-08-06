package ftn.sbnz.model.cv_element;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cv_element_importances")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CVElementImportance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "importance_level", unique = false, nullable = false)
	private int importanceLevel;
	
	@Column(name = "optional", unique = false, nullable = false)
	private boolean optional;
	
	@ManyToOne
	@NonNull
	private CVElementProficiency proficiency;
	
	
	
}
