package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.models.Questions;
import com.example.service.QuestionService;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;

import com.example.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class QuestionServiceTest {
	
	@Autowired
	QuestionService questionService;
	
	@Test
	public void deleteQuestion() throws BadRequestException, NotFoundException {
		Questions addquestions = new Questions();
		addquestions.setQuestionName("Where is Bangalore");
		addquestions.setAnswer("a");
		addquestions.setAnswer1("Karnataka");
		addquestions.setAnswer2("Telangana");
		addquestions.setAnswer3("Tamil Nadu");
		addquestions.setAnswer4("Rajasthan");
		addquestions.setCategoryId(1);
		addquestions.setDifficultyId(1);
		
		
	}

}
