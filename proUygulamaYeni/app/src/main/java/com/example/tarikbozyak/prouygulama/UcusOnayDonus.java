package com.example.tarikbozyak.prouygulama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UcusOnayDonus extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucus_onay_donus);

        Intent intent = getIntent(); // sayfa geçiçi ile ilgili bilgiler içerir.
        int position = intent.getIntExtra("otel", -1);

        final TextView txtNerden=(TextView)findViewById(R.id.txtUcusNerden1);
        final TextView txtNereye=(TextView)findViewById(R.id.txtUcusNereye1);
        final TextView txtSaat=(TextView)findViewById(R.id.txtUcusSaati1);
        final TextView txtDonusTarihi=(TextView)findViewById(R.id.txtUcusGidisTarihi1);
        final TextView txtFiyat=(TextView)findViewById(R.id.txtUcusFiyat1);
        final TextView txtFirma=(TextView)findViewById(R.id.txtFirma1);
        final TextView txtSeferNo=(TextView)findViewById(R.id.txtSeferNo1);



        txtNerden.setText(DegerTut.Nereye);
        txtNereye.setText(DegerTut.Nerden);
        txtSaat.setText(DegerTut.Saat2);
        txtDonusTarihi.setText(DegerTut.Donus);
        txtFiyat.setText(DegerTut.UcakFiyat2);
        txtFirma.setText(DegerTut.UcakFirma2);
        txtSeferNo.setText(DegerTut.SeferNo2);

        Button BtnUcusSepeteEkle =(Button)findViewById(R.id.buttonBiletRezDonus);

        BtnUcusSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DegerTutControl.Nerden2 = txtNerden.getText().toString();
                DegerTutControl.Nereye2 = txtNereye.getText().toString();
                DegerTutControl.Saat2 = txtSaat.getText().toString();
                DegerTutControl.Donus = txtDonusTarihi.getText().toString();
                DegerTutControl.Fiyat2 = txtFiyat.getText().toString();


                Toast.makeText(UcusOnayDonus.this, "Dönüş Biletiniz Sepete Eklenmiştir.", Toast.LENGTH_SHORT).show();
            }
        });




    }


}

