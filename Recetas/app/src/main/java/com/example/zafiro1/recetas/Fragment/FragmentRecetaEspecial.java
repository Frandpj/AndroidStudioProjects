package com.example.zafiro1.recetas.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zafiro1.recetas.Adaptadores.AdaptadorRecetas;
import com.example.zafiro1.recetas.BaseDatos.DatabaseAccess;
import com.example.zafiro1.recetas.ObjetoRecetas;
import com.example.zafiro1.recetas.R;

import java.util.ArrayList;

public class FragmentRecetaEspecial extends Fragment {
    private FragmentRecetaPrincipal.OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    AdaptadorRecetas adaptadorRecetas;
    ArrayList<ObjetoRecetas> arrayRecetaEspecial;


    public FragmentRecetaEspecial() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentRecetaEspecial newInstance() {
        FragmentRecetaEspecial fragment = new FragmentRecetaEspecial();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflater1 = inflater.inflate(R.layout.fragment_fragment_receta_especial, container, false);
        arrayRecetaEspecial = new ArrayList<>();
        recyclerView = (RecyclerView) inflater1.findViewById(R.id.rvRecetaEspecial);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        databaseRecetaEspecial();

        adaptadorRecetas = new AdaptadorRecetas(getContext(), arrayRecetaEspecial);
        this.recyclerView.setAdapter(adaptadorRecetas);

        // Inflate the layout for this fragment
        return inflater1;
    }

    //Implementa el array abriendo y cerrando la base de datos.
    private void databaseRecetaEspecial(){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
        databaseAccess.open();
        arrayRecetaEspecial = databaseAccess.todas_las_recetas_especial();
        databaseAccess.close();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentRecetaPrincipal.OnFragmentInteractionListener) {
            mListener = (FragmentRecetaPrincipal.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
