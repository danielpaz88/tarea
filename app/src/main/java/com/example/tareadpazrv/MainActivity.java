package com.example.tareadpazrv;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    public mascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageButton imgBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        imgBoton=(ImageButton) findViewById(R.id.imgBoton);
        imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Hizo Click", LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,MascotasGustadas.class);
                startActivity(i);
            }
        });

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
        adaptador=new mascotaAdaptador(mascotas,this );
        listaMascotas.setAdapter(adaptador);

    }
}