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
import org.springframework.dao.InvalidDataAccessResourceUsageException;
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
public class QuestionServiceTest {

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
  public void SaveQuestionTest() {
    Questions question = new Questions();
    question.setAnswer("a");
    question.setAnswer1("Karnataka");
    question.setAnswer2("tamil nadu");
    question.setAnswer3("telangana");
    question.setAnswer4("kerala");
    question.setCategoryId(1);
    question.setDifficultyId(1);

    questionService.save(question);
  }

  @Test
  public void findByIdTest() {
    Questions question = questionService.findById(11);
    assertNotNull(question);
  }

  @Test(expected = InvalidDataAccessResourceUsageException.class)
  public void generateQuizRandTest() {
    List<Questions> questions = questionService.generateQuizRand(1, 1);
    assertNotNull(questions);
  }

  @Test
  public void getQuestionsFromQuizTest() {
    List<Questions> questions = questionService.getQuestionsFromQuiz(11);
    for (Questions question : questions) {
      assertNotNull(question);
    }
  }

}
