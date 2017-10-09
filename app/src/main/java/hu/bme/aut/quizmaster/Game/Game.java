package hu.bme.aut.quizmaster.Game;


import android.app.Activity;
import android.content.Context;

import java.util.List;

public class Game {
    private Activity activity;
    private Context context;
    private List<Player> players;
    private QuizMaster quizMaster;

    public Game(Context context, Activity activity){
        this.context = context;
        this.activity = activity;

        initGame();
    }

    public void initGame(){

    }

    public void startGame(){
        nextQuestion();
    }

    public void nextQuestion(){

    }
}
