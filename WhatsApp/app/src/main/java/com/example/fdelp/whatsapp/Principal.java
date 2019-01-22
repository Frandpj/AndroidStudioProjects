package com.example.fdelp.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    public ListView listContactos;
    ArrayAdapter<String> adaptador;
    TextView txvNombreContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        listContactos = (ListView)findViewById(R.id.listContactos);
        txvNombreContacto = (TextView)findViewById(R.id.txvNombreContacto);

        //Creamos un array con los valores que vayamos a meter en el listview.
        String[] valores = new String[]{"Dani", "Ruben", "Juan Antonio", "Yebenes", "German", "Arfonzo", "Salces", "Imanol", "Alberto", "Samu"};
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, valores);

        //se carga el listview con el adaptador.
        listContactos.setAdapter(adaptador);



        listContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemval = (String)listContactos.getItemAtPosition(position);

                Intent Principal2 = new Intent(Principal.this, Principal2.class);

                Principal2.putExtra("nombre",itemval);
                startActivity(Principal2);


            }
        });

    }
}
