package com.example.tareadpazrv.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tareadpazrv.pojo.MascotaDummy;
import com.example.tareadpazrv.R;
import com.example.tareadpazrv.adapter.MascotaDummyAdaptador;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    //public ImageAdapter imageAdapter;
    public MascotaDummyAdaptador adaptadord;
    ArrayList<MascotaDummy> mascotasd;
    private RecyclerView listaMascotasd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfil,container,false);

        //GridView gridview=(GridView) v.findViewById(R.id.gvMascotasGV);
        //gridview.setAdapter(new ImageAdapter(getActivity()));
        CircleImageView circleImageView=(CircleImageView) v.findViewById(R.id.profile_image);

        listaMascotasd=(RecyclerView) v.findViewById(R.id.rvMascotasd);
        listaMascotasd.setLayoutManager(new GridLayoutManager(getActivity(),2));

        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }
    public void inicializarListaMascotas(){
        mascotasd=new ArrayList<MascotaDummy>();

        /*mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Mingui","4",R.drawable.ic_huesodorado,"Primer puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.lagartija5,"Jax","3",R.drawable.ic_huesodorado,"Segundo puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.perro1,"Gabana","4",R.drawable.ic_huesodorado,"Tercer puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.perro2,"Hopi","5",R.drawable.ic_huesodorado,"Cuarto puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Emi","4",R.drawable.ic_huesodorado,"Quinto puesto"));*/


        mascotasd.add(new MascotaDummy(R.drawable.conejo3,"Mingui",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Jax",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo5,"Gabana",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo6,"Hopi",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo7,"Emi",R.drawable.ic_huesodorado,0));
    }

    public void inicializarAdaptador(){
        //mascotaAdaptador adaptador= new mascotaAdaptador(mascotas);
        adaptadord=new MascotaDummyAdaptador(mascotasd,getActivity() );
        listaMascotasd.setAdapter(adaptadord);

    }
}
