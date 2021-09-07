package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferStatusConfigTemplateDTO {
	private MedalRank offerMedal;

	private MedalRank previousMedal;

	private MedalRank companyMedal;
	
	private Integer totalFollowers;

	private Integer daysSincePosted;
	
	public JobOfferStatusConfigTemplateDTO(JobOfferStatusConfig obj) {
		this.offerMedal = obj.getOfferMedal();
		this.previousMedal = MedalRank.previousMedal(this.offerMedal);
		this.companyMedal = obj.getCompanyMedal();
		this.totalFollowers = obj.getTotalFollowers();
		this.daysSincePosted = obj.getDaysSincePosted();
	}
}
