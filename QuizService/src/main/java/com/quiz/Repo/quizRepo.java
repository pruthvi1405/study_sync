package com.quiz.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.Model.Quiz;

public interface quizRepo extends JpaRepository<Quiz,UUID>{

}
