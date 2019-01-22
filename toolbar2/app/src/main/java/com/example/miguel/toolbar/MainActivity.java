package com.example.miguel.toolbar;
/*
* Pasos para agregar una ToolBar a una actividad
* Primero: Agregar una ToolBar al xml asociado a la actividad
* Segundo: En el archivo java: agregar el import
*          android.support.v7.widget.Toolbar  importante
  *        no es igual que android.view.Toolbar
  Tercero: Agregar el import
           android.support.v7.app.AppCompatActivity
  Cuarto: Agregar la barra al java
  Quinto: Crear una nueva carpeta llamada menu dentro de res
  Sexto: Crear un nuevo menu dentro de esta carpeta
  Séptimo: Inflar el menú en el java
  Octavo: Configurar las opciones al pulsar en el menú

  Para el FloatingActionButton
  Agregar en el archivo build.gradle(module:app) la siguiente línea
  implementation 'com.android.support:design:26.1.0'
  */
import android.os.Build;
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

import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting the title
        toolbar.setTitle("Mi Toolbar");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);

        //boton flotante
        FloatingActionButton fab = findViewById(R.id.my_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        }); }

    //método para insertar el menu en la actividad
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
            case R.id.menu_nuevo_libro:
                Log.i("Nuevo Libro", "Has pulsado nuevo libro");
                break;
            case R.id.menu_busqueda_titulo:
                Log.i("Busqueda título", "Has pulsado Búsqueda título");
                break;
            case R.id.menu_recargar:
                Log.i("Recargar", "Has pulsado nuevo recargar");
                break;
            case R.id.menu_configuracion:
                Log.i("Configuración", "Has pulsado configuración");
                break;
            case R.id.menu_about:
                Log.i("Sobre Toolbar", "Has pulsado Sobre Toolbar");
                break;
        }//fin switch




        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)
}