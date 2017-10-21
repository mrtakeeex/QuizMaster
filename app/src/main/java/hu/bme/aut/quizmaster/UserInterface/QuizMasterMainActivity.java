package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.Utility.KeyStore;

public class QuizMasterMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_main);

        TextView tvPlayerName = (TextView) findViewById(R.id.tvQuizMasterMainPlayerName);
        tvPlayerName.setText("You are playing as " + KeyStore.values.get(KeyStore.PLAYER_NAME));

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View availablePlayerItem = layoutInflater.inflate(R.layout.available_player_item, null);
        LinearLayout availablePlayersList = (LinearLayout) findViewById(R.id.available_players_list);

        availablePlayersList.addView(availablePlayerItem);

        startGame();
    }

    private void startGame() {
        Button btnStartGame = (Button) findViewById(R.id.btnStartGame);
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMasterMainActivity.this, QuizMasterGameActivity.class));
            }
        });
    }
}
