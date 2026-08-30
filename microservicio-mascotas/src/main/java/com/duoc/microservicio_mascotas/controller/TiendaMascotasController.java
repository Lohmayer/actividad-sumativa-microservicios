package com.duoc.microservicio_mascotas.controller;

import com.duoc.microservicio_mascotas.model.Producto;
import com.duoc.microservicio_mascotas.model.Venta;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/ganancias/diarias")
    public ResponseEntity<Map<String, Object>> obtenerGananciaDiaria(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fecha) {

        List<Venta> ventasDelDia = ventas.stream()
                .filter(venta -> venta.getFecha().equals(fecha))
                .toList();

        double ganancia = ventasDelDia.stream()
                .mapToDouble(this::calcularGananciaVenta)
                .sum();

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("fecha", fecha);
        respuesta.put("cantidadVentas", ventasDelDia.size());
        respuesta.put("ganancia", ganancia);

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/ganancias/mensuales")
    public ResponseEntity<Map<String, Object>> obtenerGananciaMensual(
            @RequestParam int anio,
            @RequestParam int mes) {

        if (mes < 1 || mes > 12) {
            Map<String, Object> error = new LinkedHashMap<>();
            error.put("error", "El mes debe estar entre 1 y 12");
            return ResponseEntity.badRequest().body(error);
        }

        List<Venta> ventasDelMes = ventas.stream()
                .filter(venta -> venta.getFecha().getYear() == anio)
                .filter(venta -> venta.getFecha().getMonthValue() == mes)
                .toList();

        double ganancia = ventasDelMes.stream()
                .mapToDouble(this::calcularGananciaVenta)
                .sum();

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("anio", anio);
        respuesta.put("mes", mes);
        respuesta.put("cantidadVentas", ventasDelMes.size());
        respuesta.put("ganancia", ganancia);

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/ganancias/anuales")
    public ResponseEntity<Map<String, Object>> obtenerGananciaAnual(
            @RequestParam int anio) {

        List<Venta> ventasDelAnio = ventas.stream()
                .filter(venta -> venta.getFecha().getYear() == anio)
                .toList();

        double ganancia = ventasDelAnio.stream()
                .mapToDouble(this::calcularGananciaVenta)
                .sum();

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("anio", anio);
        respuesta.put("cantidadVentas", ventasDelAnio.size());
        respuesta.put("ganancia", ganancia);

        return ResponseEntity.ok(respuesta);
    }

    private double calcularGananciaVenta(Venta venta) {
        Producto productoVendido = productos.stream()
                .filter(producto ->
                        producto.getId() == venta.getProductoId())
                .findFirst()
                .orElse(null);

        if (productoVendido == null) {
            return 0;
        }

        double gananciaUnitaria =
                productoVendido.getPrecioVenta()
                - productoVendido.getPrecioCompra();

        return gananciaUnitaria * venta.getCantidad();
    }
}