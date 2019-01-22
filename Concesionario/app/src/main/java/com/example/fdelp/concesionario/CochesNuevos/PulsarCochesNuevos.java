package com.example.fdelp.concesionario.CochesNuevos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.CochesUsados.CochesUsados;
import com.example.fdelp.concesionario.CochesUsados.PulsarCochesUsados;
import com.example.fdelp.concesionario.Principal;
import com.example.fdelp.concesionario.R;

import java.text.DecimalFormat;

public class PulsarCochesNuevos extends AppCompatActivity {

    //Variables.
    EditText edtMarcaPulsarCochesNuevos, edtModeloPulsarCochesNuevos, edtPrecioPulsarCochesNuevos, edtDescripcionPulsarCochesNuevos;
    ImageView imgPulsarCochesNuevos;
    DecimalFormat precision;
    private DatabaseAccess database;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulsar_coches_nuevos);

        //Convierte a decimal.
        precision = new DecimalFormat("0.000");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarPulsarCochesNuevos);
        toolbar.setTitle("Información adicional del coche");
        setSupportActionBar(toolbar); //Se crea el toolbar

        edtMarcaPulsarCochesNuevos=(EditText)findViewById(R.id.edtMarcaPulsarCochesNuevos);
        edtModeloPulsarCochesNuevos=(EditText)findViewById(R.id.edtModeloPulsarCochesNuevos);
        imgPulsarCochesNuevos=(ImageView)findViewById(R.id.imgPulsarCochesNuevos);
        edtPrecioPulsarCochesNuevos=(EditText)findViewById(R.id.edtPrecioPulsarCochesNuevos);
        edtDescripcionPulsarCochesNuevos=(EditText)findViewById(R.id.edtDescripcionPulsarCochesNuevos);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        pulsarCargarCoche();

        habilitarModificar(false);

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabGuardarPulsarCochesNuevos);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                guardarCocheNuevo();

                finish();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_anadir_coche_nuevo, menu);
        return true;
    }

    //Carga los datos del coche en los EditText.
    public void pulsarCargarCoche(){

        //Nos traemos la base de datos y la abrimos.
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        ObjetoCochesNuevos dir = databaseAccess.traerPosicion(id);
        databaseAccess.close();
        edtMarcaPulsarCochesNuevos.setText(String.valueOf(dir.getMarca()));
        edtModeloPulsarCochesNuevos.setText(String.valueOf(dir.getModelo()));
        imgPulsarCochesNuevos.setImageBitmap(BitmapFactory.decodeByteArray( dir.getImagen(),
                0,dir.getImagen().length));
        edtPrecioPulsarCochesNuevos.setText(String.valueOf(precision.format(dir.getPrecio())));
        edtDescripcionPulsarCochesNuevos.setText(String.valueOf(dir.getDescripcion()));

    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.modificar:
                Log.i("Modificar", "Has pulsado en modificar");
                habilitarModificar(true);

                break;
            case R.id.eliminar:
                Log.i("Eliminar", "Has pulsado en eliminar");
                AlertDialog.Builder builder = new AlertDialog.Builder(PulsarCochesNuevos.this);
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
                        guardarEliminarCocheNuevo();
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Eliminado correctamente", Toast.LENGTH_SHORT);
                        toast1.show();
                        finish();
                    }
                });
                builder.show();
                break;
            case R.id.generarPresupuesto:
                Log.i("Generar presupuesto", "Has pulsado en generar presupuesto");
                Intent PulsarCochesNuevos = new Intent(PulsarCochesNuevos.this, com.example.fdelp.concesionario.Extras.SeleccionarExtras.class);
                startActivity(PulsarCochesNuevos);
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)

    //Metodo que habilita o deshabilita los editText.
    public void habilitarModificar(boolean habilitar){

        if(habilitar == false){

            edtMarcaPulsarCochesNuevos.setEnabled(false);
            edtModeloPulsarCochesNuevos.setEnabled(false);
            edtPrecioPulsarCochesNuevos.setEnabled(false);
            edtDescripcionPulsarCochesNuevos.setEnabled(false);

        }
        if(habilitar == true){

            edtMarcaPulsarCochesNuevos.setEnabled(true);
            edtModeloPulsarCochesNuevos.setEnabled(true);
            edtPrecioPulsarCochesNuevos.setEnabled(true);
            edtDescripcionPulsarCochesNuevos.setEnabled(true);

        }

    }

    //Guarda los resultados de modificar.
    public void guardarCocheNuevo(){

        ObjetoCochesNuevos nuevoCoche = new ObjetoCochesNuevos();

        nuevoCoche.setId(id);
        nuevoCoche.setMarca(edtMarcaPulsarCochesNuevos.getText().toString());
        nuevoCoche.setModelo(edtModeloPulsarCochesNuevos.getText().toString());
        nuevoCoche.setPrecio(Float.parseFloat(edtPrecioPulsarCochesNuevos.getText().toString()));
        nuevoCoche.setDescripcion(edtDescripcionPulsarCochesNuevos.getText().toString());

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.actualizarCocheNuevo(nuevoCoche);
        databaseAccess.close();

        setResult(RESULT_OK , null);


    }

    //Guarda los resultados al eliminar.
    public void guardarEliminarCocheNuevo(){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.eliminarCocheNuevo(id);
        databaseAccess.close();

        setResult(RESULT_OK , null);


    }

}
