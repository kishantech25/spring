package com.kishan.quizservice.gateway;

import com.kishan.quizservice.model.QuestionWrapper;
import com.kishan.quizservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "QUESTION-SERVICE")
public interface QuestionAPIGatewayInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numOfQuestions);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
