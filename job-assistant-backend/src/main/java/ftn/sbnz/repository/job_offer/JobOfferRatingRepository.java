package ftn.sbnz.repository.job_offer;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOfferRating;

public interface JobOfferRatingRepository extends JpaRepository<JobOfferRating, Long> {

	JobOfferRating getOneById(Long jobOfferSuggestionId);

}
