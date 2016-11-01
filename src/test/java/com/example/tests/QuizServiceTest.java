package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.models.Quizzes;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestComponent
@ContextConfiguration(classes = {TestDatabaseConfig.class})
public class QuizServiceTest {

  @Autowired
  QuestionService questionService;

  @Autowired
  QuizService quizService;

  @Autowired
  QuizquestionsService quizquestionsService;

  @Test
  public void getByIdTest() {
    List<Quizzes> quizzes = quizService.getById(11);
    for (Quizzes quiz : quizzes) {
      assertNotNull(quiz);
      assertEquals("abhi quiz", quiz.getDescription());
      assertEquals((Integer) 1, quiz.getCategory_id());
      assertEquals((Integer) 1, quiz.getDifficulty_id());
    }
  }

  @Test
  public void deleteQuizTest() {
    quizService.deleteById(13);
    List<Quizzes> quizzes = quizService.getById(13);
    for (Quizzes quiz : quizzes) {
      assertNull(quiz);
    }
  }

  @Test
  public void generateRandQuizTest() {
    List<Quizzes> quizzes = quizService.getQuizRand(1, 1);
    for (Quizzes quiz : quizzes) {
      assertNotNull(quiz);
    }
  }

  @Test
  public void addQuizTest() {
    quizService.addQuiz(1, 1, "HelloworldQuiz");

  }

  @Test
  public void getAllQuizTest() {
    List<Quizzes> quizzes = quizService.getAll();
    for (Quizzes quiz : quizzes) {
      assertNotNull(quiz);
    }
  }

  @Test
  public void findByIdTest() {
    Quizzes quiz = quizService.findById(11);
    assertNotNull(quiz);
  }



}
