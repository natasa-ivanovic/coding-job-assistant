package ftn.sbnz.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.user.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {

}
