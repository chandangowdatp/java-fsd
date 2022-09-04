package com.onlineQuizPortal.performanceEvaluator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(CompositeKey.class)
public class UserPerformance {
    @Id
    private int userId;
    @Id
    private int quizId;
    private int bestScore;

    public UserPerformance() {
        this.bestScore = 0;
    }

    /*public int getPerformanceTableId() {
        return performanceTableId;
    }

    public void setPerformanceTableId(int performanceTableId) {
        this.performanceTableId = performanceTableId;
    }*/

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        if(this.bestScore > bestScore) {
            //System.out.println("if is running");
            return;
        }
        //System.out.println("else is running");
        this.bestScore = bestScore;
    }
}
