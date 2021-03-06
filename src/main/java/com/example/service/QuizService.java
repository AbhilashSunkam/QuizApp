package com.example.service;

import java.util.List;

import com.example.models.Quizzes;

/**
 * quiz service interface
 * 
 * @author abhilashsunkam
 *
 */
public interface QuizService {

  public List<Quizzes> getAll();

  public List<Quizzes> getById(Integer id);

  public void deleteById(Integer id);

  public void save(Quizzes quizzes);

  public Quizzes findById(Integer id);

  public List<Quizzes> getQuizRand(Integer cid, Integer did);

  public Quizzes addQuiz(Integer cid, Integer did, String description);
}
