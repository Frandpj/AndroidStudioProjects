package com.example.zafiro1.biblioteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos  extends SQLiteOpenHelper {

    //Nuestra version de la base de datos.
    private static final int VERSION_BASEDATOS = 1;

    //Nombre de nuestro archivo de base de datos.
    private static final String NOMBRE_BASEDATOS = "biblioteca.db";

    //Sentencia SQL para la creación de una tabla.
    private static final String TABLA_LIBROS = "CREATE TABLE libros" +
            "(codigo INT PRIMARY KEY AUTOINCREMENT, titulo STRING, autor STRING, descripcion STRING)";

    //Constructor de la clase.
    public BaseDatos(Context context){
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_LIBROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Metodos para insertar registros en la base de datos.
    public void insertarLIBRO(int codigo, String titulo, String autor, String descripcion) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("codigo", codigo);
            valores.put("titulo", titulo);
            valores.put("autor", autor);
            valores.put("descripcion", descripcion);
            db.insert("libros", null, valores);
            db.close();
        }

    }

    //Recuperar un contacto.
    public Libros recuperarLIBRO(int codigo) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"codigo", "titulo", "autor", "descripcion"};
        Cursor c = db.query("libros", valores_recuperar, "codigo=" + codigo,
                null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Libros libros = new Libros(c.getInt(0), c.getString(1),
                c.getString(2), c.getString(3));
        db.close();
        c.close();
        return libros;
    }

}
