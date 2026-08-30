package com.duoc.microservicio_publicaciones.model;

public class Calificacion {

    private int id;
    private int publicacionId;
    private String usuario;
    private int puntaje;

    public Calificacion() {
    }

    public Calificacion(int id, int publicacionId, String usuario, int puntaje) {
        this.id = id;
        this.publicacionId = publicacionId;
        this.usuario = usuario;
        this.puntaje = puntaje;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}