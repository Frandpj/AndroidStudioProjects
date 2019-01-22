package com.example.zafiro1.biblioteca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    private Button btnAnterior, btnSiguiente, btnUltimo, btnPrimero, btnUpd, btnDel, btnNew;
    private EditText edtCodigo, edtTitulo, edtAutor, edtDescripcion, edtTotal;
    private BaseDatos MDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        View viewbtnAnterior = findViewById(R.id.btnAnterior);
        viewbtnAnterior.setOnClickListener(Escucha);

        View viewbtnSiguiente = findViewById(R.id.btnSiguiente);
        viewbtnSiguiente.setOnClickListener(Escucha);

        View viewbtnUltimo = findViewById(R.id.btnUltimo);
        viewbtnUltimo.setOnClickListener(Escucha);

        View viewbtnPrimero = findViewById(R.id.btnPrimero);
        viewbtnPrimero.setOnClickListener(Escucha);

        View viewbtnUdp = findViewById(R.id.btnUpd);
        viewbtnUdp.setOnClickListener(Escucha);

        View viewbtnDel = findViewById(R.id.btnDel);
        viewbtnDel.setOnClickListener(Escucha);

        View viewbtnNew = findViewById(R.id.btnNew);
        viewbtnNew.setOnClickListener(Escucha);

        edtTitulo = (EditText) findViewById(R.id.edtTitulo);
        edtAutor = (EditText) findViewById(R.id.edtAutor);
        edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        edtTotal = (EditText) findViewById(R.id.edtTotal);

        MDB = new BaseDatos(getApplicationContext());


    } //Fin del Oncreate

    private View.OnClickListener Escucha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int valor_buscado = Integer.parseInt(edtCodigo.getText().toString());
            Libros libro = new Libros();
            libro = MDB.recuperarLIBRO(valor_buscado);

            edtTitulo.setText(libro.getTitulo().toString());
        }
    }; //Fin del onClick


    public void insertarCONTACTO(){
        //Escribimos 4 registros en nuestra tabla.
        MDB.insertarLIBRO(1, "Harry Potter y la Piedra Filosofal", "J.K Rowling", "Primer libro de Harry Potter");
        MDB.insertarLIBRO(2, "Harry Potter y la Camara Secreta", "J.K Rowling", "Segundo libro de Harry Potter");
        MDB.insertarLIBRO(3, "Harry Potter y el Prisionero de Azkaban", "J.K Rowling", "Tercer libro de Harry Potter");
        MDB.insertarLIBRO(4, "Harry Potter y el Caliz de Fuego", "J.K Rowling", "Cuarto libro de Harry Potter");
    } //Fin insertarLIBRO.

}
