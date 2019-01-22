package com.example.fdelp.concesionario.CochesUsados;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fdelp.concesionario.Adaptadores.AdaptadorCochesNuevos;
import com.example.fdelp.concesionario.Adaptadores.AdaptadorCochesUsados;
import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.CochesNuevos.CochesNuevos;
import com.example.fdelp.concesionario.CochesNuevos.ObjetoCochesNuevos;
import com.example.fdelp.concesionario.CochesNuevos.PulsarCochesNuevos;
import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class CochesUsados extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Creamos un atributo para controlar el ListView.
    private ListView listView;

    //Adaptador para el ListView.
    private AdaptadorCochesUsados adaptadorCochesUsados;

    //ArrayList para los elementos del listview de las CochesUsados.
    ArrayList<ObjetoCochesUsados> arrayCochesUsados = new ArrayList<ObjetoCochesUsados>();

    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coches_usados);

        //Se crea el toolbar
        Toolbar toolbarCochesUsados = (Toolbar) findViewById(R.id.toolbarCochesUsados);
        toolbarCochesUsados.setTitle("Coches usados");
        setSupportActionBar(toolbarCochesUsados);

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabCochesUsados);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent AnadirCochesUsados = new Intent(CochesUsados.this, com.example.fdelp.concesionario.CochesUsados.AnadirCochesUsados.class);
                startActivity(AnadirCochesUsados);
            }
        });

        //Listview para CochesUsados.
        this.listView = (ListView) findViewById(R.id.lvCochesUsados);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        arrayCochesUsados = databaseAccess.todos_los_coches_usados();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adaptadorCochesUsados = new AdaptadorCochesUsados(this, arrayCochesUsados);
        this.listView.setAdapter(adaptadorCochesUsados);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Obtengo el valor del string del elemento donde se hizo clic
                String itemValue = (String) listView.getItemAtPosition(position);

                //Con el fin de empezar a mostrar una nueva actividad lo que necesitamos es una intención
                Intent intent = new Intent(getApplicationContext(),PulsarCochesUsados.class);

                ObjetoCochesUsados cocheSeleccionado= arrayCochesUsados.get(position);
                int identificador= cocheSeleccionado.getId();

                intent.putExtra("id", identificador);
                //Aquí pasaremos el parámetro de la intención creada previamente.
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    //Actualiza la base de datos.
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        databaseAccess.open();
        arrayCochesUsados = databaseAccess.todos_los_coches_usados();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adaptadorCochesUsados = new AdaptadorCochesUsados(this, arrayCochesUsados);
        this.listView.setAdapter(adaptadorCochesUsados);
    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.cochesNuevos:
                Log.i("Coches nuevos", "Has pulsado en coches nuevos");
                Intent CochesNuevos = new Intent(CochesUsados.this, com.example.fdelp.concesionario.CochesNuevos.CochesNuevos.class);
                startActivity(CochesNuevos);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.cochesUsados:
                Log.i("Coches usados", "Has pulsado en coches usados");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Ya estas en esta ventana", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.extras:
                Log.i("Extras", "Has pulsado en extras");
                Intent Extras = new Intent(CochesUsados.this, com.example.fdelp.concesionario.Extras.Extras.class);
                startActivity(Extras);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.dondeEstamos:
                Log.i("Donde estamos", "Has pulsado en donde estamos");
                Intent DondeEstamos = new Intent(com.example.fdelp.concesionario.CochesUsados.CochesUsados.this, com.example.fdelp.concesionario.DondeEstamos.class);
                //Cierra la ventana que haya debajo
                startActivity(DondeEstamos);
                System.exit(0);
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)

}
