package ftn.sbnz.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.job_offer.JobOfferDTO;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferRating;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.JobSeekerRanking;
import ftn.sbnz.repository.job_offer.JobOfferRatingRepository;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.user.JobSeekerRankingRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@Service
public class JobOfferService {

	private JobOfferRepository repository;
	private JobSeekerRepository jobSeekerRepository;
	private JobSeekerRankingRepository jobSeekerRankingRepository;
	private JobOfferRatingRepository jobOfferRatingRepository;
	private KieSessionService kieSession;

	@Autowired
	public JobOfferService(JobOfferRepository repository, JobSeekerRepository jobSeekerRepository,
			JobSeekerRankingRepository jobSeekerRankingRepository, JobOfferRatingRepository jobOfferRatingRepository,
			KieSessionService kieSession) {
		this.repository = repository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobSeekerRankingRepository = jobSeekerRankingRepository;
		this.jobOfferRatingRepository = jobOfferRatingRepository;
		this.kieSession = kieSession;
	}

	public JobOffer getOffer(Long id) {
		return repository.getOneById(id);
	}

	public void save(JobOffer jo) {
		this.repository.save(jo);
	}

	public String follow(Long jobOfferRatingId, Long userId) {
		JobOfferRating jor = jobOfferRatingRepository.getOne(jobOfferRatingId);
		JobOffer jo = jor.getJobOffer();
		JobSeeker js = jobSeekerRepository.getOne(userId);
		JobSeekerRanking jsr = new JobSeekerRanking();
		jsr.setJobOffer(jo);
		jsr.setJobSeeker(js);
		jsr.setRanking(jor.getRating());
		js.getOfferRankings().add(jsr);
		jo.getRankings().add(jsr);
		JobSeekerRanking jobSeekerRankingCreated = jobSeekerRankingRepository.save(jsr);
		jobSeekerRepository.save(js);
		repository.save(jo);
		kieSession.insert(jobSeekerRankingCreated);
		kieSession.setAgendaFocus("job-offer-status");
		kieSession.fireAllRules();
		updateDBFromRule(jo);
		
		return sortRankings(jo.getRankings(), userId);
	}

	public void updateDBFromRule(JobOffer jobOfferDb) {
		Collection<Object> offers = kieSession.getObjectsFromSession(JobOffer.class);
		for (Iterator<Object> it = offers.iterator(); it.hasNext();) {
			JobOffer jo = (JobOffer) it.next();
			if (jo.getId() == jobOfferDb.getId()) {
				if (!jo.getMedal().equals(jobOfferDb.getMedal())) {
					jobOfferDb.setMedal(jo.getMedal());
					;
					this.save(jo);
				}
				return;
			}
		}
	}

	public List<JobOfferDTO> getAll() {
		List<JobOffer> offers = repository.findAll();
		return offers.stream().map(this::toDTO).collect(Collectors.toList());
	}

	private JobOfferDTO toDTO(JobOffer jo) {
		return new JobOfferDTO(jo);
	}

	private String sortRankings(List<JobSeekerRanking> rankings, Long jobSeekerId) {
		int numOfPeople = rankings.size();
		if (numOfPeople > 0) {
			rankings = rankings.stream().sorted((item1, item2) -> Long.compare(item2.getRanking(), item1.getRanking()))
					.collect(Collectors.toList());
			for (int i = 0; i < numOfPeople; i++) {
				if (rankings.get(i).getJobSeeker().getId() == jobSeekerId) {
					int position = i + 1;
					return position + "/" + numOfPeople;
				}
			}
		}
		return "1/1";
	}

}
