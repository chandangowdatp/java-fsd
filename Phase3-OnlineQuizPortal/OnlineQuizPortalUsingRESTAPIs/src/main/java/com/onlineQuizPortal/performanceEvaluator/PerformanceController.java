package com.onlineQuizPortal.performanceEvaluator;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    PerformanceServices performanceServices;

    RestTemplate performanceRESTTemplate = new RestTemplate();


    // to handle quiz submission
    @PostMapping("/{userId}/submitQuiz={QuizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("userId") int userId, @PathVariable("QuizId") int quizId, @RequestBody int score){
        try{
            UserPerformance userPerformance = new UserPerformance();
            userPerformance.setUserId(userId);
            userPerformance.setQuizId(quizId);

            List<UserPerformance> existingRecord = performanceServices.fetchStats(userId);
            if(existingRecord.size() != 0){
                for (int i = 0; i < existingRecord.size(); i++) {
                    if(existingRecord.get(i).getQuizId() == quizId && existingRecord.get(i).getBestScore() > score) {
                        score = existingRecord.get(i).getBestScore();
                    }
                }
            }
            userPerformance.setBestScore(score);
            UserPerformance resUserPerformance = performanceServices.addPerformance(userPerformance);

            if(score>=0)
                return new ResponseEntity<Integer>(score, HttpStatus.CREATED);
            else {
                return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // to handle api to fetch all quiz details of a particular user
    @GetMapping("/userId={userId}/viewAllAttemptedQuiz")
    public ResponseEntity<Map<String, Integer>> viewAllQuiz(@PathVariable("userId") int userId){
        try {
            List<UserPerformance> existingRecord = performanceServices.fetchStats(userId);
            Map<String, Integer> AttemptedQuizMap =  new HashMap<String, Integer>();
            int attemtedQuizId;
            String url;

            for (int i = 0; i < existingRecord.size(); i++) {
                attemtedQuizId = existingRecord.get(i).getQuizId();
                url = "http://localhost:8081/quiz/viewQuizById/{QuizId}";
                Map<String, Integer> params =  new HashMap<String, Integer>();
                params.put("QuizId", attemtedQuizId);
                AttemptedQuizMap.put((performanceRESTTemplate.getForObject(url, QuizObjectResponse.class, params)).getQuizname(), existingRecord.get(i).getBestScore());
                params.clear();
            }

            if(AttemptedQuizMap.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(AttemptedQuizMap,HttpStatus.OK);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
