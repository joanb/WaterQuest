package joandev.waterquest.Views;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Extra.CustomArrayAdapter;
import Extra.OnSwipeTouchListener;
import joandev.waterquest.R;


public class AvatarMaker extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

        ArrayList<Integer> listItems = new ArrayList<Integer>();
        listItems.add(R.drawable.abc_btn_radio_material);
        //listItems.add("Item 2");
        //listItems.add("Item 3");

        ListView swipeListView = (ListView)findViewById(R.id.swipeList);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.item_list, listItems);
        swipeListView.setAdapter(adapter);

        swipeListView.setOnTouchListener(new OnSwipeTouchListener(this, swipeListView, adapter) {
            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                Toast.makeText(AvatarMaker.this, "Left Swipe. Position " + this.getItemPosition(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Toast.makeText(AvatarMaker.this, "Right Swipe. Position " + this.getItemPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
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


}
