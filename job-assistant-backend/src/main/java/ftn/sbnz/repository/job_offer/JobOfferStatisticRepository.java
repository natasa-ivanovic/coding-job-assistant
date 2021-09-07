package ftn.sbnz.repository.job_offer;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferStatistic;
import ftn.sbnz.model.user.JobSeeker;

public interface JobOfferStatisticRepository extends JpaRepository<JobOfferStatistic, Long> {

	JobOfferStatistic findOneByJobSeekerAndJobOffer(JobSeeker js, JobOffer jo);

}
