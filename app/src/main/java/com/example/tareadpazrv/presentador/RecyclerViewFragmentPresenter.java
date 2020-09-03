package com.example.tareadpazrv.presentador;

import android.content.Context;

import com.example.tareadpazrv.db.ConstructorMascotas;
import com.example.tareadpazrv.fragment.IRecyclerViewFragmentView;
import com.example.tareadpazrv.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerContactosBaseDatos();
    }
    @Override
    public void obtenerContactosBaseDatos() {
        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
