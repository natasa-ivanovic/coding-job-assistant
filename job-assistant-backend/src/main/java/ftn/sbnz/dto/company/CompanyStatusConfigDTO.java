package ftn.sbnz.dto.company;

import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.enums.MedalRank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyStatusConfigDTO {
	private Long id;
	
	private MedalRank companyMedal;

	private Integer totalReviews;

	private Integer totalHired;
	
	private Float averageRating;

	private Integer ratedPositiveDifference;
	
	
	public CompanyStatusConfigDTO(CompanyStatusConfig obj) {
		this.id = obj.getId();
		this.companyMedal = obj.getCompanyMedal();
		this.totalReviews = obj.getTotalReviews();
		this.totalHired = obj.getTotalHired();
		this.averageRating = obj.getAverageRating();
		this.ratedPositiveDifference = obj.getRatedPositiveDifference();
	}
}
