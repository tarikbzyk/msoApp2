package com.example.tarikbozyak.prouygulama;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AracSorgula extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_sorgula);

        int gunFiyat;
        int al;
        int ver;
        int gun;
        int alAy;
        int verAy;
        int ay;
        int toplamGun,toplamFiyat;


        Button BtnSepeteEkle = (Button)findViewById(R.id.button21);

        final TextView txtAracTeslimYeri=(TextView)findViewById(R.id.txtAracTeslimYeri1);
        final TextView txtAracTeslimEtme=(TextView)findViewById(R.id.txtAracTeslimEtme1);
        final TextView txtTeslimAlmaTr=(TextView)findViewById(R.id.txtTeslimAlmaTr1) ;
        final TextView txtTeslimEtmeTr=(TextView)findViewById(R.id.txtTeslimEtmeTr1);
        final TextView txtAracMarka1=(TextView)findViewById(R.id.txtAracMarka1);
        final TextView txtAracSegment1=(TextView)findViewById(R.id.txtAracSegment1);
        final TextView txtAracFiyat = (TextView)findViewById(R.id.txtAracFiyat1);
        final TextView txtAracGunlukFiyat=(TextView)findViewById(R.id.txtAracGunlukFiyat1);


        txtAracTeslimYeri.setText(DegerTut.AracAlma);
        txtAracTeslimEtme.setText(DegerTut.AracTeslim);
        txtTeslimAlmaTr.setText(DegerTut.AlimTarih);
        txtTeslimEtmeTr.setText(DegerTut.TeslimTarih);
        txtAracMarka1.setText(DegerTut.AracMarka);
        txtAracSegment1.setText(DegerTut.AracSegment);




        toplamGun=Integer.parseInt(DegerTut.AracToplamGun);





        if(DegerTut.AracMarka.contains("Mercedes Benz")&&DegerTut.AracSegment.contains("C Segment")){

            gunFiyat=200;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }
        if(DegerTut.AracMarka.contains("Mercedes Benz")&&DegerTut.AracSegment.contains("D Segment")){

            gunFiyat=240;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }
        if(DegerTut.AracMarka.contains("Mercedes Benz")&&DegerTut.AracSegment.contains("D1 Segment")){

            gunFiyat=280;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }

        if(DegerTut.AracMarka.contains("Bmw")&&DegerTut.AracSegment.contains("C Segment")){

            gunFiyat=180;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");
        }
        if(DegerTut.AracMarka.contains("Bmw")&&DegerTut.AracSegment.contains("D Segment")){

            gunFiyat=220;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }
        if(DegerTut.AracMarka.contains("Bmw")&&DegerTut.AracSegment.contains("D1 Segment")){

            gunFiyat=260;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }

        if(DegerTut.AracMarka.contains("Audi")&&DegerTut.AracSegment.contains("C Segment")){

            gunFiyat=200;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }
        if(DegerTut.AracMarka.contains("Audi")&&DegerTut.AracSegment.contains("D Segment")){

            gunFiyat=250;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");
        }

        if(DegerTut.AracMarka.contains("Audi")&&DegerTut.AracSegment.contains("D1 Segment")){

            gunFiyat=300;
            String str;
            toplamFiyat=toplamGun*gunFiyat;
            str=Integer.toString(toplamFiyat);

            txtAracFiyat.setText(str +" ₺");
            txtAracGunlukFiyat.setText(Integer.toString(gunFiyat) +" ₺");

        }




        BtnSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DegerTutControl.AracAlma=txtAracTeslimYeri.getText().toString();
                DegerTutControl.AracTeslim=txtAracTeslimEtme.getText().toString();
                DegerTutControl.AlimTarih=txtTeslimAlmaTr.getText().toString();
                DegerTutControl.TeslimTarih = txtTeslimEtmeTr.getText().toString();
                DegerTutControl.AracMarka=txtAracMarka1.getText().toString();
                DegerTutControl.AracSegment=txtAracSegment1.getText().toString();
                DegerTutControl.AracFiyat=txtAracFiyat.getText().toString();

                Toast.makeText(AracSorgula.this, "Araç Rezervasyonunuz Sepete Eklenmiştir.", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(getApplicationContext(), Menu.class);
                startActivity(i1);
            }
        });




    }


}
