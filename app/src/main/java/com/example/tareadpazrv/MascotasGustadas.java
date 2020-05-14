package com.example.tareadpazrv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MascotasGustadas extends AppCompatActivity {
    public MascotaDummyAdaptador adaptadord;
    ArrayList<MascotaDummy> mascotasd;
    private RecyclerView listaMascotasd;
    //private ImageButton imgBoton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_gustadas);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMascotasd=(RecyclerView) findViewById(R.id.rvMascotasd);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasd.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
       /* imgBoton=(ImageButton) findViewById(R.id.imgBoton);
        imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Hizo Click", LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,MascotasGustadas.class);
                startActivity(i);
            }
        });*/
    }

    public void inicializarListaMascotas(){
        mascotasd=new ArrayList<MascotaDummy>();

        mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Mingui","4",R.drawable.ic_huesodorado,"Primer puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.lagartija5,"Jax","3",R.drawable.ic_huesodorado,"Segundo puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.perro1,"Gabana","4",R.drawable.ic_huesodorado,"Tercer puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.perro2,"Hopi","5",R.drawable.ic_huesodorado,"Cuarto puesto"));
        mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Emi","4",R.drawable.ic_huesodorado,"Quinto puesto"));
    }

    public void inicializarAdaptador(){
        //mascotaAdaptador adaptador= new mascotaAdaptador(mascotas);
        adaptadord=new MascotaDummyAdaptador(mascotasd,MascotasGustadas.this );
        listaMascotasd.setAdapter(adaptadord);

    }
}
