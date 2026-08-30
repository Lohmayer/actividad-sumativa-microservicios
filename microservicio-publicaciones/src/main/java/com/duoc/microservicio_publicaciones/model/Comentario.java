package com.duoc.microservicio_publicaciones.model;

public class Comentario {

    private int id;
    private int publicacionId;
    private String autor;
    private String contenido;

    public Comentario() {
    }

    public Comentario(int id, int publicacionId, String autor, String contenido) {
        this.id = id;
        this.publicacionId = publicacionId;
        this.autor = autor;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}