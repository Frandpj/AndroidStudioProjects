package com.example.zafiro1.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;



public class DialogoSexo extends DialogFragment {

    RespuestaDialogoSexo respuesta;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Usamos la clase Builder para construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Escribimos el título
        builder.setTitle("Pregunta seria:");
        //Escribimos la pregunta
        builder.setMessage("¿Eres un chico o una chica?");
        //añadimos el botón de Si y su acción asociada
        builder.setPositiveButton("Chico", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es un chico");
            }
        });
        //añadimos el botón de No y su acción asociada
        builder.setNegativeButton("Chica", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta("Es una chica");
            }
        });
        // Crear el AlertDialog y devolverlo
        return builder.create();
    }

    public interface RespuestaDialogoSexo{
        public void onRespuesta(String s);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        respuesta=(RespuestaDialogoSexo)activity;
    }


}
