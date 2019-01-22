package com.example.fdelp.concesionario.CochesUsados;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.R;

import java.io.ByteArrayOutputStream;

public class AnadirCochesUsados extends AppCompatActivity {

    Button btnAnadirCochesUsados;
    ImageView imgAnadirCochesUsados;
    EditText edtMarcaAnadirCochesUsados, edtModeloAnadirCochesUsados, edtPrecioAnadirCochesUsados, edtDescripcionAnadirCochesUsados;
    private int id;
    private Bitmap bitmap;
    private byte[] imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_coches_usados);

        imgAnadirCochesUsados =  findViewById(R.id.imgAnadirCochesUsados);
        edtMarcaAnadirCochesUsados = findViewById(R.id.edtMarcaAnadirCochesUsados);
        edtModeloAnadirCochesUsados = findViewById(R.id.edtModeloAnadirCochesUsados);
        edtPrecioAnadirCochesUsados = findViewById(R.id.edtPrecioAnadirCochesUsados);
        edtDescripcionAnadirCochesUsados = findViewById(R.id.edtDescripcionAnadirCochesUsados);

        btnAnadirCochesUsados = (Button) findViewById(R.id.btnAnadirCochesUsados);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarAnadirCochesUsados);
        toolbar.setTitle("Añadir coches usados");
        setSupportActionBar(toolbar); //Se crea el toolbar

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabGuardarAnadirCochesUsados);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Insertado con exito", Toast.LENGTH_SHORT);
                toast1.show();
                insertarCocheUsado();
                finish();
            }
        });


        btnAnadirCochesUsados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(verPermisosCamara()) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                }
            }
        });


    }

    public void insertarCocheUsado(){

        String marca, modelo, descripcion;
        float precio;

        marca = this.edtMarcaAnadirCochesUsados.getText().toString();
        modelo = this.edtModeloAnadirCochesUsados.getText().toString();
        precio = Float.valueOf(this.edtPrecioAnadirCochesUsados.getText().toString());
        descripcion = this.edtDescripcionAnadirCochesUsados.getText().toString();

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.insertarCocheUsado(marca, modelo, imagen, precio, descripcion);
        databaseAccess.close();

        setResult(RESULT_OK , null);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // SI EL CÓDIGO RE PETICIÓN ES 0, LA IMAGEN VIENE DE LA CÁMARA DE FOTOS.
        if (requestCode == 0) {
            // CREAMOS UN MAPA DE BITS CON LOS DATOS QUE HEMOS RECOGIDO DE LA CÁMARA DE FOTOS.
            Bitmap bitmap = null;
            if(data!=null) {
                bitmap = (Bitmap) data.getExtras().get("data");
            }
            // PONEMOS EL MAPA DE BITS EN EL IMAGEVIEW.
            imgAnadirCochesUsados.setImageBitmap(bitmap);
            // CREAMOS UN ARRAY DE BYTES DE SALIDA.
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            // COMPRIMIMOS EL MAPA DE BITS EN PNG Y LA VARIABLE FOTO_COCHE TOMA EL VALOR DEL FLUJO DE SALIDA DE ARRAY DE BYTES.
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            imagen = stream.toByteArray();
        }
    }

    // MÉTODO PARA COMPROBAR LOS PERMISOS DE LA CÁMARA.
    private boolean verPermisosCamara() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No tienes permisos para usar la camara.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 225);
            return false;
        } else {
            Log.i("Mensaje", "Tienes permisos para usar la camara.");
            return true;
        }
    }


}
