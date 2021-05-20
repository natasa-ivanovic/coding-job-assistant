package ftn.sbnz.repository.job_position;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.job_position.JobPositionSuggestion;

public interface JobPositionSuggestionRepository extends JpaRepository<JobPositionSuggestion, Long> {

}
