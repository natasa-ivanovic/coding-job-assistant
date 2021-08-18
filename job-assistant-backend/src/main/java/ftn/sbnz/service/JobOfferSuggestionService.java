package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.job_offer.JobOfferRatingDTO;
import ftn.sbnz.dto.job_offer.JobOfferSuggestionDTO;
import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferSuggestion;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.JobSeekerRanking;
import ftn.sbnz.repository.job_offer.JobOfferRatingRepository;
import ftn.sbnz.repository.job_offer.JobOfferSuggestionRepository;
import ftn.sbnz.repository.user.JobSeekerRankingRepository;

@Service
@Transactional
public class JobOfferSuggestionService {

	private JobOfferSuggestionRepository repository;
	private JobOfferRatingRepository ratingRepository;
	private JobSeekerRankingRepository rankingRepository;
	private UserService userService;
	private KieSessionService kieSession;
	private JobPositionSuggestionService positionSuggestionService;

	@Autowired
	public JobOfferSuggestionService(JobOfferSuggestionRepository repository, JobOfferRatingRepository ratingRepository,
			JobSeekerRankingRepository rankingRepository, UserService userService, KieSessionService kieSession,
			JobPositionSuggestionService positionSuggestionService) {
		this.repository = repository;
		this.ratingRepository = ratingRepository;
		this.rankingRepository = rankingRepository;
		this.userService = userService;
		this.kieSession = kieSession;
		this.positionSuggestionService = positionSuggestionService;
	}

	public JobOfferSuggestionDTO create(JobSeeker jobSeeker) {
		JobSeeker dbJobSeeker = (JobSeeker) userService.findByUsername(jobSeeker.getUsername());
		if (!this.positionSuggestionService.hasLastSuggestion(dbJobSeeker)) {
			this.positionSuggestionService.create(dbJobSeeker);
		}
		Calendar rightNow = Calendar.getInstance();
		JobOfferSuggestion suggestion = new JobOfferSuggestion(new Timestamp(rightNow.getTimeInMillis()), dbJobSeeker);
		kieSession.insert(suggestion);
		kieSession.setAgendaFocus("jos-p7");
		kieSession.setAgendaFocus("jos-p6");
		kieSession.setAgendaFocus("jos-p5");
		kieSession.setAgendaFocus("jos-p4");
		kieSession.setAgendaFocus("jos-p3");
		kieSession.setAgendaFocus("jos-p2");
		kieSession.setAgendaFocus("jos-p1");
		kieSession.fireAllRules();

		suggestion.getOfferRatings().sort(Comparator.reverseOrder());

		for (JobOfferRating rating : suggestion.getOfferRatings()) {
			this.ratingRepository.save(rating);
		}

		JobOfferSuggestion created = repository.save(suggestion);
		dbJobSeeker.getOfferSuggestions().add(created);
		userService.save(dbJobSeeker);
		List<JobOfferRatingDTO> ratings = toJobOfferRatingDTO(jobSeeker, created);
		return new JobOfferSuggestionDTO(created, ratings);
	}

	public JobOfferSuggestionDTO getSuggestion(JobSeeker js) throws Exception {
		List<JobOfferSuggestion> suggestions = repository.findAllByJobSeeker(js);
		JobOfferSuggestion suggestion = getLatestJobOfferSuggestion(suggestions);
		List<JobOfferRatingDTO> ratings = toJobOfferRatingDTO(js, suggestion);
		return new JobOfferSuggestionDTO(suggestion, ratings);
	}

	private JobOfferSuggestion getLatestJobOfferSuggestion(List<JobOfferSuggestion> jos) throws Exception {
		if (jos.size() > 0) {
			jos = jos.stream()
					.sorted((item1, item2) -> Long.compare(item2.getDate().getTime(), item1.getDate().getTime()))
					.collect(Collectors.toList());
			return jos.get(0);
		}
		throw new Exception("No job offer suggestions!");
	}

	private List<JobOfferRatingDTO> toJobOfferRatingDTO(JobSeeker js, JobOfferSuggestion jos) {
		List<JobOfferRatingDTO> ratings = new ArrayList<>();
		JobSeekerRanking check = null;
		for (JobOfferRating jor : jos.getOfferRatings()) {
			check = this.rankingRepository.findOneByJobSeekerAndJobOffer(js, jor.getJobOffer());
			if (check == null)
				ratings.add(new JobOfferRatingDTO(jor, js, false));
			else
				ratings.add(new JobOfferRatingDTO(jor, js, true));
		}
		return ratings;
	}

}
