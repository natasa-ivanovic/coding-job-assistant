package ftn.sbnz.service;

import java.sql.Timestamp;

import org.apache.tools.ant.types.resources.selectors.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.job_position.JobPositionSuggestionDTO;
import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_position.JobPositionRatingRepository;
import ftn.sbnz.repository.job_position.JobPositionSuggestionRepository;

@Service
public class JobPositionSuggestionService {

	private JobPositionSuggestionRepository repository;

	private JobPositionRatingRepository ratingRepository;

	private KieSessionService kieSession;

	@Autowired
	public JobPositionSuggestionService(JobPositionSuggestionRepository repository, KieSessionService kieSession, JobPositionRatingRepository ratingRepository) {
		this.repository = repository;
		this.kieSession = kieSession;
		this.ratingRepository = ratingRepository;
	}

	public JobPositionSuggestionDTO create(JobSeeker jobSeeker) {
		Date now = new Date();
		JobPositionSuggestion suggestion = new JobPositionSuggestion(new Timestamp(now.getMillis()), jobSeeker);
		kieSession.insert(suggestion);
		kieSession.fireAllRules();

		for (JobPositionRating rating : suggestion.getPositionRatings()) {
			this.ratingRepository.save(rating);
		}
		
		JobPositionSuggestion created = repository.save(suggestion);
		return new JobPositionSuggestionDTO(created);
	}

}
