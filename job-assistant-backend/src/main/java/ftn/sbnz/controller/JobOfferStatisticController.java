package ftn.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.job_offer.JobOfferStatisticDTO;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.service.JobOfferStatisticService;

@RestController
@Validated
@RequestMapping(value = "/api/job-offer-statistic", produces = MediaType.APPLICATION_JSON_VALUE)
public class JobOfferStatisticController {
	
	private JobOfferStatisticService service;
	
	@Autowired
	public JobOfferStatisticController(JobOfferStatisticService service) {
		this.service = service;
	}
	
	@PostMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Object> analyze(@PathVariable("id") String jobOfferId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JobSeeker jobSeeker = (JobSeeker) auth.getPrincipal();
		JobOfferStatisticDTO dto = service.create(jobSeeker.getId(), Long.parseLong(jobOfferId));
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
