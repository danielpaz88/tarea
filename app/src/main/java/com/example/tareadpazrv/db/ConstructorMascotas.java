package com.example.tareadpazrv.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.tareadpazrv.R;
import com.example.tareadpazrv.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE=1;
    private Context context;
    public ConstructorMascotas(Context context){
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){
       /* ArrayList mascotas=new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.perro1,"Mingui",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2,0));
        mascotas.add(new Mascota(R.drawable.perro2,"Jax",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2,0));
        mascotas.add(new Mascota(R.drawable.conejo4,"Gabana",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2,0));
        mascotas.add(new Mascota(R.drawable.lagartija5,"Hopi",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2,0));
        mascotas.add(new Mascota(R.drawable.perro1,"Emi",R.drawable.ic_huesodorado,R.mipmap.ic_hueso2,0));
        return mascotas;*/
       BaseDatos db=new BaseDatos(context);
       insertarMisContactos(db);
       return db.obtenerTodosLosContactos();
    }

    public void insertarMisContactos(BaseDatos db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perro1 );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mingui");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.perro2 );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Jax");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.conejo4 );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Hopi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.lagartija5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Emilia");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.conejo3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Bonnie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,R.drawable.lagartija5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Emilia");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO,R.drawable.ic_huesodorado );
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN,R.mipmap.ic_hueso2 );

        db.insertarMascota(contentValues);
    }

    public void darLikeContacto(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMBER_LIKES,LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db=new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
