package ftn.sbnz.dto.job_offer;

import ftn.sbnz.model.job_offer.JobOfferRating;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobOfferRatingDTO {

	private Long id;
	private int rating;
	private String description;
	private String category;
	private String company;
	private String position;
	private Long jobOfferId;
	
	public JobOfferRatingDTO(JobOfferRating jobOfferRating) {
		this.id = jobOfferRating.getId();
		this.rating = jobOfferRating.getRating();
		this.description = jobOfferRating.getDescription();
		this.category = jobOfferRating.getCategory().name();
		this.company = jobOfferRating.getJobOffer().getCompany().getName();
		this.position = jobOfferRating.getJobOffer().getPosition().getTitle();
		this.jobOfferId = jobOfferRating.getJobOffer().getId();
	}

}
