package Extra;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import joandev.waterquest.R;

public class CustomArrayAdapter extends ArrayAdapter<Integer> {
    //Array adapter used for avatar generation
    private Context context;

    public CustomArrayAdapter(Context context, int resourceId, List<Integer> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView viewHolder = null;
        int item = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list, null);
            viewHolder = (ImageView) convertView.findViewById(R.id.listItemName);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ImageView) convertView.getTag();

        viewHolder.setImageResource(item);

        return convertView;
    }
}
