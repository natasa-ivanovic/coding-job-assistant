package ftn.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.job_offer.JobOfferSuggestionDTO;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.service.JobOfferSuggestionService;

@RestController
@Validated
@RequestMapping(value = "/api/job-offer-suggestion", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobOfferSuggestionController {
	
	private JobOfferSuggestionService service;
	
	@Autowired
	public JobOfferSuggestionController(JobOfferSuggestionService service) {
		this.service = service;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> requestSuggestion() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		JobOfferSuggestionDTO dto = service.create(jobSeeker);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
