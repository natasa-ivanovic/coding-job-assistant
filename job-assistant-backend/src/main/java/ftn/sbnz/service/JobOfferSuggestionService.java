package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_offer.JobOfferSuggestionRepository;

@Service
public class JobOfferSuggestionService {
	
	private JobOfferSuggestionRepository repository;
	private UserService userService;
	private KieSessionService kieSession;
	
	@Autowired
	public JobOfferSuggestionService(JobOfferSuggestionRepository repository, UserService userService, 
			KieSessionService kieSession) {
		this.repository = repository;
		this.userService = userService;
		this.kieSession = kieSession;
	}
	
	public void create(JobSeeker jobSeeker) {
		JobSeeker dbJobSeeker = (JobSeeker) userService.findByUsername(jobSeeker.getUsername());
		Calendar rightNow = Calendar.getInstance();
		JobOfferSuggestion suggestion = new JobOfferSuggestion(new Timestamp(rightNow.getTimeInMillis()), dbJobSeeker);
		kieSession.insert(suggestion);
		kieSession.fireAllRules();

//		for (JobPositionRating rating : suggestion.getPositionRatings()) {
//			this.ratingRepository.save(rating);
//		}

		JobOfferSuggestion created = repository.save(suggestion);
//		dbJobSeeker.getOfferSuggestions().add(created);
//		userService.save(dbJobSeeker);
//		return new JobPositionSuggestionDTO(created);
	}

}
