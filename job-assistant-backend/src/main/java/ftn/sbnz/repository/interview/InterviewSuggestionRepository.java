package ftn.sbnz.repository.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.interview.InterviewSuggestion;

public interface InterviewSuggestionRepository extends JpaRepository<InterviewSuggestion, Long> {

}
