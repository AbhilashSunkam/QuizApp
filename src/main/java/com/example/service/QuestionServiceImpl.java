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

}
