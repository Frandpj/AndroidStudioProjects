package com.example.zafiro1.dialogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity  implements DialogoSexo.RespuestaDialogoSexo, DialogoEdad.RespuestaDialogoEdad{

    private Button btnSexo, btnEdad;
    private TextView txvSexo, txvEdad;

    private View.OnClickListener sexo = new View.OnClickListener() {
        public void onClick(View v) {

            DialogoSexo ds=new DialogoSexo();
            ds.show(getFragmentManager(),"Mi diálogo");
        }
    };
    private View.OnClickListener edad = new View.OnClickListener() {
        public void onClick(View v) {

            DialogoEdad ds=new DialogoEdad();
            ds.show(getFragmentManager(),"Mi diálogo");
        }
    };

    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG ).show();
        txvSexo.setText(s);
    }

    @Override
    public void onRespuesta2(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG ).show();
        txvEdad.setText(s);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnSexo=(Button)findViewById(R.id.btnSexo);
        btnSexo.setOnClickListener(sexo);
        txvSexo=(TextView)findViewById(R.id.txvSexo);

        btnEdad=(Button)findViewById(R.id.btnEdad);
        btnEdad.setOnClickListener(edad);
        txvEdad=(TextView)findViewById(R.id.txvEdad);
    }
}
