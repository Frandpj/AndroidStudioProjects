package com.example.miguel.basealistview;

/**
 * Created by miguel on 30/10/18.
 */

public class Libro {

    private int codigo_libro;
    private String titulo_libro;



    private String autor_libro;

    //constructor 1
    Libro()
    {
        this.codigo_libro = -1;
        this.autor_libro =null;
        this.titulo_libro =null;

    } //fin constructor 1

    //constructor 2
    Libro (String titulo_libro, String autor_libro)
    {
        this.autor_libro = autor_libro;
        this.titulo_libro = titulo_libro;
    }//fin constructor 2
    //no creamos un constructor al cual se le pase el código del libro puesto
    //que este campo es autonumérico a partir de 100 en la base de datos
//constructor 2
    Libro (int codigo_libro, String titulo_libro, String autor_libro)
    {
        this.codigo_libro=codigo_libro;
        this.autor_libro = autor_libro;
        this.titulo_libro = titulo_libro;
    }
    //métodos get and set
    public int getCodigo_libro() {
        return codigo_libro;
    }

    public void setCodigo_libro(int codigo_libro) {
        this.codigo_libro = codigo_libro;
    }

    public String getTitulo_libro() {
        return titulo_libro;
    }

    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }

    public String getAutor_libro() {
        return autor_libro;
    }

    public void setAutor_libro(String autor_libro) {
        this.autor_libro = autor_libro;
    }

}
