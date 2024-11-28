package com.quiz.Controller;

import com.quiz.QuizService.quizService;
import com.quiz.Client.userClient;
import com.quiz.Model.Quiz;
import com.quiz.Model.Users;
import com.quiz.Model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private quizService quizService;

    @Autowired
    private userClient userClient;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestHeader("Authorization") String token,@RequestBody Quiz quiz) {

        ResponseEntity<Users> userResponse = userClient.getProfile(token);
        Users user=userResponse.getBody();
        if (user == null) {
            return ResponseEntity.status(401).body("Invalid or expired token");
        }
    
        if (user.getRole() == Role.User) {
            return ResponseEntity.status(401).body("User can't create quiz");
        }
    
        Quiz createdQuiz = new Quiz(quiz.getTopic(), user.getId());
        quizService.createQuiz(createdQuiz);

        return ResponseEntity.ok(createdQuiz);
    }
}
