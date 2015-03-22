package joandev.waterquest.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import joandev.waterquest.R;

public class FurtivaActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furtiva);


        TextView t = (TextView)findViewById(R.id.text_description);
        ImageView i = (ImageView)findViewById(R.id.furtiva);

        Random rn = new Random();
        int id =  rn.nextInt(4);

        switch (id) {
            case 0:
                i.setImageResource(R.drawable.rojo);
                t.setText("M'has trobat, ara dóna'm una abraçada!!!!!");
                break;
            case 1:
                i.setImageResource(R.drawable.via);
                t.setText("No facis més preguntes, segueixme en l'aventura de l'aigua! :)");
                break;
            case 2:
                i.setImageResource(R.drawable.feliz);
                t.setText("Sóc molt feliç quan completo el meu cicle de l'aigua, i tu? ");
                break;
            case 3:
                i.setImageResource(R.drawable.sol);
                t.setText("Podria ser més gran si m'estalviessis més :(, ho farás veritat?");
                break;
        }

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
