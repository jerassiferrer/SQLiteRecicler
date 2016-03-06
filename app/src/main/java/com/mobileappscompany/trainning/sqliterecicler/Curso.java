package com.mobileappscompany.trainning.sqliterecicler;

/**
 * Created by admin on 3/5/2016.
 */
public class Curso {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;


    public Curso() {
    }

    public Curso(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Curso(String id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}