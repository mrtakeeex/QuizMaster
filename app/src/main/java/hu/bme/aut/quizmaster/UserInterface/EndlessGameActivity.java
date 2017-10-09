package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.Game.Game;
import hu.bme.aut.quizmaster.R;

public class EndlessGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // TODO: this and the other 3 classes
        Game game = new Game(this, this);

        TextView tvTopic = (TextView) findViewById(R.id.tvTopic);
        TextView tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        TextView tvTimer = (TextView) findViewById(R.id.tvTimer);
        TextView tvResults = (TextView) findViewById(R.id.tvResults);
        Button btnAnswer1 = (Button) findViewById(R.id.btnQpAnsw1);
        Button btnAnswer2 = (Button) findViewById(R.id.btnQpAnsw2);
        Button btnAnswer3 = (Button) findViewById(R.id.btnQpAnsw3);
        Button btnAnswer4 = (Button) findViewById(R.id.btnQpAnsw4);

        List<Question> questionList = Request.getInstance(this).getQuestionList();
        Random random = new Random();
        int formerQuestion = random.nextInt(questionList.size());
        Question question = questionList.get(formerQuestion);
        List<String> allAnswer = Request.getInstance(this).getAllAnswer(question);
        int index = random.nextInt(allAnswer.size());
        btnAnswer1.setText(allAnswer.get(index));
        allAnswer.remove(index);
        index = random.nextInt(allAnswer.size());
        btnAnswer2.setText(allAnswer.get(index));
        allAnswer.remove(index);
        index = random.nextInt(allAnswer.size());
        btnAnswer3.setText(allAnswer.get(index));
        allAnswer.remove(index);
        index = random.nextInt(allAnswer.size());
        btnAnswer4.setText(allAnswer.get(index));
        allAnswer.remove(index);

        questionList.remove(formerQuestion);

        tvResults.setText("Good anwers: 4/7");
        tvTopic.setText(question.getTopic().toString());
        tvQuestion.setText(question.getQuestionStr());

        int TimeForAnswerinMillis = 30000;

        new CountDownTimer(TimeForAnswerinMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("Done!");
            }
        }.start();

    }
}
