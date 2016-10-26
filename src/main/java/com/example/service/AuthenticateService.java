package com.example.service;

import javax.servlet.http.HttpSession;

import inti.ws.spring.exception.client.UnauthorizedException;

/**
 * Authenticate Service interface
 * 
 * @author abhilashsunkam
 *
 */
public interface AuthenticateService {

  Integer validateSession(HttpSession session) throws UnauthorizedException;

}
