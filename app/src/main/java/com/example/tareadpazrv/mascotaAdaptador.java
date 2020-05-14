package com.example.tareadpazrv;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.MascotaViewHolder>{

    Activity activity;
    ArrayList<Mascota> mascotas;
    public mascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder,int position) {
    final Mascota mascota=mascotas.get(position);
    holder.imgFoto.setImageResource(mascota.getFoto());
    holder.tvCalificacion.setText(mascota.getCalificacion());
    holder.tvNombre.setText(mascota.getNombre());
    holder.imgFoto2.setImageResource(mascota.getFoto2());
    holder.imgFotoBtn.setImageResource(mascota.getFotoBtn());
    holder.imgFotoBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(activity, "Puntuaste a "+mascota.getNombre(), Toast.LENGTH_SHORT).show();
        }
    });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imgFotoBtn;
        private ImageView imgFoto;
        private TextView tvCalificacion;
        private TextView tvNombre;
        private ImageView imgFoto2;
        public MascotaViewHolder(View itemView){
            super (itemView);
            imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
            imgFotoBtn=(ImageButton) itemView.findViewById(R.id.imgFotoBtn);
            imgFoto2=(ImageView) itemView.findViewById(R.id.imgFoto2);
            tvCalificacion=(TextView) itemView.findViewById(R.id.tvCalificacion);
            tvNombre=(TextView) itemView.findViewById(R.id.tvNombre);
        }
    }
}
