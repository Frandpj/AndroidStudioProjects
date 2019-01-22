package com.example.miguel.basealistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by miguel on 30/10/18.
 */

public class ControladorBaseDatos extends SQLiteOpenHelper {

    //creamos un controlador de la base de datos


    //atributos para el diseño de la base de datos
    //version
    private static final int VERSION_BASEDATOS = 1;

    // Nombre de nuestro archivo de base de datos
    private static final String NOMBRE_BASEDATOS = "basealistview.db";

    // Sentencia SQL para la creación de una tabla
   /* private static final String CREAR_TABLA = "CREATE TABLE libros" +
            "(_codigo_libro INT IDENTITY(100,1) NOT FOR REPLICATION PRIMARY KEY, titulo_libro TEXT, autor_libro TEXT)";
*/
    private static final String CREAR_TABLA = "CREATE TABLE libros" +
            "(codigo_libro INT PRIMARY KEY, titulo_libro TEXT, autor_libro TEXT)";

    //definimos un cursor que será usado en todas las consultas e incluso devuelto
    Cursor c;

    // CONSTRUCTOR de la clase
    public ControladorBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);

    }

    //métodos que hay que redefinir extendidos de SQLiteOpenHelper
    @Override //método que se ejecuta si la base de datos no existe
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override //método que se ejecuta si la base existe y además la versión es anterior
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREAR_TABLA);
        onCreate(db);
    }
    //método que devuelve el número que libros que tiene registrados la tabla libros
    int numero_de_libros()
    {
        Cursor c;
        //controlador
        SQLiteDatabase db = getReadableDatabase();
        //definimos el cursor

        int numero_libros=0;
        //definimos la sentencia sql en una cadena

        String[] valores_recuperar = {"codigo_libro", "titulo_libro", "autor_libro"};
        //Ejecutamos la cadena
         c = db.query("libros", valores_recuperar,null, null, null, null, null, null);

        if(c!=null) {
            numero_libros = c.getCount();
        }

        //cerramos el cursor y el SQLiteDatabase
        c.close();
        db.close();
        //devolvemos el numero de libros
        return numero_libros;


    }//fin numero_de_libros

    //metodo que devuelve un cursor con todos los libros de la tabla libros
    ArrayList<RellenarListView> todos_los_libros()
    {
        Cursor c;
        //Array donde se devuelven todos los libros
        ArrayList<RellenarListView> arrayLibros = new ArrayList<RellenarListView>();

        //controlador
        SQLiteDatabase db = getReadableDatabase();

        //definimos la sentencia sql en una cadena
        String[] valores_recuperar = {"codigo_libro", "titulo_libro", "autor_libro"};

        //Ejecutamos la cadena
       // c = db.query("libros", valores_recuperar,null, null, null, null, null, null);
        c = db.rawQuery(" SELECT * FROM libros ", null);

        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                arrayLibros.add(new RellenarListView(c.getInt(0),c.getString(1),c.getString(2)));
                int codigo= c.getInt(0);
                String nombre = c.getString(1);
            } while(c.moveToNext());
        }
        //cerramos el cursor y el SQLiteDatabase
        c.close();
        db.close();
        //devolvemos el cursor
        return arrayLibros;


    }//fin numero_de_libros


    //métodos para realizar operaciones sobre la base de datos
    //insertar un nuevo libro
    public void insertarLibro(Libro nuevo_libro) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("codigo_libro", nuevo_libro.getCodigo_libro());
            valores.put("titulo_libro", nuevo_libro.getTitulo_libro());
            valores.put("autor_libro", nuevo_libro.getAutor_libro());
            //insertamos en la base de datos en la tabla libros
            db.insert("libros", null, valores);
            db.close();
        }
    }//fin de insertar libro

    //método para eliminar un elemento de la base de datos
    void eliminar_libro(int codigo)
    {

        //controlador
        SQLiteDatabase db = getWritableDatabase();
       String[] args = new String[]{String.valueOf(codigo)};
        db.execSQL("DELETE FROM libros WHERE codigo_libro=?", args);
        //return db.delete("libros", "codigo_libro=" + codigo, null);

    }

}//final de la clase