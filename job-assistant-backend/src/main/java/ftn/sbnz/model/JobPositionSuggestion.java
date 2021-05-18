package ftn.sbnz.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_position_suggestions")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobPositionSuggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	@NonNull
	private Timestamp date;
	
	@OneToMany
	private Set<JobPositionRating> positionRatings;

	@ManyToOne
	private JobSeeker jobSeeker;
}
