package ftn.sbnz.dto.job_offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferSuggestionDTO {
	
	private Long id;
	private Timestamp date;
	private List<JobOfferRatingDTO> offerRatings;
	
	public JobOfferSuggestionDTO(JobOfferSuggestion suggestion) {
		this.id = suggestion.getId();
		this.date = suggestion.getDate();
		this.offerRatings = new ArrayList<>();
		for (JobOfferRating d : suggestion.getOfferRatings()) {
			this.offerRatings.add(new JobOfferRatingDTO(d));			
		}
	}
}
