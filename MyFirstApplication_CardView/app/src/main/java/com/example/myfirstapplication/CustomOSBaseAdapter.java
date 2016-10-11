package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by samfch on 9/11/16.
 */
public class CustomOSBaseAdapter extends BaseAdapter {
    String[] androidListViewStrings;
    Integer[] imagesId;
    Context context;

    public CustomOSBaseAdapter(Activity context, Integer[] imagesId, String[] textListView) {
        this.androidListViewStrings = textListView;
        this.imagesId = imagesId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagesId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

//        View viewRow = layoutInflater.inflate(R.layout.custom_list_item, null, true);
        View viewRow = layoutInflater.inflate(R.layout.cardview_item, null, true);

        TextView mtextView = (TextView) viewRow.findViewById(R.id.os_description);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.os_image);
        mtextView.setText(androidListViewStrings[i]);
        mimageView.setImageResource(imagesId[i]);
        return viewRow;
    }
}
