package com.example.tareadpazrv;

public class Mascota {
    private int foto;
    private int foto2;
    private int fotoBtn;
    private String nombre;
    private String calificacion;

    public Mascota(int foto, String nombre, String calificacion,int foto2,int fotoBtn) {
        this.nombre = nombre;
        this.calificacion=calificacion;
        this.foto=foto;
        this.foto2=foto2;
        this.fotoBtn=fotoBtn;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public int getFotoBtn() {
        return fotoBtn;
    }

    public void setFotoBtn(int fotoBtn) {
        this.fotoBtn = fotoBtn;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
}
