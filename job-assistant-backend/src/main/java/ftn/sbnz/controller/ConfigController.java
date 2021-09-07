package ftn.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.ConfigDetailsDTO;
import ftn.sbnz.service.ConfigService;

@RestController
@Validated
@RequestMapping(value = "/api/config", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConfigController {
	
	private ConfigService service;
	
	@Autowired
	public ConfigController (ConfigService service) {
		this.service = service;
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<ConfigDetailsDTO> getConfig(){
		ConfigDetailsDTO dto = service.getDetails();
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> updateConfig(@RequestBody ConfigDetailsDTO dto){
		service.updateConfig(dto);
		service.updateRules();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
