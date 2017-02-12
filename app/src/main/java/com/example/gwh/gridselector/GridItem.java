package com.example.gwh.gridselector;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by gwh on 1/8/2017.
 * Class to hold photo for display in grid
 */

public class GridItem {

    private BitmapDrawable bitmap = null;
    private boolean isSelected = false;

    public GridItem(BitmapDrawable bitmap) {
        this.bitmap = bitmap;
    }

    public void setBitmap(BitmapDrawable bitmap) {
        this.bitmap = bitmap;
    }

    public BitmapDrawable getBitmap() {
        return bitmap;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}

