package com.example.zafiro1.basedatosexterna;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {

    //Creamos una variable OpenHelper, otra Database y instanciamos la clase.
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    //Creamos el constructor de la clase.
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //Recoge una instancia de la propia clase y la devuelve.
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //Metodo que abre la base de datos.
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public String estructura(){
        return this.database.getPath();
    }

    //Metodo que cierra la base de datos.
    public void close(){
        if(database != null){
            this.database.close();
        }
    }

    public ArrayList<Persona> todas_las_personas() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<Persona> arrayPersona = new ArrayList<Persona>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM persona", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayPersona.add(new Persona(c.getInt(0), c.getString(1), c.getString(2), c.getInt(3)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayPersona;

    } //Fin de todas_las_personas.

    //Metodo para articulos
    public ArrayList<Articulo> todos_los_articulos() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<Articulo> arrayArticulo = new ArrayList<Articulo>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM articulo", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayArticulo.add(new Articulo(c.getInt(0), c.getString(1)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayArticulo;

    } //Fin de todos_los_articulos.

    //Metodo para la relacion entre personas y articulos.
    public ArrayList<ArticuloRelacional> todos_los_articulos_relacionales() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ArticuloRelacional> arrayArticuloRelacional = new ArrayList<ArticuloRelacional>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM persona_articulo", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayArticuloRelacional.add(new ArticuloRelacional(c.getInt(0), c.getInt(1), c.getInt(2)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayArticuloRelacional;

    } //Fin de todos_los_articulos_relacionales.

} //Fin de la clase.