package ftn.sbnz.security.auth;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import ftn.sbnz.events.UserAccountStatusEvent;
import ftn.sbnz.model.user.User;
import ftn.sbnz.security.TokenUtils;
import ftn.sbnz.service.KieSessionService;

//import com.security.admin.model.User;

//Filter koji ce presretati svaki zahtev klijenta ka serveru
//Sem nad putanjama navedenim u WebSecurityConfig.configure(WebSecurity web)
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private TokenUtils tokenUtils;

	private UserDetailsService userDetailsService;
	
	private KieSessionService kieSession;

	public TokenAuthenticationFilter(TokenUtils tokenHelper, UserDetailsService userDetailsService, KieSessionService kieSession) {
		this.tokenUtils = tokenHelper;
		this.userDetailsService = userDetailsService;
		this.kieSession = kieSession;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username;
		String authToken = tokenUtils.getToken(request);

		if (authToken != null) {
			// uzmi username iz tokena
			username = tokenUtils.getUsernameFromToken(authToken);

			if (username != null) {
				// uzmi user-a na osnovu username-a
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				User u = (User) userDetails;
				// proveri da li je prosledjeni token validan
				if (tokenUtils.validateToken(authToken, userDetails) && !userBanned(u.getId())) {
					// kreiraj autentifikaciju
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		// prosledi request dalje u sledeci filter
		chain.doFilter(request, response);
	}
	

	private boolean userBanned(Long jobSeekerId) {
		UserAccountStatusEvent fact = new UserAccountStatusEvent(jobSeekerId);
		kieSession.insert(fact);
		kieSession.setAgendaFocus("user-account-status-check");
		kieSession.fireAllRules();
		return fact.isBanned();
	}

}