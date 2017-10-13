package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hu.bme.aut.quizmaster.Utility.KeyStore;
import hu.bme.aut.quizmaster.R;

public class DialogPlayerInit extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_player_init);

        Button btnPlayAsPlayer = (Button) findViewById(R.id.btnPlayDialog);
        btnPlayAsPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.etNickName);
                if (editText.getText().toString().isEmpty()) {
                    Toast.makeText(DialogPlayerInit.this, "Type a nickname!", Toast.LENGTH_SHORT).show();
                    return;
                }

                KeyStore.values.put(KeyStore.PLAYER_NAME, editText.getText().toString());
                startActivity(new Intent(DialogPlayerInit.this, (Class) getIntent().getSerializableExtra(KeyStore.WHICH_BUTTON_CLICKED)));
            }
        });
    }
}
