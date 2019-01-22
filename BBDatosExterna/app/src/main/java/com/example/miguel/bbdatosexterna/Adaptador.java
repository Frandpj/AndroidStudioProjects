package com.example.miguel.bbdatosexterna;

/**
 * Created by miguel on 21/11/18.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Provincia> items;

    public Adaptador(Activity activity, ArrayList<Provincia> items) {
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

    public void addAll(ArrayList<Provincia> category) {
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
            v = inf.inflate(R.layout.layout_provincia, null);
        }

        Provincia dir = items.get(position);

        TextView txvNombre_provincia = (TextView) v.findViewById(R.id.txvNombre_provincia);
        txvNombre_provincia.setText(dir.getNombre_provincia());

       TextView txvNum_habitantes = (TextView) v.findViewById(R.id.txvNum_habitantes);
        txvNum_habitantes.setText(String.valueOf(dir.getNum_habitantes()));

        TextView txvCod_provincia = (TextView) v.findViewById(R.id.txvCod_provincia);
        txvCod_provincia.setText(String.valueOf(dir.getCod_provincia()));


        return v;
    }
}