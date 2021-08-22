package ftn.sbnz.dto.user;

import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.user.WorkingExperience;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkingExperienceTemplateDTO {
	private int months;
	private Long positionId;
	private SeniorityLevel seniority;
	private Long userId;
	
	public WorkingExperienceTemplateDTO(WorkingExperience we) {
		this.months = we.getMonths();
		this.positionId = we.getPosition().getId();
		this.seniority = we.getSeniority();
		this.userId = we.getUser().getId();
	}

}
