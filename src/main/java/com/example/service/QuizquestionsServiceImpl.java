package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Quizquestions;
import com.example.repository.QuizquestionsRepository;

@Service
public class QuizquestionsServiceImpl implements QuizquestionsService {

	@Autowired
	QuizquestionsRepository quizquestionsRepository;

	@Override
	public List<Quizquestions> getAll() {
		return quizquestionsRepository.getAll();
	}

	@Override
	public List<Quizquestions> getById(Integer id) {
		return quizquestionsRepository.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		quizquestionsRepository.deleteById(id);
		return;
	}

	@Override
	public void save(Quizquestions questions) {
		quizquestionsRepository.save(questions);
	}

	@Override
	public Quizquestions findById(Integer id) {
		return quizquestionsRepository.findById(id);
	}

	@Override
	public void update(Quizquestions question) {
		quizquestionsRepository.update(question);
		return;
	}

}
