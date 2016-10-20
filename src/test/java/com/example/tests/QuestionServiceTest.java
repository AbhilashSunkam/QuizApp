package com.example.tests;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.service.QuestionService;

import inti.ws.spring.exception.client.BadRequestException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {

	@Autowired
	QuestionService questionService;
	
	@Test
	@Transactional
	@Rollback(true)
	public void addQuestionTest() throws BadRequestException {
		
	}
	
}
