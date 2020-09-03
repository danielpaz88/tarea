package com.example.tareadpazrv.pojo;

public class Mascota {
    private int foto;
    private int foto2;
    private int fotoBtn;
    private String nombre;
    private int id;
    private int likes;



    public Mascota(int foto, String nombre, int foto2, int fotoBtn,int likes) {
        this.nombre = nombre;
        this.foto=foto;
        this.foto2=foto2;
        this.fotoBtn=fotoBtn;
        this.likes=likes;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
