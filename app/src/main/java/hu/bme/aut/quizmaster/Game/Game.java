package hu.bme.aut.quizmaster.Game;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.R;

public class Game {
    private Activity activity;
    private Context context;
    private Random random;
    // controls
    private TextView tvTopic;
    private TextView tvQuestion;
    private TextView tvTimer;
    private TextView tvResults;

    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private List<Question> questionList;
    private int elapsedQuestionNum;

    private List<Player> players;
    private QuizMaster quizMaster;

    public Game(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        this.random = new Random();
        this.questionList = Request.getInstance(context).getQuestionList();
        this.elapsedQuestionNum = 0;
        initControls();
    }

    private void initControls() {
        this.tvTopic = (TextView) activity.findViewById(R.id.tvTopic);
        this.tvQuestion = (TextView) activity.findViewById(R.id.tvQuestion);
        this.tvTimer = (TextView) activity.findViewById(R.id.tvTimer);
        this.tvResults = (TextView) activity.findViewById(R.id.tvResults);
        this.btnAnswer1 = (Button) activity.findViewById(R.id.btnQpAnsw1);
        this.btnAnswer2 = (Button) activity.findViewById(R.id.btnQpAnsw2);
        this.btnAnswer3 = (Button) activity.findViewById(R.id.btnQpAnsw3);
        this.btnAnswer4 = (Button) activity.findViewById(R.id.btnQpAnsw4);
    }

    public void startEndlessMode() {
//        while (!questionList.isEmpty()) {
        getRandomQuestion();
        startTimerForQuestion();
//        }
    }

    private void startTimerForQuestion() {
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                tvTimer.setText("Done!");
            }
        }.start();
    }

    public void startMultiplayerMode() {
        // TODO
    }

    private void getRandomQuestion() {
        int currQuestionIndex = random.nextInt(questionList.size());
        Question question = questionList.get(currQuestionIndex);

        List<String> answersForQuestion = Request.getInstance(context).getAllAnswer(question);

        for (Button button : Arrays.asList(btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4)) {
            int index = random.nextInt(answersForQuestion.size());
            button.setText(answersForQuestion.get(index));
            answersForQuestion.remove(index);
        }

        questionList.remove(currQuestionIndex);

        tvResults.setText("Good anwers:" + "0" + "/" + this.elapsedQuestionNum);
        tvTopic.setText(question.getTopic().toString());
        tvQuestion.setText(question.getQuestionStr());
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public QuizMaster getQuizMaster() {
        return quizMaster;
    }

    public void setQuizMaster(QuizMaster quizMaster) {
        this.quizMaster = quizMaster;
    }
}
