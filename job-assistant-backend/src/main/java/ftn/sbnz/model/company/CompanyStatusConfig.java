package ftn.sbnz.model.company;

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
@Table(name = "company_status_config")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CompanyStatusConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "company_medal", unique = false, nullable = false)
	@NonNull
	private MedalRank companyMedal;

	@Column(name = "total_reviews")
	@NonNull
	private Integer totalReviews;

	@Column(name = "total_hired")
	@NonNull
	private Integer totalHired;
	
	@Column(name = "average_rating")
	@NonNull
	private Float averageRating;

	@Column(name = "rated_positive_difference")
	@NonNull
	private Integer ratedPositiveDifference;
}
