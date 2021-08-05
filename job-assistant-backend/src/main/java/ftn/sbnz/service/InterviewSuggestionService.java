package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.interview.InterviewSuggestionStatusDTO;
import ftn.sbnz.events.StudiedTodayEvent;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferDifference;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.cv_element.CVElementProficiencyRepository;
import ftn.sbnz.repository.cv_element.CVElementRepository;
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
	private CVElementRepository cvElementRepository;
	private CVElementProficiencyRepository cvElementProficiencyRepository;
	private KieSessionService kieSession;

	@Autowired
	public InterviewSuggestionService(InterviewSuggestionRepository repository,
			InterviewSuggestionStatusRepository statusRepository, JobOfferDifferenceRepository differenceRepository,
			JobSeekerRepository jobSeekerRepository,
			CVElementRepository cvElementRepository, CVElementProficiencyRepository cvElementProficiencyRepository,
			KieSessionService kieSession) {
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.differenceRepository = differenceRepository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.cvElementRepository = cvElementRepository;
		this.cvElementProficiencyRepository = cvElementProficiencyRepository;
		this.kieSession = kieSession;
	}

	public InterviewSuggestionStatusDTO create(Long jobOfferDifferenceId, Long jobSeekerId) {
		JobOfferDifference jod = differenceRepository.getOne(jobOfferDifferenceId);
		JobOffer offer = jod.getStatistic().getJobOffer();
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

		InterviewSuggestionStatusDTO dto = new InterviewSuggestionStatusDTO(iss, offer);
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
		updateJobSeekerProficiency(iss.getInterviewSuggestion(), js);
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

	public List<InterviewSuggestionStatusDTO> getAll(JobSeeker js) {
		List<InterviewSuggestionStatus> iss = statusRepository.findAllByJobSeeker(js);
		List<InterviewSuggestionStatusDTO> dtos = new ArrayList<>();
		for (InterviewSuggestionStatus i : iss) {
			JobOffer jo = i.getJobOfferDifference().getStatistic().getJobOffer();
			dtos.add(new InterviewSuggestionStatusDTO(i, jo));
		}
		return dtos;
	}

	private void updateJobSeekerProficiency(InterviewSuggestion suggestion, JobSeeker js) {
		String name = suggestion.getElementProficiency().getCvElement().getName();
		CVElement cvElement = cvElementRepository.findOneByName(name);
		CVElementProficiency oldProficiency = js.getProficiencies().stream()
				.filter(el -> el.getCvElement().getName().equals(name)).collect(Collectors.toList()).get(0);
		SkillProficiency skillProficiency = suggestion.getElementProficiency().getProficiency();
		CVElementProficiency proficiency = cvElementProficiencyRepository.findOneByCVElementAndProficiency(cvElement,
				skillProficiency);
		proficiency.setProficiency(skillProficiency);
		js.getProficiencies().remove(oldProficiency);
		js.getProficiencies().add(proficiency);
	}

}
