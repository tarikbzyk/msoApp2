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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Ucak extends AppCompatActivity {
    ListView lv;
    Button btnUcusAra;
    ArrayAdapter adapter;
    ArrayList<HashMap<String, String>> ucus_liste;
    String kitap_adlari[];
    int kitap_idler[];
    EditText gidisTarihi;
    EditText donusTarihi;
    TextView donusLabel;

    RadioButton rdoGidiDonus;
    RadioButton rdoTekYon;

    Spinner spinnerNerden;
    Spinner spinnerNereye;

    String yy, mm, dd;

    int gidisTarihiInt;
    int donusTarihiInt;
    int gun,buGün,buAy,girAy,cikAy,ay,toplamGun,gunKontrol,AyKontrol,toplamGunKontrol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucak);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gidisTarihi = (EditText) findViewById(R.id.editTextGidisTarihi);
        donusTarihi = (EditText) findViewById(R.id.editTextDonusTarihi);
        donusLabel = (TextView) findViewById(R.id.textView3);
        rdoGidiDonus = (RadioButton) findViewById(R.id.radioButton);
        rdoTekYon = (RadioButton) findViewById(R.id.radioButton2);



        rdoGidiDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdoGidiDonus.isChecked()) {
                    rdoTekYon.setChecked(false);
                    donusTarihi.setVisibility(View.VISIBLE);
                    donusLabel.setVisibility(View.VISIBLE);
  }
                int btnDonusControl1=21;
                DegerTutControl.btnDonusControl1=btnDonusControl1;
            }
        });

        rdoTekYon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdoTekYon.isChecked()) {
                    rdoGidiDonus.setChecked(false);
                    donusTarihi.setVisibility(View.INVISIBLE);
                    donusLabel.setVisibility(View.INVISIBLE);
                }
                int btnDonusControl = 20;
                DegerTutControl.btnDonusControl = btnDonusControl;
            }
        });



        FloatingActionButton fabUcak = (FloatingActionButton) findViewById(R.id.fabUcak);
        fabUcak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ucak.this, Menu.class);
                startActivities(new Intent[]{intent});
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btnUcusAra = (Button) findViewById(R.id.buttonUcus);

        SimpleDateFormat dfDate_day = new SimpleDateFormat("dd.MM.yyyy");


        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        final String dt = dfDate_day.format(c.getTime());
        gidisTarihi.setText(dt);


        c.add(Calendar.DATE, 8);
        final String co = dfDate_day.format(c.getTime());
        donusTarihi.setText(co);

    }



    public void onClickUcak(View v) {

        if (v.getId() == R.id.buttonUcus) {
            Spinner nerden = (Spinner) findViewById(R.id.sp1);
            String nerdenStr = nerden.getSelectedItem().toString();
            Spinner nereye = (Spinner) findViewById(R.id.sp2);
            String nereyeStr = nereye.getSelectedItem().toString();

            SimpleDateFormat date_day = new SimpleDateFormat("dd.MM.yyyy");


            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 1);
            final String dt = date_day.format(c.getTime());



            String gidisTarihiStr = gidisTarihi.getText().toString();

            String donusTarihiStr = donusTarihi.getText().toString();

            gidisTarihiInt= Integer.parseInt((gidisTarihi.getText().toString().substring(0, 2)).toString());
            donusTarihiInt= Integer.parseInt((donusTarihi.getText().toString().substring(0, 2)));
            buGün=Integer.parseInt(dt.substring(0,2).toString());
            //22.10.2015
            gun=donusTarihiInt-gidisTarihiInt;

            girAy= Integer.parseInt((gidisTarihi.getText().toString().substring(3, 5)).toString());
            cikAy= Integer.parseInt((donusTarihi.getText().toString().substring(3, 5)));
            buAy=Integer.parseInt(dt.substring(3,5).toString());
            ay=(cikAy-girAy)*30;

            toplamGun=gun+ay;

            gunKontrol=gidisTarihiInt-buGün;
            AyKontrol=(buAy-girAy)*30;
            toplamGunKontrol=gunKontrol+AyKontrol;








            if (nerdenStr.equals("Havalimanı Seçiniz") || nereyeStr.equals("Havalimanı Seçiniz")) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        Ucak.this);
                alertDialogBuilder.setTitle("Hata");
                alertDialogBuilder
                        .setMessage("Havalimanı Seçmelisiniz!")
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            } else {
                if (rdoGidiDonus.isChecked())
                    DegerTut.YonTuru = rdoGidiDonus.getText().toString() + "";
                else
                    DegerTut.YonTuru = rdoTekYon.getText().toString() + "";


                DegerTut.Nerden = nerdenStr.toString();
                DegerTut.Nereye = nereyeStr.toString();
                DegerTut.Gidis = gidisTarihiStr.toString();

                if (donusTarihi.getVisibility() == View.VISIBLE)
                    DegerTut.Donus = donusTarihiStr.toString();
                else
                    DegerTut.Donus = "";



                if(toplamGun<0||toplamGunKontrol<0){
                    Toast.makeText(Ucak.this, "Gidis ve Dönüş tarihlerini kontrol ediniz.", Toast.LENGTH_SHORT).show();

                }


                else {




                if (rdoTekYon.isChecked()) {
                    Intent i = new Intent(getApplicationContext(), UcusListe.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(), Bilet.class);
                    startActivity(i);
                }
                }

            }


        }
    }


}
