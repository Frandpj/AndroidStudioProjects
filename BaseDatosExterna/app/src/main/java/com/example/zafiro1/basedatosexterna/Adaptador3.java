package com.example.zafiro1.basedatosexterna;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador3 extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<ArticuloRelacional> items;

    public Adaptador3(Activity activity, ArrayList<ArticuloRelacional> items) {
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

    public void addAll(ArrayList<ArticuloRelacional> category) {
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
            v = inf.inflate(R.layout.layout_articulo_relacional, null);
        }

        ArticuloRelacional dir = items.get(position);

        //enlazar cada elemento de tu layout a cada atributo de la clase

        TextView txvCodigoPersona = (TextView) v.findViewById(R.id.txvCodigoPersona);
        txvCodigoPersona.setText(String.valueOf(dir.getCodigo_persona()));

        TextView txvCodigoArticulo = (TextView) v.findViewById(R.id.txvCodigoArticulo);
        txvCodigoArticulo.setText(String.valueOf(dir.getCodigo_articulo()));

        TextView txvCantidad = (TextView) v.findViewById(R.id.txvCantidad);
        txvCantidad.setText(String.valueOf(dir.getCantidad()));



        return v;
    }

}
