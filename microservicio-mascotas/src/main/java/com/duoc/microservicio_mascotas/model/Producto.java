package com.duoc.microservicio_mascotas.model;

public class Producto {

    private int id;
    private String nombre;
    private String tipoAnimal;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    public Producto() {
    }

    public Producto(
            int id,
            String nombre,
            String tipoAnimal,
            double precioCompra,
            double precioVenta,
            int stock
    ) {
        this.id = id;
        this.nombre = nombre;
        this.tipoAnimal = tipoAnimal;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}