package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.interview.InterviewSuggestionGroupDTO;
import ftn.sbnz.dto.interview.InterviewSuggestionStatusDTO;
import ftn.sbnz.events.StudiedTodayEvent;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.interview.InterviewSuggestionGroup;
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
@Transactional
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
			JobSeekerRepository jobSeekerRepository, CVElementRepository cvElementRepository,
			CVElementProficiencyRepository cvElementProficiencyRepository, KieSessionService kieSession) {
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.differenceRepository = differenceRepository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.cvElementRepository = cvElementRepository;
		this.cvElementProficiencyRepository = cvElementProficiencyRepository;
		this.kieSession = kieSession;
	}

	public InterviewSuggestionGroupDTO create(Long jobOfferDifferenceId, Long jobSeekerId) {
		JobOfferDifference jod = differenceRepository.getOneById(jobOfferDifferenceId);
		JobOffer offer = jod.getStatistic().getJobOffer();
		JobSeeker js = (JobSeeker) this.jobSeekerRepository.getOne(jobSeekerId);
		Calendar rightNow = Calendar.getInstance();

		InterviewSuggestionGroup isg = new InterviewSuggestionGroup();
		isg.setJobOfferDifference(jod);
		suggest(isg);
		List<InterviewSuggestion> suggestions = isg.getInterviewSuggestions();
		List<InterviewSuggestionStatus> statuses = new ArrayList<>();
		for (InterviewSuggestion is : suggestions) {
			boolean exists = checkIfMaterialAlreadyExists(js, is, offer);
			if(!exists) {
				InterviewSuggestionStatus isstat = new InterviewSuggestionStatus(new Timestamp(rightNow.getTimeInMillis()));
				isstat.setChecked(false);
				isstat.setJobSeeker(js);
				isstat.setJobOfferDifference(jod);
				isstat.setInterviewSuggestion(is);
				isstat = statusRepository.save(isstat);
				jod.getInterviewSuggestionStatuses().add(isstat);
				js.getInterviewSuggestions().add(isstat);
				statuses.add(isstat);				
			}
		}
		
		if (statuses.size() != 0) {
			differenceRepository.save(jod);
			jobSeekerRepository.save(js);
			
			InterviewSuggestionGroupDTO dto = new InterviewSuggestionGroupDTO(statuses, offer);
			return dto;			
		}
		
		return null; //moze metoda bez problema i da bude void?

	}

	private boolean checkIfMaterialAlreadyExists(JobSeeker js, InterviewSuggestion suggestion, JobOffer jo) {
		List<InterviewSuggestionStatus> statuses = js.getInterviewSuggestions().stream().filter(
				el -> el.getJobOfferDifference().getStatistic().getJobOffer().equals(jo)).collect(Collectors.toList());
		if (statuses.size() == 0)
			return false;
		List<Long> suggestions = statuses.stream().map(el -> el.getInterviewSuggestion().getId()).collect(Collectors.toList());
		if (suggestions.contains(suggestion.getId()))
			return true;
		return false;
		
	}

	public void suggest(InterviewSuggestionGroup group) {
		kieSession.insert(group);
		kieSession.setAgendaFocus("interview-suggestion");
		kieSession.fireAllRules();
	}

	public void check(Long interviewSuggestionStatusId, Long jobSeekerId) throws Exception {
		InterviewSuggestionStatus iss = statusRepository.getOneById(interviewSuggestionStatusId);
		JobSeeker js = (JobSeeker) this.jobSeekerRepository.getOne(jobSeekerId);
		updateJobSeekerProficiency(iss.getInterviewSuggestion(), js);
		updateInterviewSuggestionStatus(iss.getInterviewSuggestion(), js);
		StudiedTodayEvent event = new StudiedTodayEvent(js.getId());
		triggerEvent(event);
	}

	public void triggerEvent(StudiedTodayEvent event) {
		kieSession.insert(event);
		kieSession.setAgendaFocus("studied-today");
		kieSession.fireAllRules();
	}

	public List<InterviewSuggestionGroupDTO> getAll(JobSeeker js) {
		List<InterviewSuggestionStatus> iss = statusRepository.findAllByJobSeeker(js);
		HashMap<JobOffer, List<InterviewSuggestionStatusDTO>> map = new HashMap<>();
		for (InterviewSuggestionStatus i : iss) {
			JobOffer jo = i.getJobOfferDifference().getStatistic().getJobOffer();
			HashMap<String, Object> result = checkMaterial(js, i.getInterviewSuggestion());
			boolean forbidden = (boolean) result.get("forbidden");
			if (!map.containsKey(jo)) {
				List<InterviewSuggestionStatusDTO> statuses = new ArrayList<>();
				statuses.add(new InterviewSuggestionStatusDTO(i, forbidden));
				map.put(jo, statuses);
			} else {
				map.get(jo).add(new InterviewSuggestionStatusDTO(i, forbidden));
			}
		}
		List<InterviewSuggestionGroupDTO> dtos = new ArrayList<>();
		map.forEach((offer, statuses) -> {
			InterviewSuggestionGroupDTO dto = new InterviewSuggestionGroupDTO();
			dto.setCompany(offer.getCompany().getName());
			dto.setPosition(offer.getPosition().getTitle());
			dto.setSeniority(offer.getSeniority());
			dto.setStatuses(statuses);
			dtos.add(dto);
		});

		return dtos;
	}

	private void updateJobSeekerProficiency(InterviewSuggestion suggestion, JobSeeker js) throws Exception {
		HashMap<String, Object> results = checkMaterial(js, suggestion);
		if ((boolean) results.get("forbidden"))
			throw new Exception("You need to study materials with lower proficiency first!");

		if (results.get("oldProficiency") != null) {
			js.getProficiencies().remove(results.get("oldProficiency"));
		}

		js.getProficiencies().add((CVElementProficiency) results.get("newProficiency"));

	}

	private void updateInterviewSuggestionStatus(InterviewSuggestion suggestion, JobSeeker js) {
		List<InterviewSuggestionStatus> statuses = this.statusRepository.findAllByJobSeekerAndInterviewSuggestion(js,
				suggestion);
		for (InterviewSuggestionStatus status : statuses) {
			Calendar rightNow = Calendar.getInstance();
			status.setChecked(true);
			status.setDateChecked(new Timestamp(rightNow.getTimeInMillis()));
			statusRepository.save(status);
		}
	}

	private HashMap<String, Object> checkMaterial(JobSeeker js, InterviewSuggestion suggestion) {
		String name = suggestion.getCvElementProficiency().getCvElement().getName();
		CVElement cvElement = cvElementRepository.findOneByName(name);
		List<CVElementProficiency> oldProficiencies = js.getProficiencies().stream()
				.filter(el -> el.getCvElement().getName().equals(name)).collect(Collectors.toList());
		SkillProficiency skillProficiency = suggestion.getCvElementProficiency().getProficiency();
		CVElementProficiency newProficiency = cvElementProficiencyRepository.findOneByCvElementAndProficiency(cvElement,
				skillProficiency);
		newProficiency.setProficiency(skillProficiency);
		CVElementProficiency oldProficiency = null;
		boolean forbidden = false;
		if (oldProficiencies.size() == 0) {
			if (skillProficiency != SkillProficiency.BASIC) {
				forbidden = true;
			}
		} else {
			oldProficiency = oldProficiencies.get(0);
			if (skillProficiency.getValue() != (oldProficiency.getProficiency().getValue() + 1))
				forbidden = true;
		}

		HashMap<String, Object> results = new HashMap<>();
		results.put("forbidden", forbidden);
		results.put("newProficiency", newProficiency);
		results.put("oldProficiency", oldProficiency);

		return results;
	}

}
