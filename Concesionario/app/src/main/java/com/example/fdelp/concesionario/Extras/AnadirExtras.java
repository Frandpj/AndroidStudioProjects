package com.example.fdelp.concesionario.Extras;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.R;

import java.io.ByteArrayOutputStream;

public class AnadirExtras extends AppCompatActivity {

    EditText edtNombreAnadirExtras, edtDescripcionAnadirExtras, edtPrecioAnadirExtras;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_extras);

        edtNombreAnadirExtras =  findViewById(R.id.edtNombreAnadirExtras);
        edtPrecioAnadirExtras = findViewById(R.id.edtPrecioAnadirExtras);
        edtDescripcionAnadirExtras = findViewById(R.id.edtDescripcionAnadirExtras);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAnadirExtras);
        toolbar.setTitle("Añadir extras");
        setSupportActionBar(toolbar); //Se crea el toolbar

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabGuardarAnadirExtras);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Insertado con exito", Toast.LENGTH_SHORT);
                toast1.show();

                insertarExtras();

                finish();

            }
        });

    }

    //Metodo que trae la imagen de la galeria y la saca en un imageView.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);

    }

    public void insertarExtras(){

        String nombre, descripcion;
        float precio;


        nombre = this.edtNombreAnadirExtras.getText().toString();
        precio = Float.valueOf(this.edtPrecioAnadirExtras.getText().toString());
        descripcion = this.edtDescripcionAnadirExtras.getText().toString();


        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.insertarExtras(nombre, precio, descripcion);
        databaseAccess.close();

        setResult(RESULT_OK , null);

    }

}
