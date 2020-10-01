package com.example.tarikbozyak.prouygulama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class UcusListe extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lv;
    String[] Saat={"20:30","17:45","18:50","19:03","19:30","06:15","08:05"};
    String[] Fiyat={"150 ₺","205 ₺","55 ₺","300 ₺","450 ₺","100 ₺","300 ₺"};
    String[] Firma={"THY","THY","THY","ATLAS JET","ATLAS JET","FLY PEGASUS","FLY PEGASUS"};
    String[] SeferNo={"TK-2881","TK-3651","TK-1781","AJ-811","AJ-790","PGS-188","PGS-820"};
    int[] images={R.drawable.thylogo,R.drawable.thylogo,R.drawable.thylogo,R.drawable.atlaslogo,R.drawable.atlaslogo,R.drawable.pegasuslogo,R.drawable.pegasuslogo};
    String Nerden;
    String Nereye;
    String[] abroud={"AMSTERDAM","LONDRA","PARIS","BERLIN","KÖLN","SIDNEY","NEW YORK"};
    String[] yurtici={"ISTANBUL","ANKARA","","","","",""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucus_liste);



        for(int i=0;i<7;i++){

            //YD-->YD
            if(DegerTut.Nereye.equals(abroud[i])){

                for (int k=0;k<7;k++) {
                    if (DegerTut.Nerden.equals(abroud[k])) {
                      //  images = new int[]{R.drawable.thylogo,R.drawable.thylogo,R.drawable.thylogo,R.drawable.lufthansalogo,R.drawable.lufthansalogo,R.drawable.americanlogo,R.drawable.americanlogo};
                       images= new int[]{R.drawable.thylogo, R.drawable.thylogo, R.drawable.thylogo, R.drawable.lufthansalogo, R.drawable.lufthansalogo, R.drawable.americanlogo, R.drawable.americanlogo};
                        Fiyat = new String[]{"420 ₺", "510 ₺", "399 ₺", "300 ₺", "350 ₺", "499 ₺", "600 ₺"};
                        Firma= new String[]{"THY","THY","THY","LUFTHANSA","LUFTHANSA","AMERICAN AIRLINES","AMERICAN AIRLINES"};
                        SeferNo= new String[]{"TK-2881","TK-3651","TK-1781","LF-3011","LF-2190","AA-8722","AA-575"};
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
                        SeferNo= new String[]{"TK-2881","TK-3651","TK-1781","LF-3011","LF-2190","AA-8722","AA-575"};
                    }
                }
            }


        }





        lv=(ListView)findViewById(R.id.listView1);


        Adapter adapter = new Adapter(this,Saat,Fiyat,SeferNo,images,Nerden,Nereye);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        DegerTut.position=position;
        DegerTut.Nerden1=Nerden;
        DegerTut.Nereye1=Nereye;
        DegerTut.UcakFiyat1=Fiyat[position];
        DegerTut.Saat1=Saat[position];
        DegerTut.UcakFirma=Firma[position];
        DegerTut.SeferNo=SeferNo[position];

        Intent intent = new Intent(this, UcusOnay.class);
        intent.putExtra("otel", position);
        startActivityForResult(intent, 1);




    }
}
