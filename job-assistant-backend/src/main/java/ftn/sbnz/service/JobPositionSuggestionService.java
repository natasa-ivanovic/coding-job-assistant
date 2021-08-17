package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.job_position.JobPositionSuggestionDTO;
import ftn.sbnz.model.job_position.JobPositionRating;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_position.JobPositionRatingRepository;
import ftn.sbnz.repository.job_position.JobPositionSuggestionRepository;

@Service
@Transactional
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
		JobPositionSuggestion suggestion = new JobPositionSuggestion(new Timestamp(rightNow.getTimeInMillis()),
				dbJobSeeker);
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
		dbJobSeeker.getPositionSuggestions().add(suggestion);
		userService.save(dbJobSeeker);
		return new JobPositionSuggestionDTO(created);
	}

	public JobPositionSuggestionDTO getLastSuggestion(JobSeeker jobSeeker) throws Exception {
		List<JobPositionSuggestionDTO> list = this.repository.findAllByJobSeeker(jobSeeker);
		if (list.size() == 0) {
			throw new Exception("No suggestions recently. Please request a new set of suggestions.");
		} else {
			list = list.stream()
					.sorted((item1, item2) -> Long.compare(item2.getDate().getTime(), item1.getDate().getTime()))
					.collect(Collectors.toList());
			return list.get(0);
		}
	}

}
