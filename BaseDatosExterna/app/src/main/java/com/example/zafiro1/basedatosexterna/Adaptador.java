package com.example.zafiro1.basedatosexterna;

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
    protected ArrayList<Persona> items;

    public Adaptador(Activity activity, ArrayList<Persona> items) {
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

    public void addAll(ArrayList<Persona> category) {
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
            v = inf.inflate(R.layout.layout_persona, null);
        }

        Persona dir = items.get(position);

        //enlazar cada elemento de tu layout a cada atributo de la clase

        TextView txvCodigoPersona = (TextView) v.findViewById(R.id.txvCodigoPersona);
        txvCodigoPersona.setText(String.valueOf(dir.getCod_persona()));

        TextView txvNombrePersona = (TextView) v.findViewById(R.id.txvNombrePersona);
        txvNombrePersona.setText(String.valueOf(dir.getNombre_persona()));

        TextView txvApellidoPersona = (TextView) v.findViewById(R.id.txvApellidoPersona);
        txvApellidoPersona.setText(String.valueOf(dir.getApellido_persona()));

        TextView txvEdadPersona = (TextView) v.findViewById(R.id.txvEdadPersona);
        txvEdadPersona.setText(String.valueOf(dir.getEdad_persona()));


        return v;
    }
}
