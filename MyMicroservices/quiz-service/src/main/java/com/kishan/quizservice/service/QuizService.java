package com.kishan.quizservice.service;

import com.kishan.quizservice.gateway.QuestionAPIGatewayInterface;
import com.kishan.quizservice.model.QuestionWrapper;
import com.kishan.quizservice.model.Quiz;
import com.kishan.quizservice.model.Response;
import com.kishan.quizservice.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionAPIGatewayInterface  questionAPIGatewayInterface;

    public ResponseEntity<String> createQuiz(String category, Integer numQ,String title) {
        //get the list of questions
        List<Integer> questionsIds =questionAPIGatewayInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionsIds);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {

        //get the all questionIds of given quiz
        Quiz quiz =quizDao.findById(id).get();

        List<Integer> questionIds = quiz.getQuestionIds();

        List<QuestionWrapper> questionWrappers =questionAPIGatewayInterface.getQuestionsFromId(questionIds).getBody();

        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> createResult(int id, List<Response> responses) {
        Quiz quiz =quizDao.findById(id).get();

        ResponseEntity<Integer> score = questionAPIGatewayInterface.getScore(responses);
        return  score;

    }
}
