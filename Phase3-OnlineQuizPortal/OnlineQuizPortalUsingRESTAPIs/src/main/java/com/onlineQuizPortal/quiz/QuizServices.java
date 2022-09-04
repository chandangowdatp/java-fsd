package com.onlineQuizPortal.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class QuizServices {
    @Autowired
    QuizJPARepo quizJPARepo;

    private RestTemplate quizRESTTemplate= new RestTemplate();

    //add Quiz
    public QuizObject addQuiz(QuizObject QP) {
        return quizJPARepo.save(QP);
    }

    // viewAll Quiz
    public List<QuizObject> getAllQuiz() {
        return quizJPARepo.findAll();

    }

    // view Quiz By Id
    public Optional<QuizObject> getQuizById(int id) {
        return (Optional<QuizObject>) quizJPARepo.findById(id);
    }
}
