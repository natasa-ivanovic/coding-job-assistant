package ftn.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.repository.job_offer.JobOfferRepository;

@Service
public class JobOfferService {

	private JobOfferRepository repository;

	@Autowired
	public JobOfferService(JobOfferRepository repository) {
		this.repository = repository;
	}
	
	public JobOffer getOffer(Long id){
		return repository.getOne(id);
	}
}
