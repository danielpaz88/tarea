package com.example.tareadpazrv.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tareadpazrv.db.BaseDatos;
import com.example.tareadpazrv.db.ConstructorMascotas;
import com.example.tareadpazrv.pojo.Mascota;
import com.example.tareadpazrv.pojo.MascotaDummy;
import com.example.tareadpazrv.R;

import java.nio.DoubleBuffer;
import java.util.ArrayList;

public class MascotaDummyAdaptador extends RecyclerView.Adapter<MascotaDummyAdaptador.MascotaViewHolder>{

    Activity activity;
    ArrayList<MascotaDummy> mascotasd;
    //ArrayList<Mascota> mascotas;
    public MascotaDummyAdaptador(ArrayList<MascotaDummy> mascotasd, Activity activity){
        this.mascotasd=mascotasd;
        this.activity=activity;
       // this.mascotas=mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dummy,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder,int position) {
        final MascotaDummy mascotad=mascotasd.get(position);
        holder.imgFoto.setImageResource(mascotad.getFoto());
        holder.tvNombre.setText(mascotad.getNombre());
        holder.tvLikes.setText(String.valueOf(mascotad.getLikes()));
       // ConstructorMascotas constructorMascotas=new ConstructorMascotas(activity);
       //holder.tvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
       // holder.tvTitulo.setText(mascotad.getTitulo());
       /* holder.imgFotoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Puntuaste a "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mascotasd.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        //private TextView tvTitulo;
        private ImageView imgFoto;
        private TextView tvLikes;
        private TextView tvNombre;
        private ImageView imgFoto2;

        public MascotaViewHolder(View itemView){
            super (itemView);
            imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
            imgFoto2=(ImageView) itemView.findViewById(R.id.imgFoto2);
            tvLikes=(TextView) itemView.findViewById(R.id.tvLikes);
            tvNombre=(TextView) itemView.findViewById(R.id.tvNombre);
        }
    }
}