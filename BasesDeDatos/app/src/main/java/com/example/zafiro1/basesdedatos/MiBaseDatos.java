package com.example.zafiro1.basesdedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MiBaseDatos extends SQLiteOpenHelper {

    //Nuestra version de la base de datos.
    private static final int VERSION_BASEDATOS = 1;

    //Nombre de nuestro archivo de base de datos.
    private static final String NOMBRE_BASEDATOS = "mibasedatos.db";

    //Sentencia SQL para la creación de una tabla.
    private static final String TABLA_CONTACTOS = "CREATE TABLE contactos" +
            "(_id INT PRIMARY KEY, nombre TEXT, telefono INT, email TEXT)";

    //Constructor de la clase.
    public MiBaseDatos(Context context){
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(TABLA_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Metodos para insertar registros en la base de datos.
    public void insertarCONTACTO(int id, String nom, int tlf, String email){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("nombre", nom);
            valores.put("telefono", tlf);
            valores.put("email", email);
            db.insert("contactos", null, valores);
            db.close();
        }
    }

    //Recuperar un contacto.
    public Contactos recuperarCONTACTO(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "nombre", "telefono", "email"};
        Cursor c = db.query("contactos", valores_recuperar, "_id=" + id,
                null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Contactos contactos = new Contactos(c.getInt(0), c.getString(1),
                c.getInt(2), c.getString(3));
        db.close();
        c.close();
        return contactos;
    }

    //Modificar un registro.
    public void modificarCONTACTO(int id, String nom, int tlf, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("_id", id);
        valores.put("nombre", nom);
        valores.put("telefono", tlf);
        valores.put("email", email);
        db.update("contactos", valores, "_id=" + id, null);
        db.close();
    }

    //Borrar un registro.
    public void borrarCONTACTO(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("contactos", "_id="+id, null);
        db.close();
    }

    //Recuperar toda la lista.
    public List<Contactos> recuperarCONTACTOS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Contactos> lista_contactos = new ArrayList<Contactos>();
        String[] valores_recuperar = {"_id", "nombre", "telefono", "email"};
        Cursor c = db.query("contactos", valores_recuperar,
                null, null, null, null, null, null);
        c.moveToFirst();
        do {
            Contactos contactos = new Contactos(c.getInt(0), c.getString(1),
                    c.getInt(2), c.getString(3));
            lista_contactos.add(contactos);
        } while (c.moveToNext());
        db.close();
        c.close();
        return lista_contactos;
    }


}
