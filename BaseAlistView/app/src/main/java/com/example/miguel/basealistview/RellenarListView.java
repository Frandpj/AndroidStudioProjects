package com.example.miguel.basealistview;

import java.io.Serializable;

/**
 * Created by miguel on 31/10/18.
 */

public class RellenarListView {

    private int codigo_libro;
    private String titulo_libro, autor_libro;

    public RellenarListView()
    {
        super();
    }

    public RellenarListView(int codigo_libro, String titulo_libro, String autor_libro)
    {
        this.codigo_libro=codigo_libro;
        this.titulo_libro=titulo_libro;
        this.autor_libro=autor_libro;
    }

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
