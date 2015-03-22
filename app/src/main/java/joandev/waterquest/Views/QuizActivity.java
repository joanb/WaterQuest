package joandev.waterquest.Views;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import Extra.EncertFragment;
import Extra.FailedFragment;
import joandev.waterquest.R;
import java.util.Random;

import Model.Quiz;

public class QuizActivity extends ActionBarActivity implements View.OnClickListener {



    int quizIdentifier;
    Quiz quiz;
    TextView question;
    TextView scoreTV;
    Button buttonTop;
    Button buttonMiddleTop;
    Button buttonMiddleBottom;
    Button buttonBottom;
    int score;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz = new Quiz();

        sharedPreferences = getSharedPreferences("pref", 0);
        // Print dynamic avatar
        ((ImageView)findViewById(R.id.imageViewHead)).setImageResource(sharedPreferences.getInt("head", 0));
        ((ImageView)findViewById(R.id.imageViewBody)).setImageResource(sharedPreferences.getInt("body", 0));
        ((ImageView)findViewById(R.id.imageViewLegs)).setImageResource(sharedPreferences.getInt("legs", 0));

        score = sharedPreferences.getInt("drops", 0);

        Random rn = new Random();
        quizIdentifier =  rn.nextInt(quiz.getQuizs().size());
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonMiddleTop = (Button) findViewById(R.id.buttonMiddleTop);
        buttonMiddleBottom = (Button) findViewById(R.id.buttonMiddleBottom);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);
        question = (TextView) findViewById(R.id.question);
        scoreTV = (TextView) findViewById(R.id.Score);
        buttonTop.setOnClickListener(this);
        buttonMiddleTop.setOnClickListener(this);
        buttonMiddleBottom.setOnClickListener(this);
        buttonBottom.setOnClickListener(this);

        question.setText(quiz.getQuizs().get(quizIdentifier).get(0));
        buttonTop.setText(quiz.getQuizs().get(quizIdentifier).get(1));
        buttonMiddleTop.setText(quiz.getQuizs().get(quizIdentifier).get(2));
        buttonMiddleBottom.setText(quiz.getQuizs().get(quizIdentifier).get(3));
        buttonBottom.setText(quiz.getQuizs().get(quizIdentifier).get(4));
        scoreTV.setText("= "+score);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        NiftyDialogBuilder dialogBuilder=NiftyDialogBuilder.getInstance(this);
        boolean acertado = false;
        switch (v.getId()) {
            case R.id.buttonTop:
                Log.v("Button", "1");
                if (Integer.parseInt(quiz.getQuizs().get(quizIdentifier).get(5)) == 1) {
                    acertado = true;
                }
                break;
            case R.id.buttonMiddleTop:
                Log.v("Button", "2");
                if (Integer.parseInt(quiz.getQuizs().get(quizIdentifier).get(5)) == 2) {
                    acertado = true;
                }
                break;
            case R.id.buttonMiddleBottom:
                Log.v("Button", "3");

                if (Integer.parseInt(quiz.getQuizs().get(quizIdentifier).get(5)) == 3) {
                    acertado = true;
                }
                break;
            case R.id.buttonBottom:
                Log.v("Button", "4");

                if (Integer.parseInt(quiz.getQuizs().get(quizIdentifier).get(5)) == 4) {
                    acertado = true;
                }
                break;
        }
        if (acertado){
            v.setBackgroundColor(Color.GREEN);
            Log.v("SCORE+1", "SCORE+1");
            score += 1;
            scoreTV.setText("= "+score);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("drops", score);
            editor.commit();

            dialogBuilder
                    .withTitle("Pregunta encertada!")

                    .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                    .withDialogColor("#ff2a7180")
                    .withMessage(getResources().getString(R.string.pregunta_encertada))
                    .withButton1Text("Continuar")
                    .withDuration(300)                                          //def//def gone//def gone
                    .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), AcercameActivity.class);
                            startActivity(intent);                        }
                    })
                    .show();

        }
        else {
            dialogBuilder
                    .withTitle("Pregunta fallada!")

                    .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                    .withDialogColor("#FFE74C3C")
                    .withMessage(getResources().getString(R.string.pregunta_fallada))
                    .withButton1Text("Continuar")
                    .withDuration(300)                                          //def//def gone
                    .isCancelableOnTouchOutside(false)                           //def    | isCancelable(true)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getApplicationContext(), AcercameActivity.class);
                            startActivity(intent);                        }
                    })
                    .show();
            v.setBackgroundColor(Color.RED);
//            DialogFragment fallada = new FailedFragment();
//            fallada.show(getFragmentManager(), "");
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), AcercameActivity.class);
        startActivity(intent);
        finish();
    }
}
