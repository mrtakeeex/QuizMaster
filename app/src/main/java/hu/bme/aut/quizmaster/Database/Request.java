package hu.bme.aut.quizmaster.Database;

import android.content.Context;
import android.util.Log;

import com.orm.util.NamingHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


public class Request {

    private static volatile Request instance = null;
    private static List<Question> questionList = null;
    private static final String FILE_NAME = "quizmaster_db.txt";
    private static final String TAG = "Request.class";

    private Request(Context context) {
        clearDataBase();
        initDataBaseWithQuestionsFromTxt(context);
        loadQuestionsToList();
    }

    private void loadQuestionsToList() {
        if (questionList != null) {
            questionList = null;
        }
        questionList = Question.listAll(Question.class);
        if (questionList == null) {
            throw new NullPointerException("Failed to initialize questions!");
        }
    }

    private void clearDataBase() {
        Question.deleteAll(Question.class);
        Question.executeQuery("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + NamingHelper.toSQLName(Question.class) + "'");
    }


    private void initDataBaseWithQuestionsFromTxt(Context context) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(FILE_NAME)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                new Question(parts[0], parts[1], parts[2], parts[3], parts[4], getTopicByString(parts[5])).save();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
    }

    private Topic getTopicByString(String string) {
        switch (string) {
            case "SCIENCE":
                return Topic.SCIENCE;
            case "GEOGRAPHY":
                return Topic.GEOGRAPHY;
            case "CHEMISTRY":
                return Topic.CHEMISTRY;
            case "AWARDS":
                return Topic.AWARDS;
            case "TECHNOLOGY":
                return Topic.TECHNOLOGY;
            case "PHYSICS":
                return Topic.PHYSICS;
            case "INVENTIONS":
                return Topic.INVENTIONS;
            case "BIOLOGY":
                return Topic.BIOLOGY;
            case "SPORTS":
                return Topic.SPORTS;
            default:
                return Topic.GENERAL;
        }
    }

    public static Request getInstance(Context context) {
        if (instance == null) {
            instance = new Request(context);
        }
        return instance;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public List<Question> getQuestionsInTopic(Topic topic) {
        return questionList.stream().filter(o -> o.getTopic().equals(topic)).collect(Collectors.toList());
    }

    public Question getQuestionWithId(String id) {
        return questionList.stream().filter(o -> o.getId().equals(id)).collect(Collectors.toList()).get(0);
    }
}
