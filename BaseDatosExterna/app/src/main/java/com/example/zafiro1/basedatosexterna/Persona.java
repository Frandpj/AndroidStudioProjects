package com.example.zafiro1.basedatosexterna;

public class Persona {

    int cod_persona;
    int edad_persona;
    String nombre_persona;
    String apellido_persona;

    public Persona(int cod_persona, String nombre_persona, String apellido_persona, int edad_persona){

        this.cod_persona = cod_persona;
        this.nombre_persona = nombre_persona;
        this.apellido_persona = apellido_persona;
        this.edad_persona = edad_persona;

    }

    public int getCod_persona() {
        return cod_persona;
    }

    public void setCod_persona(int cod_persona) {
        this.cod_persona = cod_persona;
    }

    public int getEdad_persona() {
        return edad_persona;
    }

    public void setEdad_persona(int edad_persona) {
        this.edad_persona = edad_persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public String getApellido_persona() {
        return apellido_persona;
    }

    public void setApellido_persona(String apellido_persona) {
        this.apellido_persona = apellido_persona;
    }




}
