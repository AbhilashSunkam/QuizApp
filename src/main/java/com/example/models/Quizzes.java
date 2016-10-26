package com.example.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Quizzes table
 * 
 * @author abhilashsunkam
 *
 */
@Entity
@Table(name = "quizzes", catalog = "quizapp")
public class Quizzes implements java.io.Serializable {

  private Integer id;
  private Integer category_id;
  private Integer difficulty_id;
  private String description;

  private List<Quizquestions> quizquestions;

  public Quizzes() {

  }

  public Quizzes(Integer category_id, Integer difficulty_id, String description) {
    this.category_id = category_id;
    this.difficulty_id = difficulty_id;
    this.description = description;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "category_id")
  public Integer getCategory_id() {
    return category_id;
  }

  public void setCategory_id(Integer category_id) {
    this.category_id = category_id;
  }

  @Column(name = "difficulty_id")
  public Integer getDifficulty_id() {
    return difficulty_id;
  }

  public void setDifficulty_id(Integer difficulty_id) {
    this.difficulty_id = difficulty_id;
  }

  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @JsonIgnore
  @OneToMany(targetEntity = Quizquestions.class, mappedBy = "quizzes", fetch = FetchType.LAZY)
  public List<Quizquestions> getQuizquestions() {
    return quizquestions;
  }

  public void setQuizquestions(List<Quizquestions> quizquestions) {
    this.quizquestions = quizquestions;
  }

}
