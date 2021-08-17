package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.job_offer.JobOfferStatisticDTO;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.job_offer.JobOfferRatingRepository;
import ftn.sbnz.repository.job_offer.JobOfferStatisticRepository;
import ftn.sbnz.repository.job_offer.JobOfferSuggestionRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;
import lombok.Data;

@Service
@Transactional
public class JobOfferStatisticService {
	
	private JobOfferStatisticRepository repository;
	private JobSeekerRepository jobSeekerRepository;
	private JobOfferRatingRepository ratingRepository;
	private JobOfferService jobOfferService;
	private KieSessionService kieSession;
	
	@Autowired
	public JobOfferStatisticService(JobOfferStatisticRepository repository,
			JobOfferService jobOfferService, JobSeekerRepository jobSeekerRepository,
			JobOfferRatingRepository ratingRepository, KieSessionService kieSession) {
		this.repository = repository;
		this.jobOfferService = jobOfferService;
		this.ratingRepository = ratingRepository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.kieSession = kieSession;
	}
	
	public JobOfferStatisticDTO create(Long jobSeekerId, Long jobOfferId) {
		JobOffer jo = this.jobOfferService.getOffer(jobOfferId);
		JobSeeker js = (JobSeeker) this.jobSeekerRepository.getOne(jobSeekerId);
		Calendar rightNow = Calendar.getInstance();
		JobOfferStatistic statistic = new JobOfferStatistic(new Timestamp(rightNow.getTimeInMillis()));
		statistic.setJobOffer(jo);
		statistic.setJobSeeker(js);
		analyze(statistic);
		statistic = repository.save(statistic);
		jo.getStatistics().add(statistic);
		js.getStatistics().add(statistic);
		this.jobOfferService.save(jo);
		this.jobSeekerRepository.save(js);
		JobOfferStatisticDTO dto = new JobOfferStatisticDTO(statistic);
		return dto;
	}
	
	public void analyze(JobOfferStatistic jos) {
		kieSession.insert(jos);
		kieSession.setAgendaFocus("job-seeker-statistic");
		kieSession.fireAllRules();
	}
}
