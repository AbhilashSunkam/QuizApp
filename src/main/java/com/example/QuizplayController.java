package com.example;

import java.util.List;

import javax.servlet.http.HttpSession;
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

/**
 * Controllers for quizzes and quizquestion tables
 * 
 * @author abhilashsunkam
 *
 */
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

  /**
   * Controller that returns quiz based on category and difficulty
   * 
   * @param session HttpSession object to validate user session
   * @param cId
   * @param dId
   * @return List of Quizzes randomly {@link QuizService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   * 
   */
  @RequestMapping(value = "/quizplay/{cId}/{dId}", method = RequestMethod.GET)
  @ResponseBody
  public List<Quizzes> quizPlay(HttpSession session, @PathVariable("cId") Integer cId,
      @PathVariable("dId") Integer dId) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return quizservice.getQuizRand(cId, dId);
  }

  /**
   * Controller for getting questions for a particular quiz id
   * 
   * @param session HttpSession object to validate user session
   * @param quizId
   * @return List of questions {@link QuestionService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   * 
   */
  @RequestMapping(value = "/viewquestions/{quizId}", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Questions> getQuizQuestions(HttpSession session,
      @PathVariable("quizId") Integer quizId) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return questionService.getQuestionsFromQuiz(quizId);
  }

  /**
   * Controller that deletes a particular quiz
   * 
   * @param session HttpSession object to validate user session
   * @param quizId
   * @throws NotFoundException Throws when the quiz is not found
   * @throws BadRequestException Throws when there is no valid input
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   * 
   */
  @RequestMapping(value = "/deletequiz/{quizId}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public void deleteQuiz(HttpSession session, @PathVariable("quizId") Integer quizId)
      throws NotFoundException, BadRequestException, UnauthorizedException {
    authenticateService.validateSession(session);
    quizservice.deleteById(quizId);
  }

  /**
   * Controllers that renders a quizPlay page
   * 
   * @param session HttpSession object to validate user session
   * @return Renders a HTML quizPlay page
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   * 
   */
  @RequestMapping(value = "/quizplay", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public String viewQuizPlay(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return "quizplay";
  }

  /**
   * Controller that renders a quizQuestions page
   * 
   * @param session HttpSession object to validate user session
   * @return Renders a HTML quizQuestions page
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   * 
   */
  @RequestMapping(value = "/quizquestions", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public String viewQuizQuestion(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return "quizQuestions";
  }
}
