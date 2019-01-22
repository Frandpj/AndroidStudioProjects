package com.example.zafiro1.tiendavirtual;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaramos.el.toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cliente");
        setSupportActionBar(toolbar);

        //boton flotante
        FloatingActionButton fab = findViewById(R.id.cargar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        }); }

    // Método para insertar el menu en la actividad
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

        switch (id)
        {
            case R.id.menu_crear:
                Log.i("Nuevo cliente", "Has pulsado nuevo cliente");
                break;
            case R.id.menu_simple:
                Log.i("Busqueda título", "Has pulsado Búsqueda título");
                break;
            case R.id.menu_completo:
                Log.i("Recargar", "Has pulsado nuevo recargar");
                break;
            case R.id.menu_modificar:
                Log.i("Modificar", "Has pulsado modificar");
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)
}