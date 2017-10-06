package hu.bme.aut.quizmaster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;

public class QuizMasterGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_master_game);

        TextView textView_1 = (TextView) findViewById(R.id.tvTest1);
        TextView textView_2 = (TextView) findViewById(R.id.tvTest2);

        List<Question> questionList = Request.getInstance().getQuestionList();

        textView_1.setText(questionList.get(0).getQuestionStr());
        textView_2.setText(questionList.get(1).getQuestionStr());
    }
}
