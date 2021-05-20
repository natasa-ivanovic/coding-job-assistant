package ftn.sbnz.repository.job_offer;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOfferSuggestion;

public interface JobOfferSuggestionRepository extends JpaRepository<JobOfferSuggestion, Long> {

}
