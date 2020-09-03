package com.example.tareadpazrv;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.tareadpazrv.adapter.PageAdapter;
import com.example.tareadpazrv.adapter.mascotaAdaptador;
import com.example.tareadpazrv.fragment.PerfilFragment;
import com.example.tareadpazrv.fragment.RecyclerViewFragment;
import com.example.tareadpazrv.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public mascotaAdaptador adaptador;
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageButton imgBoton;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolbar!=null){setSupportActionBar(toolbar);}//ojo con este


       /* imgBoton=(ImageButton) findViewById(R.id.imgBoton);//esto solo esta en el action bar y es la estrella
        imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "Hizo Click", LENGTH_SHORT).show();
                Intent i=new Intent(MainActivity.this,MascotasGustadas.class);
                startActivity(i);
            }
        });*/

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.mAbout:
                Intent i = new Intent(this, ActivityAbout.class);
                startActivity(i);
                break;
            case R.id.mContacto:
                Intent j = new Intent(this, ActivityContacto.class);
                startActivity(j);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add (new RecyclerViewFragment());
        fragments.add (new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_namegato);
    }
}