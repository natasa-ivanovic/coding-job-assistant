package ftn.sbnz.model.cv_element;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ftn.sbnz.model.enums.CVElementType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "cv_elements")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CVElement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	@NonNull
	private String name;
	
	@Column(name = "type", unique = false, nullable = false)
	@NonNull
	private CVElementType type;
	

}
