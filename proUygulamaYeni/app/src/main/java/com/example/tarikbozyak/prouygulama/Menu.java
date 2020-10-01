package com.example.tarikbozyak.prouygulama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String userNAme = helper.searchUser();

        TextView kullaniciGiris=(TextView)findViewById(R.id.kullaniciGiris);
        kullaniciGiris.setText(userNAme +"");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivities(new Intent[]{intent});

            }
        });
    }

    public void Tiklendi1(View v) {

        if (v.getId() == R.id.button4) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), Ucak.class);
            startActivity(i1);


        }
        if (v.getId() == R.id.button5) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), OtelDetay.class);
            startActivity(i1);


        }
        if (v.getId() == R.id.button6) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), AracBir.class);
            startActivity(i1);


        }
        if (v.getId() == R.id.button7) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), Sepet.class);
            startActivity(i1);
        }


    }
}