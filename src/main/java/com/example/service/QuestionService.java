package com.example.service;

import java.util.List;

import com.example.models.Questions;

public interface QuestionService {

	public List<Questions> getAll();

	public List<Questions> getById(Integer id);

	public void deleteById(Integer id);

	public void save(Questions questions);

	public Questions findById(Integer id);

	public void update(Questions question);

	public List<Questions> generateQuizRand(Integer cid, Integer did);

	public void editQuestion(Integer id, Questions question);

	public void addQuestion(String questionName, String answer1, String answer2, String answer3, String answer4,
			String answer, Integer categoryId, Integer difficultyId);

	public List<Questions> getQuestionsFromQuiz(Integer quizId);

}
