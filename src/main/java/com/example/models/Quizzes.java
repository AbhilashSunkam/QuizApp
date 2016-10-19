package com.example.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quizzes", catalog = "quizapp")
public class Quizzes implements java.io.Serializable {

	private Integer id;
	private Integer category_id;
	private Integer difficulty_id;
	
	private List<Quizquestions> quizquestions;

	public Quizzes() {

	}

	public Quizzes(Integer category_id, Integer difficulty_id, String questions) {
		this.category_id = category_id;
		this.difficulty_id = difficulty_id;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

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

	@OneToMany(targetEntity=Quizquestions.class, mappedBy = "quizzes")
	public List<Quizquestions> getQuizquestions() {
		return quizquestions;
	}

	public void setQuizquestions(List<Quizquestions> quizquestions) {
		this.quizquestions = quizquestions;
	}

}
