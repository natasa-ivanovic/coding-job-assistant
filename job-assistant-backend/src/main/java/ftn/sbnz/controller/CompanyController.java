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

import ftn.sbnz.dto.company.CompanyDTO;
import ftn.sbnz.service.CompanyService;

@RestController
@Validated
@RequestMapping(value = "/api/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
	
	private CompanyService service;
	
	@Autowired
	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseEntity<List<CompanyDTO>> getAll() {
		List<CompanyDTO> dtos = service.getAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Long> create(@RequestBody CompanyDTO dto) throws Exception {
		Long id = service.create(dto);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> edit(@RequestBody CompanyDTO dto, @PathVariable Long id) throws Exception {
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
