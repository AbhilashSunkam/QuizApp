package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Questions table
 * 
 * @author abhilashsunkam
 *
 */
@Entity
@Table(name = "questions", catalog = "quizapp")
public class Questions implements java.io.Serializable {

  private Integer id;
  private String answer;
  private String answer1;
  private String answer2;
  private String answer3;
  private String answer4;
  private Integer categoryId;
  private Integer difficultyId;
  private String questionName;

  private List<Quizquestions> quizquestions;

  public Questions() {}


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Column(name = "answer")
  public String getAnswer() {
    return this.answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Column(name = "answer1")
  public String getAnswer1() {
    return this.answer1;
  }

  public void setAnswer1(String answer1) {
    this.answer1 = answer1;
  }

  @Column(name = "answer2")
  public String getAnswer2() {
    return this.answer2;
  }

  public void setAnswer2(String answer2) {
    this.answer2 = answer2;
  }

  @Column(name = "answer3")
  public String getAnswer3() {
    return this.answer3;
  }

  public void setAnswer3(String answer3) {
    this.answer3 = answer3;
  }

  @Column(name = "answer4")
  public String getAnswer4() {
    return this.answer4;
  }

  public void setAnswer4(String answer4) {
    this.answer4 = answer4;
  }

  @Column(name = "category_id")
  public Integer getCategoryId() {
    return this.categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  @Column(name = "difficulty_id")
  public Integer getDifficultyId() {
    return this.difficultyId;
  }

  public void setDifficultyId(Integer difficultyId) {
    this.difficultyId = difficultyId;
  }

  @Column(name = "question_name")
  public String getQuestionName() {
    return this.questionName;
  }

  public void setQuestionName(String questionName) {
    this.questionName = questionName;
  }

  @JsonIgnore
  @OneToMany(targetEntity = Quizquestions.class, mappedBy = "questions", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  public List<Quizquestions> getQuizquestions() {
    return quizquestions;
  }

  public void setQuizquestions(List<Quizquestions> quizquestions) {
    this.quizquestions = quizquestions;
  }

}
