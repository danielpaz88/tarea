package com.example.tareadpazrv;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaDummyAdaptador extends RecyclerView.Adapter<MascotaDummyAdaptador.MascotaViewHolder>{

    Activity activity;
    ArrayList<MascotaDummy> mascotasd;
    public MascotaDummyAdaptador(ArrayList<MascotaDummy> mascotasd, Activity activity){
        this.mascotasd=mascotasd;
        this.activity=activity;
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
        holder.tvCalificacion.setText(mascotad.getCalificacion());
        holder.tvNombre.setText(mascotad.getNombre());
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
        private TextView tvCalificacion;
        private TextView tvNombre;
        private ImageView imgFoto2;
        public MascotaViewHolder(View itemView){
            super (itemView);
            imgFoto=(ImageView) itemView.findViewById(R.id.imgFoto);
            imgFoto2=(ImageView) itemView.findViewById(R.id.imgFoto2);
            tvCalificacion=(TextView) itemView.findViewById(R.id.tvCalificacion);
            tvNombre=(TextView) itemView.findViewById(R.id.tvNombre);
            //tvTitulo=(TextView) itemView.findViewById(R.id.tvTitulo);
        }
    }
}