package com.mobileappscompany.trainning.sqliterecicler;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by admin on 3/5/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static final String DB_NOMBRE="escuela.sqLite";

    private static final int DB_SCHEME_VERSION=1;


    //Context context, String name, SQLiteDatabase.CursorFactory factory, int version
    public DBHelper(Context context) {
        super(context, DB_NOMBRE, null, DB_SCHEME_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManagerCurso.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" +DB_NOMBRE);
        onCreate(db);
    }
}
