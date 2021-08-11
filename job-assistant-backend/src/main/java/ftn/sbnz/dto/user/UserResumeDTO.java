package ftn.sbnz.dto.user;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.dto.cv_element.CVElementProficiencyDTO;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResumeDTO {
	private List<WorkingExperienceDTO> workingExperience;
	private List<CVElementProficiencyDTO> proficiencies;
	
	public UserResumeDTO(JobSeeker js) {
		this.workingExperience = js.getWorkingExperience().stream().map(we -> new WorkingExperienceDTO(we)).collect(Collectors.toList());
		this.proficiencies = js.getProficiencies().stream().map(el -> new CVElementProficiencyDTO(el)).collect(Collectors.toList());		
	}
}
