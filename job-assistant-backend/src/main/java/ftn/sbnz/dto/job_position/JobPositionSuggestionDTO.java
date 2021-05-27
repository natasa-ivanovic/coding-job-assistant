package ftn.sbnz.dto.job_position;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionSuggestionDTO {
	private Long id;

	private Timestamp date;
	
	private Set<JobPositionRatingDTO> positionRatings;

	public JobPositionSuggestionDTO(JobPositionSuggestion suggestion) {
		this.id = suggestion.getId();
		this.date = suggestion.getDate();
		this.positionRatings = new HashSet<>();
		for (JobPositionRating d : suggestion.getPositionRatings()) {
			this.positionRatings.add(new JobPositionRatingDTO(d));			
		}
	}
}
