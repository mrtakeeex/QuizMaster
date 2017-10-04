package hu.bme.aut.quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuizMasterSettingsActivity extends Activity {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_settings);

        openQuizMasterMainActivity();

        playerName = getIntent().getStringExtra(KeyStore.PLAYER_NAME);
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
