package ftn.sbnz.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.interview.InterviewSuggestionStatusDTO;
import ftn.sbnz.events.StudiedTodayEvent;
import ftn.sbnz.model.enums.CVElement;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.interview.InterviewSuggestion;
import ftn.sbnz.model.interview.InterviewSuggestionStatus;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_offer.JobOfferDifference;
import ftn.sbnz.model.knowledge.Knowledge;
import ftn.sbnz.model.knowledge.KnowledgeProficiency;
import ftn.sbnz.model.language.Language;
import ftn.sbnz.model.language.LanguageProficiency;
import ftn.sbnz.model.programming_language.ProgrammingLanguage;
import ftn.sbnz.model.programming_language.ProgrammingProficiency;
import ftn.sbnz.model.soft_skill.SoftSkill;
import ftn.sbnz.model.soft_skill.SoftSkillProficiency;
import ftn.sbnz.model.technology.Technology;
import ftn.sbnz.model.technology.TechnologyProficiency;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.repository.interview.InterviewSuggestionRepository;
import ftn.sbnz.repository.interview.InterviewSuggestionStatusRepository;
import ftn.sbnz.repository.job_offer.JobOfferDifferenceRepository;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.knowledge.KnowledgeProficiencyRepository;
import ftn.sbnz.repository.knowledge.KnowledgeRepository;
import ftn.sbnz.repository.language.LanguageProficiencyRepository;
import ftn.sbnz.repository.language.LanguageRepository;
import ftn.sbnz.repository.programming_language.ProgrammingLanguageRepository;
import ftn.sbnz.repository.programming_language.ProgrammingProficiencyRepository;
import ftn.sbnz.repository.soft_skill.SoftSkillProficiencyRepository;
import ftn.sbnz.repository.soft_skill.SoftSkillRepository;
import ftn.sbnz.repository.technology.TechnologyProficiencyRepository;
import ftn.sbnz.repository.technology.TechnologyRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;

@Service
public class InterviewSuggestionService {
	
	private InterviewSuggestionRepository repository;
	private InterviewSuggestionStatusRepository statusRepository;
	private JobOfferDifferenceRepository differenceRepository;
	private JobSeekerRepository jobSeekerRepository;
	private JobOfferRepository jobOfferRepository;
	private KieSessionService kieSession;
	
	//TODO: ovo ce se refaktorisati za diplomski da bude normalno, a ne ovako krs uradjeno
	private TechnologyRepository tRepository;
	private TechnologyProficiencyRepository tpRepository;
	private SoftSkillRepository sRepository;
	private SoftSkillProficiencyRepository spRepository;
	private ProgrammingLanguageRepository pRepository;
	private ProgrammingProficiencyRepository ppRepository;
	private LanguageRepository lRepository;
	private LanguageProficiencyRepository lpRepository;
	private KnowledgeRepository kRepository;
	private KnowledgeProficiencyRepository kpRepository;
	
