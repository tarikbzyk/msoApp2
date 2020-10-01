package com.example.tarikbozyak.prouygulama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bilet extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet);
        Button btnDonusBilet =(Button)findViewById(R.id.buttonDonusBileti);

        if(DegerTutControl.btnDonusControl==20){
            btnDonusBilet.setVisibility(View.INVISIBLE);

        }
        if(DegerTutControl.btnDonusControl1==21){
            btnDonusBilet.setVisibility(View.VISIBLE);
        }

    }

    public void Tiklendi2(View v) {

        if (v.getId() == R.id.buttonGidisBileti) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), UcusListe.class);
            startActivity(i1);


        }
        if (v.getId() == R.id.buttonDonusBileti) {
            //Uçak yazılı buton
            Intent i1 = new Intent(getApplicationContext(), UcusListeDonus.class);
            startActivity(i1);


        }




    }
}
