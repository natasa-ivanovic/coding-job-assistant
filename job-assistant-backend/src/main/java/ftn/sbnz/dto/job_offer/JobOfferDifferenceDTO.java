package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.job_offer.JobOfferDifference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferDifferenceDTO {
	
	private Long id;
	private String subject;
	private SkillProficiency userProficiency;
	private SkillProficiency jobOfferProficiency;
	
	public JobOfferDifferenceDTO(JobOfferDifference jod) {
		this.id = jod.getId();
		this.subject = jod.getSubject();
		this.userProficiency = jod.getUserProficiency();
		this.jobOfferProficiency = jod.getJobOfferProficiency();
	}

}
