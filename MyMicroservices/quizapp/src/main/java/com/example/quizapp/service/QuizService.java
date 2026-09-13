package com.example.quizapp.service;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuestionWrapper;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.Response;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class QuizService {

    @Autowired
    private QuizDao  quizDao;

    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions =questionRepository.findRandomQuestionByCategory(category,numQ);

        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question>  questionsFromDb=quiz.get().getQuestions();
        List<QuestionWrapper> questionFOrUser=new CopyOnWriteArrayList<>();
        for(Question q:questionsFromDb){
            QuestionWrapper wrapper=new QuestionWrapper(q.getId(),q.getQuestionTitle()
                    ,q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionFOrUser.add(wrapper);
        }
        return new ResponseEntity<>(questionFOrUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> createResult(int id, List<Response> responses) {

        //get the first original Quiz data
        Optional<Quiz> quiz =quizDao.findById(id);
        List<Question> questionsFromDb=quiz.get().getQuestions();
        int right =0;
        int i=0;
        //to check the response data using stream

        for(Response response:responses){
           if(response.response().equals(questionsFromDb.get(i).getRightAnswer())){
               right++;
           }
           i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
