package ftn.sbnz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.job_position.JobPositionDTO;
import ftn.sbnz.dto.job_position.JobPositionElementsDTO;
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
	
	@GetMapping("/with-elements")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<List<JobPositionElementsDTO>> getAllWithElements() {
		List<JobPositionElementsDTO> dtos = service.getAllWithElements();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> create(@RequestBody JobPositionElementsDTO dto) throws Exception {
		service.create(dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> edit(@RequestBody JobPositionElementsDTO dto, @PathVariable Long id) throws Exception {
		service.edit(dto, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
