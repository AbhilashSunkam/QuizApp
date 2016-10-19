package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.models.Questions;
import com.example.models.Quizquestions;
import com.example.models.Quizzes;
import com.example.service.QuestionService;
import com.example.service.QuizService;
import com.example.service.QuizquestionsService;

import org.springframework.stereotype.Controller;

@Controller
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@Autowired
	QuizService quizService;

	@Autowired
	QuizquestionsService quizquestionsService;

	// Shows home page
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String questionView() {
		return "quizhome";
	}

	// Lists out all the questions in the question bank
	@RequestMapping(value = "/getquestions", method = RequestMethod.GET)
	@ResponseBody
	public List<Questions> getAllQuestions() {
		List<Questions> questions = (List<Questions>) questionService.getAll();
		System.out.println("Getting Questions");
		return questions;
	}

	// Shows the generate quiz page
	@RequestMapping(value = "/generatequiz", method = RequestMethod.GET)
	public String showGenerateQuiz() {
		return "generatequiz";
	}

	// Get details of particular question using id
	@RequestMapping(value = "/getquestion/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Questions> editQuestion(@PathVariable("id") Integer qid) {
		List<Questions> question = (List<Questions>) questionService.getById(qid);
		return question;
	}

	// Deleting the question from the question bank
	@RequestMapping(value = "/deletequestion/{id}", method = RequestMethod.DELETE)
	public String deleteQuestion(@PathVariable("id") Integer qid) {
		System.out.println("fetching and deleting the question with id" + qid);
		questionService.deleteById(qid);
		return "quizhome";
	}

	// Editing the question and updating it in the database
	@RequestMapping(value = "/editquestion/{id}", method = RequestMethod.PUT)
	public String editQuestion(@PathVariable("id") Integer qid, @RequestBody Questions question) {
		System.out.println("Updating user " + qid);
		Questions currentQuestion = questionService.findById(qid);
		currentQuestion.setQuestionName(question.getQuestionName());
		currentQuestion.setAnswer1(question.getAnswer1());
		currentQuestion.setAnswer2(question.getAnswer2());
		currentQuestion.setAnswer3(question.getAnswer3());
		currentQuestion.setAnswer4(question.getAnswer4());
		currentQuestion.setAnswer(question.getAnswer());
		currentQuestion.setCategoryId(question.getCategoryId());
		currentQuestion.setDifficultyId(question.getDifficultyId());

		questionService.update(currentQuestion);
		return "quizhome";

	}

	// Opens setQuestions form
	@RequestMapping(value = "/setquestions", method = RequestMethod.GET)
	public String questionList() {
		return "setQuestions";
	}

	// Post the newly added question into question bank
	@RequestMapping(value = "/setquestions", method = RequestMethod.POST)
	public String questionsAdd(@RequestParam String questionName, @RequestParam String answer1,
			@RequestParam String answer2, @RequestParam String answer3, @RequestParam String answer4,
			@RequestParam String answer, @RequestParam Integer categoryId, @RequestParam Integer difficultyId) {
		Questions newQuestion = new Questions();
		newQuestion.setQuestionName(questionName);
		newQuestion.setAnswer1(answer1);
		newQuestion.setAnswer2(answer2);
		newQuestion.setAnswer3(answer3);
		newQuestion.setAnswer4(answer4);
		newQuestion.setAnswer(answer);
		newQuestion.setCategoryId(categoryId);
		newQuestion.setDifficultyId(difficultyId);

		questionService.save(newQuestion);

		return "setQuestions";
	}

	// Generating a new quiz
	@RequestMapping(value = "/generatequiz/{cId}/{dId}", method = RequestMethod.POST)
	@ResponseBody
	public void generateQuiz(@PathVariable("cId") Integer cId, @PathVariable("dId") Integer dId) {
		List<Questions> questions = (List<Questions>) questionService.generateQuizRand(cId, dId);

		// 1.Insert into quizztemp
		Quizzes quizzes = new Quizzes();
		quizzes.setCategory_id(cId);
		quizzes.setDifficulty_id(dId);
		quizService.save(quizzes);

		System.out.println(quizzes.getId());

		// 2. insert into quizquestions temp using quizz id from above
		for (Questions question : questions) {
			Quizquestions quizquestions = new Quizquestions();
			quizquestions.setQuestions(question);
			quizquestions.setQuizzes(quizzes);

			System.out.println(quizquestions.getQuestions().getId());
			System.out.println(quizquestions.getQuizzes().getId());
			quizquestionsService.save(quizquestions);
		}

	}

}