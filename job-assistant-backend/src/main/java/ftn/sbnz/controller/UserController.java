package ftn.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.sbnz.dto.user.UserDetailsDTO;
import ftn.sbnz.model.user.User;
import ftn.sbnz.service.UserService;

@RestController
@Validated
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/my-profile/details")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<UserDetailsDTO> getMyProfile(@AuthenticationPrincipal User user){
		Long userId = user.getId();
		UserDetailsDTO dto = userService.getDetails(userId);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@PutMapping("/my-profile/details")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<UserDetailsDTO> updateMyProfile(@AuthenticationPrincipal User user, @RequestBody UserDetailsDTO dto){
		Long userId = user.getId();
		userService.updateDetails(userId, dto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
