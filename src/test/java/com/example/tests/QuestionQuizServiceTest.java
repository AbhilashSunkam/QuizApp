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

import com.example.models.Questions;
import com.example.models.Quizzes;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestComponent
@ContextConfiguration(classes = {TestDatabaseConfig.class})
public class QuestionQuizServiceTest {

  @Autowired
  QuestionService questionService;

  @Autowired
  QuizService quizService;
  
  @Autowired
  QuizquestionsService quizquestionsService; 

  @Test
  public void getQuestionsTest() {
    List<Questions> questions = questionService.getAll();
    for (Questions question : questions) {
      System.out.println("Question Name - " + question.getQuestionName());
    }
  }

  @Test
  public void addQuestionsTest() {
    List<Questions> questions = questionService.getAll();
    int size = questions.size();
    questionService.addQuestion("Where is india", "asia", "africa", "australia", "antarctica", "a",
        1, 1);
    List<Questions> updatedquestions = questionService.getAll();
    int newsize = updatedquestions.size();
    assertEquals(size + 1, newsize);
  }

  @Test
  public void getQuestionByIdTest() {
    List<Questions> questions = questionService.getById(12);
    for (Questions question : questions) {
      assertNotNull(question);
      assertEquals("b", question.getAnswer());
      assertEquals("bangalore", question.getAnswer1());
      assertEquals("chennai", question.getAnswer2());
      assertEquals("hyderabad", question.getAnswer3());
      assertEquals("mumbai", question.getAnswer4());
      assertEquals("what is the capital of tamilnadu", question.getQuestionName());
      assertEquals((Integer) 1, question.getCategoryId());
      assertEquals((Integer) 1, question.getDifficultyId());
    }
  }

  @Test
  public void editQuestionTest() {
    Questions newQuestion = new Questions();
    newQuestion.setQuestionName("where is bangalore located");
    newQuestion.setAnswer1("karnataka");
    newQuestion.setAnswer2("tamil nadu");
    newQuestion.setAnswer3("telangana");
    newQuestion.setAnswer4("kerala");
    newQuestion.setAnswer("a");
    newQuestion.setCategoryId(1);
    newQuestion.setDifficultyId(1);

    questionService.editQuestion(1, newQuestion);
    List<Questions> questions = questionService.getById(1);
    for (Questions question : questions) {
      assertNotNull(question);
      assertEquals("a", question.getAnswer());
      assertEquals("karnataka", question.getAnswer1());
      assertEquals("tamil nadu", question.getAnswer2());
      assertEquals("telangana", question.getAnswer3());
      assertEquals("kerala", question.getAnswer4());
      assertEquals("where is bangalore located", question.getQuestionName());
      assertEquals((Integer) 1, question.getCategoryId());
      assertEquals((Integer) 1, question.getDifficultyId());
    }
  }

  @Test
  public void deleteQuestionTest() {
    questionService.deleteById(13);
    List<Questions> questions = questionService.getById(13);
    for (Questions question : questions) {
      assertNull(question);
    }
  }
  

  @Test
  public void getByIdTest() {
    List<Quizzes> quizzes = quizService.getById(1);
    for (Quizzes quiz : quizzes) {
      assertNotNull(quiz);
      assertEquals("abhi quiz", quiz.getDescription());
      assertEquals((Integer) 1, quiz.getCategory_id());
      assertEquals((Integer) 1, quiz.getDifficulty_id());
    }
  }

  @Test
  public void deleteQuizTest() {
    quizService.deleteById(3);
    List<Quizzes> quizzes = quizService.getById(3);
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
  

}
