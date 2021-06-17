package ftn.sbnz.service;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.UserDTO;
import ftn.sbnz.dto.UserTokenStateDTO;
import ftn.sbnz.events.InvalidLoginEvent;
import ftn.sbnz.events.UserLoginStatusEvent;
import ftn.sbnz.exception.UserException;
import ftn.sbnz.model.auth.Authority;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.User;
import ftn.sbnz.repository.user.UserRepository;
import ftn.sbnz.security.CustomUserDetailsService;
import ftn.sbnz.security.TokenUtils;

@Service
public class UserService {

	private UserRepository userRepository;
	private TokenUtils tokenUtils;
	private AuthenticationManager authenticationManager;
	private CustomUserDetailsService userDetailsService;
	private KieSessionService kieSession;
	private AuthorityService authorityService;

	@Autowired
	public UserService(UserRepository userRepository, TokenUtils tokenUtils,
			AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService,
			KieSessionService kieSession, AuthorityService authorityService) {
		this.userRepository = userRepository;
		this.tokenUtils = tokenUtils;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.kieSession = kieSession;
		this.authorityService = authorityService;
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findUser(Long id) {
		return userRepository.getOne(id);
	}

	public void save(JobSeeker dbJobSeeker) {
		this.userRepository.save(dbJobSeeker);
	}

	public UserTokenStateDTO login(String username, String password) throws UserException {
		User existUser = null;
		try {
			existUser = getOne(username);
		} catch (NoSuchElementException e) {
			throw new UserException("No such element!", "username", "User with this username doesn't exist.");
		}

		if (!existUser.isEnabled()) {
			throw new DisabledException("Your account hasn't been activated yet. Please check your email!");
		}

		if (existUser.getKey() != null && existUser.getRole().equals("USER")) {
			throw new DisabledException("Your password hasn't been reset yet. Please check your email!");
		}

		UserTokenStateDTO token = generateToken(username, password, existUser);
		return token;
	}

	public User getOne(String username) throws NoSuchElementException {
		User user = findByUsername(username);
		if (user == null) {
			throw new NoSuchElementException("User with this username doesn't exist!");
		}
		return user;
	}

	public UserTokenStateDTO generateToken(String username, String password, User user) throws UserException {
		Authentication authentication = null;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			if (user.getRole().equals("USER")) {
				// suspicious login event for user
				UserLoginStatusEvent check = new UserLoginStatusEvent(user.getId());
				kieSession.insert(new InvalidLoginEvent(user.getId()));
				kieSession.insert(check);
				kieSession.setAgendaFocus("user-login-check");
				kieSession.fireAllRules();
				if (check.isAllowed()) {
					// allowed to try again
					throw new UserException("Bad credentials exception!", "password", "Incorrect password.");
				} else {
					// not allowed - set access code and tell user
					generateUserAccesToken(user);
					throw new UserException("Too many failed attempts! Visit your email to reset your password.",
							"password", "Incorrect password.");
				}
			} else {
				// no event for admin
				throw new UserException("Bad credentials exception!", "password", "Incorrect password.");
			}
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		return new UserTokenStateDTO(user.getId(), jwt, expiresIn, user.getUsername(), user.getName(),
				user.getSurname(), user.getRole());
	}

	private void generateUserAccesToken(User user) {
		String key = UUID.randomUUID().toString();
		user.setKey(key);
		// poslati preko mejla key korisniku
		System.out.println("Key sent over email for user " + user.getUsername() + ", key: " + key);
		userRepository.save(user);
	}

	public void resetPassword(String username, String password, String key) throws UserException {
		User user = userRepository.findByKey(key);
		if (!user.getUsername().equals(username)) {
			throw new UserException("Wrong username for key! Please try again.", "username", "Invalid username.");
		}
		userDetailsService.changePasswordUtil(user, password);
		user.setKey(null);
		userRepository.save(user);
		kieSession.removeLoginEvents(user.getId());
	}

	public void register(UserDTO userDTO) throws UserException {
		User user = findByUsername(userDTO.getUsername());
		if (user != null) {
			throw new UserException("Username is already taken! Please try again.", "username", "Invalid username");
		}
		JobSeeker js = new JobSeeker();
		js.setUsername(userDTO.getUsername());
		js.setName(userDTO.getName());
		js.setSurname(userDTO.getSurname());
		js.setPassword(userDetailsService.encodePassword(userDTO.getPassword()));
		js.setRole("USER");
		ArrayList<Authority> auth = new ArrayList<>();
		auth.add(authorityService.findByName("ROLE_USER"));
		js.setAuthorities(auth);
		js.setEnabled(true); //TODO: account activation mail
		
		save(js);
	}
}
