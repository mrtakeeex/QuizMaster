package hu.bme.aut.quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

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
                Intent intent = new Intent(DialogPlayerInit.this, (Class) getIntent().getSerializableExtra(KeyStore.WHICH_BUTTON_CLICKED));
                intent.putExtra(KeyStore.PLAYER_NAME, editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
