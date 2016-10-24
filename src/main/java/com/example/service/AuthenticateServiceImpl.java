package com.example.service;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import inti.ws.spring.exception.client.UnauthorizedException;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

	@Override
	public Integer validateSession(HttpSession session) throws UnauthorizedException {
		if (session == null)
			throw new UnauthorizedException("Please login to continue");
		Integer id = (Integer) session.getAttribute("id");

		if (id == null) {
			throw new UnauthorizedException("Please login to continue");
		} else {
			return id;
		}
	}

}
