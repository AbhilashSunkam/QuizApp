package com.example;

import java.util.List;

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
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;

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

	/**
	 * Shows home page for Admin
	 * 
	 * @return Home page for Admin
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String questionView() {
		return "quizhome";
	}

	/**
	 * Fetching all the questions added in the question bank
	 * 
	 * @return List of All Questions
	 */
	@RequestMapping(value = "/getquestions", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Questions> getAllQuestions() {
		List<Questions> questions = (List<Questions>) questionService.getAll();
		System.out.println("Getting Questions");
		return questions;
	}

	/**
	 * Shows generate Quiz page where the admin can generate quiz
	 * 
	 * @return generate quiz page
	 */
	@RequestMapping(value = "/generatequiz", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String showGenerateQuiz() {
		return "generatequiz";
	}

	/**
	 * Get Question by id.
	 * 
	 * @param id
	 * 
	 * @return Question with particular id
	 * 
	 */
	@RequestMapping(value = "/getquestion/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Questions> editQuestion(@PathVariable("id") Integer qid) {
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
	 */
	@RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String deleteQuestion(@PathVariable("id") Integer qid) throws NotFoundException, BadRequestException {
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
	 */
	@RequestMapping(value = "/editquestion/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String editQuestion(@PathVariable("id") Integer qid, @RequestBody Questions question)
			throws BadRequestException {
		System.out.println("Updating user " + qid);
		questionService.editQuestion(qid, question);
		return "quizhome";

	}

	/**
	 * Shows set question form for admin to add question to question bank
	 * 
	 * @return A form for adding question
	 */
	@RequestMapping(value = "/setquestions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String questionList() {
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
	 */
	@RequestMapping(value = "/setquestions", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String questionsAdd(@RequestParam String questionName, @RequestParam String answer1,
			@RequestParam String answer2, @RequestParam String answer3, @RequestParam String answer4,
			@RequestParam String answer, @RequestParam Integer categoryId, @RequestParam Integer difficultyId)
			throws BadRequestException {
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
	 */
	@RequestMapping(value = "/generatequiz/{cId}/{dId}", method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void generateQuiz(@PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId,
			@RequestBody String description) throws BadRequestException {
		List<Questions> questions = (List<Questions>) questionService.generateQuizRand(cId, dId);
		Quizzes quizzes = quizService.addQuiz(cId, dId, description);
		quizquestionsService.addToQuizQuestions(questions, quizzes);

		System.out.println(quizzes.getId());

	}

	/**
	 * Getting the quizzes by Admin from quizzes table
	 * 
	 * @return
	 */
	@RequestMapping(value = "/seequizzes", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<Quizzes> getAllQuizzes() {
		List<Quizzes> quizzes = (List<Quizzes>) quizService.getAll();
		System.out.println("Getting Quizzes");
		return quizzes;
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
}