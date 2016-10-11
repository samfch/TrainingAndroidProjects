package com.example.mysecondapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // textview untuk menampung data
        TextView namaTV = (TextView) findViewById(R.id.namaTextView);
        TextView nimTV = (TextView) findViewById(R.id.nimTextView);
        TextView alamatTV = (TextView) findViewById(R.id.alamatTextView);

        // variable untuk menampung data intent
        String nama = getIntent().getStringExtra("nama");
        int nim = getIntent().getIntExtra("nim", 0);
        String alamat = getIntent().getStringExtra("alamat");

        // set data intent ke TextView
        namaTV.setText(nama);
        nimTV.setText(String.valueOf(nim));
        alamatTV.setText(alamat);
    }
}
