package Extra;

import java.util.ArrayList;
import java.util.List;

import joandev.waterquest.R;

/**
 * Created by jcampos on 22/03/2015.
 */
public class ListViewContext {

    private int[] headImages, bodyImages, legsImages;
    private int headPosition, bodyPosition, legsPosition;
    private ArrayList<Integer> listItems = new ArrayList<>();

    public ListViewContext() {
        headImages = new int[]{R.drawable.head_0, R.drawable.head_1, R.drawable.head_2};
        bodyImages = new int[]{R.drawable.body_0, R.drawable.body_1, R.drawable.body_2};
        legsImages = new int[]{R.drawable.legs_0, R.drawable.legs_1, R.drawable.legs_2};
        headPosition = 0;
        bodyPosition = 0;
        legsPosition = 0;

        listItems.add(headImages[headPosition]);
        listItems.add(bodyImages[bodyPosition]);
        listItems.add(legsImages[legsPosition]);
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public int getBodyPosition() {
        return bodyPosition;
    }

    public int getLegsPosition() {
        return legsPosition;
    }

    public List<Integer> getListItems() {
        return listItems;
    }

    public void setHeadPosition(int headPosition) {
        this.headPosition = headPosition;
    }

    public void setBodyPosition(int bodyPosition) {
        this.bodyPosition = bodyPosition;
    }

    public void setLegsPosition(int legsPosition) {
        this.legsPosition = legsPosition;
    }

    public void changeItemAtPosition(int fragment, int position) {
        switch (fragment) {
            case 0:
                listItems.set(fragment, headImages[position]);
                headPosition = position;
                break;
            case 1:
                listItems.set(fragment, bodyImages[position]);
                bodyPosition = position;
                break;
            case 2:
                listItems.set(fragment, legsImages[position]);
                legsPosition = position;
        }
    }

}
