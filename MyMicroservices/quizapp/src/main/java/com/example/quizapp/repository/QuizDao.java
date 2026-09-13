package com.example.quizapp.repository;

import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

  // Quiz findByCategoryAndTitle(String category,String title);



}
