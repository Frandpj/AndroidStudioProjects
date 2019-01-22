package com.example.miguel.bbdatosexterna;

/**
 * Created by miguel on 21/11/18.
 */

public class Provincia {


    private int cod_provincia;
    private String nombre_provincia;
    private int num_habitantes;


    Provincia(int cod_provincia, String nombre_provincia, int num_habitantes)
    {
        this.cod_provincia=cod_provincia;
        this.nombre_provincia=nombre_provincia;
        this.num_habitantes=num_habitantes;


    }
    public int getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public int getNum_habitantes() {
        return num_habitantes;
    }

    public void setNum_habitantes(int num_habitantes) {
        this.num_habitantes = num_habitantes;
    }
}
