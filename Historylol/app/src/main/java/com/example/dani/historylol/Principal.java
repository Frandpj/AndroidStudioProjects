package com.example.dani.historylol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dani.historylol.R;

public class Principal extends AppCompatActivity implements View.OnClickListener{

    public Button btncamp, btnanalisis, btnequipos, btnayuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        View viewbtncamp = findViewById(R.id.btncamp);
        viewbtncamp.setOnClickListener(this);

        View viewbtnanalisis = findViewById(R.id.btnanalisis);
        viewbtnanalisis.setOnClickListener(this);

        View viewbtnequipos = findViewById(R.id.btnequipos);
        viewbtnequipos.setOnClickListener(this);


        View viewbtnayuda = findViewById(R.id.btnayuda);
        viewbtnayuda.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==findViewById(R.id.btncamp).getId()) {
            Intent Campeones = new Intent(getApplicationContext(), Campeones.class);
            Campeones.putExtra("parametro", "vacio");
            startActivity(Campeones);
        }

        if(v.getId()==findViewById(R.id.btnanalisis).getId()) {
            Intent Analisis = new Intent(getApplicationContext(), Analisis.class);
            Analisis.putExtra("parametro", "vacio");
            startActivity(Analisis);
        }

        if(v.getId()==findViewById(R.id.btnanalisis).getId()) {
            Intent Analisis = new Intent(getApplicationContext(), Analisis.class);
            Analisis.putExtra("parametro", "vacio");
            startActivity(Analisis);
        }

        if(v.getId()==findViewById(R.id.btnequipos).getId()) {
            Intent Equipos = new Intent(getApplicationContext(), Equipos.class);
            Equipos.putExtra("parametro", "vacio");
            startActivity(Equipos);
        }

        if(v.getId()==findViewById(R.id.btnayuda).getId()) {
            Intent Ayuda = new Intent(getApplicationContext(), Ayuda.class);
            Ayuda.putExtra("parametro", "vacio");
            startActivity(Ayuda);
        }

    }
}