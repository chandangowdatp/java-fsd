package com.onlineQuizPortal.quiz;



public class QuestionObjectResponse {
    private int QId;
    private String Qname;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctoption;



    public String getOption1() {
        return option1;
    }
    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getOption4() {
        return option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getCorrectoption() {
        return correctoption;
    }
    public void setCorrectoption(String correctoption) {
        this.correctoption = correctoption;
    }
    public int getQId() {
        return QId;
    }
    public void setQId(int QId) {
        this.QId = QId;
    }
    public String getQname() {
        return Qname;
    }
    public void setQname(String Qname) {
        this.Qname = Qname;
    }
}
