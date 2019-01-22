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

public class FragmentRecetaSushi extends Fragment {

    private FragmentRecetaPrincipal.OnFragmentInteractionListener mListener;

    private RecyclerView recyclerView;
    AdaptadorRecetas adaptadorRecetas;
    ArrayList<ObjetoRecetas> arrayRecetaSushi;


    public FragmentRecetaSushi() {
        // Required empty public constructor
    }

    public static FragmentRecetaSushi newInstance() {
        FragmentRecetaSushi fragment = new FragmentRecetaSushi();
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

        View inflater1 = inflater.inflate(R.layout.fragment_fragment_receta_sushi, container, false);
        arrayRecetaSushi = new ArrayList<>();
        recyclerView = (RecyclerView) inflater1.findViewById(R.id.rvRecetaSushi);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        databaseRecetaSushi();

        adaptadorRecetas = new AdaptadorRecetas(getContext(), arrayRecetaSushi);
        this.recyclerView.setAdapter(adaptadorRecetas);

        // Inflate the layout for this fragment
        return inflater1;
    }

    //Implementa el array abriendo y cerrando la base de datos.
    private void databaseRecetaSushi(){

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getContext());
        databaseAccess.open();
        arrayRecetaSushi = databaseAccess.todas_las_recetas_sushi();
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
