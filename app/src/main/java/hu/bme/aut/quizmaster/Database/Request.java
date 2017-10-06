package hu.bme.aut.quizmaster.Database;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Request {

    private static volatile Request instance = null;
    private static List<Question> questionList = null;
    private static final String TAG = "Request.class";

    private Request() {
        initSugarOrmWithQuestionsFromTxt();
        loadQuestionsToList();
    }

    private void loadQuestionsToList() {
        questionList.clear();
        questionList = Question.listAll(Question.class);
        if (questionList == null) {
            throw new NullPointerException("Failed to initialize questions!");
        }
    }

    private void initSugarOrmWithQuestionsFromTxt() {

        // TODO: SZAR AZ EGESZ
        try (BufferedReader br = new BufferedReader(new FileReader("raw/quizmaster.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                new Question(parts[0], parts[1], parts[2], parts[3], parts[4], getTopicByString(parts[5])).save();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }

//        try {
//            InputStream inputStream = context.openFileInput("quizmaster_db.txt");
//
//            if (inputStream != null) {
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String line = "";
//
//                while ((line = bufferedReader.readLine()) != null) {
//                    String[] parts = line.split(";");
//                    new Question(parts[0], parts[1], parts[2], parts[3], parts[4], getTopicByString(parts[5])).save();
//                }
//
//                inputStream.close();
//            }
//        } catch (FileNotFoundException e) {
//            Log.e(TAG, "File not found: " + e.toString());
//        } catch (IOException e) {
//            Log.e(TAG, "Can not read file: " + e.toString());
//        }
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

    public static Request getInstance() {
        if (instance == null) {
            instance = new Request();
        }
        return instance;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public Question getQuestionWithId(String id) {
        return questionList.stream().filter(o -> o.getId().equals(id)).map(o -> o).collect(Collectors.toList()).get(0);
    }
}
