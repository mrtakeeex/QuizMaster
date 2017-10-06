package hu.bme.aut.quizmaster.Database;


import com.orm.SugarRecord;

public class Question extends SugarRecord {

    private String questionStr;
    private String answerGood;
    private String answerWrong_1;
    private String answerWrong_2;
    private String answerWrong_3;

    public Question() {
    }

    public Question(String questionStr, String anwserGood, String answerWrong_1, String answerWrong_2, String answerWrong_3, Topic topic) {
        this.questionStr = questionStr;
        this.answerGood = anwserGood;
        this.answerWrong_1 = answerWrong_1;
        this.answerWrong_2 = answerWrong_2;
        this.answerWrong_3 = answerWrong_3;
        this.topic = topic;
    }

    public String getQuestionStr() {
        return questionStr;
    }

    public void setQuestionStr(String questionStr) {
        this.questionStr = questionStr;
    }

    public String getAnswerGood() {
        return answerGood;
    }

    public void setAnswerGood(String answerGood) {
        this.answerGood = answerGood;
    }

    public String getAnswerWrong_1() {
        return answerWrong_1;
    }

    public void setAnswerWrong_1(String answerWrong_1) {
        this.answerWrong_1 = answerWrong_1;
    }

    public String getAnswerWrong_2() {
        return answerWrong_2;
    }

    public void setAnswerWrong_2(String answerWrong_2) {
        this.answerWrong_2 = answerWrong_2;
    }

    public String getAnswerWrong_3() {
        return answerWrong_3;
    }

    public void setAnswerWrong_3(String answerWrong_3) {
        this.answerWrong_3 = answerWrong_3;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    private Topic topic;
}
