package com.onlineQuizPortal.performanceEvaluator;

import java.util.ArrayList;
import java.util.List;



public class QuizObjectResponse {
    private int QuizId;
    private String Quizname;
    List<QuestionObjectResponse> questions = new ArrayList<>();




    public int getQuizId() {
        return QuizId;
    }
    public void setQuizId(int QuizId) {
        this.QuizId = QuizId;
    }
    public String getQuizname() {
        return Quizname;
    }
    public void setQuizname(String Quizname) {
        this.Quizname = Quizname;
    }
    public List<QuestionObjectResponse> getQuestions() {
        return questions;
    }
    public void setQuestions(List<QuestionObjectResponse> questions) {
        this.questions = questions;
    }
}
