package com.quiz.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.Model.Quiz;
import com.quiz.QuizService.quizService;
import com.quiz.Repo.quizRepo;


@Service
public class QuizImpl implements quizService {

    @Autowired
    private quizRepo quizRepository;

    @Override
    public Quiz createQuiz(Quiz quiz) {
            return quizRepository.save(quiz);
    }

}
