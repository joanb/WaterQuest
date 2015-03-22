package joandev.waterquest.Views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Extra.CustomArrayAdapter;
import Extra.ListViewContext;
import Extra.OnSwipeTouchListener;
import joandev.waterquest.R;


public class AvatarMaker extends ActionBarActivity {

    private ListViewContext listViewContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

        SharedPreferences preferences = getSharedPreferences("pref", this.MODE_PRIVATE);
        String name = preferences.getString("name", null);
        if (name != null) {
            ((EditText)findViewById(R.id.textLabel)).setText(name);
        }

        listViewContext = new ListViewContext();

        //Mount dynamic avatar
        int head = preferences.getInt("head", R.drawable.head_0);
        int body = preferences.getInt("body", R.drawable.body_0);
        int legs = preferences.getInt("legs", R.drawable.legs_0);
        listViewContext.changeItemAtResource(0, head);
        listViewContext.changeItemAtResource(1, body);
        listViewContext.changeItemAtResource(2, legs);

        ListView swipeListView = (ListView)findViewById(R.id.swipeList);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, R.layout.item_list, listViewContext.getListItems());
        swipeListView.setAdapter(adapter);

        swipeListView.setOnTouchListener(new OnSwipeTouchListener(this, swipeListView, adapter, listViewContext) {
            @Override
            public void onSwipeLeft() {
                ListViewContext lvc = this.getListViewContext();
                // Swipe diferent avatar parts
                if(getItemPosition() == 0)
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getHeadPosition() - 1 < 0 ? 2 : lvc.getHeadPosition() -1));
                else if(getItemPosition() == 1)
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getBodyPosition() - 1 < 0 ? 2 : lvc.getBodyPosition() -1));
                else
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getLegsPosition() - 1 < 0 ? 2 : lvc.getLegsPosition() -1));
            }

            @Override
            public void onSwipeRight() {
                ListViewContext lvc = this.getListViewContext();
                // Swipe diferent avatar parts
                if(getItemPosition() == 0)
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getHeadPosition() + 1 > 2 ? 0 : lvc.getHeadPosition() +1));
                else if(getItemPosition() == 1)
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getBodyPosition() + 1 > 2 ? 0 : lvc.getBodyPosition() +1));
                else
                    lvc.changeItemAtPosition(this.getItemPosition(), (lvc.getLegsPosition() + 1 > 2 ? 0 : lvc.getLegsPosition() +1));

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

    public void clickOnButton(View v) {
        SharedPreferences preferences = getSharedPreferences("pref", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", ((EditText) findViewById(R.id.textLabel)).getText().toString());
        ArrayList<Integer> partsOfAvatar = (ArrayList) listViewContext.getListItems();
        editor.putInt("head", partsOfAvatar.get(0));
        editor.putInt("body", partsOfAvatar.get(1));
        editor.putInt("legs", partsOfAvatar.get(2));
        editor.commit();

        Intent intent = new Intent(this, AcercameActivity.class);
        startActivity(intent);

        finish();
    }
}
