package com.example.zafiro1.biblioteca;

public class Libros {

    private int codigo;
    private String titulo;
    private String autor;
    private String descripcion;

    public Libros(){

    }

    //Constructor del objeto Libros.
    public Libros(int codigo, String titulo, String autor, String descripcion){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
