package joandev.waterquest.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import joandev.waterquest.R;

public class FurtivaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furtiva);
        TextView t = (TextView)findViewById(R.id.text_description);
        t.setText("Lore pipsum dolor amet aisdaji sdjias doaish aosih " +
                "wofid oijasodiajsdo aoisjd oaijooij  oij oij oij" +
                "ij" +
                "isjd aoisjd");

        SharedPreferences sharedPreferences = getSharedPreferences("pref", 0);

        ((ImageView)findViewById(R.id.imageViewHeadFurtiva)).setImageResource(sharedPreferences.getInt("head", 0));
        ((ImageView)findViewById(R.id.imageViewBodyFurtiva)).setImageResource(sharedPreferences.getInt("body", 0));
        ((ImageView)findViewById(R.id.imageViewLegsFurtiva)).setImageResource(sharedPreferences.getInt("legs", 0));
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), AcercameActivity.class);
        startActivity(intent);
        finish();
    }
}
