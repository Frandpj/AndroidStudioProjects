package com.example.zafiro1.tiendavirtual2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.example.zafiro1.tiendavirtual2.R;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Creamos el toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Titulo.
        toolbar.setTitle("Tienda virtual");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.my_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    //método para insertar el menu en la actividad.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.nuevoCliente:
                Log.i("Nuevo Cliente", "Has pulsado nuevo cliente");
                break;
            case R.id.vistaSimple:
                Log.i("Vista Simple", "Has pulsado vista simple");
                break;
            case R.id.vistaCompleja:
                Log.i("Vista Compleja", "Has pulsado vista compleja");
                break;
            case R.id.modificar:
                Log.i("Modificar", "Has pulsado modificar");
                break;
        }//fin switch


        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)
}