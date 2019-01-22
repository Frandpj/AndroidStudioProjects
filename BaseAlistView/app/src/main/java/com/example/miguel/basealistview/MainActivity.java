package com.example.miguel.basealistview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

//clase principal de la aplicación

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //atributo para gestionar la base de datos
    private ControladorBaseDatos MBD;

    //atributos para los elementos de la interfaz
    private TextView txvCentral;

    private ListView lsvListado;

    //adaptador para el listview
    private Adaptador adapter;

    //Arraylist para los elementos del listview, este arraylist será rellenado
    //con los elementos de la tabla, usando el cursor
    ArrayList<RellenarListView> arrayLibros = new ArrayList<RellenarListView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variables que utilizamos
        int numero_libros;

        //inicializamos los elementos de la interfa
        txvCentral= (TextView) findViewById(R.id.txvCentral);
        lsvListado = (ListView) findViewById(R.id.lsvListado);

        //inicializamos la base de datos
        MBD= new ControladorBaseDatos(getApplicationContext());

        //vamos a comprobar si existen datos en tabla libros
        //si no existen los insertamos
      if ((numero_libros= MBD.numero_de_libros())==0)
        {

            txvCentral.setText("No hay libros, se han insertado");
            String titulo, autor;

            Libro v[]=new Libro[10];
            int i;
            for (i=0; i<10; i++)
            {
                titulo="Título"+ String.valueOf(i);
                autor = "Autor"+ String.valueOf(i);
                v[i]=new Libro(i,titulo, autor);
                //insertamos en la base de datos
                MBD.insertarLibro(v[i]);
            }
        }//fin if
        else {
          txvCentral.setText("Hay " + String.valueOf(numero_libros) + " libros");

          //obtenemos todos los elementos de la tabla almacenandolos en array
          arrayLibros=MBD.todos_los_libros();

          //cargamos el arraylist en el listview usando el adaptador y la clase
          //que lo infla
          adapter = new Adaptador(this, arrayLibros);
          lsvListado.setAdapter(adapter);
          //añadimos la escucha
          lsvListado.setOnItemClickListener(this);
        }


        //operaciones sobre los elementos adicionales
        //asignamos la toolbar al control


      
    }//fin del oncreate



    //método que se ejecuta al pulsar sobre un elemento del listview
    @Override
    public void onItemClick(final AdapterView<?> adapter, View view, final int position,
                            long ID) {
        // Al hacer click sobre uno de los items del ListView mostramos un diálogo para
        //que nos confirme si queremos o no borrarlo
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar un libro");
        builder.setMessage("Desea realmente eliminar el libro?");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Hacer cosas aqui al hacer clic en el boton NO
            }
        });
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Hacer cosas aqui al hacer clic en el boton SI
                //Obtenemos el código del elemento que hemos pulsado
               int codigo= arrayLibros.get(position).getCodigo_libro();
               //lo eliminamos de la base de datos
               MBD.eliminar_libro(codigo);
               //lo eliminamos del array
                arrayLibros.remove(position);
                //volvemos a cargar el adaptador con el vector



            }
        });
        builder.show();


    }


}
