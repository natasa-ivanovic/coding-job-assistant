package ftn.sbnz.dto.user;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserExperienceDTO {
	private List<WorkingExperienceDTO> workingExperience;
	
	public UserExperienceDTO(JobSeeker js) {
		this.workingExperience = js.getWorkingExperience().stream().map(we -> new WorkingExperienceDTO(we)).collect(Collectors.toList());
	}
}
