package ftn.sbnz.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.JobSeekerRanking;

public interface JobSeekerRankingRepository extends JpaRepository<JobSeekerRanking, Long> {

	JobSeekerRanking findOneByJobSeekerAndJobOffer(JobSeeker js, JobOffer jo);

}
