package ftn.sbnz.model.cv_element;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.model.enums.SkillProficiency;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cv_element_proficiencies")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CVElementProficiency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "proficiency", unique = false, nullable = false)
	@NonNull
	private SkillProficiency proficiency;
	
	@ManyToOne
	private CVElement cvElement;
	
}
