package ftn.sbnz.repository.interview;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.user.JobSeeker;

public interface InterviewSuggestionStatusRepository extends JpaRepository<InterviewSuggestionStatus, Long> {

	public List<InterviewSuggestionStatus> findAllByJobSeeker(JobSeeker js);

	public InterviewSuggestionStatus getOneById(Long interviewSuggestionStatusId);

	public List<InterviewSuggestionStatus> findAllByJobSeekerAndInterviewSuggestion(JobSeeker js, InterviewSuggestion suggestion);
}
