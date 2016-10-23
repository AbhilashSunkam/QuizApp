package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Questions;

@Repository
@Transactional
public class QuestionsRepository {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Questions> getAll() {
		return getSession().createQuery("from Questions").list();
	}

	@SuppressWarnings("unchecked")
	public List<Questions> getById(Integer id) {
		return getSession().createQuery("from Questions where id = :id").setParameter("id", id).list();
	}

	public void deleteById(Integer id) {
		Questions question = (Questions) getSession().load(Questions.class, id);
		getSession().delete(question);
		System.out.println("Deleting id" + id);
		return;
	}

	public void save(Questions questions) {
		getSession().save(questions);
		return;
	}

	public Questions findById(Integer id) {
		System.out.println("Return question with id" + id);
		return (Questions) getSession().get(Questions.class, id);

	}

	public void update(Questions question) {
		getSession().update(question);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<Questions> generateQuizRand(Integer cid, Integer did) {
		return getSession()
				.createQuery(
						"from Questions where category_id = :cid and difficulty_id = :did group by id order by rand()")
				.setParameter("cid", cid).setParameter("did", did).setMaxResults(5).list();
	}

	@SuppressWarnings("unchecked")
	public List<Questions> getQuestions(Integer quizId) {
			return getSession()
					.createQuery("from Questions where id in (select questions.id from Quizquestions where quiz_id = :qId)")
					.setParameter("qId" , quizId).list();
			
		}
	}
