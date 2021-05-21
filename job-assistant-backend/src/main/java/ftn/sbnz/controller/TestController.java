package ftn.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.model.Test;
import ftn.sbnz.service.TestService;

@RestController
@RequestMapping(value = "/api/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping()
	public ResponseEntity<Test> getTest() {
		Test test = testService.test();
		return new ResponseEntity<>(test, HttpStatus.OK);
	}
}
