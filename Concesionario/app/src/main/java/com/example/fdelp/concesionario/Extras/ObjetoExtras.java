package com.example.fdelp.concesionario.Extras;

public class ObjetoExtras {

    int id;
    String nombre, descripcion;
    float precio;

    public ObjetoExtras(int id, String nombre, float precio, String descripcion){

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;

    }

    public ObjetoExtras(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
