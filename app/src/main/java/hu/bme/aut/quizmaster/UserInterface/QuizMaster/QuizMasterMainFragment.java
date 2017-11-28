package hu.bme.aut.quizmaster.UserInterface.QuizMaster;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.UserInterface.QuizMasterActivity;
import hu.bme.aut.quizmaster.Utility.KeyStore;

public class QuizMasterMainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_master_main, container, false);

        TextView tvPlayerName = (TextView) view.findViewById(R.id.tvQuizMasterMainPlayerName);
        tvPlayerName.setText("You are playing as " + KeyStore.values.get(KeyStore.PLAYER_NAME));
        LinearLayout availablePlayersList = (LinearLayout) view.findViewById(R.id.available_players_list);

        for (int i = 0; i < 5; i++) {
            View availablePlayerItem = inflater.inflate(R.layout.available_player_item, null);
            TextView tvAvailablePlayerName = (TextView) availablePlayerItem.findViewById(R.id.tvAvailablePlayer);
            tvAvailablePlayerName.setText("Player " + i);
            availablePlayersList.addView(availablePlayerItem);
        }

        Button btnStartGame = (Button) view.findViewById(R.id.btnStartGame);
        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((QuizMasterActivity) getActivity()).startGame();
            }
        });

        return view;
    }
}
