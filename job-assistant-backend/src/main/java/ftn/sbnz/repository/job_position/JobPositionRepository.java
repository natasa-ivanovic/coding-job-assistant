package ftn.sbnz.repository.job_position;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_position.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

}
