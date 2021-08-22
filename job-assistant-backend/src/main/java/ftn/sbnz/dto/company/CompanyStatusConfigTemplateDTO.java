package ftn.sbnz.dto.company;

import ftn.sbnz.model.company.CompanyStatusConfig;
import ftn.sbnz.model.enums.MedalRank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyStatusConfigTemplateDTO {

	private MedalRank companyMedal;

	private MedalRank previousMedal;

	private Integer totalReviews;

	private Integer totalHired;
	
	private Float averageRating;

	private Integer ratedPositiveDifference;
	
	
	public CompanyStatusConfigTemplateDTO(CompanyStatusConfig obj) {
		this.companyMedal = obj.getCompanyMedal();
		this.previousMedal = MedalRank.previousMedal(this.companyMedal);
		this.totalReviews = obj.getTotalReviews();
		this.totalHired = obj.getTotalHired();
		this.averageRating = obj.getAverageRating();
		this.ratedPositiveDifference = obj.getRatedPositiveDifference();
	}
}
