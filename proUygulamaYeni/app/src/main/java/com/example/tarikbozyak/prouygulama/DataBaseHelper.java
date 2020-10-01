package com.example.tarikbozyak.prouygulama;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper
{
    private  static final int DATABASE_VERSION =1;
    private  static final String DATABASE_NAME ="contact.db";

    private  static final String TABLE_NAME ="contacts";
    private  static final String COLUMN_ID ="id";
    private  static final String COLUMN_NAME ="name";
    private  static final String COLUMN_EMAIL ="email";
    private  static final String COLUMN_PASS ="pass";
    private  static final String COLUMN_UNAME ="uname";
    SQLiteDatabase db;
    private static final String TABLE_CREATE ="create table contacts(id integer primary key not null , " +
            "name text not null,email text not null,uname text not null,pass text not null); ";



    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when no database exists in disk and the helper class needs
    // to create a new one.

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        String query ="DROP TABLE IF EXISTS "+TABLE_NAME ;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query ="select * from contacts";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(COLUMN_ID,count);

        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_UNAME,c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public String searchPass(String uname) {

        db = this.getReadableDatabase();
        String query = "select uname,pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="not found";

        if(cursor.moveToFirst()){ //Veysel Hoca'ya sorulacak.
            do {
                a = cursor.getString(0);
                b=cursor.getString(1);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());

        }
        return b;
    }

    public String searchUser() {

        db = this.getReadableDatabase();
        String query = "select uname,pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        a="not found";

        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);

            }
            while(cursor.moveToNext());

        }
        return a;
    }
}
