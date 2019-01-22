package com.example.zafiro1.recetas.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.zafiro1.recetas.ObjetoRecetas;

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

    public ArrayList<ObjetoRecetas> todas_las_recetas_principal() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoRecetas> arrayRecetas = new ArrayList<ObjetoRecetas>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas where categoria ='Principal'", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayRecetas.add(new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayRecetas;

    } //Fin de todas_las_recetas.

    public ObjetoRecetas traerPosicionRecetaPrincipal(int posicion){

        Cursor c;

        ObjetoRecetas receta = new ObjetoRecetas();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                receta = new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return receta;

    }

    /*-----------------------------------------------------------------------------------------------------------------------*/

    public ArrayList<ObjetoRecetas> todas_las_recetas_especial() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoRecetas> arrayRecetas = new ArrayList<ObjetoRecetas>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas where categoria ='Especial'", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayRecetas.add(new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayRecetas;

    } //Fin de todas_las_recetas.

    public ObjetoRecetas traerPosicionRecetaEspecial(int posicion){

        Cursor c;

        ObjetoRecetas receta = new ObjetoRecetas();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                receta = new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return receta;

    }

    /*-----------------------------------------------------------------------------------------------------------------------*/

    public ArrayList<ObjetoRecetas> todas_las_recetas_sushi() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoRecetas> arrayRecetas = new ArrayList<ObjetoRecetas>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas where categoria ='Sushi'", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayRecetas.add(new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayRecetas;

    } //Fin de todas_las_recetas.

    public ObjetoRecetas traerPosicionRecetaSushi(int posicion){

        Cursor c;

        ObjetoRecetas receta = new ObjetoRecetas();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                receta = new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return receta;

    }

    /*-----------------------------------------------------------------------------------------------------------------------*/

    public ArrayList<ObjetoRecetas> todas_las_recetas_postre() {
        Cursor c;

        //Metodo que devuelve un cursos con todos las personas de la tabla persona.
        ArrayList<ObjetoRecetas> arrayRecetas = new ArrayList<ObjetoRecetas>();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas where categoria ='Postre'", null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                arrayRecetas.add(new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6)));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos el array.
        return arrayRecetas;

    } //Fin de todas_las_recetas.

    public ObjetoRecetas traerPosicionRecetaPostre(int posicion){

        Cursor c;

        ObjetoRecetas receta = new ObjetoRecetas();

        //Ejecutamos la cadena.
        c = database.rawQuery("SELECT * FROM recetas WHERE id=" + posicion, null);

        //Nos aseguramos de que existe al menos un registro.
        if(c.moveToFirst()){

            //Recorremos el cursor hasta que no haya más registros
            do{

                receta = new ObjetoRecetas(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getBlob(5), c.getString(6));

            }while(c.moveToNext());

        }

        //Cerramos el cursor.
        c.close();

        //Devolvemos la posicion.
        return receta;

    }

}

