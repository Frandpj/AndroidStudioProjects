package com.example.zafiro1.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class DialogoEdad extends DialogFragment {
    RespuestaDialogoEdad respuesta;
    private String[] edades;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        edades = getResources().getStringArray(R.array.edades);

        // Usamos la clase Builder para construir el diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Escribimos el título
        builder.setTitle("Selecciona tu edad:");
        builder.setItems(R.array.edades, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                respuesta.onRespuesta2(edades[id]);
            }
        });

        // Crear el AlertDialog y devolverlo
        return builder.create();
    }

    public interface RespuestaDialogoEdad {
        public void onRespuesta2(String s);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        respuesta = (DialogoEdad.RespuestaDialogoEdad) activity;
    }
}