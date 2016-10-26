package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Role;


/**
 * Role repository
 * 
 * @author abhilashsunkam
 *
 */
@Repository
@Transactional
public class RoleRepository {

  @Autowired
  private SessionFactory _sessionFactory;

  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public List<Role> getAll() {
    return getSession().createQuery("from Role").list();
  }

  @SuppressWarnings("unchecked")
  public List<Role> getById(Integer id) {
    return getSession().createQuery("from Role where id = :id").setParameter("id", id).list();
  }

  public void deleteById(Integer id) {
    Role question = (Role) getSession().load(Role.class, id);
    getSession().delete(question);
    System.out.println("Deleting id" + id);
    return;
  }

  public void save(Role questions) {
    getSession().save(questions);
    return;
  }

  public Role findById(Integer id) {
    System.out.println("Return question with id" + id);
    return (Role) getSession().get(Role.class, id);

  }

  public void update(Role question) {
    getSession().update(question);
    return;
  }

}
