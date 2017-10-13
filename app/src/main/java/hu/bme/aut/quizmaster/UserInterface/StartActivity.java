package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hu.bme.aut.quizmaster.Utility.KeyStore;
import hu.bme.aut.quizmaster.R;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        playAsPlayer();
        playAsQuizMaster();
        openQuickPlayActivity();
    }

    private void openQuickPlayActivity() {
        Button btnQuickPlay = (Button) findViewById(R.id.btnQuickPlay);
        btnQuickPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this, EndlessGameActivity.class));
            }
        });
    }

    private void playAsPlayer() {
        Button btnPlayer = (Button) findViewById(R.id.btnPlayer);
        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, DialogPlayerInit.class);
                intent.putExtra(KeyStore.WHICH_BUTTON_CLICKED, PlayerMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void playAsQuizMaster() {
        Button btnQuizMaster = (Button) findViewById(R.id.btnQuizMaster);
        btnQuizMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, DialogPlayerInit.class);
                intent.putExtra(KeyStore.WHICH_BUTTON_CLICKED, QuizMasterMainActivity.class);
                startActivity(intent);
            }
        });
    }
}