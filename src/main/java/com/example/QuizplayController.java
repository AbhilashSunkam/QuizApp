package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Quizzes;
import com.example.service.QuizService;

@Controller
public class QuizplayController {

	@Autowired
	QuizService quizservice;

	@RequestMapping(value = "/quizplay/{cId}/{dId}", method = RequestMethod.GET)
	@ResponseBody
	public List<Quizzes> quizPlay(@PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId) {
		return quizservice.getQuizRand(cId, dId);
	}
}
