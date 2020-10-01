package com.example.tarikbozyak.prouygulama;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OtelActivity extends Activity {
    TextView OtelIsım;
    TextView OtelYıldız;
    TextView GunlukFıyat;
    TextView txtKonaklama;
    TextView txtCheckInTarihi,txtCheckOutTarihi,txtAdres,txtKisiSayisi,txtToplamFiyat;
    int kisi,gece,FiyatToplam,fiyat;



    Otel selectedOtel;
    JCGSQLiteHelper db;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otel_detay);

        OtelIsım = (TextView) findViewById(R.id.txtOtelAdi1);
        OtelYıldız = (TextView) findViewById(R.id.txtOtelKalitesi1);
        GunlukFıyat =(TextView) findViewById(R.id.txtGunlukFiyat1);
        txtKonaklama=(TextView)findViewById(R.id.txtKonaklama1);
        txtCheckInTarihi=(TextView)findViewById(R.id.txtCheckInTarihi1);
        txtCheckOutTarihi=(TextView)findViewById(R.id.txtCheckOutTarihi1);
        txtAdres=(TextView)findViewById(R.id.txtOtelAdres1);
        txtKisiSayisi=(TextView)findViewById(R.id.txtKisiSayisi1);
        txtToplamFiyat=(TextView)findViewById(R.id.txtToplamFiyat1);

        kisi=Integer.parseInt((DegerTut.KisiSayisi).toString());
        gece=Integer.parseInt((DegerTut.ToplamGun));







        // get the intent that we have passed from OtelListe
        Intent intent = getIntent(); // sayfa geçiçi ile ilgili bilgiler içerir.
        int id = intent.getIntExtra("otel", -1);

        // open the database of the application context
        db = new JCGSQLiteHelper(getApplicationContext());

        //---
        selectedOtel = db.findOtel(id);

        fiyat=Integer.parseInt((selectedOtel.getGunlukFıyat()));
        FiyatToplam=kisi*gece*fiyat;



        initializeViews();
        Goster();

        Button BtnOtelRezSepete =(Button)findViewById(R.id.buttonOtelRez);

        BtnOtelRezSepete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DegerTutControl.OtelIsım=selectedOtel.getOtelAdi();
                DegerTutControl.OtelYildiz=selectedOtel.getOtelYıldız();
                DegerTutControl.OtelKonum=txtAdres.getText().toString();
                DegerTutControl.Checkin=txtCheckInTarihi.getText().toString();
                DegerTutControl.CheckOut=txtCheckOutTarihi.getText().toString();
                DegerTutControl.ToplamGun = txtKonaklama.getText().toString();
                DegerTutControl.KisiSayisi=txtKisiSayisi.getText().toString();
                DegerTutControl.OtelGunlukFiyat=selectedOtel.getGunlukFıyat();
                DegerTutControl.OtelToplamFiyat=txtToplamFiyat.getText().toString();

                Toast.makeText(OtelActivity.this, "Otel Rezervasyonunuz Sepete Eklenmiştir.", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(getApplicationContext(), Menu.class);
                startActivity(i1);
            }
        });


    }

    public void initializeViews() {
        OtelIsım.setText(selectedOtel.getOtelAdi());
        OtelYıldız.setText(selectedOtel.getOtelYıldız());
        GunlukFıyat.setText(selectedOtel.getGunlukFıyat()+" ₺");
    }

    public void Goster(){

        txtKonaklama.setText(DegerTut.ToplamGun);
        txtCheckInTarihi.setText(DegerTut.Checkin);
        txtCheckOutTarihi.setText(DegerTut.CheckOut);
        txtAdres.setText(DegerTut.OtelKonum);
        txtKisiSayisi.setText(DegerTut.KisiSayisi);
        txtToplamFiyat.setText(Integer.toString(FiyatToplam)+" ₺");

    }







}