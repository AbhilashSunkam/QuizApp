package com.example.service;

import java.util.List;

import com.example.models.Questions;
import com.example.models.Quizquestions;
import com.example.models.Quizzes;

public interface QuizquestionsService {

	public List<Quizquestions> getAll();

	public List<Quizquestions> getById(Integer id);

	public void deleteById(Integer id);

	public void save(Quizquestions questions);

	public Quizquestions findById(Integer id);

	public void update(Quizquestions question);

	public void addToQuizQuestions(List<Questions> questions, Quizzes quizzes);
	

}
