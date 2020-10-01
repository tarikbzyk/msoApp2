package com.example.tarikbozyak.prouygulama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OtelDetay extends AppCompatActivity {

    int girisTarihi;
    int cikisTarihi;
    int gun,buGün,buAy,girAy,cikAy,ay,toplamGun,gunKontrol,AyKontrol,toplamGunKontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtelDetay.this, Menu.class);
                startActivities(new Intent[]{intent});
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






        final Spinner OtelKonum=(Spinner)findViewById(R.id.spinnerSeyahatNoktası);
        final EditText ChekcIn=(EditText)findViewById(R.id.editTextCheckInTarihi);
        final EditText CheckOut=(EditText)findViewById(R.id.editTextCheckOutTarihi) ;
        final Spinner KisiSayisi=(Spinner)findViewById(R.id.spinnerKisi);

        SimpleDateFormat dfDate_day = new SimpleDateFormat("dd.MM.yyyy");


        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 0);
        final String dt = dfDate_day.format(c.getTime());
        ChekcIn.setText(dt);


        c.add(Calendar.DATE, 7);
        final String co = dfDate_day.format(c.getTime());
        CheckOut.setText(co);



        Button buttonOtelKayit=(Button)findViewById(R.id.buttonOtelAra);
        buttonOtelKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DegerTut.OtelKonum=OtelKonum.getSelectedItem().toString();
                DegerTut.Checkin=ChekcIn.getText().toString();
                DegerTut.CheckOut=CheckOut.getText().toString();
                DegerTut.KisiSayisi=(KisiSayisi.getSelectedItem().toString().substring(0,1));

                girisTarihi= Integer.parseInt((ChekcIn.getText().toString().substring(0, 2)).toString());
                cikisTarihi= Integer.parseInt((CheckOut.getText().toString().substring(0, 2)));
                buGün=Integer.parseInt(dt.substring(0,2).toString());
                //22.10.2015
                gun=cikisTarihi-girisTarihi;

                girAy= Integer.parseInt((ChekcIn.getText().toString().substring(3, 5)).toString());
                cikAy= Integer.parseInt((CheckOut.getText().toString().substring(3, 5)));
                buAy=Integer.parseInt(dt.substring(3,5).toString());
                ay=(cikAy-girAy)*30;

                toplamGun=gun+ay;

                gunKontrol=girisTarihi-buGün;
                AyKontrol=(buAy-girAy)*30;
                toplamGunKontrol=gunKontrol+AyKontrol;

                DegerTut.ToplamGun=Integer.toString(toplamGun);
                //String testString = Integer.toString(toplamGun);


                if(toplamGun<0||toplamGunKontrol<0){
                    Toast.makeText(OtelDetay.this, "Check In ve Check Out Tarihlerini kontrol ediniz.", Toast.LENGTH_SHORT).show();

                }


                else {

                    Intent i1 = new Intent(getApplicationContext(), OtelListe.class);
                    startActivity(i1);
                }
            }
        });
    }

}
