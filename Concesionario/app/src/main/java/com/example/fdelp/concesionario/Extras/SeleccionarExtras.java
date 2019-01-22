package com.example.fdelp.concesionario.Extras;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fdelp.concesionario.Adaptadores.AdaptadorExtras;
import com.example.fdelp.concesionario.BasesDatos.DatabaseAccess;

import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class SeleccionarExtras extends AppCompatActivity {

    //Creamos un atributo para controlar el ListView.
    private ListView listView;

    //Adaptador para el ListView.
    private AdaptadorExtras adaptadorExtras;

    //ArrayList para los elementos del listview de las CochesNuevos.
    ArrayList<ObjetoExtras> arrayExtras = new ArrayList<ObjetoExtras>();

    DatabaseAccess databaseAccess;

    TextView txvSumarPrecio;

    private float sumaPrecio = 0;

    private boolean extraSelec = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionar_extras);

        txvSumarPrecio = (TextView) findViewById(R.id.txvSumarPrecio);
        //Se crea el toolbar
        Toolbar toolbarSeleccionarExtras = (Toolbar) findViewById(R.id.toolbarSeleccionarExtras);
        toolbarSeleccionarExtras.setTitle("Seleccionar extras");
        setSupportActionBar(toolbarSeleccionarExtras);

        //Boton flotante.
        FloatingActionButton fab = findViewById(R.id.fabSeleccionarExtras);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Procesando...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent SeleccionarExtras = new Intent(SeleccionarExtras.this, com.example.fdelp.concesionario.CochesNuevos.GenerarPresupuestoCochesNuevos.class);
                startActivity(SeleccionarExtras);

            }
        });

        //Listview para extras.
        this.listView = (ListView) findViewById(R.id.lvSeleccionarExtra);

        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        arrayExtras = databaseAccess.todos_los_extras();

        databaseAccess.close();

        //Cargamos el arraylist en el listview usando el adaptador y la clase que lo infla.
        adaptadorExtras = new AdaptadorExtras(this, arrayExtras);
        this.listView.setAdapter(adaptadorExtras);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        //Pulsamos el listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Obtengo el valor del string del elemento donde se hizo clic
                String itemValue = (String) listView.getItemAtPosition(position);

                ObjetoExtras extraSeleccionado= arrayExtras.get(position);

                if(extraSelec == false){
                    extraSelec = true;

                    if(extraSelec == true){
                        view.setBackgroundColor(Color.GRAY);
                        sumaPrecio = sumaPrecio + extraSeleccionado.getPrecio();
                        txvSumarPrecio.setText(Float.toString(sumaPrecio));
                    }
                }
                else{
                    view.setBackgroundColor(Color.alpha(0));
                    sumaPrecio = sumaPrecio - extraSeleccionado.getPrecio();
                    txvSumarPrecio.setText(Float.toString(sumaPrecio));
                    extraSelec = false;
                }
            }
        });

    }



}
