package com.example.miguel.basealistview;

/**
 * Created by miguel on 31/10/18.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<RellenarListView> items;

    public Adaptador (Activity activity, ArrayList<RellenarListView> items) {
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

    public void addAll(ArrayList<RellenarListView> category) {
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
            v = inf.inflate(R.layout.layout_libros, null);
        }

        RellenarListView dir = items.get(position);

        TextView txvTitulo = (TextView) v.findViewById(R.id.txvTitulo);
        txvTitulo.setText(dir.getTitulo_libro());

        TextView txvAutor = (TextView) v.findViewById(R.id.txvAutor);
        txvAutor.setText(dir.getAutor_libro());

        TextView txvCodigo = (TextView) v.findViewById(R.id.txvCodigo);
        txvCodigo.setText(String.valueOf(dir.getCodigo_libro()));


        return v;
    }
}