package joandev.waterquest.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import joandev.waterquest.R;

public class AcercameActivity extends ActionBarActivity {

    Button buttonQuiz;
    Button buttonDrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercame);

        buttonQuiz = (Button) findViewById(R.id.showQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), QuizActivity.class);
            startActivity(i);
            finish();
            }
        });
        buttonDrop = (Button) findViewById(R.id.showLostDrop);
        buttonDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), FurtivaActivity.class);
            startActivity(i);
            finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent =  null;
        switch (item.getItemId()) {
            case (R.id.action_settings) :
                intent = new Intent(getApplicationContext(), AvatarMaker.class);
                break;
            case (R.id.action_bar):
                intent = new Intent(getApplicationContext(), RanquingActivity.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
