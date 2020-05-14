package com.example.tareadpazrv;

public class MascotaDummy {

    private int foto;
    private int foto2;
    private String nombre;
    private String calificacion;
    private String titulo;

    public MascotaDummy(int foto, String nombre, String calificacion, int foto2, String titulo) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.foto = foto;
        this.foto2 = foto2;
        this.titulo=titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}