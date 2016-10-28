package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Questions;
import com.example.models.Quizquestions;

/**
 * quiz questions repository
 * 
 * @author abhilashsunkam
 *
 */
@Repository
@Transactional
public class QuizquestionsRepository {

  @Autowired
  private SessionFactory _sessionFactory;

  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public List<Quizquestions> getAll() {
    return getSession().createQuery("from Quizquestions").list();
  }

  @SuppressWarnings("unchecked")
  public List<Quizquestions> getById(Integer id) {
    return getSession().createQuery("from Quizquestions where id = :id").setParameter("id", id)
        .list();
  }

//  public void deleteById(Integer id) {
//    Quizquestions question = (Quizquestions) getSession().load(Quizquestions.class, id);
//    getSession().delete(question);
//    System.out.println("Deleting id" + id);
//    return;
//  }

  public void save(Quizquestions questions) {
    getSession().save(questions);
    return;
  }


}
