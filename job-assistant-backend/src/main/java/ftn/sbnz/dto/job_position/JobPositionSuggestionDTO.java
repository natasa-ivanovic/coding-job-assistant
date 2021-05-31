package ftn.sbnz.dto.job_position;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionSuggestionDTO {
	private Long id;

	private Timestamp date;
	
	private List<JobPositionRatingDTO> positionRatings;

	public JobPositionSuggestionDTO(JobPositionSuggestion suggestion) {
		this.id = suggestion.getId();
		this.date = suggestion.getDate();
		this.positionRatings = new ArrayList<>();
		for (JobPositionRating d : suggestion.getPositionRatings()) {
			this.positionRatings.add(new JobPositionRatingDTO(d));			
		}
	}
}
