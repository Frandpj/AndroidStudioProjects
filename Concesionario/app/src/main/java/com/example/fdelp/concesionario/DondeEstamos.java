package com.example.fdelp.concesionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fdelp.concesionario.CochesNuevos.CochesNuevos;
import com.example.fdelp.concesionario.Extras.Extras;

public class DondeEstamos extends AppCompatActivity {

    Button btnAbrirMapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donde_estamos);

        btnAbrirMapa = (Button) findViewById(R.id.btnAbrirMapa);

        btnAbrirMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent DondeEstamos = new Intent(DondeEstamos.this, com.example.fdelp.concesionario.Mapa.class);
                startActivity(DondeEstamos);

            }
        });

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

        switch (id) {
            case R.id.cochesNuevos:
                Log.i("Coches nuevos", "Has pulsado en coches nuevos");
                Intent CochesNuevos = new Intent(DondeEstamos.this, com.example.fdelp.concesionario.CochesNuevos.CochesNuevos.class);
                startActivity(CochesNuevos);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.cochesUsados:
                Log.i("Coches usados", "Has pulsado en coches usados");
                Intent CochesUsados = new Intent(DondeEstamos.this, com.example.fdelp.concesionario.CochesUsados.CochesUsados.class);
                startActivity(CochesUsados);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.extras:
                Log.i("Extras", "Has pulsado en extras");
                Intent Extras = new Intent(DondeEstamos.this, com.example.fdelp.concesionario.Extras.Extras.class);
                startActivity(Extras);
                //Cierra la ventana que haya debajo
                System.exit(0);
                break;
            case R.id.dondeEstamos:
                Log.i("Donde estamos", "Has pulsado en donde estamos");
                Toast toast1 =
                        Toast.makeText(getApplicationContext(),
                                "Ya estas en esta ventana", Toast.LENGTH_SHORT);
                toast1.show();
                break;
        }//fin switch

        return super.onOptionsItemSelected(item);
    }//fin del método nOptionsItemSelected(MenuItem item)
}
