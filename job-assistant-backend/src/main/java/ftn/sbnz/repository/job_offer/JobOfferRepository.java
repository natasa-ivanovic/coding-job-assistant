package ftn.sbnz.repository.job_offer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.model.job_offer.JobOffer;

@Transactional
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

	JobOffer getOneById(Long id);

	List<JobOffer> findAllByPositionId(Long id);

}
