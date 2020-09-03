package com.example.tareadpazrv.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.tareadpazrv.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto="CREATE TABLE "+ ConstantesBaseDatos.TABLE_MASCOTAS+"("+
        ConstantesBaseDatos.TABLE_MASCOTAS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE+" TEXT, "+
        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO+" INTEGER, "+
        ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESODORADO+" INTEGER, "+
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO_HUESOBTN+" INTEGER"+ ")";


        String queryCrearTablaLikesContacto="CREATE TABLE "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+
                "("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT, "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO+
                " INTEGER, "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMBER_LIKES+
                " INTEGER, "+"FOREIGN KEY("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO+") "+"REFERENCES "+
                ConstantesBaseDatos.TABLE_MASCOTAS+"("+ConstantesBaseDatos.TABLE_MASCOTAS_ID+")"+")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    public ArrayList <Mascota> obtenerTodosLosContactos(){
        ArrayList<Mascota> mascotas=new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);

        while(registros.moveToNext()){
            Mascota mascotaActual=new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));
            mascotaActual.setFoto2(registros.getInt(3));
            mascotaActual.setFotoBtn(registros.getInt(4));
            mascotas.add(mascotaActual);

            String queryLikes="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMBER_LIKES+") as likes "+
                    " FROM "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+" WHERE "+
                    ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO+"="+mascotaActual.getId();
            Cursor registrosLikes=db.rawQuery(queryLikes,null);
            if(registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else{mascotaActual.setLikes(0);}
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA,null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota (Mascota mascota){
        int likes=0;
        String query="SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMBER_LIKES+")"+
                " FROM "+ConstantesBaseDatos.TABLE_LIKES_MASCOTA+" WHERE "+
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_CONTACTO+"="+mascota.getId();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor registros=db.rawQuery(query,null);
        if(registros.moveToNext()){
            likes=registros.getInt(0);
        }
        db.close();
        return likes;
    }

}
