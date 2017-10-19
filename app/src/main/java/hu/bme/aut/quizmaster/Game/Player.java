package hu.bme.aut.quizmaster.Game;

public class Player {
    private String name;
    private int score;
    private int goodAnswers;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.goodAnswers = 0;
    }

    public Player() {
        this.name = "undefined";
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementGoodAnswers() {
        this.goodAnswers++;
    }

    public int getGoodAnswers() {
        return goodAnswers;
    }

    public void incrementScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
