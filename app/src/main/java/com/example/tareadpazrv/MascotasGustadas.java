package com.example.tareadpazrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.tareadpazrv.adapter.MascotaDummyAdaptador;
import com.example.tareadpazrv.pojo.MascotaDummy;

import java.util.ArrayList;

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

        mascotasd.add(new MascotaDummy(R.drawable.conejo3,"Mingui",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo4,"Jax",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo5,"Gabana",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo6,"Hopi",R.drawable.ic_huesodorado,0));
        mascotasd.add(new MascotaDummy(R.drawable.conejo7,"Emi",R.drawable.ic_huesodorado,0));
    }

    public void inicializarAdaptador(){
        //mascotaAdaptador adaptador= new mascotaAdaptador(mascotas);
        adaptadord=new MascotaDummyAdaptador(mascotasd,MascotasGustadas.this );
        listaMascotasd.setAdapter(adaptadord);

    }
}
