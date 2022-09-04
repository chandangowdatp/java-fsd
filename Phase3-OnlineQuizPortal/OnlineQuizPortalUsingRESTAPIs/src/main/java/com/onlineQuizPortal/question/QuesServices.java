package com.onlineQuizPortal.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class QuesServices {
    @Autowired
    QuestionJPARepo quesRepo;

    //add Question
    public QuestionObject addQuestion(QuestionObject question) {
        return quesRepo.save(question);
    }

    public List<QuestionObject> getAllQuestion() {
        return quesRepo.findAll();
    }

    public Optional<QuestionObject> getQuestionById(int quesId) {
        return quesRepo.findById(quesId);
    }
}
