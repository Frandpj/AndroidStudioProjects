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
import com.example.fdelp.concesionario.CochesUsados.ObjetoCochesUsados;
import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class AdaptadorCochesUsados extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ObjetoCochesUsados> items;

    public AdaptadorCochesUsados(Activity activity, ArrayList<ObjetoCochesUsados> items) {
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

    public void addAll(ArrayList<ObjetoCochesUsados> category) {
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
            v = inf.inflate(R.layout.layout_coches_usados, null);
        }

        ObjetoCochesUsados dir = items.get(position);

        //enlazar cada elemento de tu layout a cada atributo de la clase

        ImageView imgCochesUsados = (ImageView) v.findViewById(R.id.imgCochesUsados);
        imgCochesUsados.setImageBitmap(BitmapFactory.decodeByteArray( dir.getImagen(),
                0,dir.getImagen().length));
        //IMPORTANTE, TENGO QUE RECUPERAR LA IMAGEN.

        TextView txvMarcaCochesUsados = (TextView) v.findViewById(R.id.txvMarcaCochesUsados);
        txvMarcaCochesUsados.setText(String.valueOf(dir.getMarca()));

        TextView txvModeloCochesUsados = (TextView) v.findViewById(R.id.txvModeloCochesUsados);
        txvModeloCochesUsados.setText(String.valueOf(dir.getModelo()));


        return v;
    }

}
