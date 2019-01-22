package com.example.fran_dpj.lolgg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Analisis extends AppCompatActivity {

    Bundle nombre, pasiva, habilidad1, habilidad2, habilidad3, habilidad4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analisis);

        TextView nombreCampeon, p, q, w, e, r;

        nombreCampeon=(TextView)findViewById(R.id.nombreCampeon);
        p=(TextView)findViewById(R.id.p);
        q=(TextView)findViewById(R.id.q);
        w=(TextView)findViewById(R.id.w);
        e=(TextView)findViewById(R.id.e);
        r=(TextView)findViewById(R.id.r);


        nombre = getIntent().getExtras();
        String nombreObtenido = nombre.getString("nombreCampeon");
        nombreCampeon.setText(nombreObtenido);

        pasiva = getIntent().getExtras();
        String pasivaObtenido = pasiva.getString("p");
        p.setText(pasivaObtenido);
        p.setMovementMethod(ScrollingMovementMethod.getInstance());

        habilidad1 = getIntent().getExtras();
        String habilidad1Obtenido = habilidad1.getString("q");
        q.setText(habilidad1Obtenido);
        q.setMovementMethod(ScrollingMovementMethod.getInstance());

        habilidad2 = getIntent().getExtras();
        String habilidad2Obtenido = habilidad2.getString("w");
        w.setText(habilidad2Obtenido);
        w.setMovementMethod(ScrollingMovementMethod.getInstance());

        habilidad3 = getIntent().getExtras();
        String habilidad3Obtenido = habilidad3.getString("e");
        e.setText(habilidad3Obtenido);
        e.setMovementMethod(ScrollingMovementMethod.getInstance());

        habilidad4 = getIntent().getExtras();
        String habilidad4Obtenido = habilidad4.getString("r");
        r.setText(habilidad4Obtenido);
        r.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