	@Autowired
	public InterviewSuggestionService(InterviewSuggestionRepository repository,
			InterviewSuggestionStatusRepository statusRepository, JobOfferDifferenceRepository differenceRepository,
			JobSeekerRepository jobSeekerRepository, JobOfferRepository jobOfferRepository, KieSessionService kieSession,
			TechnologyRepository tRepository, TechnologyProficiencyRepository tpRepository,
			SoftSkillRepository sRepository, SoftSkillProficiencyRepository spRepository,
			ProgrammingLanguageRepository pRepository, ProgrammingProficiencyRepository ppRepository,
			LanguageRepository lRepository, LanguageProficiencyRepository lpRepository,
			KnowledgeRepository kRepository, KnowledgeProficiencyRepository kpRepository) {
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.differenceRepository = differenceRepository;
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobOfferRepository = jobOfferRepository;
		this.kieSession = kieSession;
		this.tRepository = tRepository;
		this.tpRepository = tpRepository;
		this.sRepository = sRepository;
		this.spRepository = spRepository;
		this.pRepository = pRepository;
		this.ppRepository = ppRepository;
		this.lRepository = lRepository;
		this.lpRepository = lpRepository;
		this.kRepository = kRepository;
		this.kpRepository = kpRepository;
		
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
		updateJobSeekerProficiencies(iss.getInterviewSuggestions(), js);
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
	
	private void updateJobSeekerProficiencies(List<InterviewSuggestion> suggestions, JobSeeker js) {
		CVElement cvElement = suggestions.get(0).getCvElement();
		String elementName = suggestions.get(0).getSubject();
		SkillProficiency maxProficiency = SkillProficiency.NONE;
		
		for (InterviewSuggestion is : suggestions) {
			if (is.getProficiency().getValue() >= maxProficiency.getValue()) {
				maxProficiency = is.getProficiency();
			}
		}
		
		if (cvElement == CVElement.TECHNOLOGY) {
			boolean exist = false;
			Technology t = tRepository.findOneByName(elementName);
			TechnologyProficiency tp = tpRepository.findOneByTechnologyAndProficiency(t, maxProficiency);
			for (TechnologyProficiency p : js.getTechnologyProficiencies()) {
				if (p.getTechnology().getName().equalsIgnoreCase(elementName)) {
					p.setProficiency(maxProficiency);
					exist = true;
					break;
				}
			}
			if (!exist) {
				js.getTechnologyProficiencies().add(tp);
			}
		} else if (cvElement == CVElement.SOFT_SKILL) {
			boolean exist = false;
			SoftSkill t = sRepository.findOneByName(elementName);
			SoftSkillProficiency tp = spRepository.findOneBySoftSkillAndProficiency(t, maxProficiency);
			for (SoftSkillProficiency p : js.getSoftSkillProficiencies()) {
				if (p.getSoftSkill().getName().equalsIgnoreCase(elementName)) {
					p.setProficiency(maxProficiency);
					exist = true;
					break;
				}
			}
			if (!exist) {
				js.getSoftSkillProficiencies().add(tp);
			}
		} else if (cvElement == CVElement.PROGRAMMING_LANGUAGE) {
			boolean exist = false;
			ProgrammingLanguage t = pRepository.findOneByName(elementName);
			ProgrammingProficiency tp = ppRepository.findOneByProgrammingLanguageAndProficiency(t, maxProficiency);
			for (ProgrammingProficiency p : js.getProgrammingProficiencies()) {
				if (p.getProgrammingLanguage().getName().equalsIgnoreCase(elementName)) {
					p.setProficiency(maxProficiency);
					exist = true;
					break;
				}
			}
			if (!exist) {
				js.getProgrammingProficiencies().add(tp);
			}
		} else if (cvElement == CVElement.LANGUAGE) {
			boolean exist = false;
			Language t = lRepository.findOneByName(elementName);
			LanguageProficiency tp = lpRepository.findOneByLanguageAndProficiency(t, maxProficiency);
			for (LanguageProficiency p : js.getLanguageProficiencies()) {
				if (p.getLanguage().getName().equalsIgnoreCase(elementName)) {
					p.setProficiency(maxProficiency);
					exist = true;
					break;
				}
			}
			if (!exist) {
				js.getLanguageProficiencies().add(tp);
			}
		} else if (cvElement == CVElement.KNOWLEDGE) {
			boolean exist = false;
			Knowledge t = kRepository.findOneByName(elementName);
			KnowledgeProficiency tp = kpRepository.findOneByKnowledgeAndProficiency(t, maxProficiency);
			for (KnowledgeProficiency p : js.getKnowledgeProficiencies()) {
				if (p.getKnowledge().getName().equalsIgnoreCase(elementName)) {
					p.setProficiency(maxProficiency);
					exist = true;
					break;
				}
			}
			if (!exist) {
				js.getKnowledgeProficiencies().add(tp);
			}
		}
		
	}

}
