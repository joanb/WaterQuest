package joandev.waterquest.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import joandev.waterquest.R;

public class AcercameActivity extends Activity {

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


}
