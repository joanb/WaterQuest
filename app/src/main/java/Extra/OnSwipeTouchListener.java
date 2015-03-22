package Extra;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import joandev.waterquest.R;

/**
 * Created by jcampos on 21/03/2015.
 */
public class OnSwipeTouchListener implements OnTouchListener {

    private final GestureDetector gestureDetector;
    private final ListView listView;
    private final ArrayAdapter arrayAdapter;
    private int itemPosition;
    private ListViewContext listViewContext;

    public OnSwipeTouchListener(Context context, ListView listView, ArrayAdapter arrayAdapter, ListViewContext listViewContext) {
        gestureDetector = new GestureDetector(context, new GestureListener());
        this.listView = listView;
        this.arrayAdapter = arrayAdapter;
        this.listViewContext = listViewContext;
    }

    public void onSwipeLeft() {
    }

    public void onSwipeRight() {
    }

    public int getItemPosition() {
        return itemPosition;
    }

    public ListViewContext getListViewContext() {
        return listViewContext;
    }

    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float distanceX = e2.getX() - e1.getX();
            float distanceY = e2.getY() - e1.getY();

            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                itemPosition = listView.pointToPosition((int) e1.getX(), (int) e1.getY());
                if (distanceX > 0)
                    onSwipeRight();
                else
                    onSwipeLeft();
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
            return false;
        }
    }
}
