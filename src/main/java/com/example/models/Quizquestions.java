package com.example.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quizquestions")
public class Quizquestions implements Serializable{
	
	//private Integer id;
	private Questions questions;
    private Quizzes quizzes;
    
	public Quizquestions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//
//	@Column(name = "id", unique = true, nullable = false)
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	@Id
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	@Id
    @ManyToOne
    @JoinColumn(name = "quiz_id", referencedColumnName = "id")
	public Quizzes getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Quizzes quizzes) {
		this.quizzes = quizzes;
	}

	
	
	
}
