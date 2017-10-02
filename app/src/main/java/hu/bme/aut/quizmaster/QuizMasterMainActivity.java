package hu.bme.aut.quizmaster;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class QuizMasterMainActivity extends AppCompatActivity {

    private String playerName;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_main);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            playerName = bundle.getString("playerNickName");
        } else {
            playerName = "unknown";
        }

        View availablePlayerItem = layoutInflater.inflate(R.layout.available_player_item, null);
        LinearLayout availablePlayersList = (LinearLayout) findViewById(R.id.available_players_list);

        availablePlayersList.addView(availablePlayerItem);
    }
}
