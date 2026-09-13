package com.kishan.questionservice.service;

import com.kishan.questionservice.model.Question;
import com.kishan.questionservice.model.QuestionWrapper;
import com.kishan.questionservice.model.Response;
import com.kishan.questionservice.repository.QuestionRepository;
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

    public Question addQuestions(Question question) {
        return questionRepository.save(question);
    }


    public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, Integer numOfQuestions) {

        List<Integer> questions =questionRepository.findRandomQuestionByCategory(categoryName,numOfQuestions);



        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
       List<QuestionWrapper> wrappers =new ArrayList<>();
       List<Question> questions =new ArrayList<>();

       for(Integer questionId:questionIds){
           questions.add(questionRepository.findById(questionId).get());
       }
       for(Question question:questions){
           QuestionWrapper wrapper =new QuestionWrapper(question.getId(),
                   question.getQuestionTitle(),
                   question.getOption1(),
                   question.getOption2(),
                   question.getOption3(),
                   question.getOption4());
           wrappers.add(wrapper);
       }
       return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        //get the first original Quiz data

        int right =0;
        //to check the response data using stream
        for(Response response:responses){
            Question question =questionRepository.findById(response.id()).get();

            if(response.answer().equals(question.getRightAnswer())){
                right++;
            }
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
