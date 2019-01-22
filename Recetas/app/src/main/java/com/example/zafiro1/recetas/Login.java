package com.example.zafiro1.recetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private CardView cvEntrarLogin;
    private TextView txvRegistrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializar();



    }

    @Override
    public void onClick(View v) {

        if(v.getId()==findViewById(R.id.cvEntrarLogin).getId()) {
            Intent Principal = new Intent(getApplicationContext(), Principal.class);
            startActivity(Principal);
        }

        if(v.getId()==findViewById(R.id.txvRegistrate).getId()) {
            Intent Principal = new Intent(getApplicationContext(), Principal.class);
            startActivity(Principal);
        }

    }

    void inicializar(){

        //Button.
        cvEntrarLogin = (CardView) findViewById(R.id.cvEntrarLogin);
        cvEntrarLogin.setOnClickListener(this);

        //TextView.
        txvRegistrate = (TextView) findViewById(R.id.txvRegistrate);
        txvRegistrate.setOnClickListener(this);


    }


}
