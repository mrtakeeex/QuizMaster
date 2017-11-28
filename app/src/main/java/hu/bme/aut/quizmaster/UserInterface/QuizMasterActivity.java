package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.UserInterface.QuizMaster.QuizMasterGameFragment;
import hu.bme.aut.quizmaster.UserInterface.QuizMaster.QuizMasterMainFragment;

public class QuizMasterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master);

        switchView(new QuizMasterMainFragment());
    }

    public void startGame() {
        switchView(new QuizMasterGameFragment());
    }

    @Override
    public void onBackPressed() {
        switchView(new QuizMasterMainFragment());
    }

    private void switchView(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.quizMasterActivity, fragment);
        fragmentTransaction.commit();
    }
}
