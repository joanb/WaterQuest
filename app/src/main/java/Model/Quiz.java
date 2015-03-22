package Model;

import java.util.ArrayList;

/**
 * Created by joanbarroso on 21/3/15.
 */
public class Quiz {

    //Hardcoded questions for prototyping
    private final String QuizQuestion1 = "Perquè es pot utilitzar l'aigua depurada? ";
    private final String Quiz1Response1 = "Per netejar els carrers";
    private final String Quiz1Response2 = "Per donar de beure a un gos";
    private final String Quiz1Response3 = "Per beure";
    private final String Quiz1Response4 = "Per omplir una peixera amb peixos d'aigua dolça";
    private final int correct = 1;

    private final String QuizQuestion2 = "Hi ha fàbriques que fan aigua?";
    private final String Quiz2Response1 = "Si";
    private final String Quiz2Response2 = "No";
    private final String Quiz2Response3 = "Hi ha fàbriques que l'extreuan";
    private final String Quiz2Response4 = "Es imposible";
    private final int correct2 = 3;

    private final String QuizQuestion3 = "Tot l'aigua del planeta es pot beure?";
    private final String Quiz3Response1 = "Tota es pot beure";
    private final String Quiz3Response2 = "Sols l'aigua salada";
    private final String Quiz3Response3 = "Sols l'aigua dolça";
    private final String Quiz3Response4 = "Sols l'aigua depurada";
    private final int correct3 = 3;

    private final String QuizQuestion4 = "Quants dies podem aguantar sense aigua?";
    private final String Quiz4Response1 = "3";
    private final String Quiz4Response2 = "10";
    private final String Quiz4Response3 = "5";
    private final String Quiz4Response4 = "20";
    private final int correct4 = 1;

    private final String QuizQuestion5 = "Un cop l'aigua arriba a mar obert, quin és el següent pas en el seu cicle";
    private final String Quiz5Response1 = "Condensació";
    private final String Quiz5Response2 = "Evaporització";
    private final String Quiz5Response3 = "Filtració";
    private final String Quiz5Response4 = "S'acaba el cicle";
    private final int correct5 = 2;


    private ArrayList<ArrayList<String>> quizs;

    public Quiz() {
        quizs = new ArrayList<ArrayList<String>>();

        ArrayList<String> quiz1 = new ArrayList<>();
        quiz1.add(QuizQuestion1);
        quiz1.add(Quiz1Response1);
        quiz1.add(Quiz1Response2);
        quiz1.add(Quiz1Response3);
        quiz1.add(Quiz1Response4);
        quiz1.add(""+correct);
        quizs.add(quiz1);


        ArrayList<String> quiz2 = new ArrayList<>();
        quiz2.add(QuizQuestion2);
        quiz2.add(Quiz2Response1);
        quiz2.add(Quiz2Response2);
        quiz2.add(Quiz2Response3);
        quiz2.add(Quiz2Response4);
        quiz2.add(""+correct2);
        quizs.add(quiz2);

        ArrayList<String> quiz3 = new ArrayList<>();
        quiz3.add(QuizQuestion3);
        quiz3.add(Quiz3Response1);
        quiz3.add(Quiz3Response2);
        quiz3.add(Quiz3Response3);
        quiz3.add(Quiz3Response4);
        quiz3.add(""+correct3);
        quizs.add(quiz3);

        ArrayList<String> quiz4 = new ArrayList<>();
        quiz4.add(QuizQuestion4);
        quiz4.add(Quiz4Response1);
        quiz4.add(Quiz4Response2);
        quiz4.add(Quiz4Response3);
        quiz4.add(Quiz4Response4);
        quiz4.add(""+correct4);
        quizs.add(quiz4);

        ArrayList<String> quiz5 = new ArrayList<>();
        quiz5.add(QuizQuestion5);
        quiz5.add(Quiz5Response1);
        quiz5.add(Quiz5Response2);
        quiz5.add(Quiz5Response3);
        quiz5.add(Quiz5Response4);
        quiz5.add(""+correct5);
        quizs.add(quiz5);
    }

    public ArrayList<ArrayList<String>> getQuizs() {
        return quizs;
    }


}
