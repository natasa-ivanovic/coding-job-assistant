package ftn.sbnz.dto.user;

import ftn.sbnz.model.user.JobSeeker;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JobSeekerDTO {
	
	private long id;
	private String name;
	private String surname;
	private boolean continuousLearning;
	
	public JobSeekerDTO(JobSeeker js) {
		this.id = js.getId();
		this.name = js.getName();
		this.surname = js.getSurname();
		this.continuousLearning = js.isContinuousLearning();
	}

}
