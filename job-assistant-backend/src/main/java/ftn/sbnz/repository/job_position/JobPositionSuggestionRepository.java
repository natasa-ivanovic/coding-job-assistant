package ftn.sbnz.repository.job_position;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.dto.job_position.JobPositionSuggestionDTO;
import ftn.sbnz.model.job_position.JobPositionSuggestion;
import ftn.sbnz.model.user.JobSeeker;

public interface JobPositionSuggestionRepository extends JpaRepository<JobPositionSuggestion, Long> {

	List<JobPositionSuggestionDTO> findAllByJobSeeker(JobSeeker jobSeeker);

}
