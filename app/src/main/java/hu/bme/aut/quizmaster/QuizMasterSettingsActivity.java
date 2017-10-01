package hu.bme.aut.quizmaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QuizMasterSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_settings);

        openQuizMasterMainActivity();
    }

    private void openQuizMasterMainActivity() {
        Button btnCreateRoom = (Button) findViewById(R.id.btnCreateRoom);
        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizMasterSettingsActivity.this, QuizMasterMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
