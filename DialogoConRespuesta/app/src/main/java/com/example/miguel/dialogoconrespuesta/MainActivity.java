package com.example.miguel.dialogoconrespuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements DialogoSexo.RespuestaDialogoSexo{



    private Button boton;

    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {

            DialogoSexo ds=new DialogoSexo();
            ds.show(getFragmentManager(),"Mi diálogo");
        }
    };
    @Override
    public void onRespuesta(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG ).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton=(Button)findViewById(R.id.btn);
        boton.setOnClickListener(mCorkyListener);
    }






}





