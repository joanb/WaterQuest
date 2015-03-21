package joandev.waterquest.Views;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import joandev.waterquest.R;

public class RankingAdapter extends ArrayAdapter<RankingModel> {
    private final Context context;
    private final List<RankingModel> values;

    public RankingAdapter(Context context, List<RankingModel> values) {
        super(context, R.layout.ranking_row, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    public static class ViewHolder {
        public TextView n;
        public TextView d;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = null;

        if (convertView != null) {
            rowView = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.ranking_row, parent, false);

            TextView name = (TextView) rowView.findViewById(R.id.rankingName);
            TextView dnumber = (TextView) rowView.findViewById(R.id.dropNumber);
            ViewHolder holder = new ViewHolder();
            holder.n = name;
            holder.d = dnumber;
            rowView.setTag(holder);

        }
        ViewHolder tag = (ViewHolder) rowView.getTag();

        tag.n.setText(values.get(position).getName());
        tag.d.setText(String.valueOf(values.get(position).getDrops()));
        return rowView;
    }
}