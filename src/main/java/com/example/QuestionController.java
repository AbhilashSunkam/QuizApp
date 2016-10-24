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
 * This is the controller which handles all the api requests in the Admin quiz
 * portal
 * 
 * @author abhilash
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
	 * Shows home page for Admin
	 * 
	 * @return Home page for Admin
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String questionView(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return "quizhome";
	}

	/**
	 * Fetching all the questions added in the question bank
	 * 
	 * @return List of All Questions
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/getquestions", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Questions> getAllQuestions(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		List<Questions> questions = (List<Questions>) questionService.getAll();
		System.out.println("Getting Questions");

		return questions;
	}

	/**
	 * Shows generate Quiz page where the admin can generate quiz
	 * 
	 * @return generate quiz page
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/generatequiz", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String showGenerateQuiz(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return "generatequiz";
	}

	/**
	 * Get Question by id.
	 * 
	 * @param id
	 * 
	 * @return Question with particular id
	 * @throws UnauthorizedException
	 * 
	 */
	@RequestMapping(value = "/getquestion/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Questions> editQuestion(HttpSession session, @PathVariable("id") Integer qid)
			throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		List<Questions> question = (List<Questions>) questionService.getById(qid);
		return question;
	}

	/**
	 * Delete a specific question from the question bank
	 * 
	 * @param qid
	 *
	 * @return home page
	 * @throws NotFoundException
	 * @throws BadRequestException
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteQuestion(HttpSession session, @PathVariable("id") Integer qid)
			throws NotFoundException, BadRequestException, UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		System.out.println("fetching and deleting the question with id" + qid);
		questionService.deleteById(qid);
		return "quizhome";
	}

	/**
	 * Editing a Question in question bank
	 * 
	 * @param id
	 * @param question
	 * 
	 * @return
	 * @throws BadRequestException
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/editquestion/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String editQuestion(HttpSession session, @PathVariable("id") Integer qid, @RequestBody Questions question)
			throws BadRequestException, UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		System.out.println("Updating user " + qid);
		questionService.editQuestion(qid, question);
		return "quizhome";

	}

	/**
	 * Shows set question form for admin to add question to question bank
	 * 
	 * @return A form for adding question
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/setquestions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String questionList(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		return "setQuestions";
	}

	// Post the newly added question into question bank
	/**
	 * Adding a new question to the question bank
	 * 
	 * @param All
	 *            the parameter required for adding a question
	 * 
	 * @return Form page
	 * 
	 * @throws BadRequestException
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/setquestions", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String questionsAdd(HttpSession session, @RequestParam String questionName, @RequestParam String answer1,
			@RequestParam String answer2, @RequestParam String answer3, @RequestParam String answer4,
			@RequestParam String answer, @RequestParam Integer categoryId, @RequestParam Integer difficultyId)
			throws BadRequestException, UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		questionService.addQuestion(questionName, answer1, answer2, answer3, answer4, answer, categoryId, difficultyId);

		return "setQuestions";
	}

	/**
	 * Genrating a new quiz by Admin
	 * 
	 * @param cId
	 * @param dId
	 * @param description
	 * 
	 * @return
	 * @throws BadRequestException
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/generatequiz/{cId}/{dId}", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void generateQuiz(HttpSession session, @PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId,
			@RequestBody String description) throws BadRequestException, UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		List<Questions> questions = (List<Questions>) questionService.generateQuizRand(cId, dId);
		Quizzes quizzes = quizService.addQuiz(cId, dId, description);
		quizquestionsService.addToQuizQuestions(questions, quizzes);

		System.out.println(quizzes.getId());

	}

	/**
	 * Getting the quizzes by Admin from quizzes table
	 * 
	 * @return
	 * @throws UnauthorizedException
	 */
	@RequestMapping(value = "/seequizzes", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Quizzes> getAllQuizzes(HttpSession session) throws UnauthorizedException {
		Integer id = authenticateService.validateSession(session);
		List<Quizzes> quizzes = (List<Quizzes>) quizService.getAll();
		System.out.println("Getting Quizzes");
		return quizzes;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

}