package com.example.tareadpazrv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tareadpazrv.pojo.Mascota;
import com.example.tareadpazrv.R;
import com.example.tareadpazrv.adapter.mascotaAdaptador;
import com.example.tareadpazrv.presentador.IRecyclerViewFragmentPresenter;
import com.example.tareadpazrv.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{
    //public mascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
        //inicializarListaMascotas();
        presenter=new RecyclerViewFragmentPresenter(this,getContext());
        return v;
    }

    public void inicializarListaMascotas(){

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public mascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        mascotaAdaptador adaptador=new mascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(mascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }



  /*
    public void inicializarAdaptador() {
        adaptador=new mascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }*/

}
