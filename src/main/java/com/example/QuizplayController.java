package com.example;

import java.util.List;

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
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;

@Controller
public class QuizplayController {

	@Autowired
	QuizService quizservice;

	@Autowired
	QuizquestionsService quizquestionsService;
	
	@Autowired
	QuestionService questionService;

	// getting a random quiz .. Have to retrive questions after that
	@RequestMapping(value = "/quizplay/{cId}/{dId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Quizzes> quizPlay(@PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId) {
		return quizservice.getQuizRand(cId, dId);
	}

	// Getting questions for particular quizId
	@RequestMapping(value = "/viewquestions/{quizId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Questions> getQuizQuestions(@PathVariable("quizId") Integer quizId) {
		
		return questionService.getQuestionsFromQuiz(quizId);
	}
	
	@RequestMapping(value = "/deletequiz/{quizId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteQuiz(@PathVariable("quizId") Integer quizId) throws NotFoundException, BadRequestException {
		quizservice.deleteById(quizId);
	}
	
	@RequestMapping(value = "/quizplay" , method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String viewQuizPlay() {
		return "quizplay";
	}
	
	@RequestMapping(value = "/quizquestions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String viewQuizQuestion() {
		return "quizQuestions";
	}
}
