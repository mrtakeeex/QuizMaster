package hu.bme.aut.quizmaster;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class QuizMasterMainActivity extends Activity {

    private String playerName;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_main);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View availablePlayerItem = layoutInflater.inflate(R.layout.available_player_item, null);
        LinearLayout availablePlayersList = (LinearLayout) findViewById(R.id.available_players_list);

        availablePlayersList.addView(availablePlayerItem);
    }
}
