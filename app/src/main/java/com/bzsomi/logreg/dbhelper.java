package com.bzsomi.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper  extends SQLiteOpenHelper {
    public static final String ABnev = "felhasznalo.db";
    public static final String ABNEVE = "felhasznalo";
    public static final int ABversion = 1;
    public static final String OSZ_id = "id";
    public static final String OSZ_email = "email";
    public static final String OSZ_felhnev = "felhnev";
    public static final String OSZ_jelszo = "jelszo";
    public static final String OSZ_teljesnev = "teljesnev";

    public dbhelper(Context context)
    {
        super(context, ABnev, null, ABversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + ABNEVE + " (" + OSZ_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OSZ_email + " VARCHAR(225) NOT NULL, " + OSZ_felhnev + " VARCHAR(225) NOT NULL, "
                + OSZ_jelszo + " VARCHAR(225) NOT NULL, " + OSZ_teljesnev + " VARCHAR(225) NOT NULL )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + ABNEVE;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean emailEllenorzes(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + ABNEVE + " WHERE " + OSZ_email + " = ?", new String[]{email});
        return result.getCount() == 0;
    }

    public boolean nevEllenorzes(String nev) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + ABNEVE + " WHERE " + OSZ_felhnev + " = ?", new String[]{nev});
        return result.getCount() == 0;
    }

    public boolean BejelentkezesNevvel(String felhasznalonev, String jelszo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + ABNEVE +
                        " WHERE " + OSZ_felhnev + " = ?" +
                        " AND " + OSZ_jelszo + "= ?",
                new String[]{felhasznalonev, jelszo});
        return result.getCount() == 1;
    }

    public boolean BejelentkezesEmaillal(String felhasznalonev, String jelszo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + ABNEVE +
                        " WHERE " + OSZ_email + " = ?" +
                        " AND " + OSZ_jelszo + "= ?",
                new String[]{felhasznalonev, jelszo});
        return result.getCount() == 1;
    }

    public String teljesNev(String felhasznalonev, String jelszo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT "+OSZ_teljesnev+" FROM " + ABNEVE +
                        " WHERE " + OSZ_felhnev + " = ?" +
                        " OR " + OSZ_email + "= ?" +
                        " AND " + OSZ_jelszo + "= ?",
                new String[]{felhasznalonev, felhasznalonev, jelszo});
        String back = "";
        while (result.moveToNext())
        {
            back = result.getString(0);
        }
        return back;
    }

    public boolean adatRogzites(String nev, String teljes, String email, String jelszo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OSZ_email, email);
        values.put(OSZ_felhnev, nev);
        values.put(OSZ_jelszo, jelszo);
        values.put(OSZ_teljesnev, teljes);
        return db.insert(ABNEVE, null, values) != -1;

    }
}
