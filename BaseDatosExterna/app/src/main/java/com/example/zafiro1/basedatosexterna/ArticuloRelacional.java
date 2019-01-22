package com.example.zafiro1.basedatosexterna;

public class ArticuloRelacional {

    int codigo_persona, codigo_articulo, cantidad;

    public ArticuloRelacional(int codigo_persona, int codigo_articulo, int cantidad){

        this.codigo_persona = codigo_persona;
        this.codigo_articulo = codigo_articulo;
        this.cantidad = cantidad;

    }

    public int getCodigo_persona() {
        return codigo_persona;
    }

    public void setCodigo_persona(int codigo_persona) {
        this.codigo_persona = codigo_persona;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
