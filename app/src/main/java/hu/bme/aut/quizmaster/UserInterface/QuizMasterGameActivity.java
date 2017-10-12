package hu.bme.aut.quizmaster.UserInterface;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.Database.Topic;
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

        List<String> topics = Request.getInstance(this).getTopicNamesInString();
    }
}
