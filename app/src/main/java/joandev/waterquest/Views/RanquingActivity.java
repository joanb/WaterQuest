package joandev.waterquest.Views;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.List;

import Extra.RankingAdapter;
import Model.RankingModel;
import joandev.waterquest.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.view.MenuItem;


public class RanquingActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<RankingModel> list = getModel();
        RankingAdapter adapter = new RankingAdapter(this, list);
        setListAdapter(adapter);
    }

    private List<RankingModel> getModel() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", 0);
        String name = pref.getString("name", "Name");
        int drops = pref.getInt("drops", 0);


        // Hardcoded users but ordered by drops
        List<RankingModel> list = new ArrayList<RankingModel>();
        list.add(get("Mark", 21));
        list.add(get("Jeff", 32));
        list.add(get("Bill", 14));
        list.add(get("Gates", 10));
        list.add(get("Frank", 11));
        list.add(get("Kim", 2));
        list.add(get(name, drops));

        Collections.sort(list, new Comparator<RankingModel>() {
            @Override
            public int compare(RankingModel r1, RankingModel r2) {
                return r2.getDrops() - r1.getDrops();
            }
        });
        return list;
    }

    private RankingModel get(String n,  int d) {
        return new RankingModel(n, d);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), AvatarMaker.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
