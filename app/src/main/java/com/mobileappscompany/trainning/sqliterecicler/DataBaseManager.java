package com.mobileappscompany.trainning.sqliterecicler;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

/**
 * Created by admin on 3/5/2016.
 */
public abstract class DataBaseManager {

    private DBHelper helper;
    private  SQLiteDatabase db;

    public DataBaseManager (Context ctx){
        helper= new DBHelper(ctx);
        db=helper.getWritableDatabase();

    }

    public  void cerrar(){

        db.close();
    }


    abstract public void insertar_parametros(String id, String nombre, String descripcion, String precio);
    abstract  public void actualizar_parametros(String id, String nombre, String descripcion, String precio);
    abstract  public void eliminar (String id);
    abstract  public void eliminarTodo();
    abstract  public Cursor cargarCursor();
    abstract public  Boolean compruebaregistro(String id);



// GETTER Y SETTERs
    public DBHelper getHelper() {
        return helper;
    }

    public void setHelper(DBHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }





}


