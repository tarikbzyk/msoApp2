package com.example.tarikbozyak.prouygulama;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class JCGSQLiteHelper extends SQLiteOpenHelper {

    // database version
    private static final int database_VERSION = 1;
    // database name
    private static final String database_NAME = "OtelDB";
    private static final String table_otel = "OTEL";
    private static final String otel_ID = "id";
    private static final String otel_ADI = "OTELADI";
    private static final String otel_YILDIZ = "OTELYILDIZ";
    private static final String gunluk_FIYAT ="GUNLUKFIYAT";
    private static final String[] COLUMNS = { otel_ID, otel_ADI, otel_YILDIZ,gunluk_FIYAT };

    public JCGSQLiteHelper(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_HOTEL_TABLE = "CREATE TABLE OTEL ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "OTELADI TEXT, " + "OTELYILDIZ TEXT, " + "GUNLUKFIYAT TEXT )";
        db.execSQL(CREATE_HOTEL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS OTEL");
        this.onCreate(db);
    }

    public void createOtel(Otel otel) {
        //Database e veri yazmak için izin alıyor..
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(otel_ADI, otel.getOtelAdi());
        values.put(otel_YILDIZ, otel.getOtelYıldız());
        values.put(gunluk_FIYAT, otel.getGunlukFıyat());

        //  otel ekle
        db.insert(table_otel, null, values);

        // database kapatma
        db.close();
    }

    public Otel findOtel(int id) {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(table_otel, // a. table
                COLUMNS, " id = ?", new String[] { String.valueOf(id) }, null, null, null, null);


        if (cursor != null)
            cursor.moveToFirst();

        Otel otel = new Otel();
        otel.setId(Integer.parseInt(cursor.getString(0)));
        otel.setOtelAdi(cursor.getString(1));
        otel.setOtelYıldız(cursor.getString(2));
        otel.setGunlukFıyat(cursor.getString(3));

        return otel;
    }

    public List getAllOtel() {
        List otels = new LinkedList();

        // select otel query
        String query = "SELECT  * FROM " + table_otel;

        // get reference of the BookDB database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // parse all results
        Otel otel = null;
        if (cursor.moveToFirst()) {
            do {
                otel = new Otel();
                otel.setId(Integer.parseInt(cursor.getString(0)));
                otel.setOtelAdi(cursor.getString(1));
                otel.setOtelYıldız(cursor.getString(2));
                otel.setGunlukFıyat(cursor.getString(3));

                // Add otel to books
                otels.add(otel);
            } while (cursor.moveToNext());
        }
        return otels;
    }

    public int updateOtel(Otel otel) {

        // database den yazmak için izin alıyor.
        SQLiteDatabase db = this.getWritableDatabase();

        // make values to be inserted
        ContentValues values = new ContentValues();
        values.put("OTELADI", otel.getOtelAdi()); // Otel Adı
        values.put("OTELYILDIZ", otel.getOtelYıldız());
        values.put("GUNLUKFIYAT", otel.getGunlukFıyat());

        // update
        int i = db.update(table_otel, values, otel_ID + " = ?", new String[] { String.valueOf(otel.getId()) });

        db.close();
        return i;
    }


    public void deleteOtel(Otel otel) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(table_otel, otel_ID + " = ?", new String[] { String.valueOf(otel.getId()) });
        db.close();
    }
}