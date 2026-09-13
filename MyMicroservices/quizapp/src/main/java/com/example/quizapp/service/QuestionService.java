package com.example.quizapp.service;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
        }
    }
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<String> addQuestions(Question question) {
        ResponseEntity<String> response=null;
//        try(questionRepository.save(question);
//            response=new ResponseEntity<>("Question added successfully", HttpStatus.OK)){
//
//        }

        return response;
    }





}
