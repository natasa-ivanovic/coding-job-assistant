package ftn.sbnz.model.company;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.enums.ReviewStatus;
import ftn.sbnz.model.job_offer.JobOffer;
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
	
	@Column(name = "medal", unique = false, nullable = false)
	@NonNull
	private MedalRank medal;
	
	@OneToMany(mappedBy = "company")
	private List<JobOffer> jobOffers;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
	private List<CompanyReview> companyReviews;
	
	public float getAverageRating() {
		float totalScore = 0;
		float count = 0;
		for (CompanyReview cr : companyReviews) {
			if (cr.getStatus().equals(ReviewStatus.APPROVED)) {
				totalScore += cr.getRating();
				count++;
			}
		}
		if (count == 0)
			return 0f;
		else
			return totalScore / count;
	}
}
