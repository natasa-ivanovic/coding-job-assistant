package ftn.sbnz.controller;

import java.util.List;
import java.util.Map;

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

import ftn.sbnz.dto.cv_element.CVElementDTO;
import ftn.sbnz.service.CVElementService;

@RestController
@Validated
@RequestMapping(value = "/api/cv-elements", produces = MediaType.APPLICATION_JSON_VALUE)
public class CVElementController {

	private CVElementService service;
	
	@Autowired
	public CVElementController(CVElementService service) {
		this.service = service;
	}
	
	@GetMapping("/by-type")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseEntity<Map<String, List<CVElementDTO>>> getAllByType() {
		Map<String, List<CVElementDTO>> dtos = service.getAllByType();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseEntity<List<CVElementDTO>> getAll() {
		List<CVElementDTO> dtos = service.getAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@PostMapping
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Long> create(@RequestBody CVElementDTO dto) throws Exception {
		Long id = service.create(dto);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> edit(@RequestBody CVElementDTO dto, @PathVariable Long id) throws Exception {
		service.edit(dto, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
