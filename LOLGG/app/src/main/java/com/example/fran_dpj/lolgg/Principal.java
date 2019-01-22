package com.example.fran_dpj.lolgg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnCampeon, btnAnalisis, btnEquipos, btnAyuda;

        View viewbtnCampeon = findViewById(R.id.btnCampeon);
        viewbtnCampeon.setOnClickListener(this);

        btnCampeon = findViewById(R.id.btnCampeon);
        viewbtnCampeon.setOnClickListener(this);

        View viewbtnAnalisis = findViewById(R.id.btnAnalisis);
        viewbtnAnalisis.setOnClickListener(this);

        btnAnalisis = findViewById(R.id.btnAnalisis);
        viewbtnAnalisis.setOnClickListener(this);

        View viewbtnEquipos = findViewById(R.id.btnEquipos);
        viewbtnEquipos.setOnClickListener(this);

        btnEquipos = findViewById(R.id.btnEquipos);
        viewbtnEquipos.setOnClickListener(this);

        View viewbtnAyuda = findViewById(R.id.btnAyuda);
        viewbtnAyuda.setOnClickListener(this);

        btnAyuda = findViewById(R.id.btnAyuda);
        viewbtnAyuda.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        if (v.getId() == findViewById(R.id.btnCampeon).getId()) {

            Intent Campeones = new Intent(Principal.this, Campeones.class);
            startActivity(Campeones);
        }

        if (v.getId() == findViewById(R.id.btnAnalisis).getId()) {

            Intent CampeonAnalisis = new Intent(Principal.this, CampeonAnalisis.class);
            startActivity(CampeonAnalisis);

        }

        if (v.getId() == findViewById(R.id.btnEquipos).getId()) {

            Intent Equipos = new Intent(Principal.this, Equipos.class);
            startActivity(Equipos);

        }

        if (v.getId() == findViewById(R.id.btnAyuda).getId()) {

            Intent Ayuda = new Intent(Principal.this, Ayuda.class);
            startActivity(Ayuda);

        }

    }
}
