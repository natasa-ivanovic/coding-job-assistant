package ftn.sbnz.model.job_offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.user.JobSeeker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "job_offer_suggestions")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOfferSuggestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date")
	@NonNull
	private Timestamp date;
	
	@OneToMany
	private List<JobOfferRating> offerRatings = new ArrayList<>();

	@ManyToOne
	@NonNull
	private JobSeeker jobSeeker;

	@Column(name = "finished")
	private boolean finished;
}
