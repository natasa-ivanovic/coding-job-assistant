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
@Table(name = "companies")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false)
	@NonNull
	private String name;
	
	@Column(name = "popularity", unique = false, nullable = false)
	private float popularity;

	@Column(name = "rank", unique = false, nullable = false)
	@NonNull
	private MedalRank medal;
	
	@OneToMany
	private Set<JobOffer> jobOffers;
	
	@OneToMany
	private Set<JobOfferReview> jobOffersReviews;
}
