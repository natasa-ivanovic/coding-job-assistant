package ftn.sbnz.dto.job_position;

import java.util.List;
import java.util.stream.Collectors;

import ftn.sbnz.model.job_position.JobPosition;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionElementsDTO {
	private Long id;
	private String title;
	private List<Long> elementIds;
	
	public JobPositionElementsDTO(JobPosition jp) {
		this.id = jp.getId();
		this.title = jp.getTitle();
		this.elementIds = jp.getCvElements().stream().map(el -> el.getId()).collect(Collectors.toList());
	}
}
