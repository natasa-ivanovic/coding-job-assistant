package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.job_offer.JobOfferStatusConfig;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferStatusConfigDTO {
	private Long id;
	
	private MedalRank offerMedal;

	private MedalRank companyMedal;
	
	private Integer totalFollowers;

	private Integer daysSincePosted;
	
	public JobOfferStatusConfigDTO(JobOfferStatusConfig obj) {
		this.id = obj.getId();
		this.offerMedal = obj.getOfferMedal();
		this.companyMedal = obj.getCompanyMedal();
		this.totalFollowers = obj.getTotalFollowers();
		this.daysSincePosted = obj.getDaysSincePosted();
	}
}
