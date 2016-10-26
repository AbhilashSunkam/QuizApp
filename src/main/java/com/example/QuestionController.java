package com.example;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import com.example.models.Questions;
import com.example.models.Quizzes;
import com.example.service.AuthenticateService;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import inti.ws.spring.exception.client.UnauthorizedException;

import org.springframework.stereotype.Controller;

/**
 * Controller that handles api requests on questions, quizzes and quizquestion tables
 * 
 * @author abhilashsunkam
 *
 */
@Controller
public class QuestionController {

  @Autowired
  QuestionService questionService;

  @Autowired
  QuizService quizService;

  @Autowired
  QuizquestionsService quizquestionsService;

  @Autowired
  AuthenticateService authenticateService;

  /**
   * Controller that renders a quiz home page
   * 
   * @param session HttpSession object to validate user session
   * @return Renders a HTML quiz home page {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String questionView(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return "quizhome";
  }

  /**
   * Controller that gets all the questions from questionBank
   * 
   * @param session HttpSession object to validate user session
   * @return List of questions {@link QuestionService} {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/getquestions", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Questions> getAllQuestions(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    List<Questions> questions = (List<Questions>) questionService.getAll();
    System.out.println("Getting Questions");

    return questions;
  }

  /**
   * Controller that render generate quiz page
   * 
   * @param session HttpSession object to validate user session
   * @return Renders a HTML generate quiz page {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/generatequiz", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public String showGenerateQuiz(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return "generatequiz";
  }

  /**
   * Controller that gets a question by id
   * 
   * @param session HttpSession object to validate user session
   * @param qid
   * @return Question with that particular id {@link QuestionService} {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/getquestion/{id}", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Questions> editQuestion(HttpSession session, @PathVariable("id") Integer qid)
      throws UnauthorizedException {
    authenticateService.validateSession(session);
    List<Questions> question = (List<Questions>) questionService.getById(qid);
    return question;
  }

  /**
   * Controller that deletes a question
   * 
   * @param session HttpSession object to validate user session
   * @param qid
   * @return Deletes and renders a home page {@link QuestionService} {@link AuthenticateService}
   * @throws NotFoundException Throws when question id is not found
   * @throws BadRequestException Throws when question id id not given
   * @throws UnauthorizedException Throws when user doesn't have valid session
   */
  @RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(HttpStatus.OK)
  public String deleteQuestion(HttpSession session, @PathVariable("id") Integer qid)
      throws NotFoundException, BadRequestException, UnauthorizedException {
    authenticateService.validateSession(session);
    System.out.println("fetching and deleting the question with id" + qid);
    questionService.deleteById(qid);
    return "quizhome";
  }

  /**
   * Controller that edits a question
   * 
   * @param session HttpSession object to validate user session
   * @param qid
   * @param question
   * @return Renders a home page {@link QuestionService} {@link AuthenticateService}
   * @throws BadRequestException Throws when question id id not given
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/editquestion/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public String editQuestion(HttpSession session, @PathVariable("id") Integer qid,
      @RequestBody Questions question) throws BadRequestException, UnauthorizedException {
    authenticateService.validateSession(session);
    System.out.println("Updating user " + qid);
    questionService.editQuestion(qid, question);
    return "quizhome";

  }

  /**
   * Controller that renders set questions page
   * 
   * @param session HttpSession object to validate user session
   * @return Renders a HTML set questions page {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/setquestions", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public String questionList(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    return "setQuestions";
  }

  /**
   * Controller that add questions to question bank
   * 
   * @param session HttpSession object to validate user session
   * @param questionName
   * @param answer1
   * @param answer2
   * @param answer3
   * @param answer4
   * @param answer
   * @param categoryId
   * @param difficultyId
   * @return Renders a HTML page setQuestions after successful addition {@link QuestionService}
   *         {@link AuthenticateService}
   * @throws BadRequestException Throws when any parameter is not passed
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/setquestions", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public String questionsAdd(HttpSession session, @RequestParam String questionName,
      @RequestParam String answer1, @RequestParam String answer2, @RequestParam String answer3,
      @RequestParam String answer4, @RequestParam String answer, @RequestParam Integer categoryId,
      @RequestParam Integer difficultyId) throws BadRequestException, UnauthorizedException {
    authenticateService.validateSession(session);
    questionService.addQuestion(questionName, answer1, answer2, answer3, answer4, answer,
        categoryId, difficultyId);

    return "setQuestions";
  }

  /**
   * Controller to generate quiz based on category and difficulty
   * 
   * @param session HttpSession object to validate user session
   * @param cId
   * @param dId
   * @param description
   * @throws BadRequestException Throws when any parameter is not passed
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/generatequiz/{cId}/{dId}", method = RequestMethod.POST)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public void generateQuiz(HttpSession session, @PathVariable("cId") Integer cId,
      @PathVariable("dId") Integer dId, @RequestBody String description)
      throws BadRequestException, UnauthorizedException {
    authenticateService.validateSession(session);
    List<Questions> questions = (List<Questions>) questionService.generateQuizRand(cId, dId);
    Quizzes quizzes = quizService.addQuiz(cId, dId, description);
    quizquestionsService.addToQuizQuestions(questions, quizzes);

    System.out.println(quizzes.getId());

  }

  /**
   * Controller to see the list of quizzes generated
   * 
   * @param session HttpSession object to validate user session
   * @return List of quizzes generated {@link QuizService} {@link AuthenticateService}
   * @throws UnauthorizedException Throws when user doesn't have a valid session
   */
  @RequestMapping(value = "/seequizzes", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<Quizzes> getAllQuizzes(HttpSession session) throws UnauthorizedException {
    authenticateService.validateSession(session);
    List<Quizzes> quizzes = (List<Quizzes>) quizService.getAll();
    System.out.println("Getting Quizzes");
    return quizzes;
  }

  /**
   * Controller to render a login page
   * 
   * @return Renders the login HTML page
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String login() {
    return "login";
  }

}
