package com.duoc.microservicio_mascotas.controller;

import com.duoc.microservicio_mascotas.model.Producto;
import com.duoc.microservicio_mascotas.model.Venta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TiendaMascotasController {

    private final List<Producto> productos = List.of(
        new Producto(1, "Alimento premium", "Perro", 12000, 16990, 20),
        new Producto(2, "Arena sanitaria", "Gato", 5500, 8990, 30),
        new Producto(3, "Juguete mordedor", "Perro", 2500, 4990, 25),
        new Producto(4, "Rascador", "Gato", 15000, 22990, 10),
        new Producto(5, "Jaula mediana", "Ave", 18000, 27990, 8),
        new Producto(6, "Alimento para conejos", "Conejo", 4500, 7490, 15),
        new Producto(7, "Acuario de 20 litros", "Pez", 22000, 34990, 6),
        new Producto(8, "Correa ajustable", "Perro", 4000, 7990, 18)
    );

    private final List<Venta> ventas = List.of(
        new Venta(1, 1, 2, LocalDate.of(2026, 8, 30)),
        new Venta(2, 2, 3, LocalDate.of(2026, 8, 30)),
        new Venta(3, 3, 4, LocalDate.of(2026, 8, 29)),
        new Venta(4, 4, 1, LocalDate.of(2026, 8, 28)),
        new Venta(5, 5, 1, LocalDate.of(2026, 8, 15)),
        new Venta(6, 6, 3, LocalDate.of(2026, 7, 20)),
        new Venta(7, 7, 1, LocalDate.of(2026, 6, 10)),
        new Venta(8, 8, 2, LocalDate.of(2025, 12, 15))
    );

    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        return productos;
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/productos/animal/{tipoAnimal}")
    public List<Producto> obtenerProductosPorAnimal(
            @PathVariable String tipoAnimal) {

        return productos.stream()
                .filter(producto ->
                        producto.getTipoAnimal().equalsIgnoreCase(tipoAnimal))
                .toList();
    }

    @GetMapping("/ventas")
    public List<Venta> obtenerVentas() {
        return ventas;
    }
}