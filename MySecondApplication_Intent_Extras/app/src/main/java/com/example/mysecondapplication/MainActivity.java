package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dapatkan Button
        Button gotoButton = (Button) findViewById(R.id.button);

        // berikan action Click pada button
        gotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // buat intent dari MainActivity ke SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // tambahkan extras data
                intent.putExtra("nama", "John Doe");
                intent.putExtra("nim", 1234567890);
                intent.putExtra("alamat", "Jalan Android no 50");

                startActivity(intent);
            }
        });


    }
}
