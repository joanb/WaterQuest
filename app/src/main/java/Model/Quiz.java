package Model;

import java.util.ArrayList;

/**
 * Created by joanbarroso on 21/3/15.
 */
public class Quiz {


    private final String QuizQuestion1 = "q1";
    private final String Quiz1Response1 = "r1";
    private final String Quiz1Response2 = "r2";
    private final String Quiz1Response3 = "r3";
    private final String Quiz1Response4 = "r4";

    private final String QuizQuestion2 = "q2";
    private final String Quiz2Response1 = "r1";
    private final String Quiz2Response2 = "r2";
    private final String Quiz2Response3 = "r3";
    private final String Quiz2Response4 = "r4";

    private final String QuizQuestion3 = "q1";
    private final String Quiz3Response1 = "r1";
    private final String Quiz3Response2 = "r2";
    private final String Quiz3Response3 = "r3";
    private final String Quiz3Response4 = "r4";


    private ArrayList<ArrayList<String>> quizs;

    public Quiz() {
        ArrayList<String> quiz1 = new ArrayList<>();
        quiz1.add(QuizQuestion1);
        quiz1.add(Quiz1Response1);
        quiz1.add(Quiz1Response2);
        quiz1.add(Quiz1Response3);
        quiz1.add(Quiz1Response4);

        ArrayList<String> quiz2 = new ArrayList<>();
        quiz2.add(QuizQuestion2);
        quiz2.add(Quiz2Response1);
        quiz2.add(Quiz2Response2);
        quiz2.add(Quiz2Response3);
        quiz2.add(Quiz2Response4);

        ArrayList<String> quiz3 = new ArrayList<>();
        quiz3.add(QuizQuestion3);
        quiz3.add(Quiz3Response1);
        quiz3.add(Quiz3Response2);
        quiz3.add(Quiz3Response3);
        quiz3.add(Quiz3Response4);
        quizs = new ArrayList<ArrayList<String>>();
        quizs.add(quiz1);
        quizs.add(quiz2);
        quizs.add(quiz3);
    }

    public ArrayList<ArrayList<String>> getQuizs() {
        return quizs;
    }


}
