package com.example.fdelp.concesionario.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fdelp.concesionario.CochesNuevos.ObjetoCochesNuevos;
import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class AdaptadorCochesNuevos extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ObjetoCochesNuevos> items;

    public AdaptadorCochesNuevos(Activity activity, ArrayList<ObjetoCochesNuevos> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<ObjetoCochesNuevos> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.layout_coches_nuevos, null);
        }

        ObjetoCochesNuevos dir = items.get(position);

        //enlazar cada elemento de tu layout a cada atributo de la clase

        ImageView imgCochesNuevos = (ImageView) v.findViewById(R.id.imgCochesNuevos);
        imgCochesNuevos.setImageBitmap(BitmapFactory.decodeByteArray( dir.getImagen(),
                0,dir.getImagen().length));
        //IMPORTANTE, TENGO QUE RECUPERAR LA IMAGEN.

        TextView txvMarcaCochesNuevos = (TextView) v.findViewById(R.id.txvMarcaCochesNuevos);
        txvMarcaCochesNuevos.setText(String.valueOf(dir.getMarca()));

        TextView txvModeloCochesNuevos = (TextView) v.findViewById(R.id.txvModeloCochesNuevos);
        txvModeloCochesNuevos.setText(String.valueOf(dir.getModelo()));


        return v;
    }
}
