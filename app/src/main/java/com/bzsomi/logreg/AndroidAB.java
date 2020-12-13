package com.bzsomi.logreg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AndroidAB  extends SQLiteOpenHelper {
    public static final String ABnev = "felhasznalo.db";
    public static final String ABNEVE = "felhasznalo";
    public static final int ABversion = 1;
    public static final String OSZ_id = "id";
    public static final String OSZ_email = "email";
    public static final String OSZ_felhnev = "felhnev";
    public static final String OSZ_jelszo = "jelszo";
    public static final String OSZ_teljesnev = "teljesnev";

    public AndroidAB(Context context)
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
}
