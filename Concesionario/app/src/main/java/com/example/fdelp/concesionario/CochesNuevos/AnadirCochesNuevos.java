package com.example.fdelp.concesionario.CochesNuevos;

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

import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.R;

import java.io.ByteArrayOutputStream;

public class AnadirCochesNuevos extends AppCompatActivity {

        ImageView imgAnadirCochesNuevos;
        EditText edtMarcaAnadirCochesNuevos, edtModeloAnadirCochesNuevos, edtPrecioAnadirCochesNuevos, edtDescripcionAnadirCochesNuevos;
        private int id;
        private  Bitmap bitmap;
        private byte[] imagen;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_anadir_coches_nuevos);

            imgAnadirCochesNuevos =  findViewById(R.id.imgAnadirCochesNuevos);
            edtMarcaAnadirCochesNuevos = findViewById(R.id.edtMarcaAnadirCochesNuevos);
            edtModeloAnadirCochesNuevos = findViewById(R.id.edtModeloAnadirCochesNuevos);
            edtPrecioAnadirCochesNuevos = findViewById(R.id.edtPrecioAnadirCochesNuevos);
            edtDescripcionAnadirCochesNuevos = findViewById(R.id.edtDescripcionAnadirCochesNuevos);

            Intent intent = getIntent();
            id = intent.getIntExtra("id", 0);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAnadirCochesNuevos);
            toolbar.setTitle("Añadir coches nuevos");
            setSupportActionBar(toolbar); //Se crea el toolbar

            //Boton flotante.
            FloatingActionButton fab = findViewById(R.id.fabGuardarAnadirCochesNuevos);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    insertarCocheNuevo();

                    finish();

                }
            });

        }



        //Metodo para clickar en el boton para seleccionar imagen.
        public void onClickBtnAnadirCochesNuevos(View view) {

            cargarImagen();

        }

        //Metodo que carga la aplicación de galeria.
        private void cargarImagen(){

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/");
            startActivityForResult(intent.createChooser(intent, "Seleccione la aplicación"), 10);

        }

        //Metodo que trae la imagen de la galeria y la saca en un imageView.
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK){
                Uri path = data.getData();
                imgAnadirCochesNuevos.setImageURI(path);

                //Pasar a mapa de bits
                bitmap = imgAnadirCochesNuevos.getDrawingCache();
            }

        }

        public void insertarCocheNuevo(){

            String marca, modelo, descripcion;
            float precio;

            //Tamaño del baos depende del tamaño de tus imagenes en promedio.
            bitmap = ((BitmapDrawable) imgAnadirCochesNuevos.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100 , baos);
            imagen = baos.toByteArray();

            marca = this.edtMarcaAnadirCochesNuevos.getText().toString();
            modelo = this.edtModeloAnadirCochesNuevos.getText().toString();
            precio = Float.valueOf(this.edtPrecioAnadirCochesNuevos.getText().toString());
            descripcion = this.edtDescripcionAnadirCochesNuevos.getText().toString();

            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
            databaseAccess.open();
            databaseAccess.insertarCocheNuevo(marca, modelo, imagen, precio, descripcion);
            databaseAccess.close();

            setResult(RESULT_OK , null);

        }

    }
