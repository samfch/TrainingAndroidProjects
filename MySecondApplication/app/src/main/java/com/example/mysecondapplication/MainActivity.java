package com.example.mysecondapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager ft = getSupportFragmentManager();
    ImageView androidImg;

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


        // tambahkan pada fungsi onCreate
        androidImg = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(androidImg);

        androidImg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // buat instance popup menu
                PopupMenu popup = new PopupMenu(getApplicationContext(),androidImg);

                // buat menu dari xml
                popup.getMenuInflater().inflate(R.menu.popup_menu,popup.getMenu());

                // buat action untuk menu item
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item1:
                                Toast.makeText(getApplicationContext(),"Popup 1 Selected", Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.item2:
                                Toast.makeText(getApplicationContext(),"Popup 2 Selected",Toast.LENGTH_LONG).show();
                                return true;
                            case R.id.item3:
                                Toast.makeText(getApplicationContext(),"Popup 3 Selected",Toast.LENGTH_LONG).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                // tampilkan popup menu
                popup.show();

            }
        });


    }

    // fungsi untuk menambahkan menu pada activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // fungsi untuk memberikan action pada menu klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // untuk menambahkan context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select Menu");
    }

    // action pada context menu item
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Context menu 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Context menu 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Context menu 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
}
