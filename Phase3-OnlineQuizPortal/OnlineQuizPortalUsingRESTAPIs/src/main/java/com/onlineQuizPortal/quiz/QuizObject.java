package com.onlineQuizPortal.quiz;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class QuizObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int QuizId;
    private String Quizname;
    @ElementCollection
    List<Integer> questionID=new ArrayList<>();

    public int getQuizId() {
        return QuizId;
    }

    public void setQuizId(int quizId) {
        QuizId = quizId;
    }

    public String getQuizname() {
        return Quizname;
    }

    public void setQuizname(String quizname) {
        Quizname = quizname;
    }

    public List<Integer> getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int quesId) {
        this.questionID.add(quesId);
    }


/*public List<Integer> getQuestionID() {
        return questionID;
    }
    public void setQuestionID(List<Integer> questionID) {
        this.questionID = questionID;
    }
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
    public QuizObject( ) {
        super();

        this.questionID.add(1);
        this.questionID.add(3);
    }*/
}
