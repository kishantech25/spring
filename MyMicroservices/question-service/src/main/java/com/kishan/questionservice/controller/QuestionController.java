package com.kishan.questionservice.controller;

import com.kishan.questionservice.model.Question;
import com.kishan.questionservice.model.QuestionWrapper;
import com.kishan.questionservice.model.Response;
import com.kishan.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>  getAllQuestionsByCategory(@PathVariable("category") String category){
           return questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestions(question);
        return ResponseEntity.status(HttpStatus.CREATED).body("Question added successfully");
    }
    //generate
    //getQuestions (questionid)

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numOfQuestions){
        return questionService.getQuestionForQuiz(categoryName,numOfQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){
         return questionService.getQuestionsFromId(questionIds);
    }
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}
