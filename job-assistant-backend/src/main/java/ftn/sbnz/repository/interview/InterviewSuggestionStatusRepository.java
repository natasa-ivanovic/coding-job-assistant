package ftn.sbnz.repository.interview;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.interview.InterviewSuggestionStatus;

public interface InterviewSuggestionStatusRepository extends JpaRepository<InterviewSuggestionStatus, Long> {

}
