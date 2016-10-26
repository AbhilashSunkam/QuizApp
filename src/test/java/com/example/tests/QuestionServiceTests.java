// package com.example.tests;
//
// import static org.junit.Assert.assertEquals;
//
// import static org.junit.Assert.assertNotEquals;
// import static org.junit.Assert.assertTrue;
//
// import java.util.List;
//
// import javax.transaction.Transactional;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.annotation.Rollback;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.dao.InvalidDataAccessApiUsageException;
// import com.example.models.Questions;
// import com.example.service.QuestionService;
//
// import inti.ws.spring.exception.client.BadRequestException;
// import inti.ws.spring.exception.client.NotFoundException;
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class QuestionServiceTests {
// }
// @Autowired
// QuestionService questionService;
//
// @Test(expected = DataIntegrityViolationException.class)
// @Transactional
// @Rollback(true)
// public void addQuestionTest() throws BadRequestException {
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1,null);
// }
//
// @Test(expected = InvalidDataAccessApiUsageException.class)
// @Transactional
// @Rollback(true)
// public void editQuestionTest() throws BadRequestException {
// Questions question = new Questions();
// question.setQuestionName("What is the capital of india");
// question.setAnswer("a");
// question.setAnswer1("delhi");
// question.setAnswer2("Mumbai");
// question.setAnswer3("chennai");
// question.setAnswer4("bangalore");
// question.setCategoryId(1);
// question.setDifficultyId(1);
//
// questionService.editQuestion(question.getId(), question);
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void getAllQuestionsTest() throws BadRequestException {
//
// List<Questions> questionsList = questionService.getAll();
// int size = questionsList.size();
//
//
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// List<Questions> updatedQuestionList = questionService.getAll();
// int newsize = updatedQuestionList.size();
//
// assertEquals(size+1, newsize);
//
// }
//
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateQuestionTest() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setQuestionName("What is the capital of Bangladesh");
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getQuestionName(), newedit.getQuestionName());
//
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateAnswer1Test() throws BadRequestException, NotFoundException {
// System.out.println("xxxz ");
// Questions questions = new Questions();
// System.out.println("xxxy ");
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
// System.out.println("xxx - " + questions.getId());
// Questions newedit = new Questions();
// newedit.setAnswer1("Hyderabad");
//
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getAnswer1(), newedit.getAnswer1());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateAnswer2Test() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setAnswer2("Hyderabad");
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getAnswer2(), newedit.getAnswer2());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateAnswer3Test() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setAnswer3("Hyderabad");
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getAnswer3(), newedit.getAnswer3());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateAnswer4Test() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setAnswer4("Hyderabad");
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getAnswer4(), newedit.getAnswer4());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateAnswerTest() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setAnswer("Hyderabad");
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getAnswer(), newedit.getAnswer());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateCategoryTest() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setCategoryId(2);
// System.out.println("zzzzzzzz - " + questions.getId());
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getCategoryId(), newedit.getCategoryId());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void updateDifficultyTest() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// Questions newedit = new Questions();
// newedit.setDifficultyId(2);
// questionService.editQuestion(questions.getId(), newedit);
//
// assertNotEquals(questions.getDifficultyId(), newedit.getDifficultyId());
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void getAllQuestionsTest() throws BadRequestException {
//
// List<Questions> questionsList = questionService.getAll();
// int size = questionsList.size();
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// assertTrue(questions.getId() > 0);
//
// questionsList = questionService.getAll();
// assertEquals(size + 1, questionsList.size());
//
// }
//
// @Test
// @Transactional
// @Rollback(true)
// public void deleteQuestionTest() throws BadRequestException, NotFoundException {
//
// Questions questions = new Questions();
// questionService.addQuestion("What is the capital of india", "Delhi", "Mumbai", "Chennai",
// "Bangalore", "Delhi",
// 1, 1);
//
// assertTrue(questions.getId() > 0);
//
// questionService.deleteById(questions.getId());
//
// }
//
// @Test(expected = BadRequestException.class)
// @Transactional
// @Rollback(true)
// public void deleteQuestionInvalidId() throws BadRequestException {
// questionService.deleteById(-1);
// }
//
// }
