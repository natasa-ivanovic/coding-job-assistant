package ftn.sbnz.model.company;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferReview;
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
	
	@Column(name = "rank", unique = false, nullable = false)
	@NonNull
	private MedalRank medal;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobOffer> jobOffers;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<JobOfferReview> jobOffersReviews;
}
