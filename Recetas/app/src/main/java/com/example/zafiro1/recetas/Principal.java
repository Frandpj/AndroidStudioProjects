package com.example.zafiro1.recetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private CardView cvRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        inicializar();

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==findViewById(R.id.cvRecetas).getId()) {
            Intent Recetas = new Intent(getApplicationContext(), Recetas.class);
            startActivity(Recetas);
        }

    }

    void inicializar(){

        //Button.
        cvRecetas = (CardView) findViewById(R.id.cvRecetas);
        cvRecetas.setOnClickListener(this);

    }

}
