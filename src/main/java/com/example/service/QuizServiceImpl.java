package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Quizzes;
import com.example.repository.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepository;

	@Override
	public List<Quizzes> getAll() {
		return quizRepository.getAll();
	}

	@Override
	public List<Quizzes> getById(Integer id) {
		return quizRepository.getById(id);
	}

	@Override
	public void deleteById(Integer id) {
		quizRepository.deleteById(id);
		return;
	}

	@Override
	public void save(Quizzes quizzes) {
		quizRepository.save(quizzes);
	}

	@Override
	public Quizzes findById(Integer id) {
		return quizRepository.findById(id);
	}

	@Override
	public void update(Quizzes quiz) {
		quizRepository.update(quiz);
		return;
	}

	@Override
	public List<Quizzes> getQuizRand(Integer cid, Integer did) {
		return quizRepository.getQuizRand(cid, did);
	}

}
