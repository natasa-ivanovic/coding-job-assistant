package ftn.sbnz.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.JobSeekerRanking;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.user.JobSeekerRankingRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@Service
public class JobOfferService {

	private JobOfferRepository repository;
	private JobSeekerRepository jobSeekerRepository;
	private JobSeekerRankingRepository jobSeekerRankingRepository;
	private KieSessionService kieSession;

	@Autowired
	public JobOfferService(JobOfferRepository repository, JobSeekerRepository jobSeekerRepository,
			JobSeekerRankingRepository jobSeekerRankingRepository, KieSessionService kieSession) {
		this.repository = repository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobSeekerRankingRepository = jobSeekerRankingRepository;
		this.kieSession = kieSession;
	}
	
	public JobOffer getOffer(Long id){
		return repository.getOne(id);
	}
	
	public void save(JobOffer jo) {
		this.repository.save(jo);
	}
	
	
	public void follow(Long jobOfferId, Long userId) {
		JobOffer jo = getOffer(jobOfferId);
		JobSeeker js = jobSeekerRepository.getOne(userId);
		JobSeekerRanking jsr = new JobSeekerRanking();
		jsr.setJobOffer(jo);
		jsr.setJobSeeker(js);
		jsr.setRanking(15);
		js.getOfferRankings().add(jsr);
		jo.getRankings().add(jsr);
		JobSeekerRanking jobSeekerRankingCreated = jobSeekerRankingRepository.save(jsr);
		jobSeekerRepository.save(js);
		repository.save(jo);
		kieSession.insert(jobSeekerRankingCreated);
		kieSession.setAgendaFocus("job-offer-status");
		kieSession.fireAllRules();
		updateDBFromRule(jo);
	}
	
	public void updateDBFromRule(JobOffer jobOfferDb) {
		Collection<Object> offers = kieSession.getObjectsFromSession(JobOffer.class);
		for (Iterator<Object> it = offers.iterator(); it.hasNext();) {
			JobOffer jo = (JobOffer) it.next();
			if (jo.getId() == jobOfferDb.getId()) {
				if (!jo.getMedal().equals(jobOfferDb.getMedal())) {
					jobOfferDb.setMedal(jo.getMedal());;
					this.save(jo);
				}
				return;
			}
		}

	}
}
