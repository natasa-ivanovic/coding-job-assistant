package ftn.sbnz.dto.job_position;

import ftn.sbnz.model.job_position.JobPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionDTO {
	private Long id;
	private String title;
	
	public JobPositionDTO(JobPosition jp) {
		this.id = jp.getId();
		this.title = jp.getTitle();
	}
}
