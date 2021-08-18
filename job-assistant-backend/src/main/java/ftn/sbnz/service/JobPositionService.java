package ftn.sbnz.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.job_position.JobPositionDTO;
import ftn.sbnz.dto.job_position.JobPositionElementsDTO;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.job_offer.JobOffer;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.repository.cv_element.CVElementRepository;
import ftn.sbnz.repository.job_offer.JobOfferRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;

@Service
@Transactional
public class JobPositionService {

	private JobPositionRepository repository;
	private JobOfferRepository offerRepository;
	private CVElementRepository cvElementRepository;
	private KieSessionService kieSession;

	@Autowired
	public JobPositionService(JobPositionRepository repository, CVElementRepository cvElementRepository,
			JobOfferRepository offerRepository, KieSessionService kieSession) {
		this.repository = repository;
		this.cvElementRepository = cvElementRepository;
		this.offerRepository = offerRepository;
		this.kieSession = kieSession;
	}

	public List<JobPositionDTO> getAll() {
		List<JobPosition> positions = repository.findAll();
		return positions.stream().map(this::toDTO).collect(Collectors.toList());
	}

	public List<JobPositionElementsDTO> getAllWithElements() {
		List<JobPosition> positions = repository.findAll();
		return positions.stream().map(this::toElementsDTO).collect(Collectors.toList());
	}
	
	public JobPositionDTO toDTO(JobPosition jp) {
		return new JobPositionDTO(jp);
	}
	
	public JobPositionElementsDTO toElementsDTO(JobPosition jp) {
		return new JobPositionElementsDTO(jp);
	}

	public Long create(JobPositionElementsDTO dto) throws Exception {
		JobPosition check = repository.findOneByTitle(dto.getTitle());
		if (check != null)
			throw new Exception("Job position name is not unique!");
		JobPosition jp = new JobPosition(dto.getTitle());
		Set<CVElement> set = new HashSet<>();
		for (Long l : dto.getElementIds()) {
			CVElement el = this.cvElementRepository.getOne(l);
			set.add(el);
		}
		jp.setCvElements(set);
		jp = this.repository.save(jp);
		this.kieSession.insert(jp);
		return jp.getId();
	}

	public void edit(JobPositionElementsDTO dto, Long id) throws Exception {
		JobPosition check = repository.findOneByTitle(dto.getTitle());
		if (check != null && check.getId() != id)
			throw new Exception("Job position name is not unique!");
		JobPosition jp = this.repository.getOne(id);
		jp.setTitle(dto.getTitle());
		Set<CVElement> set = new HashSet<>();
		for (Long l : dto.getElementIds()) {
			CVElement el = this.cvElementRepository.getOne(l);
			set.add(el);
		}
		jp.setCvElements(set);
		jp = this.repository.save(jp);
		this.kieSession.removeJobPositionById(id);
		this.kieSession.insert(jp);
	}

	public void delete(Long id) throws Exception {
		List<JobOffer> offers = this.offerRepository.findAllByPositionId(id);
		if (offers.size() != 0)
			throw new Exception("Job position referenced by offers. Cannot delete!");
		this.repository.deleteById(id);
		this.kieSession.removeJobPositionById(id);
	}

}
