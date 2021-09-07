package ftn.sbnz.repository.job_offer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.user.JobSeeker;

public interface JobOfferSuggestionRepository extends JpaRepository<JobOfferSuggestion, Long> {
	
	public List<JobOfferSuggestion> findAllByJobSeeker(JobSeeker jobSeeker);

	public JobOfferSuggestion getOneById(Long jobOfferSuggestionId);
}
