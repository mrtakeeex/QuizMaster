package hu.bme.aut.quizmaster;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class PlayerMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_main);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        playerName = KeyStore.values.get(KeyStore.PLAYER_NAME);

        View availableRoomItem = layoutInflater.inflate(R.layout.available_room_item, null);
        LinearLayout availableRoomsList = (LinearLayout) findViewById(R.id.available_rooms_list);

        availableRoomsList.addView(availableRoomItem);
    }
}
