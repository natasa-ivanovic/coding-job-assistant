package ftn.sbnz.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sbnz.dto.cv_element.CVElementDTO;
import ftn.sbnz.dto.cv_element.CVElementProficiencyDTO;
import ftn.sbnz.dto.user.UserDTO;
import ftn.sbnz.dto.user.UserDetailsDTO;
import ftn.sbnz.dto.user.UserExperienceDTO;
import ftn.sbnz.dto.user.UserResumeDTO;
import ftn.sbnz.dto.user.UserTokenStateDTO;
import ftn.sbnz.dto.user.WorkingExperienceDTO;
import ftn.sbnz.events.InvalidLoginEvent;
import ftn.sbnz.events.UserAccountStatusEvent;
import ftn.sbnz.events.UserLoginStatusEvent;
import ftn.sbnz.exception.UserException;
import ftn.sbnz.model.auth.Authority;
import ftn.sbnz.model.cv_element.CVElement;
import ftn.sbnz.model.cv_element.CVElementProficiency;
import ftn.sbnz.model.enums.SkillProficiency;
import ftn.sbnz.model.job_position.JobPosition;
import ftn.sbnz.model.user.JobSeeker;
import ftn.sbnz.model.user.User;
import ftn.sbnz.model.user.WorkingExperience;
import ftn.sbnz.repository.cv_element.CVElementProficiencyRepository;
import ftn.sbnz.repository.cv_element.CVElementRepository;
import ftn.sbnz.repository.job_position.JobPositionRepository;
import ftn.sbnz.repository.user.JobSeekerRepository;
import ftn.sbnz.repository.user.UserRepository;
import ftn.sbnz.repository.user.WorkingExperienceRepository;
import ftn.sbnz.security.CustomUserDetailsService;
import ftn.sbnz.security.TokenUtils;

@Service
@Transactional
public class UserService {

	private UserRepository userRepository;
	private TokenUtils tokenUtils;
	private AuthenticationManager authenticationManager;
	private CustomUserDetailsService userDetailsService;
	private KieSessionService kieSession;
	private AuthorityService authorityService;
	private JobSeekerRepository jobSeekerRepository;
	private CVElementProficiencyRepository cvElementProficiencyRepository;
	private WorkingExperienceRepository workingExperienceRepository;
	private JobPositionRepository jobPositionRepository;
	private CVElementRepository cvElementRepository;

	@Autowired
	public UserService(UserRepository userRepository, TokenUtils tokenUtils,
			AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService,
			KieSessionService kieSession, AuthorityService authorityService, JobSeekerRepository jobSeekerRepository,
			CVElementProficiencyRepository cvElementProficiencyRepository,
			WorkingExperienceRepository workingExperienceRepository, JobPositionRepository jobPositionRepository,
			CVElementRepository cvElementRepository) {
		this.userRepository = userRepository;
		this.tokenUtils = tokenUtils;
		this.authenticationManager = authenticationManager;
		this.userDetailsService = userDetailsService;
		this.kieSession = kieSession;
		this.authorityService = authorityService;
		this.jobSeekerRepository = jobSeekerRepository;
		this.cvElementProficiencyRepository = cvElementProficiencyRepository;
		this.workingExperienceRepository = workingExperienceRepository;
		this.jobPositionRepository = jobPositionRepository;
		this.cvElementRepository = cvElementRepository;
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

	public UserTokenStateDTO login(String username, String password) throws Exception {
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

		if (userBanned(existUser.getId())) {
			throw new Exception("User has been banned for posting too many malicious reviews!");
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
		Set<Authority> auth = new HashSet<>();
		auth.add(authorityService.findByName("ROLE_USER"));
		js.setAuthorities(auth);
		js.setEnabled(true); // TODO: account activation mail

		save(js);
	}

	private boolean userBanned(Long jobSeekerId) {
		UserAccountStatusEvent fact = new UserAccountStatusEvent(jobSeekerId);
		kieSession.insert(fact);
		kieSession.setAgendaFocus("user-account-status-check");
		kieSession.fireAllRules();
		return fact.isBanned();
	}

	public UserDetailsDTO getDetails(Long userId) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		return new UserDetailsDTO(js);
	}

	public void updateDetails(Long userId, UserDetailsDTO dto) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		js.setName(dto.getName());
		js.setSurname(dto.getSurname());
		js.setEducation(dto.getEducation());
		js.setRemoteWork(dto.isRemoteWork());
		js.setSalaryExpectation(dto.getSalaryExpectation());
		this.jobSeekerRepository.save(js);
	}

	public UserResumeDTO getResume(Long userId) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		return new UserResumeDTO(js);
	}

	public void updateResume(Long userId, UserResumeDTO dto) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		Set<CVElementProficiency> newProficiencies = new HashSet<>();
		for (CVElementProficiencyDTO el : dto.getProficiencies()) {
			String cvElementName = el.getElementName();
			SkillProficiency proficiency = el.getProficiency();
			CVElementProficiency prof = this.cvElementProficiencyRepository
					.findOneByCvElementNameAndProficiency(cvElementName, proficiency);
			newProficiencies.add(prof);
		}
		js.setProficiencies(newProficiencies);
		this.jobSeekerRepository.save(js);
	}

	public UserExperienceDTO getWorkingExperience(Long userId) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		return new UserExperienceDTO(js);
	}

	
	public void updateWorkingExperience(Long userId, UserExperienceDTO dto) {
		JobSeeker js = this.jobSeekerRepository.getOne(userId);
		List<WorkingExperience> newExperience = new ArrayList<>();
		for (WorkingExperienceDTO el : dto.getWorkingExperience()) {
			List<CVElement> cvElements = new ArrayList<>();
			for (CVElementDTO cvEl : el.getCvElements()) {
				CVElement element = this.cvElementRepository.findOneByName(cvEl.getName());
				cvElements.add(element);
			}
			JobPosition position = this.jobPositionRepository.findOneByTitle(el.getPositionName());
			WorkingExperience exp = new WorkingExperience(el, cvElements, position);
			exp = this.workingExperienceRepository.save(exp);
			newExperience.add(exp);
		}
		List<WorkingExperience> oldExperiences = js.getWorkingExperience();
		js.setWorkingExperience(newExperience);
		this.jobSeekerRepository.save(js);
		for (WorkingExperience el : oldExperiences) {
			this.workingExperienceRepository.deleteById(el.getId());
		}
	}
}
