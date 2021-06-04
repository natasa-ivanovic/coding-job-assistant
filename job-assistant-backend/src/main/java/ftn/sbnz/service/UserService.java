package ftn.sbnz.service;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ftn.sbnz.dto.UserTokenStateDTO;
import ftn.sbnz.exception.UserException;
import ftn.sbnz.model.job_offer.JobOffer;
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
    private AuthorityService authorityService;
    private KieSessionService kieSession;

    @Autowired
    public UserService(UserRepository userRepository, TokenUtils tokenUtils, AuthenticationManager authenticationManager,
                       CustomUserDetailsService userDetailsService, AuthorityService authorityService,
                       KieSessionService kieSession) {
        this.userRepository = userRepository;
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.authorityService = authorityService;
        this.kieSession = kieSession;
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

      UserTokenStateDTO token = generateToken(username, password);
      return token;
	}
	
    public User getOne(String username) throws NoSuchElementException {
        User user = findByUsername(username);
        if (user == null) {
            throw new NoSuchElementException("User with this username doesn't exist!");
        }
        return user;
    }
    
    public UserTokenStateDTO generateToken(String username, String password) throws UserException {
        Authentication authentication = null;
        try {
            authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new UserException("Bad credentials exception!", "password", "Incorrect password.");
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        // create token
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();

        return new UserTokenStateDTO(user.getId(), jwt, expiresIn, user.getUsername(), user.getName(), user.getSurname());
    }
    

}
