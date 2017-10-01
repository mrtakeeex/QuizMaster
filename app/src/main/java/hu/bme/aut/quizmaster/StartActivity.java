package hu.bme.aut.quizmaster;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        openPlayerMainDialog();
        openQuizMasterMainDialog();
    }

    private void openPlayerMainDialog() {
        Button btnPlayer = (Button) findViewById(R.id.btnPlayer);
        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPlayerDialog();
            }
        });
    }

    private void openQuizMasterMainDialog() {
        Button btnQuizMaster = (Button) findViewById(R.id.btnQuizMaster);
        btnQuizMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuizMasterDialog();
            }
        });
    }

    private void showQuizMasterDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_player_init);
        dialog.show();

        openQuizMasterMainActivity(dialog);
    }

    private void openQuizMasterMainActivity(final Dialog playerDialog) {
        Button btnPlayAsQuizMaster = (Button) playerDialog.findViewById(R.id.btnPlayDialog);
        btnPlayAsQuizMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) playerDialog.findViewById(R.id.etNickName);
                Intent intent = new Intent(StartActivity.this, QuizMasterMainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("playerNickName", editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void showPlayerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_player_init);
        dialog.show();

        openPlayerMainActivity(dialog);
    }

    private void openPlayerMainActivity(final Dialog playerDialog) {
        Button btnPlayAsPlayer = (Button) playerDialog.findViewById(R.id.btnPlayDialog);
        btnPlayAsPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) playerDialog.findViewById(R.id.etNickName);
                Intent intent = new Intent(StartActivity.this, PlayerMainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("playerNickName", editText.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
