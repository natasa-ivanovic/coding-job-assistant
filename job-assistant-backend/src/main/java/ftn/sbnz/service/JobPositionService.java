package ftn.sbnz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.job_position.JobPositionDTO;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.repository.job_position.JobPositionRepository;

@Service
public class JobPositionService {

	private JobPositionRepository repository;

	@Autowired
	public JobPositionService(JobPositionRepository repository) {
		this.repository = repository;
	}

	public List<JobPositionDTO> getAll() {
		List<JobPosition> positions = repository.findAll();
		return positions.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	private JobPositionDTO toDTO(JobPosition jp) {
		return new JobPositionDTO(jp);
	}
}
