package com.onlineQuizPortal.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizServices quizService;

    RestTemplate quizRESTTemplate = new RestTemplate();

    // to handle api to add new quiz in db
    @PostMapping("/addQuiz")
    public ResponseEntity<Object> addQuiz(@RequestBody QuizObject QP){
        QuizObject resp = quizService.addQuiz(QP);

        if(resp != null) {
            return new ResponseEntity<Object>(resp, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<Object>("Error while creating quiz.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // to handle api to add questions in a particular quiz using its id
    @PostMapping("/{QuizId}/addQuestions")
    public ResponseEntity<QuizObjectResponse> addQuestionsInQuiz(@PathVariable("QuizId") int QuizId, @RequestBody List<Integer> newQuesIdList){
        try {
            Optional<QuizObject> quiz = quizService.getQuizById(QuizId);
            for (int element: newQuesIdList) {
                quiz.get().setQuestionID(element);
            }

            quizService.addQuiz(quiz.get());

            List<QuestionObjectResponse> quesList = new ArrayList<QuestionObjectResponse>();

            String url = "http://localhost:8081/question/questionbyid/{quesId}";
            Map<String, Integer> params =  new HashMap<String, Integer>();
            for(int i : newQuesIdList) {
                params.put("quesId", i);
                quesList.add(quizRESTTemplate.getForObject(url, QuestionObjectResponse.class, params));
                params.clear();
            }

            QuizObjectResponse resQuiz = new QuizObjectResponse();
            resQuiz.setQuizId(QuizId);
            resQuiz.setQuizname(quiz.get().getQuizname());
            resQuiz.setQuestions(quesList);

            if(quiz == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(resQuiz, HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    // to handle api to view all quizz stored in db
    @GetMapping("/viewAllQuiz")
    public ResponseEntity<List<QuizObject>> viewAllQuiz(@RequestParam(required = false) String quizname){
        try {
            List<QuizObject> QuizList = new ArrayList<QuizObject>();
            quizService.getAllQuiz().forEach(QuizList::add);

            if(QuizList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(QuizList,HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // to handle api to view a particular quiz using its id
    @GetMapping("/viewQuizById/{QuizId}")
    public ResponseEntity<QuizObjectResponse> viewQuizById(@PathVariable("QuizId") int quizId){
        try {
            Optional<QuizObject> qui = quizService.getQuizById(quizId);
            List<QuestionObjectResponse> quesList = new ArrayList<QuestionObjectResponse>();

            String url = "http://localhost:8081/question/questionbyid/{quesId}";
            Map<String, Integer> params =  new HashMap<String, Integer>();
            for(int i : qui.get().questionID) {
                params.put("quesId", i);
                quesList.add(quizRESTTemplate.getForObject(url, QuestionObjectResponse.class, params));
                params.clear();
            }

            QuizObjectResponse resQuiz = new QuizObjectResponse();
            resQuiz.setQuizId(qui.get().getQuizId());
            resQuiz.setQuizname(qui.get().getQuizname());
            resQuiz.setQuestions(quesList);

            if(qui == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(resQuiz, HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
