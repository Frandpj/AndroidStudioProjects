package com.example.zafiro1.basesdedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private MiBaseDatos MDB;

    private Button btnBuscar;
    private EditText edtEntrada;
    private TextView txvSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Asignamos objetos a la interfaz.
        btnBuscar = (Button)findViewById(R.id.btnBuscar);
        txvSalida = (TextView)findViewById(R.id.txvSalida);
        edtEntrada = (EditText)findViewById(R.id.edtEntrada);

        btnBuscar.setOnClickListener(Escucha);

        MDB = new MiBaseDatos(getApplicationContext());




    } //Fin oncreate.

    private View.OnClickListener Escucha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int valor_buscado = Integer.parseInt(edtEntrada.getText().toString());
            Contactos contacto = new Contactos();
            contacto = MDB.recuperarCONTACTO(valor_buscado);

            txvSalida.setText(contacto.getNombre().toString());
        }
    };


    public void insertarCONTACTO(){
        //Escribimos 4 registros en nuestra tabla.
        MDB.insertarCONTACTO(1, "Pedro", 111111111, "pedro@DB.es");
        MDB.insertarCONTACTO(2, "Sandra", 222222222, "sandra@DB.es");
        MDB.insertarCONTACTO(3, "Maria", 333333333, "maria@DB.es");
        MDB.insertarCONTACTO(4, "Daniel", 444444444, "daniel@DB.es");
    } //Fin insertarCONTACTO.

}
