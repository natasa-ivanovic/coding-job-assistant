package ftn.sbnz.dto.job_position;

import ftn.sbnz.model.job_position.JobPositionRating;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobPositionRatingDTO {
	private Long id;
	
	private int rating;

	private String description;

	private String title;

	private String subtitle;
	
	private String seniority;
	
	private Long jobPositionId;
	
	public JobPositionRatingDTO(JobPositionRating jobPositionRating) {
		this.id = jobPositionRating.getId();
		this.rating = jobPositionRating.getRating();
		this.description = jobPositionRating.getDescription();
		this.title = jobPositionRating.getTitle();
		this.subtitle = jobPositionRating.getSubtitle();
		this.seniority = jobPositionRating.getSeniority().name();
		this.jobPositionId = jobPositionRating.getJobPosition().getId();
	}
}
