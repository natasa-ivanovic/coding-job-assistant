package ftn.sbnz.model.job_position;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.sbnz.model.enums.SeniorityLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_position_ratings")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobPositionRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "rating", unique = false, nullable = false)
	private int rating;

	@Column(name = "description", unique = false, nullable = false)
	@NonNull
	private String description;

	@Column(name = "title", unique = false, nullable = false)
	@NonNull
	private String title;

	@Column(name = "subtitle", unique = false, nullable = false)
	@NonNull
	private String subtitle;
	
	@Column(name = "seniority", unique = false, nullable = false)
	private SeniorityLevel seniority;
	
	@ManyToOne
	private JobPosition jobPosition;

}
