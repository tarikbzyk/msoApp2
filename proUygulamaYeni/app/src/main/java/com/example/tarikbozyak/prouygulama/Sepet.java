package com.example.tarikbozyak.prouygulama;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Sepet extends AppCompatActivity {

    Button buttonOnay, buttonIptal;
    int ToplamFiyat=0,UcakGidisFiyat=0,UcakDonusFiyat=0,OtelFiyat=0,AracFiyat=0,UcakToplam=0;
    DataBaseHelper helper = new DataBaseHelper(this);

    String mesajIcerik;
    String numara="5555";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepet);
        ActivityCompat.requestPermissions(Sepet.this, new String[]{Manifest.permission.SEND_SMS}, 1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sepet.this, Menu.class);
                startActivities(new Intent[]{intent});
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        buttonIptal = (Button) findViewById(R.id.buttonIptal);
        buttonIptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Sepet.this).create();
                alertDialog.setTitle("Rezervasyon Iptal Talebi");
                alertDialog.setMessage("Uygulamayı kapattığınız anda Rezervasyonunuz otomatik olarak iptal edilecektir..");
                alertDialog.setIcon(R.drawable.icon);
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tamam",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "MSO'yu tercih ettiğiniz için Teşekkür ederiz..:)", Toast.LENGTH_LONG).show();
                            }
                        });
                alertDialog.show();
            }
        });

        TextView txtNerdenNereye=(TextView)findViewById(R.id.txtNerdenNereye);
        TextView txtGidisTarihi=(TextView)findViewById(R.id.txtGidisTarihi);
        TextView txtGidisSaat=(TextView)findViewById(R.id.txtSaat);
        TextView txtFiyat=(TextView)findViewById(R.id.txtUcakFiyat);
        TextView txtFirma=(TextView)findViewById(R.id.txtFirma);
        TextView txtSeferNo=(TextView)findViewById(R.id.txtSeferNo);

        txtNerdenNereye.setText(DegerTutControl.Nerden + " / " + DegerTutControl.Nereye);
        txtGidisTarihi.setText(DegerTutControl.Gidis);
        txtGidisSaat.setText(DegerTutControl.Saat);
        txtFiyat.setText(DegerTutControl.Fiyat);//Ucak gidiş fiyat

        TextView txtNerdenNereye2=(TextView)findViewById(R.id.txtNerdenNereye3);
        TextView txtDonusTarihi=(TextView)findViewById(R.id.txtDonusTarihi);
        TextView txtDonusSaat=(TextView)findViewById(R.id.txtSaat2);
        TextView txtFiyat2=(TextView)findViewById(R.id.txtUcakFiyat2);
        TextView txtFirma2=(TextView)findViewById(R.id.txtFirma1);
        TextView txtSeferNo2=(TextView)findViewById(R.id.txtSeferNo1);


        txtNerdenNereye2.setText(DegerTutControl.Nerden2 + " / " + DegerTutControl.Nereye2);
        txtDonusTarihi.setText(DegerTutControl.Donus);
        txtDonusSaat.setText(DegerTutControl.Saat2);
        txtFiyat2.setText(DegerTutControl.Fiyat2);//Ucak dönüş fiyat


        TextView txtOtelAdi=(TextView)findViewById(R.id.txtOtelAdi2);
        TextView txtOtelYildiz=(TextView)findViewById(R.id.txtOtelKalitesi2);
        TextView txtCheckIn=(TextView)findViewById(R.id.txtCheckInTarihi2);
        TextView txtCheckOut=(TextView)findViewById(R.id.txtCheckOutTarihi2);
        TextView txtOtelToplamFiyat=(TextView)findViewById(R.id.txtToplamFiyat2);

        txtOtelAdi.setText(DegerTutControl.OtelIsım);
        txtOtelYildiz.setText(DegerTutControl.OtelYildiz);
        txtCheckIn.setText(DegerTutControl.Checkin);
        txtCheckOut.setText(DegerTutControl.CheckOut);
        txtOtelToplamFiyat.setText(DegerTutControl.OtelToplamFiyat);//Otel Toplam Fiyat

        TextView txtAracTeslimYeri=(TextView)findViewById(R.id.txtAracTeslimYeri);
        TextView txtAracTeslimEtme=(TextView)findViewById(R.id.txtAracTeslimEtme);
        TextView txtTeslimAlmaTr=(TextView)findViewById(R.id.txtAracATarihi) ;
        TextView txtTeslimEtmeTr=(TextView)findViewById(R.id.txtAracTTarihi);
        TextView txtAracMarka1=(TextView)findViewById(R.id.txtAracMarka);
        TextView txtAracSegment1=(TextView)findViewById(R.id.txtAracSegment);
        TextView txtAracFiyat=(TextView)findViewById(R.id.txtAracFiyat);


        txtAracTeslimYeri.setText(DegerTutControl.AracAlma);
        txtAracTeslimEtme.setText(DegerTutControl.AracTeslim);
        txtTeslimAlmaTr.setText(DegerTutControl.AlimTarih);
        txtTeslimEtmeTr.setText(DegerTutControl.TeslimTarih);
        txtAracMarka1.setText(DegerTutControl.AracMarka);
        txtAracSegment1.setText(DegerTutControl.AracSegment);
        txtAracFiyat.setText(DegerTutControl.AracFiyat);//Arac Fiyat





            if(txtFiyat.getText().toString().contains("₺")) {
                String[] dizi=txtFiyat.getText().toString().split(" ");
                UcakGidisFiyat = Integer.parseInt(dizi[0]);
            }
            if(txtFiyat2.getText().toString().contains("₺")) {
                String[] dizi=txtFiyat2.getText().toString().split(" ");
                UcakDonusFiyat=Integer.parseInt(dizi[0]);
            }
            if(txtOtelToplamFiyat.getText().toString().contains("₺")) {
                String[] dizi=txtOtelToplamFiyat.getText().toString().split(" ");
                OtelFiyat=Integer.parseInt(dizi[0]);
            }
            if(txtAracFiyat.getText().toString().contains("₺")) {
                String[] dizi=txtAracFiyat.getText().toString().split(" ");
            AracFiyat=Integer.parseInt(dizi[0]);
            }
        ToplamFiyat=UcakGidisFiyat+UcakDonusFiyat+OtelFiyat+AracFiyat;
        UcakToplam=UcakGidisFiyat+UcakDonusFiyat;

        String userNAme = helper.searchUser();

        mesajIcerik="Merhaba "+userNAme+"\n"+"Uçak Bileti :" + UcakToplam +" ₺"+ "\n"
                + "Otel Rezervasyonu : " + OtelFiyat +" ₺"+ "\n"
                + "Araç Rezervasyonu : " + AracFiyat +" ₺"+ "\n"
                + "Toplam Fiyat : " + ToplamFiyat+" ₺"+"\n"
                + "Ödeme işleminiz gerçekleşmiştir"+"\n"
                + "İyi Günler Dileriz " +"\n"+"MSO";





        buttonOnay = (Button) findViewById(R.id.buttonOnay);
        buttonOnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mesaj = "Uçak Bileti :" + UcakToplam +" ₺"+ "\n"
                        + "Otel Rezervasyonu :" + OtelFiyat +" ₺"+ "\n"
                        + "Araç Rezervasyonu : " + AracFiyat +" ₺"+ "\n"
                        + "Toplam Fiyat : " + ToplamFiyat+" ₺";
                if (ToplamFiyat == 0) {
                    Toast.makeText(getApplicationContext(), "Sepete Eklenen Ürün Bulunmamaktadır.", Toast.LENGTH_LONG).show();
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(Sepet.this).create();
                    alertDialog.setTitle("Rezervasyonunuz Alınmıştır...");
                    alertDialog.setMessage(mesaj);
                    alertDialog.setIcon(R.drawable.icon);
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tamam",

                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i1 = new Intent(getApplicationContext(), Menu.class);
                                    startActivity(i1);
                                    smsDirektGonder(mesajIcerik, numara);
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Iptal",

                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Ödeme gerçekleştirilmedi.",
                                            Toast.LENGTH_LONG).show();

                                }
                            });

                    alertDialog.show();
                }


            }

        });



    }
    private void smsDirektGonder(String mesajIcerik,String numara) {

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numara, null, mesajIcerik, null, null);
            Toast.makeText(getApplicationContext(), "Ödeme detayları kısa mesaj olarak cihazınıza gönderilmiştir.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),
                    ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }


    }
}
