package com.example.quizapp.controller;

import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Response;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService  quizService;


   @PostMapping("create")
    public ResponseEntity<String> createToQuiz(@RequestParam("category") String category, @RequestParam("noOfQuestions") int numQ, @RequestParam("title") String title){
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") int id){

       return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
       return quizService.createResult(id,responses);
    }
}
