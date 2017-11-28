package hu.bme.aut.quizmaster.UserInterface.Player;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import hu.bme.aut.quizmaster.R;

public class PlayerLobbyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_lobby, container, false);

        LinearLayout availablePlayersList = (LinearLayout) view.findViewById(R.id.available_players_list);

        return view;
    }
}
