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

public class AracBir extends AppCompatActivity {

    //Aşağıda belirtilen değiştenlerin hepsi tarih kontrolü yapmak için oluşturulmuştur.
    int girisTarihi;
    int cikisTarihi;
    int gun,buGün,buAy,girAy,cikAy,ay,toplamGun,gunKontrol,AyKontrol,toplamGunKontrol;
    int yil1,yil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //AracBir sayfasındaki fab iconu bu aşağıda kullanılmıştır.

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AracBir.this, Menu.class);
                startActivities(new Intent[]{intent});
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Edit Text tanımlamaları yapıldı.

        SimpleDateFormat dfDate_day = new SimpleDateFormat("dd.MM.yyyy");

        final Spinner txtTeslimAlmaYeri=(Spinner)findViewById(R.id.spinnerTeslimAlma);
        final Spinner txtTeslimEtmeYeri=(Spinner)findViewById(R.id.spinnerTeslimEtme);
        final EditText txtTeslimAlmaTarih=(EditText)findViewById(R.id.AraceditText3);
        final EditText txtTeslimEtmeTarih=(EditText)findViewById(R.id.AraceditTextGidisTarihi);
        final Spinner txtAracMarka=(Spinner)findViewById(R.id.spinnerAracMarka);
        final Spinner txtAracSegment=(Spinner)findViewById(R.id.spinnerAracSegment);

        //Bu kısımdaki kodlar bugünün tarihini tespit ediyor.
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 0);
        final String dt = dfDate_day.format(c.getTime());
        txtTeslimAlmaTarih.setText(dt);//Tespit edilen tarih değişkene atanıyor.

        //Bu kısımda 1 hafta sonrasının tarihini tespit etmek için kullanılıyor.
        c.add(Calendar.DATE, 7);
        final String co = dfDate_day.format(c.getTime());
        txtTeslimEtmeTarih.setText(co);//Tespit edilen tarih değişkene atanıyor.



        Button btnKaydet=(Button)findViewById(R.id.AracbuttonArama);
        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Butona tıklandığında çalışacak kod bloğu bu kısımda yer alıyor.
                DegerTut.AracAlma=txtTeslimAlmaYeri.getSelectedItem().toString();
                DegerTut.AracTeslim=txtTeslimEtmeYeri.getSelectedItem().toString();
                DegerTut.AlimTarih=txtTeslimAlmaTarih.getText().toString();
                DegerTut.TeslimTarih = txtTeslimEtmeTarih.getText().toString();
                DegerTut.AracMarka=txtAracMarka.getSelectedItem().toString();
                DegerTut.AracSegment=txtAracSegment.getSelectedItem().toString();

                yil1= Integer.parseInt((txtTeslimAlmaTarih.getText().toString().substring(6, 10)).toString());
                yil2=Integer.parseInt((txtTeslimEtmeTarih.getText().toString().substring(6, 10)).toString());

                //Bu kısımda teslim alma tarihi ve teslim etme tarihi arasındaki gün farkı ve ay farkı tespit ediliyor.
                girisTarihi= Integer.parseInt((txtTeslimAlmaTarih.getText().toString().substring(0, 2)).toString());
                cikisTarihi= Integer.parseInt((txtTeslimEtmeTarih.getText().toString().substring(0, 2)));
                buGün=Integer.parseInt(dt.substring(0,2).toString());
                //22.10.2015
                gun=cikisTarihi-girisTarihi;

                girAy= Integer.parseInt((txtTeslimAlmaTarih.getText().toString().substring(3, 5)).toString());
                cikAy= Integer.parseInt((txtTeslimEtmeTarih.getText().toString().substring(3, 5)));
                buAy=Integer.parseInt(dt.substring(3,5).toString());
                ay=(cikAy-girAy)*30;

                toplamGun=gun+ay;

                gunKontrol=girisTarihi-buGün;
                AyKontrol=(buAy-girAy)*30;
                toplamGunKontrol=gunKontrol+AyKontrol;

                DegerTut.AracToplamGun=Integer.toString(toplamGun);

                if(toplamGun<0||toplamGunKontrol<0){
                    Toast.makeText(AracBir.this, "Teslim Alma ve Etme Tarihlerini kontrol ediniz.", Toast.LENGTH_SHORT).show();

                }
                else if(toplamGun==0){

                    Toast.makeText(AracBir.this, "Minimum 1 gün için araç kiralayabilirsiniz.", Toast.LENGTH_SHORT).show();
                }

                else if(yil1!=2016 || yil2!=2016){

                    Toast.makeText(AracBir.this, "Sadece 2016 yılı için işlem yapabilirsiniz.", Toast.LENGTH_SHORT).show();

                }



                else {
                    Intent i1 = new Intent(getApplicationContext(), AracSorgula.class);
                    startActivity(i1);


                }




            }
        });
    }

}
