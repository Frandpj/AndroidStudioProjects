package com.example.fdelp.concesionario.BasesDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fdelp.concesionario.CochesNuevos.ObjetoCochesNuevos;
import com.example.fdelp.concesionario.CochesUsados.ObjetoCochesUsados;
import com.example.fdelp.concesionario.Extras.ObjetoExtras;

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

    public ArrayList<ObjetoCochesNuevos> todos_los_coches_nuevos() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoCochesNuevos> arrayCochesNuevos = new ArrayList<ObjetoCochesNuevos>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM cochesNuevos", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayCochesNuevos.add(new ObjetoCochesNuevos(c.getInt(0), c.getString(1), c.getString(2), c.getBlob(3), c.getFloat(4), c.getString(5)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayCochesNuevos;

    } //Fin de todos_los_coches_nuevos.

    public ObjetoCochesNuevos traerPosicion(int posicion){

        Cursor c;

        ObjetoCochesNuevos CocheNuevo = new ObjetoCochesNuevos();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM cochesNuevos WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                CocheNuevo = new ObjetoCochesNuevos(c.getInt(0), c.getString(1), c.getString(2), c.getBlob(3), c.getFloat(4), c.getString(5));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return CocheNuevo;

    }

    public ArrayList<ObjetoCochesUsados> todos_los_coches_usados() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoCochesUsados> arrayCochesUsados = new ArrayList<ObjetoCochesUsados>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM cochesUsados", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayCochesUsados.add(new ObjetoCochesUsados(c.getInt(0), c.getString(1), c.getString(2), c.getBlob(3), c.getFloat(4), c.getString(5)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayCochesUsados;

    } //Fin de todos_los_coches_usados.

    public ObjetoCochesUsados traerPosicion1(int posicion){

        Cursor c;

        ObjetoCochesUsados CocheUsado = new ObjetoCochesUsados();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM cochesUsados WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                CocheUsado = new ObjetoCochesUsados(c.getInt(0), c.getString(1), c.getString(2), c.getBlob(3), c.getFloat(4), c.getString(5));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return CocheUsado;

    }

    public ArrayList<ObjetoExtras> todos_los_extras() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoExtras> arrayExtras = new ArrayList<ObjetoExtras>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM extras", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayExtras.add(new ObjetoExtras(c.getInt(0), c.getString(1), c.getFloat(2), c.getString(3)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayExtras;

    } //Fin de todos_los_extras.

    public ObjetoExtras traerPosicion2(int posicion){

        Cursor c;

        ObjetoExtras extras = new ObjetoExtras();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM extras WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                extras = new ObjetoExtras(c.getInt(0), c.getString(1), c.getFloat(4), c.getString(5));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return extras;

    }

    //Metodo que actualiza los datos.
    public void actualizarCocheNuevo(ObjetoCochesNuevos nuevoCoche){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("marca", nuevoCoche.getMarca());
        valores.put("modelo", nuevoCoche.getModelo());
        //valores.put("imagen", nuevoCoche.getImagen());
        valores.put("precio", Float.valueOf(nuevoCoche.getPrecio()));
        valores.put("descripcion", nuevoCoche.getDescripcion());
        //Insertamos en la base de datos en la tabla cochesNuevos
        db.update("cochesNuevos", valores, "id=" + Integer.valueOf(nuevoCoche.getId()), null);
        db.close();

    }

    //Metodo que actualiza los datos.
    public void insertarCocheNuevo(String marca, String modelo, byte[] imagen, float precio, String descripcion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("marca", marca);
        valores.put("modelo", modelo);
        valores.put("imagen", imagen);
        valores.put("precio", precio);
        valores.put("descripcion", descripcion);
        //Insertamos en la base de datos en la tabla cochesNuevos
        db.insert("cochesNuevos", null, valores);
        db.close();

    }

    //Metodo que actualiza los datos.
    public void insertarCocheUsado(String marca, String modelo, byte[] imagen, float precio, String descripcion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("marca", marca);
        valores.put("modelo", modelo);
        valores.put("imagen", imagen);
        valores.put("precio", precio);
        valores.put("descripcion", descripcion);
        //Insertamos en la base de datos en la tabla cochesUsados
        db.insert("cochesUsados", null, valores);
        db.close();

    }

    //Metodo que actualiza los datos.
    public void insertarExtras(String nombre, float precio, String descripcion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("precio", precio);
        valores.put("descripcion", descripcion);
        //Insertamos en la base de datos en la tabla cochesNuevos
        db.insert("extras", null, valores);
        db.close();

    }


    //Metodo que actualiza los datos.
    public void eliminarCocheNuevo(int posicion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        //Insertamos en la base de datos en la tabla cochesNuevos
        db.delete("cochesNuevos", "id=" + posicion, null);
        db.close();

    }

    //Metodo que actualiza los datos.
    public void eliminarCocheUsado(int posicion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        //Insertamos en la base de datos en la tabla cochesNuevos
        db.delete("cochesUsados", "id=" + posicion, null);
        db.close();

    }

    //Metodo que actualiza los datos.
    public void eliminarExtras(int posicion){

        SQLiteDatabase db= openHelper.getWritableDatabase();
        //Insertamos en la base de datos en la tabla extras
        db.delete("extras", "id=" + posicion, null);
        db.close();

    }
}

