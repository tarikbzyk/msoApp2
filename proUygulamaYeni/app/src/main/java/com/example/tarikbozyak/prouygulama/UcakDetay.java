package com.example.tarikbozyak.prouygulama;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UcakDetay extends AppCompatActivity {

    private String[] ulkeler =
            {"Türkiye", "Almanya", "Avusturya", "Amerika", "İngiltere",
                    "Macaristan", "Yunanistan", "Rusya", "Suriye", "İran", "Irak",
                    "Şili", "Brezilya", "Japonya", "Portekiz", "İspanya",
                    "Makedonya", "Ukrayna", "İsviçre"};


    private String[] saat =
            {"06:00","08:00", "11:15", "15:40", "19:00", "21:45", "23:00"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucak_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UcakDetay.this, Sepet.class);
                startActivities(new Intent[]{intent});
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //(A) adımı
        final ListView listemiz = (ListView) findViewById(R.id.listView1);


        //(B) adımı
        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, saat);

        //(C) adımı
        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String UcusBilgileri;

                        UcusBilgileri = "Yön: " + DegerTut.YonTuru + " \n";
                        UcusBilgileri = UcusBilgileri + "Nereden: " + DegerTut.Nerden + " \n";
                        UcusBilgileri = UcusBilgileri + "Nereye: " + DegerTut.Nereye + " \n";
                        UcusBilgileri = UcusBilgileri + "Gidiş Tarihi: " + DegerTut.Gidis + " \n";
                        if (DegerTut.Donus.equals("")) {
                        } else
                            UcusBilgileri = UcusBilgileri + "Dönüş Tarihi: " + DegerTut.Donus + " \n";
                        UcusBilgileri = UcusBilgileri + "Saat: " + listemiz.getItemAtPosition(position).toString();
                        DegerTut.Saat = listemiz.getItemAtPosition(position).toString();

                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                UcakDetay.this);
                        alertDialogBuilder.setTitle("Uçuş Bilgileri");
                        alertDialogBuilder
                                .setMessage(UcusBilgileri)
                                .setCancelable(false)
                                .setPositiveButton("Sepete Ekle", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Toast.makeText(UcakDetay.this, "Uçak Rezervasyonunuz Sepete Eklenmiştir.", Toast.LENGTH_SHORT).show();
                                    }
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                });


    }

}
