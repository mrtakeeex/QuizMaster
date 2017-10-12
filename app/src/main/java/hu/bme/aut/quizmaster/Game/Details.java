package hu.bme.aut.quizmaster.Game;


public class Details {
    private static int timeForAnswerQuestionInSec;
    private static int elapsedQuestionNum;

    public static int getElapsedQuestionNum() {
        return elapsedQuestionNum;
    }

    public static void incrementElapsedQuestionNum() {
        Details.elapsedQuestionNum++;
    }


    static int getTimeForAnswerQuestionInSec() {
        return timeForAnswerQuestionInSec;
    }

    static void setTimeForAnswerQuestionInSec(int timeForAnswerQuestionInSec) {
        Details.timeForAnswerQuestionInSec = timeForAnswerQuestionInSec;
    }

    static void setDefaultSettings() {
        timeForAnswerQuestionInSec = 300;
        elapsedQuestionNum = 0;
    }
}
