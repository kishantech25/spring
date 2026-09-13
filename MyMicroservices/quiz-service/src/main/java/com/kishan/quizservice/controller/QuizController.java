package com.kishan.quizservice.controller;

import com.kishan.quizservice.model.QuestionWrapper;
import com.kishan.quizservice.model.QuizDto;
import com.kishan.quizservice.model.Response;
import com.kishan.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


   @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        return quizService.createQuiz(quizDto.categoryName(),quizDto.numberOfQuestions(),quizDto.title());
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
