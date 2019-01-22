package com.example.fdelp.whatsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);

        TextView txvNombreContacto;

        txvNombreContacto = (TextView)findViewById(R.id.txvNombreContacto);

        Bundle nombre = this.getIntent().getExtras();
        String n = nombre.getString("nombre");
        txvNombreContacto.setText(n.toString());

        //txvNombreContacto.setText();
    }
}
