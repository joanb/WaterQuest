package joandev.waterquest.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import joandev.waterquest.R;

public class AcercameActivity extends ActionBarActivity {

    Button button;
    Timer autoUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercame);

        button = (Button) findViewById(R.id.ranking_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RanquingActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshTimer();
    }

    @Override
    public void onStop() {
        super.onResume();
        autoUpdate.cancel();
    }

    private void refreshTimer() {
        autoUpdate = new Timer();
        autoUpdate.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        Random rn = new Random();
                        int range = 2 - 1 + 1;
                        int randomNum =  rn.nextInt(range) + 1;
                        if (randomNum == 1) {
                            Intent i = new Intent(getApplicationContext(), QuizActivity.class);
                            startActivity(i);
                        } else if (randomNum == 2) {
                            Intent i = new Intent(getApplicationContext(), FurtivaActivity.class);
                            startActivity(i);
                        }
                        autoUpdate.cancel();
                    }
                });
            }
        }, 3000);
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
