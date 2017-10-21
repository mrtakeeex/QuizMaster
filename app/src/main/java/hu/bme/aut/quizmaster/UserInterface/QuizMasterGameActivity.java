package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.R;
import hu.bme.aut.quizmaster.Utility.KeyStore;

public class QuizMasterGameActivity extends Activity {

    private List<String> allTopics;
    private TextView tvQmTimer;
    private TextView tvPlayerName;
    private Random random;
    private CountDownTimer countDownTimer;
    private List<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_game);

        init();

        tvPlayerName.setText("You are playing as " + KeyStore.values.get(KeyStore.PLAYER_NAME));

        setNextFourTopics();
    }

    private void setNextFourTopics() {
        for (Button button : buttons) {
            button.setClickable(true);
        }
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        loadRandomFourTopics();

        countDownTimer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvQmTimer.setText("" + millisUntilFinished / 1000);
                tvQmTimer.setTextColor(Color.RED);
                for (Button button : buttons) {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // TODO: getQuestionsFromTopic
                            // TODO: sleep until others answer

                            setNextFourTopics();
                        }
                    });
                }
            }

            public void onFinish() {
                String chosenTopic = buttons.get(random.nextInt(buttons.size())).getText().toString();
                for (Button button : buttons) {
                    button.setText(chosenTopic);
                }
                // TODO: sleep until others answer
                setNextFourTopics();
            }
        }.start();
    }

    private void init() {
        Button btnTopic1 = (Button) findViewById(R.id.btnTopic1);
        Button btnTopic2 = (Button) findViewById(R.id.btnTopic2);
        Button btnTopic3 = (Button) findViewById(R.id.btnTopic3);
        Button btnTopic4 = (Button) findViewById(R.id.btnTopic4);
        tvQmTimer = (TextView) findViewById(R.id.tvQmTimer);
        tvPlayerName = (TextView) findViewById(R.id.tvQuizMasterGamePlayerName);
        allTopics = Request.getInstance(this).getTopicNamesInString();
        random = new Random();
        buttons = Arrays.asList(btnTopic1, btnTopic2, btnTopic3, btnTopic4);
    }


    private void loadRandomFourTopics() {
        if (allTopics.isEmpty() || allTopics == null) {
            allTopics = Request.getInstance(this).getTopicNamesInString();
        }

        Collections.shuffle(allTopics);
        List<String> temp = new ArrayList<>(allTopics);
        List<String> fourRandomTopics = temp.subList(0, 4);

        for (Button button : buttons) {
            int index = random.nextInt(fourRandomTopics.size());
            button.setText(fourRandomTopics.get(index));
            fourRandomTopics.remove(index);
        }
    }
}
