package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;

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

	private UserService userService;

	private KieSessionService kieSession;

	@Autowired
	public JobPositionSuggestionService(JobPositionSuggestionRepository repository, KieSessionService kieSession,
			JobPositionRatingRepository ratingRepository, UserService userService) {
		this.repository = repository;
		this.kieSession = kieSession;
		this.ratingRepository = ratingRepository;
		this.userService = userService;
	}

	public JobPositionSuggestionDTO create(JobSeeker jobSeeker) {
		JobSeeker dbJobSeeker = (JobSeeker) userService.findByUsername(jobSeeker.getUsername());
		Calendar rightNow = Calendar.getInstance();
		JobPositionSuggestion suggestion = new JobPositionSuggestion(new Timestamp(rightNow.getTimeInMillis()), dbJobSeeker);
		kieSession.insert(suggestion);
		kieSession.setAgendaFocus("jps-p4");
		kieSession.setAgendaFocus("jps-p3");
		kieSession.setAgendaFocus("jps-p2");
		kieSession.setAgendaFocus("jps-p1");
		kieSession.fireAllRules();

		for (JobPositionRating rating : suggestion.getPositionRatings()) {
			this.ratingRepository.save(rating);
		}

		JobPositionSuggestion created = repository.save(suggestion);
		return new JobPositionSuggestionDTO(created);
	}

}
