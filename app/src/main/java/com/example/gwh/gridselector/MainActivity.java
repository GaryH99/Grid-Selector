package com.example.gwh.gridselector;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Main: ";
    private GridAdapter mAdapter = null;
    private List<GridItem> mList = null;

    private final static int[] imageArray = {R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7, R.drawable.sample_8, R.drawable.sample_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mList = new ArrayList<>();

        for (int  imageId : imageArray) {
            try {
                BitmapDrawable drawable = (BitmapDrawable) ResourcesCompat.getDrawable(getResources(), imageId, null);
                GridItem item = new GridItem(drawable);
                mList.add(item);
            } catch (Resources.NotFoundException e) {
                Log.e(TAG, "resource " + imageId + " not found");
            }
        }

        mAdapter = new GridAdapter(getApplicationContext(), R.layout.grid_item, mList);
        GridView gridView = (GridView)findViewById(R.id.grid_view);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "item clicked = " + i);
                boolean isSelected = mList.get(i).isSelected();
                mList.get(i).setSelected(!isSelected);

                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
