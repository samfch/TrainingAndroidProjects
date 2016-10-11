package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by samfch on 9/10/16.
 */
public class CustomOSAdapter extends ArrayAdapter {
    String[] androidListViewStrings;
    Integer[] imagesId;
    Context context;

    public CustomOSAdapter(Activity context, Integer[] imagesId, String[] textListView) {
        super(context, R.layout.custom_list_item, textListView);
        this.androidListViewStrings = textListView;
        this.imagesId = imagesId;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_item, null,
                true);
        TextView mtextView = (TextView) viewRow.findViewById(R.id.os_description);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.os_image);
        mtextView.setText(androidListViewStrings[i]);
        mimageView.setImageResource(imagesId[i]);
        return viewRow;
    }
}
