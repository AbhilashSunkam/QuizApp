package com.example.tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.models.Questions;
import com.example.models.Quizzes;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestComponent
@ContextConfiguration(classes = {TestDatabaseConfig.class})
public class QuizquestionsServiceTest {

  @Autowired
  QuestionService questionService;

  @Autowired
  QuizService quizService;

  @Autowired
  QuizquestionsService quizquestionsService;

  @Test(expected = NullPointerException.class)
  public void addToQuizQuestionsTest() {
    List<Questions> questions = questionService.getById(12);
    Quizzes quizzes = new Quizzes();
    quizzes.setCategory_id(1);
    quizzes.setDifficulty_id(1);
    quizzes.setDescription("testquiz");
    quizquestionsService.addToQuizQuestions(questions, quizzes);

  }

}
