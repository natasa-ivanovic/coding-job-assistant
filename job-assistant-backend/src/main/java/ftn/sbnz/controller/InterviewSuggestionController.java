package ftn.sbnz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.interview.InterviewSuggestionStatusDTO;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.service.InterviewSuggestionService;

@RestController
@Validated
@RequestMapping(value = "/api/interview-suggestion", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterviewSuggestionController {
	
	private InterviewSuggestionService service;
	
	@Autowired
	public InterviewSuggestionController(InterviewSuggestionService service) {
		this.service = service;
	}
	
	@PostMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> suggest(@PathVariable("id") String jobOfferDifferenceId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		InterviewSuggestionStatusDTO dto = service.create(Long.parseLong(jobOfferDifferenceId), jobSeeker.getId());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/check/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> check(@PathVariable("id") String InterviewSuggestionStatusId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		InterviewSuggestionStatusDTO dto = service.check(Long.parseLong(InterviewSuggestionStatusId), jobSeeker.getId());
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping()
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> getAll() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		List<InterviewSuggestionStatusDTO> dto = service.getAll(jobSeeker);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}


}
