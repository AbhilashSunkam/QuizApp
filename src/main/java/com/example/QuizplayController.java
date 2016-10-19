package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Quizquestions;
import com.example.models.Quizzes;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

@Controller
public class QuizplayController {

	@Autowired
	QuizService quizservice;

	@Autowired
	QuizquestionsService quizquestionsService;

	// getting a random quiz .. Have to retrive questions after that
	@RequestMapping(value = "/quizplay/{cId}/{dId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Quizzes> quizPlay(@PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId) {
		return quizservice.getQuizRand(cId, dId);
	}

	// Getting questions for particular quizId
	// @RequestMapping(value = "/viewquestions/{quizId}", method =
	// RequestMethod.GET)
	// @ResponseBody
	// public List<Quizquestions> getQuizQuestions(@PathVariable("quizId")
	// Integer quizId) {
	// return quizquestionsService.getById(quizId);
	// }
}
