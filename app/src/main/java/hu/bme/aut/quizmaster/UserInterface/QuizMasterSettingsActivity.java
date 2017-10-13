package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hu.bme.aut.quizmaster.R;

public class QuizMasterSettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_settings);

        openQuizMasterMainActivity();

//        playerName = KeyStore.values.get(KeyStore.PLAYER_NAME);
    }

    private void openQuizMasterMainActivity() {
        Button btnCreateRoom = (Button) findViewById(R.id.btnCreateRoom);
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizMasterSettingsActivity.this, QuizMasterMainActivity.class));
            }
        });
    }
}