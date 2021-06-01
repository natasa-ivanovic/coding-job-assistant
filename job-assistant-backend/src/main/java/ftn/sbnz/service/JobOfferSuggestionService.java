package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.job_offer.JobOfferSuggestionDTO;
import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_offer.JobOfferRatingRepository;
import ftn.sbnz.repository.job_offer.JobOfferSuggestionRepository;

@Service
public class JobOfferSuggestionService {
	
	private JobOfferSuggestionRepository repository;
	private JobOfferRatingRepository ratingRepository;
	private UserService userService;
	private KieSessionService kieSession;
	
	@Autowired
	public JobOfferSuggestionService(JobOfferSuggestionRepository repository, JobOfferRatingRepository ratingRepository, UserService userService, 
			KieSessionService kieSession) {
		this.repository = repository;
		this.ratingRepository = ratingRepository;
		this.userService = userService;
		this.kieSession = kieSession;
	}
	
	public JobOfferSuggestionDTO create(JobSeeker jobSeeker) {
		JobSeeker dbJobSeeker = (JobSeeker) userService.findByUsername(jobSeeker.getUsername());
		Calendar rightNow = Calendar.getInstance();
		JobOfferSuggestion suggestion = new JobOfferSuggestion(new Timestamp(rightNow.getTimeInMillis()), dbJobSeeker);
		kieSession.insert(suggestion);
		kieSession.setAgendaFocus("jos-p3");
		kieSession.setAgendaFocus("jos-p2");
		kieSession.setAgendaFocus("jos-p1");
		kieSession.fireAllRules();

		for (JobOfferRating rating : suggestion.getOfferRatings()) {
			this.ratingRepository.save(rating);
		}

		JobOfferSuggestion created = repository.save(suggestion);
		dbJobSeeker.getOfferSuggestions().add(created);
		userService.save(dbJobSeeker);
		return new JobOfferSuggestionDTO(created);
	}

}
