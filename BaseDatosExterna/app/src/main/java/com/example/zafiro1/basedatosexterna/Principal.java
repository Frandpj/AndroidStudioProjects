package com.example.zafiro1.basedatosexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Principal extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Creamos un atributo para controlar el ListView.
    private ListView listView;

    //Adaptadores para el ListView uno por cada cosa nueva que se muestra.
    private Adaptador adapter;
    private Adaptador2 adapter2;
    private Adaptador3 adapter3;

    //ArrayList para los elementos del listview de las personas, articulos y articulos relacionales.
    ArrayList<Persona> arrayPersona = new ArrayList<Persona>();
    ArrayList<Articulo> arrayArticulo = new ArrayList<Articulo>();
    ArrayList<ArticuloRelacional> arrayArticuloRelacional = new ArrayList<ArticuloRelacional>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Listview.
        this.listView = (ListView) findViewById(R.id.listview);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        //Enlazamos los arrays con los metodos.
       arrayPersona = databaseAccess.todas_las_personas();
       arrayArticulo = databaseAccess.todos_los_articulos();
       arrayArticuloRelacional = databaseAccess.todos_los_articulos_relacionales();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adapter = new Adaptador(this, arrayPersona);
        this.listView.setAdapter(adapter);

        // Declaramos.el.toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Listado");
        setSupportActionBar(toolbar);

    } //Fin del Oncreate.

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
            case R.id.personas:
                Log.i("Listado de personas", "Has pulsado personas");

                //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
                adapter = new Adaptador(this, arrayPersona);
                this.listView.setAdapter(adapter);

                break;
            case R.id.articulos:
                Log.i("Listado de articulos", "Has pulsado articulos");

                //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
                adapter2 = new Adaptador2(this, arrayArticulo);
                this.listView.setAdapter(adapter2);

                break;
            case R.id.articulosRelacional:
                Log.i("Listado de artRel", "Has pulsado articulos relacionales");

                //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
                adapter3 = new Adaptador3(this, arrayArticuloRelacional);
                this.listView.setAdapter(adapter3);

                break;
        }//fin switch




        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
