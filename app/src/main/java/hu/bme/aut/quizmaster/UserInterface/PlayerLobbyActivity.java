package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.os.Bundle;

import hu.bme.aut.quizmaster.R;

public class PlayerLobbyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_lobby);
    }
}
