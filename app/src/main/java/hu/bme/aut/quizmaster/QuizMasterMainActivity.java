package hu.bme.aut.quizmaster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class QuizMasterMainActivity extends AppCompatActivity {

    private String playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_main);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            playerName = bundle.getString("playerNickName");
        } else {
            playerName = "unknown";
        }
    }
}
