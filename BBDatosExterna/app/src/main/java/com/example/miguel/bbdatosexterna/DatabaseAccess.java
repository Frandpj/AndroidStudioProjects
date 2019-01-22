package com.example.miguel.bbdatosexterna;

/**
 * Created by miguel on 21/11/18.
 */
//clase para hacer las operaciones con la base de datos externa
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Leer las provincias de la base de datos.
     *
     * @return a List of quotes
     */
    //Devuelve todas las provincias


    //metodo que devuelve un cursor con todos los libros de la tabla libros
    ArrayList<Provincia> todas_las_provincias()
    {
        Cursor c;
        //Array donde se devuelven todos los libros
        ArrayList<Provincia> arrayLibros = new ArrayList<Provincia>();


        //definimos la sentencia sql en una cadena
       // String[] valores_recuperar = {"cod_provincia", "nombre_provincia", "num_habitantes"};

        //Ejecutamos la cadena
        //c = database.query("provincia", valores_recuperar,null, null, null, null, null, null);
        c = database.rawQuery(" SELECT * FROM provincia", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {

                arrayLibros.add(new Provincia(c.getInt(0),c.getString(1),c.getInt(2)));

            } while(c.moveToNext());
        }
        //cerramos el cursor
        c.close();

        //devolvemos el array
        return arrayLibros;


    }//fin todas_las_provincias

    /*ejemplo de lectura de un select no es de esta base
    public List<String> getQuotes() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM quotes", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }*/
}
