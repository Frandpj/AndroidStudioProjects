package com.example.fdelp.concesionario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fdelp.concesionario.Extras.Extras;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Se crea el toolbar
        Toolbar toolbarPrincipal = (Toolbar) findViewById(R.id.toolbarPrincipal);
        toolbarPrincipal.setTitle("Concesionario del Pino");
        setSupportActionBar(toolbarPrincipal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    //método para controlar la acción que se pulsa sobre un menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
            case R.id.cochesNuevos:
                Log.i("Coches nuevos", "Has pulsado en coches nuevos");
                Intent CochesNuevos = new Intent(Principal.this, com.example.fdelp.concesionario.CochesNuevos.CochesNuevos.class);
                startActivity(CochesNuevos);
                break;
            case R.id.cochesUsados:
                Log.i("Coches usados", "Has pulsado en coches usados");
                Intent CochesUsados = new Intent(Principal.this, com.example.fdelp.concesionario.CochesUsados.CochesUsados.class);
                startActivity(CochesUsados);
                break;
            case R.id.extras:
                Log.i("Extras", "Has pulsado en extras");
                Intent Extras = new Intent(Principal.this, com.example.fdelp.concesionario.Extras.Extras.class);
                startActivity(Extras);
                break;
            case R.id.dondeEstamos:
                Log.i("Donde estamos", "Has pulsado en donde estamos");
                Intent DondeEstamos = new Intent(Principal.this, com.example.fdelp.concesionario.DondeEstamos.class);
                startActivity(DondeEstamos);
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)


}
