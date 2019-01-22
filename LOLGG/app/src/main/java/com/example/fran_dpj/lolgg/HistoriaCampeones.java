package com.example.fran_dpj.lolgg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoriaCampeones extends AppCompatActivity {

    Bundle nombre, historia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia_campeones);

        TextView nombreCampeon, historiaCampeon;

        nombreCampeon=(TextView)findViewById(R.id.nombreCampeon);
        historiaCampeon=(TextView)findViewById(R.id.historiaCampeon);


        nombre = getIntent().getExtras();
        String nombreObtenido = nombre.getString("nombreCampeon");
        nombreCampeon.setText(nombreObtenido);

        historia = getIntent().getExtras();
        String historiaObtenido = historia.getString("historiaCampeon");
        historiaCampeon.setText(historiaObtenido);



    }
}
