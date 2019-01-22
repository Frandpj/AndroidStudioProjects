package com.example.miguel.bbdatosexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    //adaptador para el listview
    private Adaptador adapter;

    //Arraylist para los elementos del listview de las provincias
    ArrayList<Provincia> arrayprovincias = new ArrayList<Provincia>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //listview para provincias
        this.listView = (ListView) findViewById(R.id.listview);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        arrayprovincias = databaseAccess.todas_las_provincias();
        databaseAccess.close();

        //cargamos el arraylist en el listview usando el adaptador y la clase
        //que lo infla
      adapter = new Adaptador(this, arrayprovincias);
        this.listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }//final oncreate

    @Override
    public void onItemClick(final AdapterView<?> adapter, View view, final int position,
                            long ID) {
    }//fin onItemClick


}//final de la clase
