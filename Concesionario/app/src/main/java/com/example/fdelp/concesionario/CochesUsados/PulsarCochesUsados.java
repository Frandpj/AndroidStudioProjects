package com.example.fdelp.concesionario.CochesUsados;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.CochesNuevos.ObjetoCochesNuevos;
import com.example.fdelp.concesionario.R;

import java.text.DecimalFormat;

public class PulsarCochesUsados extends AppCompatActivity {

    //Variables.
    EditText edtMarcaPulsarCochesUsados, edtModeloPulsarCochesUsados, edtPrecioPulsarCochesUsados, edtDescripcionPulsarCochesUsados;
    ImageView imgPulsarCochesUsados;
    DecimalFormat precision;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsar_coches_usados);

        //Convierte a decimal.
        precision = new DecimalFormat("0.000");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPulsarCochesUsados);
        toolbar.setTitle("Información adicional del coche");
        setSupportActionBar(toolbar); //Se crea el toolbar

        edtMarcaPulsarCochesUsados=(EditText)findViewById(R.id.edtMarcaPulsarCochesUsados);
        edtModeloPulsarCochesUsados=(EditText)findViewById(R.id.edtModeloPulsarCochesUsados);
        imgPulsarCochesUsados=(ImageView)findViewById(R.id.imgPulsarCochesUsados);
        edtPrecioPulsarCochesUsados=(EditText)findViewById(R.id.edtPrecioPulsarCochesUsados);
        edtDescripcionPulsarCochesUsados=(EditText)findViewById(R.id.edtDescripcionPulsarCochesUsados);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        pulsarCargarCoche();

        habilitarModificar(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_anadir_coche_usado, menu);
        return true;
    }

    //Carga los datos del coche en los EditText.
    public void pulsarCargarCoche(){

        //Nos traemos la base de datos y la abrimos.
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        ObjetoCochesUsados dir = databaseAccess.traerPosicion1(id);
        databaseAccess.close();

        edtMarcaPulsarCochesUsados.setText(String.valueOf(dir.getMarca()));
        edtModeloPulsarCochesUsados.setText(String.valueOf(dir.getModelo()));
        imgPulsarCochesUsados.setImageBitmap(BitmapFactory.decodeByteArray( dir.getImagen(),
                0,dir.getImagen().length));
        edtPrecioPulsarCochesUsados.setText(String.valueOf(precision.format(dir.getPrecio())));
        edtDescripcionPulsarCochesUsados.setText(String.valueOf(dir.getDescripcion()));

    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.eliminar:
                Log.i("Eliminar", "Has pulsado en eliminar");
                AlertDialog.Builder builder = new AlertDialog.Builder(PulsarCochesUsados.this);
                //Escribimos el título
                builder.setTitle("Eliminar registro");
                //Escribimos la pregunta
                builder.setMessage("¿Quieres eliminar el registro?");
                //Añadimos el botón de No y su acción asociada
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //Añadimos el botón de Si y su acción asociada
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        guardarEliminarCocheUsado();
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Eliminado correctamente", Toast.LENGTH_SHORT);
                        toast1.show();
                        finish();
                    }
                });
                builder.show();
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)

    //Metodo que habilita o deshabilita los editText.
    public void habilitarModificar(boolean habilitar){

        if(habilitar == false){

            edtMarcaPulsarCochesUsados.setEnabled(false);
            edtModeloPulsarCochesUsados.setEnabled(false);
            edtPrecioPulsarCochesUsados.setEnabled(false);
            edtDescripcionPulsarCochesUsados.setEnabled(false);

        }
        if(habilitar == true){

            edtMarcaPulsarCochesUsados.setEnabled(true);
            edtModeloPulsarCochesUsados.setEnabled(true);
            edtPrecioPulsarCochesUsados.setEnabled(true);
            edtDescripcionPulsarCochesUsados.setEnabled(true);

        }

    }

    public void guardarEliminarCocheUsado(){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.eliminarCocheUsado(id);
        databaseAccess.close();

        setResult(RESULT_OK , null);

    }

}
