package com.example;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.models.Questions;
import com.example.models.Quizzes;
import com.example.service.AuthenticateService;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import inti.ws.spring.exception.client.UnauthorizedException;

@Controller
public class QuizplayController {

	@Autowired
	QuizService quizservice;

	@Autowired
	QuizquestionsService quizquestionsService;

	@Autowired
	QuestionService questionService;

	@Autowired
	AuthenticateService authenticateService;

	// getting a random quiz .. Have to retrive questions after that
	/**
	 * Getting the quizzes by Admin from quizzes table
	 * 
	 * @return
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/quizplay/{cId}/{dId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Quizzes> quizPlay(HttpSession session, @PathVariable("cId") Integer cId,
			@PathVariable("dId") Integer dId) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return quizservice.getQuizRand(cId, dId);
	}

	// Getting questions for particular quizId
	@RequestMapping(value = "/viewquestions/{quizId}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Questions> getQuizQuestions(HttpSession session, @PathVariable("quizId") Integer quizId)
			throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return questionService.getQuestionsFromQuiz(quizId);
	}

	@RequestMapping(value = "/deletequiz/{quizId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteQuiz(HttpSession session, @PathVariable("quizId") Integer quizId)
			throws NotFoundException, BadRequestException, UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		quizservice.deleteById(quizId);
	}

	@RequestMapping(value = "/quizplay", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String viewQuizPlay(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return "quizplay";
	}

	@RequestMapping(value = "/quizquestions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String viewQuizQuestion(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return "quizQuestions";
	}
}
