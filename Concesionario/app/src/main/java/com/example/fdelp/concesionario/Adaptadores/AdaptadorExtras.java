package com.example.fdelp.concesionario.Adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.fdelp.concesionario.Extras.ObjetoExtras;
import com.example.fdelp.concesionario.R;

import java.util.ArrayList;

public class AdaptadorExtras extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<ObjetoExtras> items;

    public AdaptadorExtras(Activity activity, ArrayList<ObjetoExtras> items) {
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

    public void addAll(ArrayList<ObjetoExtras> category) {
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
            v = inf.inflate(R.layout.layout_extras, null);
        }

        ObjetoExtras dir = items.get(position);

        TextView txvNombreExtras = (TextView) v.findViewById(R.id.txvNombreExtras);
        txvNombreExtras.setText(String.valueOf(dir.getNombre()));

        TextView txvPrecioExtras = (TextView) v.findViewById(R.id.txvPrecioExtras);
        txvPrecioExtras.setText(String.valueOf(dir.getPrecio()));

        TextView txvDescripcionExtras = (TextView) v.findViewById(R.id.txvDescripcionExtras);
        txvDescripcionExtras.setText(String.valueOf(dir.getDescripcion()));


        return v;
    }

}
