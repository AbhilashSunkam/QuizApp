package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Users;

/**
 * Users repository
 * 
 * @author abhilashsunkam
 *
 */
@Repository
@Transactional
public class UsersRepository {

  @Autowired
  private SessionFactory _sessionFactory;

  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public List<Users> getAll() {
    return getSession().createQuery("from Users").list();
  }

  @SuppressWarnings("unchecked")
  public List<Users> getById(Integer id) {
    return getSession().createQuery("from Users where id = :id").setParameter("id", id).list();
  }

  public void deleteById(Integer id) {
    Users question = (Users) getSession().load(Users.class, id);
    getSession().delete(question);
    System.out.println("Deleting id" + id);
    return;
  }

  public void save(Users questions) {
    getSession().save(questions);
    return;
  }

}
