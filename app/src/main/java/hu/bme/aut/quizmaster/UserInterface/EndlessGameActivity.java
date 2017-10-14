package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.os.Bundle;

import hu.bme.aut.quizmaster.Game.Game;
import hu.bme.aut.quizmaster.R;

public class EndlessGameActivity extends Activity {

    private static Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = new Game(this, this);
        game.startEndlessMode();
    }

    @Override
    protected void onPause(){
        super.onPause();
        game.stopGame();
    }
}
