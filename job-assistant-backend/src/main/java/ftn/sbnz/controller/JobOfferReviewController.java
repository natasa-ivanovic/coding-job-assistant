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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.job_offer.JobOfferReviewDTO;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.service.JobOfferReviewService;

@RestController
@Validated
@RequestMapping(value = "/api/job-offer-review", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobOfferReviewController {

	private JobOfferReviewService service;
	
	@Autowired
	public JobOfferReviewController(JobOfferReviewService service) {
		this.service = service;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> createReview(@RequestBody JobOfferReviewDTO dto) throws Exception {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		service.create(dto, jobSeeker);
		return new ResponseEntity<>("Successfully added a review request", HttpStatus.OK);
	}

	@PostMapping("/approve/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> approveReview(@PathVariable(name = "id") Long id) throws Exception {
		service.approve(id);
		return new ResponseEntity<>("Successfully approved review", HttpStatus.OK);
	}

	@PostMapping("/decline/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> declineReview(@PathVariable(name = "id") Long id) throws Exception {
		service.decline(id);
		return new ResponseEntity<>("Successfully declined review", HttpStatus.OK);
	}
	
	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<JobOfferReviewDTO>> getAllReviews() throws Exception {
		List<JobOfferReviewDTO> reviews = service.getAll();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
}
