package com.example;

import java.security.Principal;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Role;
import com.example.models.Users;
import com.example.service.RoleService;
import com.example.service.UserService;

import inti.ws.spring.exception.client.ForbiddenException;
import inti.ws.spring.exception.client.UnauthorizedException;

@EnableOAuth2Sso
@RestController
public class AuthController extends WebSecurityConfigurerAdapter {

	@Autowired
	UserService userservice;

	@Autowired
	RoleService roleservice;

	Logger logger = Logger.getLogger(getClass());

	@RequestMapping("/user")
	public Users user(Principal principal, HttpSession session) throws UnauthorizedException, ForbiddenException {

		logger.info("Recieved request for authentication");
		if (principal == null)
			throw new ForbiddenException("Access forbiden");
		OAuth2Authentication auth = (OAuth2Authentication) principal;
		if (auth.isAuthenticated()) {

			@SuppressWarnings("unchecked")
			LinkedHashMap<String, String> details = (LinkedHashMap<String, String>) auth.getUserAuthentication()
					.getDetails();

			String domain = details.get("hd");
			if (!"practo.com".equalsIgnoreCase(domain))
				throw new UnauthorizedException("Unauthorized user");

			String email = details.get("email");
			String name = details.get("name");
			String picture = details.get("picture");

			Users user = new Users();
			Role role = new Role();
			if ("abhilash.sunkam@practo.com".equalsIgnoreCase(email)) {
				role.setId(1);
			} else {
				role.setId(2);
			}
			user.setRole(role);

			user.setEmail(email);

			userservice.save(user);

			session.setAttribute("id", user.getId());

			return user;

		} else {
			throw new UnauthorizedException("Login failed. Please try again");
		}

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/**", "/login**", "/webjars/**").permitAll()
				.anyRequest().authenticated().and().logout().logoutSuccessUrl("/").permitAll().and().csrf().disable();
	}

}
