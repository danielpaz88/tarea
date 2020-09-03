package com.example.tareadpazrv.pojo;

public class MascotaDummy {

    private int foto;
    private int foto2;
    private String nombre;
    private int likes;
    private String titulo;
    private int id;


    public MascotaDummy(int foto, String nombre, int foto2, int likes) {
        this.nombre = nombre;
        this.foto = foto;
        this.foto2 = foto2;
        this.likes=likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}