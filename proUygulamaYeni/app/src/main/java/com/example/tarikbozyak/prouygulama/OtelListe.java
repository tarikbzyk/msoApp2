package com.example.tarikbozyak.prouygulama;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class OtelListe extends ListActivity implements OnItemClickListener {
    JCGSQLiteHelper db = new JCGSQLiteHelper(this);
    List<Otel> list;
    ArrayAdapter<String> myAdapter;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_otel_liste);

        // drop this database if already exists
        db.onUpgrade(db.getWritableDatabase(), 1, 2);

        db.createOtel(new Otel("Hilton", "*****", "850"));
        db.createOtel(new Otel("Radison Blue", "*****", "800"));
        db.createOtel(new Otel("Mariotte", "*****", "785"));
        db.createOtel(new Otel("The Luxor Hotel", "****", "655"));
        db.createOtel(new Otel("Caesars Palace", "*****", "875"));
        db.createOtel(new Otel("Monte Carlo", "*****", "975"));
        db.createOtel(new Otel("Venetian Resort", "***", "475"));
        db.createOtel(new Otel("Foldable Hotel Pods", "****", "650"));
        db.createOtel(new Otel("Waterworld", "*****", "950"));
        db.createOtel(new Otel("The Poseidon Undersea Resort", "***", "455"));
        db.createOtel(new Otel("Diamond Ring", "***", "450"));
        db.createOtel(new Otel("Ramada", "*****", "770"));
        db.createOtel(new Otel("Albatros", "***", "400"));

        // get all books
        list = db.getAllOtel();
        List<String> listTitle = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            listTitle.add(i,list.get(i).getOtelAdi());

        }

     myAdapter = new ArrayAdapter<String>(this, R.layout.row_layout, R.id.listText, listTitle);

      getListView().setOnItemClickListener(this);
        setListAdapter(myAdapter);


    }





    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // start OtelActivity with extras the book id
        Intent intent = new Intent(this, OtelActivity.class);
        intent.putExtra("otel", list.get(arg2).getId());
        startActivityForResult(intent, 1);
    }


}
