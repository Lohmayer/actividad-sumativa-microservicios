package com.duoc.microservicio_mascotas.model;

import java.time.LocalDate;

public class Venta {

    private int id;
    private int productoId;
    private int cantidad;
    private LocalDate fecha;

    public Venta() {
    }

    public Venta(
            int id,
            int productoId,
            int cantidad,
            LocalDate fecha
    ) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}