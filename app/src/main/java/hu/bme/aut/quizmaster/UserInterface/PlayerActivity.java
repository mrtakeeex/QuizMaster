package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.LinearLayout;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.UserInterface.Player.PlayerMainFragment;

public class PlayerActivity extends Activity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        linearLayout = (LinearLayout) findViewById(R.id.playerActivity);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.playerActivity, new PlayerMainFragment());
        fragmentTransaction.commit();
    }
}
