package com.example.fdelp.concesionario.Extras;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.fdelp.concesionario.Adaptadores.AdaptadorExtras;
import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;
import com.example.fdelp.concesionario.CochesNuevos.AnadirCochesNuevos;
import com.example.fdelp.concesionario.CochesNuevos.CochesNuevos;
import com.example.fdelp.concesionario.CochesNuevos.ObjetoCochesNuevos;
import com.example.fdelp.concesionario.CochesNuevos.PulsarCochesNuevos;
import com.example.fdelp.concesionario.CochesUsados.CochesUsados;
import com.example.fdelp.concesionario.CochesUsados.ObjetoCochesUsados;
import com.example.fdelp.concesionario.CochesUsados.PulsarCochesUsados;
import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class Extras extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Creamos un atributo para controlar el ListView.
    private ListView listView;

    //Adaptador para el ListView.
    private AdaptadorExtras adaptadorExtras;

    //ArrayList para los elementos del listview de las CochesUsados.
    ArrayList<ObjetoExtras> arrayExtras = new ArrayList<ObjetoExtras>();

    DatabaseAccess databaseAccess;
    private int identificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);

        //Se crea el toolbar
        Toolbar toolbarExtras = (Toolbar) findViewById(R.id.toolbarExtras);
        toolbarExtras.setTitle("Extras");
        setSupportActionBar(toolbarExtras);

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabExtras);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent AnadirExtras = new Intent(Extras.this, com.example.fdelp.concesionario.Extras.AnadirExtras.class);
                startActivity(AnadirExtras);
            }
        });

        //Listview para CochesUsados.
        this.listView = (ListView) findViewById(R.id.lvExtras);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        arrayExtras = databaseAccess.todos_los_extras();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adaptadorExtras = new AdaptadorExtras(this, arrayExtras);
        this.listView.setAdapter(adaptadorExtras);

        //Pulsamos el listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Obtengo el valor del string del elemento donde se hizo clic
                String itemValue = (String) listView.getItemAtPosition(position);


                ObjetoExtras extraSeleccionado= arrayExtras.get(position);
                identificador= extraSeleccionado.getId();

                pulsarExtras();


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
        arrayExtras = databaseAccess.todos_los_extras();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adaptadorExtras = new AdaptadorExtras(this, arrayExtras);
        this.listView.setAdapter(adaptadorExtras);
    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.cochesNuevos:
                Log.i("Coches nuevos", "Has pulsado en coches nuevos");
                Intent CochesNuevos = new Intent(Extras.this, com.example.fdelp.concesionario.CochesNuevos.CochesNuevos.class);
                startActivity(CochesNuevos);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.cochesUsados:
                Log.i("Coches usados", "Has pulsado en coches usados");
                Intent CochesUsados = new Intent(Extras.this, com.example.fdelp.concesionario.CochesUsados.CochesUsados.class);
                startActivity(CochesUsados);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.extras:
                Log.i("Extras", "Has pulsado en extras");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Ya estas en esta ventana", Toast.LENGTH_SHORT);
                toast1.show();
                break;
            case R.id.dondeEstamos:
                Log.i("Donde estamos", "Has pulsado en donde estamos");
                Intent DondeEstamos = new Intent(Extras.this, com.example.fdelp.concesionario.DondeEstamos.class);
                //Cierra la ventana que haya debajo
                startActivity(DondeEstamos);
                System.exit(0);
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)

    public void pulsarExtras(){

        Log.i("Eliminar", "Has pulsado en eliminar");
        AlertDialog.Builder builder = new AlertDialog.Builder(Extras.this);
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
                guardarEliminarExtras();
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Eliminado correctamente", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
        builder.show();

    }

    //Guarda los resultados al eliminar.
    public void guardarEliminarExtras(){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        databaseAccess.eliminarExtras(identificador);
        databaseAccess.close();

        setResult(RESULT_OK , null);


    }

}
