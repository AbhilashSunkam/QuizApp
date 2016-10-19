package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Quizzes;

@Repository
@Transactional
public class QuizRepository {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Quizzes> getAll() {
		return getSession().createQuery("from Quizzes").list();
	}

	@SuppressWarnings("unchecked")
	public List<Quizzes> getById(Integer id) {
		return getSession().createQuery("from Quizzes where id = :id").setParameter("id", id).list();
	}

	public void deleteById(Integer id) {
		Quizzes quiz = (Quizzes) getSession().load(Quizzes.class, id);
		getSession().delete(quiz);
		System.out.println("Deleting id" + id);
		return;
	}

	public void save(Quizzes quizzes) {
		getSession().save(quizzes);
		return;
	}

	public Quizzes findById(Integer id) {
		System.out.println("Return question with id" + id);
		return (Quizzes) getSession().get(Quizzes.class, id);

	}

	public void update(Quizzes quiz) {
		getSession().update(quiz);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<Quizzes> getQuizRand(Integer cid, Integer did) {
		return getSession()
				.createQuery("from Quizzes where category_id = :cId and difficulty_id = :dId order by rand()")
				.setParameter("cId", cid).setParameter("dId", did).setMaxResults(1).list();
	}

}
