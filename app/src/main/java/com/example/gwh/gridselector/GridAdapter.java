package com.example.gwh.gridselector;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by gwh on 1/8/2017.
 *
 */

public class GridAdapter extends ArrayAdapter<GridItem> {

    private final static String TAG = "Adapter: ";
    private final int PADDING = 16;

    public GridAdapter(Context context, int resource, List<GridItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        RelativeLayout itemLayout;

        // use existing Views when we can
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemLayout = (RelativeLayout) inflater.inflate(R.layout.grid_item, null);
        } else {
            itemLayout = (RelativeLayout) convertView;
        }

        GridItem gridItem = getItem(position);
        if(gridItem != null) {
            // get your bitmap or list item etc. here
            BitmapDrawable bitmap = gridItem.getBitmap();
            ImageView imageView = (ImageView) itemLayout.findViewById(R.id.image_view);
            imageView.setBackground(bitmap);

            FrameLayout frame = (FrameLayout)itemLayout.findViewById(R.id.image_frame);
            ImageView checkBox = (ImageView)itemLayout.findViewById(R.id.custom_check_box);

            // If this item is selected, increase the padding which will decrease the size
            //      of the image to show the color of the background.  Also, set the drawable
            //      to show the check inside the checkbox
            if (gridItem.isSelected()) {
                Log.d(TAG, "position " + position + " is selected");
                frame.setPadding(PADDING, PADDING, PADDING, PADDING);
                checkBox.setBackgroundResource(R.drawable.custom_check_box_selected);
            } else {
                Log.d(TAG, "position " + position + " is NOT selected");
                frame.setPadding(0, 0, 0, 0);
                checkBox.setBackgroundResource(R.drawable.custom_check_box_unselected);
            }
        }
        return itemLayout;
    }
}
