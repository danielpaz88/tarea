package com.example.tareadpazrv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    public mascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }
    public void inicializarListaMascotas(){
        mascotas=new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"Mingui","4",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2));
        mascotas.add(new Mascota(R.drawable.perro2,"Jax","3",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2));
        mascotas.add(new Mascota(R.drawable.conejo4,"Gabana","4",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2));
        mascotas.add(new Mascota(R.drawable.lagartija5,"Hopi","5",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2));
        mascotas.add(new Mascota(R.drawable.perro1,"Emi","4",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2));
    }

    public void inicializarAdaptador(){
        //mascotaAdaptador adaptador= new mascotaAdaptador(mascotas);
        adaptador=new mascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);

    }
}
