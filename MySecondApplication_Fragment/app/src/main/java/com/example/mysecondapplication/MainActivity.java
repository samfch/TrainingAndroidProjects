package com.example.mysecondapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager ft = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dapatkan Button
        Button gotoButton = (Button) findViewById(R.id.gotoButton);
        Button loadA = (Button) findViewById(R.id.load_a_button);
        Button loadB = (Button) findViewById(R.id.load_b_button);

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

        loadA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = ft.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder, new FragmentA());
                fragmentTransaction.commit();
            }
        });

        loadB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = ft.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentHolder, new FragmentB());
                fragmentTransaction.commit();
            }
        });

    }
}
