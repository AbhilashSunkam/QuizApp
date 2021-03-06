package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Users table
 * 
 * @author abhilashsunkam
 *
 */
@Entity
@Table(name = "users", catalog = "quizapp")
public class Users implements java.io.Serializable {

  private Integer id;
  private Quizzes quizzes;
  private Role role;
  private String email;
  private int score;

  public Users() {}

  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "quiz_id", nullable = true)
  public Quizzes getQuizzes() {
    return this.quizzes;
  }

  public void setQuizzes(Quizzes quizzes) {
    this.quizzes = quizzes;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", nullable = true)
  public Role getRole() {
    return this.role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Column(name = "email", nullable = false, length = 50)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "score", nullable = true)
  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

}
