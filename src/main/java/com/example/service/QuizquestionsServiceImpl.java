package com.example.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Questions;
import com.example.models.Quizquestions;
import com.example.models.Quizzes;
import com.example.repository.QuizquestionsRepository;

@Service
public class QuizquestionsServiceImpl implements QuizquestionsService {

	@Autowired
	QuizquestionsRepository quizquestionsRepository;

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

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

	@Override
	public void addToQuizQuestions(List<Questions> questions, Quizzes quizzes) {
		for (Questions question : questions) {
			Quizquestions quizquestions = new Quizquestions();
			quizquestions.setQuestions(question);
			quizquestions.setQuizzes(quizzes);

			System.out.println(quizquestions.getQuestions().getId());
			System.out.println(quizquestions.getQuizzes().getId());
			quizquestionsRepository.save(quizquestions);
		}

	}

}
