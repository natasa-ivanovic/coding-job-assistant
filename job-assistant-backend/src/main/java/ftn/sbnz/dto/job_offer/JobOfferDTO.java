package ftn.sbnz.dto.job_offer;

import java.util.Date;

import ftn.sbnz.model.enums.MedalRank;
import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.job_offer.JobOffer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferDTO {

	private Long id;
	private SeniorityLevel seniority;
	private MedalRank medal;
	private Date datePosted;
	private String companyName;
	private String companyId;
	private String positionName;
	private String positionId;

	public JobOfferDTO(JobOffer jo) {
		this.id = jo.getId();
		this.seniority = jo.getSeniority();
		this.medal = jo.getMedal();
		this.datePosted = jo.getDatePosted();
		this.companyName = jo.getCompany().getName();
		this.companyId = jo.getCompany().getId().toString();
		this.positionName = jo.getPosition().getTitle();
		this.positionId = jo.getPosition().getId().toString();
	}
}
