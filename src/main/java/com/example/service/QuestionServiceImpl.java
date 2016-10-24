package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Questions;
import com.example.repository.QuestionsRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionsRepository questionsRepository;

	@Override
	public List<Questions> getAll() {
		return questionsRepository.getAll();
	}

	@Override
	public List<Questions> getById(Integer id) {
		return questionsRepository.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		questionsRepository.deleteById(id);
		return;
	}

	@Override
	public void save(Questions questions) {
		questionsRepository.save(questions);
	}

	@Override
	public Questions findById(Integer id) {
		return questionsRepository.findById(id);
	}

	@Override
	public void update(Questions question) {
		questionsRepository.update(question);
		return;
	}

	@Override
	public List<Questions> generateQuizRand(Integer cid, Integer did) {
		return questionsRepository.generateQuizRand(cid, did);
	}

	@Override
	public void editQuestion(Integer id, Questions question) {
		Questions currentQuestion = questionsRepository.findById(id);
		currentQuestion.setQuestionName(question.getQuestionName());
		currentQuestion.setAnswer1(question.getAnswer1());
		currentQuestion.setAnswer2(question.getAnswer2());
		currentQuestion.setAnswer3(question.getAnswer3());
		currentQuestion.setAnswer4(question.getAnswer4());
		currentQuestion.setAnswer(question.getAnswer());
		currentQuestion.setCategoryId(question.getCategoryId());
		currentQuestion.setDifficultyId(question.getDifficultyId());

		questionsRepository.update(currentQuestion);
	}

	@Override
	public void addQuestion(String questionName, String answer1, String answer2, String answer3, String answer4,
			String answer, Integer categoryId, Integer difficultyId) {
		Questions newQuestion = new Questions();
		newQuestion.setQuestionName(questionName);
		newQuestion.setAnswer1(answer1);
		newQuestion.setAnswer2(answer2);
		newQuestion.setAnswer3(answer3);
		newQuestion.setAnswer4(answer4);
		newQuestion.setAnswer(answer);
		newQuestion.setCategoryId(categoryId);
		newQuestion.setDifficultyId(difficultyId);

		questionsRepository.save(newQuestion);

	}

	@Override
	public List<Questions> getQuestionsFromQuiz(Integer quizId) {
		return questionsRepository.getQuestions(quizId);
	}

}
