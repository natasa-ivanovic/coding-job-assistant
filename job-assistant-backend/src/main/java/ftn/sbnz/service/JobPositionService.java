package ftn.sbnz.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.job_position.JobPositionDTO;
import ftn.sbnz.dto.job_position.JobPositionElementsDTO;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.repository.cv_element.CVElementRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;

@Service
public class JobPositionService {

	private JobPositionRepository repository;
	
	private CVElementRepository cvElementRepository;

	@Autowired
	public JobPositionService(JobPositionRepository repository, CVElementRepository cvElementRepository) {
		this.repository = repository;
		this.cvElementRepository = cvElementRepository;
	}

	public List<JobPositionDTO> getAll() {
		List<JobPosition> positions = repository.findAll();
		return positions.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	private JobPositionDTO toDTO(JobPosition jp) {
		return new JobPositionDTO(jp);
	}

	public void create(JobPositionDTO dto) {
		JobPosition jp = new JobPosition(dto.getTitle());
		this.repository.save(jp);
	}

	public void edit(JobPositionDTO dto, Long id) {
		JobPosition jp = this.repository.getOne(id);
		jp.setTitle(dto.getTitle());
		this.repository.save(jp);
	}

	public void editElements(JobPositionElementsDTO dto, Long id) {
		JobPosition jp = this.repository.getOne(id);
		Set<CVElement> set = new HashSet<>();
		for (Long l : dto.getPositionIds()) {
			CVElement el = this.cvElementRepository.getOne(l);
			set.add(el);
		}
		jp.setCvElements(set);
		this.repository.save(jp);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);		
	}
}
