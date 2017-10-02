package hu.bme.aut.quizmaster;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class PlayerMainActivity extends AppCompatActivity {

    private String playerName;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);

        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            playerName = bundle.getString("playerNickName");
        } else {
            playerName = "unknown";
        }

        View availableRoomItem = layoutInflater.inflate(R.layout.available_room_item, null);
        LinearLayout availableRoomsList = (LinearLayout) findViewById(R.id.available_rooms_list);

        availableRoomsList.addView(availableRoomItem);
    }
}
