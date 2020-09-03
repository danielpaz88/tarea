package com.example.tareadpazrv.fragment;

import com.example.tareadpazrv.adapter.mascotaAdaptador;
import com.example.tareadpazrv.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public mascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(mascotaAdaptador adaptador);
}
