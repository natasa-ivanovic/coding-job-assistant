package ftn.sbnz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.job_position.JobPositionDTO;
import ftn.sbnz.service.JobPositionService;

@RestController
@Validated
@RequestMapping(value = "/api/job-position", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobPositionController {
	
	private JobPositionService service;
	
	@Autowired
	public JobPositionController(JobPositionService service) {
		this.service = service;
	}
		
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseEntity<List<JobPositionDTO>> getAll() {
		List<JobPositionDTO> dtos = service.getAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

}
