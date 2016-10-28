package com.example.service;

import java.util.List;

import com.example.models.Questions;
import com.example.models.Quizquestions;
import com.example.models.Quizzes;

/**
 * Quiz questions service interface
 * 
 * @author abhilashsunkam
 *
 */
public interface QuizquestionsService {


  public void addToQuizQuestions(List<Questions> questions, Quizzes quizzes);

}
