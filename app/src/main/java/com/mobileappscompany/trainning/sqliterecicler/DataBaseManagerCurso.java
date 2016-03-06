package com.mobileappscompany.trainning.sqliterecicler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 3/5/2016.
 */
public class DataBaseManagerCurso extends DataBaseManager {

    private static final  String NOMBRE_TABLA="curso";
    private static final  String CN_ID="_id";
    private static final  String CN_NOMBRE="nombre";
    private static final  String CN_DESCRIPCION="descripcion";
    private static final  String CN_PRECIO="precio";



    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + " ("
            + CN_ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + CN_NOMBRE + " text NOT NULL, "
            + CN_DESCRIPCION + " text NULL, "
            + CN_PRECIO + " DECIMAL(10,5) NULL"
            + ");";



    public DataBaseManagerCurso(Context ctx) {
        super(ctx);
    }
    @Override
    public void cerrar() {
        super.getDb().close();
    }


    private ContentValues generarContentValues(String id, String name, String descripcion, String precio) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_NOMBRE, name);
        valores.put(CN_DESCRIPCION, descripcion);
        valores.put(CN_PRECIO, precio);
        return valores;
    }






    @Override
    public void insertar_parametros(String id, String nombre, String descripcion, String precio) {
        Log.d("cursos_insertar", super.getDb().insert(NOMBRE_TABLA, null, generarContentValues(id, nombre, descripcion, precio)) + "");
    }

    @Override
    public void actualizar_parametros(String id, String nombre, String descripcion, String precio) {
        ContentValues valores = new ContentValues();
        valores.put(CN_ID, id);
        valores.put(CN_NOMBRE, nombre);
        valores.put(CN_DESCRIPCION, descripcion);
        valores.put(CN_PRECIO, precio);

        String [] args= new String[]{id};


        Log.d("cursos_actualizar", super.getDb().update(NOMBRE_TABLA, valores, "_id=?", args)+"");
    }

    @Override
    public void eliminar(String id) {
        super.getDb().delete(NOMBRE_TABLA, CN_ID + "=?", new String[]{id});
    }



    @Override
    public void eliminarTodo() {
        super.getDb().execSQL("DELETE FROM "+ NOMBRE_TABLA+";");
        Log.d("cursos_eliminar", "Datos borrados");
    }

    @Override
    public Cursor cargarCursor() {
        String [] columnas= new String[]{CN_ID, CN_NOMBRE, CN_DESCRIPCION, CN_PRECIO};


        return super.getDb().query(NOMBRE_TABLA,columnas,null,null,null,null,null );
    }

    @Override
    public Boolean compruebaregistro(String id) {
        boolean esta=true;

        Cursor resultSet= super.getDb().rawQuery("Select * from " + NOMBRE_TABLA + " WHERE " + CN_ID + "=" + id, null);

        if(resultSet.getCount()<=0)
            esta=false;
        else
            esta=true;

        return esta;
    }

    public List<Curso> getCursosList(){
        List<Curso>  list= new ArrayList<>();

        Cursor c= cargarCursor();


        while (c.moveToNext()){
            Curso curso = new Curso();

            curso.setId(c.getString(0));
            curso.setNombre(c.getString(1));
            curso.setDescripcion(c.getString(2));
            curso.setPrecio(c.getDouble(3));


            list.add(curso);
        }

        return list;

    }

}
