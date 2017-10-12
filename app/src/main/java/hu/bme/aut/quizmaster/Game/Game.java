package hu.bme.aut.quizmaster.Game;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hu.bme.aut.quizmaster.Database.Question;
import hu.bme.aut.quizmaster.Database.Request;
import hu.bme.aut.quizmaster.R;

import static java.lang.Math.toIntExact;

public class Game implements Runnable {
    private Activity activity;
    private Context context;
    private Random random;

    private TextView tvTopic;
    private TextView tvQuestion;
    private TextView tvTimer;
    private TextView tvResults;

    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private Button btnAnswer4;

    private List<Question> questionList;

    private List<Player> players;
    private QuizMaster quizMaster;

    public Game(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
        this.random = new Random();
        this.questionList = Request.getInstance(context).getQuestionList();
        initControls();
    }

    private void initControls() {
        this.tvTopic = (TextView) activity.findViewById(R.id.tvTopic);
        this.tvQuestion = (TextView) activity.findViewById(R.id.tvQuestion);
        this.tvTimer = (TextView) activity.findViewById(R.id.tvTimer);
        this.tvResults = (TextView) activity.findViewById(R.id.tvResults);
        this.btnAnswer1 = (Button) activity.findViewById(R.id.btnAnswer1);
        this.btnAnswer2 = (Button) activity.findViewById(R.id.btnAnswer2);
        this.btnAnswer3 = (Button) activity.findViewById(R.id.btnAnswer3);
        this.btnAnswer4 = (Button) activity.findViewById(R.id.btnAnswer4);
    }

    Player player = new Player();

    public void startEndlessMode() {
        Details.setDefaultSettings();


        goToNextQuestion(player);

        // TODO: WAIT UNTIL BTN CLICKED IS TRUE AND THEN GO ON WITH THIS
//        while (!questionList.isEmpty() && (btnAnswer1.isPressed() || btnAnswer2.isPressed()
//                || btnAnswer3.isPressed() || btnAnswer4.isPressed())) {
//            goToNextQuestion(player);
//        }


        Thread thread = new Thread();
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            if (btnAnswer1.isPressed() || btnAnswer2.isPressed()
                    || btnAnswer3.isPressed() || btnAnswer4.isPressed()) {
                goToNextQuestion(player);
            }
        }
    }

    private void goToNextQuestion(Player player) {
        Details.incrementElapsedQuestionNum();
        Question randomQuestion = getRandomQuestion();
        getTimeLeftInSecAfterPlayerAnswer(randomQuestion, player);
    }


    private int getTimeLeftInSecAfterPlayerAnswer(Question question, Player player) {
        String goodAnswer = question.getAnswerGood();
        final int[] retSec = {0};

        new CountDownTimer(Details.getTimeForAnswerQuestionInSec() * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + millisUntilFinished / 1000);

                for (Button button : Arrays.asList(btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4)) {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (button.getText().equals(goodAnswer)) {
                                player.incrementScore(toIntExact(millisUntilFinished / 1000));
                                Toast.makeText(context, "Good! +" + toIntExact(millisUntilFinished / 1000) + " points!",
                                        Toast.LENGTH_LONG).show();
                                retSec[0] = toIntExact(millisUntilFinished / 1000);
                            } else {
                                Toast.makeText(context, "WRONG! The good answer is: " + goodAnswer,
                                        Toast.LENGTH_LONG).show();
                                retSec[0] = toIntExact(millisUntilFinished / 1000);
                            }
                        }
                    });
                }
            }

            public void onFinish() {
                tvTimer.setText("Time up!");
                Toast.makeText(context, "Time up! The good answer is: " + goodAnswer,
                        Toast.LENGTH_LONG).show();
            }
        }.start();

        return retSec[0];
    }

    public void startMultiplayerMode() {
        // TODO
    }

    private Question getRandomQuestion() {
        int currQuestionIndex = random.nextInt(questionList.size());
        Question question = questionList.get(currQuestionIndex);

        List<String> answersForQuestion = Request.getInstance(context).getAllAnswer(question);

        for (Button button : Arrays.asList(btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4)) {
            int index = random.nextInt(answersForQuestion.size());
            button.setText(answersForQuestion.get(index));
            answersForQuestion.remove(index);
        }

        questionList.remove(currQuestionIndex);

        tvResults.setText("Good anwers:" + "0" + "/" + Details.getElapsedQuestionNum());
        tvTopic.setText(question.getTopic().toString());
        tvQuestion.setText(question.getQuestionStr());

        return question;
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
