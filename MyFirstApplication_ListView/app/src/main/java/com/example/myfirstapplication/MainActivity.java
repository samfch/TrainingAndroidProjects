package com.example.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // buat listview menjadi variable osListView
        ListView osListView = (ListView) findViewById(R.id.listView);

        // data deskripsi OS
        String description[] = {
                "Windows adalah OS buatan Microsoft. Pertama kali diluncurkan tahun 1985",
                "MacOS adalah OS buatan Apple.inc. Diluncurkan pada tahun 1984 satu tahun sebelum Windows",
                "Android adalah OS buatan Andy Rubin yang diakuisisi Google.inc"};

        // data gambar OS
        Integer image_id[] = {R.drawable.windows, R.drawable.macos, R.drawable.android};

        CustomOSAdapter androidListAdapter = new CustomOSAdapter(this, image_id, description);

        osListView.setAdapter(androidListAdapter);
    }
}
