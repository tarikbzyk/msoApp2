package com.example.tarikbozyak.prouygulama;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class UcusListeDonus extends Activity implements AdapterView.OnItemClickListener {

    ListView lv;
    String[] Saat={"20:30","17:45","18:50","19:03","19:30","06:15","08:05"};
    String[] Fiyat={"150 ₺","205 ₺","55 ₺","300 ₺","450 ₺","100 ₺","300 ₺"};
    String[] Firma={"THY","THY","THY","ATLAS JET","ATLAS JET","FLY PEGASUS","FLY PEGASUS"};
    String[] SeferNo={"TK-7855","TK-3351","TK-9010","AJ-421","AJ-775","PGS-378","PGS-9001"};
    int[] images={R.drawable.thylogo,R.drawable.thylogo,R.drawable.thylogo,R.drawable.atlaslogo,R.drawable.atlaslogo,R.drawable.pegasuslogo,R.drawable.pegasuslogo};
    String Nerden,Nerden1;
    String Nereye,Nereye1;
    String[] abroud={"AMSTERDAM","LONDRA","PARIS","BERLIN","KÖLN","SIDNEY","NEW YORK"};
    String[] yurtici={"ISTANBUL","ANKARA","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucus_liste_donus);




        for(int i=0;i<7;i++){

            //YD-->YD
            if(DegerTut.Nereye.equals(abroud[i])){

                for (int k=0;k<7;k++) {
                    if (DegerTut.Nerden.equals(abroud[k])) {
                        //  images = new int[]{R.drawable.thylogo,R.drawable.thylogo,R.drawable.thylogo,R.drawable.lufthansalogo,R.drawable.lufthansalogo,R.drawable.americanlogo,R.drawable.americanlogo};
                        images= new int[]{R.drawable.thylogo, R.drawable.thylogo, R.drawable.thylogo, R.drawable.lufthansalogo, R.drawable.lufthansalogo, R.drawable.americanlogo, R.drawable.americanlogo};
                        Firma= new String[]{"THY","THY","THY","LUFTHANSA","LUFTHANSA","AMERICAN AIRLINES","AMERICAN AIRLINES"};
                        Fiyat = new String[]{"550 ₺", "610 ₺", "599 ₺", "500 ₺", "560 ₺", "620 ₺", "700 ₺"};
                        SeferNo = new String[]{"TK-7855","TK-3351","TK-9010","LF-645","LF-1175","AA-5590","AA-3228"};
                    }
                }
            }
            //YI-->YI
            if(DegerTut.Nerden.equals(yurtici[i])){

                for (int k=0;k<7;k++) {
                    if (DegerTut.Nereye.equals(yurtici[k])) {

                        Fiyat = new String[]{"120 ₺", "150 ₺", "99 ₺", "75 ₺", "70 ₺", "60 ₺", "45 ₺"};
                    }
                }
            }
            // YI-->YD
            if(DegerTut.Nerden.equals(yurtici[i])){

                for (int k=0;k<7;k++) {
                    if (DegerTut.Nereye.equals(abroud[k])) {

                        Fiyat = new String[]{"359 ₺", "405 ₺", "300 ₺", "289 ₺", "230 ₺", "200 ₺", "220 ₺"};
                    }
                }
            }
            //YD-->YI
            if(DegerTut.Nerden.equals(abroud[i])){

                for (int k=0;k<7;k++) {
                    if (DegerTut.Nereye.equals(yurtici[k])) {
                        images= new int[]{R.drawable.thylogo, R.drawable.thylogo, R.drawable.thylogo, R.drawable.lufthansalogo, R.drawable.lufthansalogo, R.drawable.americanlogo, R.drawable.americanlogo};
                        Fiyat = new String[]{"380 ₺", "635 ₺", "450 ₺", "380 ₺", "350 ₺", "310 ₺", "340 ₺"};
                        Firma= new String[]{"THY","THY","THY","LUFTHANSA","LUFTHANSA","AMERICAN AIRLINES","AMERICAN AIRLINES"};
                        SeferNo = new String[]{"TK-7855","TK-3351","TK-9010","LF-645","LF-1175","AA-5590","AA-3228"};
                    }
                }
            }


        }

        

        lv=(ListView)findViewById(R.id.listView2);


        AdapterDonus adapter = new AdapterDonus(this, Saat,Fiyat,SeferNo,images,Nerden,Nereye);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        DegerTut.position=position;
        DegerTut.Nerden2=Nerden;
        DegerTut.Nereye2=Nereye;
        DegerTut.UcakFiyat2=Fiyat[position];
        DegerTut.Saat2=Saat[position];
        DegerTut.UcakFirma2=Firma[position];
        DegerTut.SeferNo2=SeferNo[position];

        Intent intent = new Intent(this, UcusOnayDonus.class);
        intent.putExtra("otel", position);
        startActivityForResult(intent, 1);




    }

}
