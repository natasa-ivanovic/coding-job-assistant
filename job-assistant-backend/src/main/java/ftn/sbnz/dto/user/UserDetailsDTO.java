package ftn.sbnz.dto.user;

import ftn.sbnz.model.enums.EducationLevel;
import ftn.sbnz.model.user.JobSeeker;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailsDTO {
	private Long id;
	private String name;
	private String surname;
	private String username;
	private boolean remoteWork;
	private float salaryExpectation;
	private EducationLevel education;

	public UserDetailsDTO(JobSeeker js) {
		this.id = js.getId();
		this.name = js.getName();
		this.surname = js.getSurname();
		this.username = js.getUsername();
		this.remoteWork = js.isRemoteWork();
		this.salaryExpectation = js.getSalaryExpectation();
		this.education = js.getEducation();
	}

}
