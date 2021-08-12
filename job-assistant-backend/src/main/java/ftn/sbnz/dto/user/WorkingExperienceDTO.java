package ftn.sbnz.dto.user;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.dto.cv_element.CVElementDTO;
import ftn.sbnz.model.enums.SeniorityLevel;
import ftn.sbnz.model.user.WorkingExperience;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkingExperienceDTO {
	private Long id;
	private int months;
	private SeniorityLevel seniority;
	private List<CVElementDTO> cvElements;
	private String positionName;
	
	public WorkingExperienceDTO(WorkingExperience we) {
		this.id = we.getId();
		this.months = we.getMonths();
		this.seniority = we.getSeniority();
		this.positionName = we.getPosition().getTitle();
		this.cvElements = we.getCvElements().stream().map(el -> new CVElementDTO(el)).collect(Collectors.toList());
	}

}
