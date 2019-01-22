package com.example.zafiro1.basedatosexterna;

public class Articulo {

    int codigo_articulo;
    String descripcion_articulo;

    public void setDescripcion_articulo(String descripcion_articulo) {
        this.descripcion_articulo = descripcion_articulo;
    }

    public Articulo(int codigo_articulo, String descripcion_articulo){
        this.codigo_articulo =  codigo_articulo;
        this.descripcion_articulo = descripcion_articulo;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }


    public String getDescripcion_articulo() {
        return descripcion_articulo;
    }


}
