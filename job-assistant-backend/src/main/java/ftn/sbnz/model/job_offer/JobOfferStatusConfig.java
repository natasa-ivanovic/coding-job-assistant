package ftn.sbnz.model.job_offer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ftn.sbnz.model.enums.MedalRank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "job_offer_status_config")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JobOfferStatusConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "offer_medal", unique = false, nullable = false)
	@NonNull
	private MedalRank offerMedal;
	
	@Column(name = "company_medal", unique = false, nullable = false)
	@NonNull
	private MedalRank companyMedal;
	
	@Column(name = "total_followers")
	@NonNull
	private Integer totalFollowers;

	@Column(name = "days_since_posted")
	@NonNull
	private Integer daysSincePosted;
}