package com.example.tarikbozyak.prouygulama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UcusOnay extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucus_onay);

        Intent intent = getIntent(); // sayfa geçiçi ile ilgili bilgiler içerir.
        int position = intent.getIntExtra("otel", -1);

        final TextView txtNerden=(TextView)findViewById(R.id.txtUcusNerden);
        final TextView txtNereye=(TextView)findViewById(R.id.txtUcusNereye);
        final TextView txtSaat=(TextView)findViewById(R.id.txtUcusSaati);
        final TextView txtGidisTarihi=(TextView)findViewById(R.id.txtUcusGidisTarihi);
        final TextView txtFiyat=(TextView)findViewById(R.id.txtUcusFiyat);
        final TextView txtFirma=(TextView)findViewById(R.id.txtFirma);
        final TextView txtSeferNo=(TextView)findViewById(R.id.txtSeferNo);



        txtNerden.setText(DegerTut.Nerden);
        txtNereye.setText(DegerTut.Nereye);
        txtSaat.setText(DegerTut.Saat1);
        txtGidisTarihi.setText(DegerTut.Gidis);
        txtFiyat.setText(DegerTut.UcakFiyat1);
        txtFirma.setText(DegerTut.UcakFirma);
        txtSeferNo.setText(DegerTut.SeferNo);



        Button BtnUcusSepeteEkle1 =(Button)findViewById(R.id.buttonBiletRez);

        BtnUcusSepeteEkle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DegerTutControl.Nerden = txtNerden.getText().toString();
                DegerTutControl.Nereye = txtNereye.getText().toString();
                DegerTutControl.Saat = txtSaat.getText().toString();
                DegerTutControl.Gidis = txtGidisTarihi.getText().toString();
                DegerTutControl.Fiyat = txtFiyat.getText().toString();



                Toast.makeText(UcusOnay.this, "Gidiş Biletiniz Sepete Eklenmiştir.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Intent intent = getIntent(); // sayfa geçiçi ile ilgili bilgiler içerir.
    //int id = intent.getIntExtra("otel", -1);




}
