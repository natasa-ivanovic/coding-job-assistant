package ftn.sbnz.model.benefit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "benefits")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Benefit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	@NonNull
	private String name;
	
	@Column(name = "description", unique = false, nullable = false)
	@NonNull
	private String description;
	
	@Column(name = "importance_level", unique = false, nullable = false)
	private int importanceLevel;

}
