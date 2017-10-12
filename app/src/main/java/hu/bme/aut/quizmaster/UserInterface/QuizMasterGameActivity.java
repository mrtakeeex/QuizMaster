package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.R;

public class QuizMasterGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_game);

        Button btnTopic1 = (Button) findViewById(R.id.btnTopic1);
        Button btnTopic2 = (Button) findViewById(R.id.btnTopic2);
        Button btnTopic3 = (Button) findViewById(R.id.btnTopic3);
        Button btnTopic4 = (Button) findViewById(R.id.btnTopic4);
        TextView tvQmTimer = (TextView) findViewById(R.id.tvQmTimer);


        List<String> allTopics = Request.getInstance(this).getTopicNamesInString();
        Collections.shuffle(allTopics);
        List<String> fourTopics = allTopics.subList(0, 4);

        Random random = new Random();
        List<Button> buttons = Arrays.asList(btnTopic1, btnTopic2, btnTopic3, btnTopic4);
        for (Button button : buttons) {
            int index = random.nextInt(fourTopics.size());
            button.setText(fourTopics.get(index));
            fourTopics.remove(index);
        }

        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvQmTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvQmTimer.setText(buttons.get(random.nextInt(buttons.size())).getText());
            }
        }.start();
    }
}
