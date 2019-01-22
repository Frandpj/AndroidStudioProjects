package com.example.zafiro1.recetas.Adaptadores;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zafiro1.recetas.ObjetoRecetas;
import com.example.zafiro1.recetas.R;

import java.util.ArrayList;

    public class AdaptadorRecetas extends RecyclerView.Adapter<AdaptadorRecetas.RecetaPrincipalViewHolder> {

        private Context context;
        private ArrayList<ObjetoRecetas> arrayRecetas;

        public AdaptadorRecetas(Context context, ArrayList<ObjetoRecetas> arrayRecetaPrincipal) {
            this.context = context;
            this.arrayRecetas = arrayRecetaPrincipal;
        }

        @NonNull
        @Override
        public RecetaPrincipalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.layout_recetas_principal, null);
            return new RecetaPrincipalViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecetaPrincipalViewHolder recetaPrincipalViewHolderViewHolder, int position) {
            ObjetoRecetas dir = arrayRecetas.get(position);

            recetaPrincipalViewHolderViewHolder.imgReceta.setImageBitmap(BitmapFactory.decodeByteArray(dir.getImagen(),
                    0,dir.getImagen().length));
            recetaPrincipalViewHolderViewHolder.txvNombreReceta.setText(String.valueOf(dir.getNombre()));
            recetaPrincipalViewHolderViewHolder.txvIngredientesReceta.setText(String.valueOf(dir.getIngredientes()));
        }

        @Override
        public int getItemCount() {
            return arrayRecetas.size();
        }

        class RecetaPrincipalViewHolder extends RecyclerView.ViewHolder{

            ImageView imgReceta;
            TextView txvNombreReceta, txvIngredientesReceta;

            public RecetaPrincipalViewHolder(@NonNull View v) {
                super(v);

                imgReceta = v.findViewById(R.id.imgReceta);
                txvNombreReceta = v.findViewById(R.id.txvNombreReceta);
                txvIngredientesReceta = v.findViewById(R.id.txvIngredientesReceta);

            }
        }
    }

