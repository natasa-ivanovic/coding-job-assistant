package ftn.sbnz.repository.job_position;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_position.JobPosition;

public interface JobPositionRepository extends JpaRepository<JobPosition, Long> {

	List<JobPosition> findAll();

}
