package hu.bme.aut.quizmaster.Game;


import hu.bme.aut.quizmaster.Database.Topic;

public class Details {
    private static int timeForAnswerQuestionInMillis;
    private static Topic topic;
    private static int elapsedQuestionNum;

    public static int getElapsedQuestionNum() {
        return elapsedQuestionNum;
    }

    public static void setElapsedQuestionNum(int elapsedQuestionNum) {
        Details.elapsedQuestionNum = elapsedQuestionNum;
    }

    static Topic getTopic() {
        return topic;
    }

    public static void setTopic(Topic topic) {
        Details.topic = topic;
    }

    static int getTimeForAnswerQuestionInMillis() {
        return timeForAnswerQuestionInMillis;
    }

    static void setTimeForAnswerQuestionInMillis(int timeForAnswerQuestionInMillis) {
        Details.timeForAnswerQuestionInMillis = timeForAnswerQuestionInMillis;
    }

    static void setDefaultSettings() {
        timeForAnswerQuestionInMillis = 30000;
        topic = null;
        elapsedQuestionNum = 0;
    }
}
