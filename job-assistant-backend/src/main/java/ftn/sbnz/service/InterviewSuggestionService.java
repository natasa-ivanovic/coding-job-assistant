package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import ftn.sbnz.dto.interview.InterviewSuggestionStatusDTO;
import ftn.sbnz.events.StudiedTodayEvent;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.job_offer.JobOfferDifference;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.interview.InterviewSuggestionRepository;
import ftn.sbnz.repository.interview.InterviewSuggestionStatusRepository;
import ftn.sbnz.repository.job_offer.JobOfferDifferenceRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@Service
public class InterviewSuggestionService {
	
	private InterviewSuggestionRepository repository;
	private InterviewSuggestionStatusRepository statusRepository;
	private JobOfferDifferenceRepository differenceRepository;
	private JobSeekerRepository jobSeekerRepository;
	private KieSessionService kieSession;
	
	public InterviewSuggestionService(InterviewSuggestionRepository repository,
			InterviewSuggestionStatusRepository statusRepository, JobOfferDifferenceRepository differenceRepository,
			JobSeekerRepository jobSeekerRepository, KieSessionService kieSession) {
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.differenceRepository = differenceRepository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.kieSession = kieSession;
	}
	
	public InterviewSuggestionStatusDTO create(Long jobOfferDifferenceId, Long jobSeekerId) {
		JobOfferDifference jod = differenceRepository.getOne(jobOfferDifferenceId);
		JobSeeker js = (JobSeeker) this.jobSeekerRepository.getOne(jobSeekerId);
		Calendar rightNow = Calendar.getInstance();
		InterviewSuggestionStatus iss = new InterviewSuggestionStatus(new Timestamp(rightNow.getTimeInMillis()));
		iss.setChecked(false);
		iss.setJobSeeker(js);
		iss.setJobOfferDifference(jod);
		suggest(iss);
		iss = statusRepository.save(iss);
		jod.getInterviewSuggestionStatuses().add(iss);
		js.getInterviewSuggestions().add(iss);
		differenceRepository.save(jod);
		jobSeekerRepository.save(js);
		
		InterviewSuggestionStatusDTO dto = new InterviewSuggestionStatusDTO(iss);
		return dto;

	}
	
	public void suggest(InterviewSuggestionStatus is) {
		kieSession.insert(is);
		kieSession.setAgendaFocus("interview-suggestion");
		kieSession.fireAllRules();
	}

	public InterviewSuggestionStatusDTO check(Long interviewSuggestionStatusId, Long jobSeekerId) {
		InterviewSuggestionStatus iss = statusRepository.getOne(interviewSuggestionStatusId);
		JobSeeker js = (JobSeeker) this.jobSeekerRepository.getOne(jobSeekerId);
		Calendar rightNow = Calendar.getInstance();
		iss.setChecked(true);
		iss.setDateChecked(new Timestamp(rightNow.getTimeInMillis()));
		StudiedTodayEvent event = new StudiedTodayEvent(js.getId());
		iss = statusRepository.save(iss);
		triggerEvent(event);
		InterviewSuggestionStatusDTO dto = new InterviewSuggestionStatusDTO(iss);
		return dto;
	}
	
	public void triggerEvent(StudiedTodayEvent event) {
		kieSession.insert(event);
		kieSession.setAgendaFocus("studied-today");
		kieSession.fireAllRules();
	}

}
