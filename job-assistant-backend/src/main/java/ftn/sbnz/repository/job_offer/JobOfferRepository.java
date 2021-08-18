package ftn.sbnz.repository.job_offer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOffer;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

	JobOffer getOneById(Long id);

	List<JobOffer> findAllByPositionId(Long id);

}
