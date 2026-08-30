package com.duoc.microservicio_publicaciones.controller;

import com.duoc.microservicio_publicaciones.model.Calificacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private final List<Calificacion> calificaciones = List.of(
            new Calificacion(1, 1, "Camila Soto", 5),
            new Calificacion(2, 1, "Felipe González", 4),

            new Calificacion(3, 2, "Daniela Rojas", 4),
            new Calificacion(4, 2, "Carlos Muñoz", 5),

            new Calificacion(5, 3, "Fernanda Díaz", 5),
            new Calificacion(6, 3, "José Martínez", 5),

            new Calificacion(7, 4, "Valentina Pérez", 4),
            new Calificacion(8, 4, "Andrés Price", 3),

            new Calificacion(9, 5, "Camila Soto", 5),
            new Calificacion(10, 5, "Felipe González", 4),

            new Calificacion(11, 6, "Daniela Rojas", 4),
            new Calificacion(12, 6, "Carlos Muñoz", 4),

            new Calificacion(13, 7, "Fernanda Díaz", 5),
            new Calificacion(14, 7, "José Martínez", 3),

            new Calificacion(15, 8, "Valentina Pérez", 5),
            new Calificacion(16, 8, "Andrés Price", 4)
    );

    @GetMapping
    public List<Calificacion> obtenerCalificaciones() {
        return calificaciones;
    }

    @GetMapping("/publicacion/{publicacionId}")
    public List<Calificacion> obtenerCalificacionesPorPublicacion(
            @PathVariable int publicacionId
    ) {
        return calificaciones.stream()
                .filter(calificacion ->
                        calificacion.getPublicacionId() == publicacionId
                )
                .toList();
    }

    @GetMapping("/publicacion/{publicacionId}/promedio")
    public ResponseEntity<Map<String, Object>> obtenerPromedio(
            @PathVariable int publicacionId
    ) {
        List<Calificacion> calificacionesPublicacion = calificaciones.stream()
                .filter(calificacion ->
                        calificacion.getPublicacionId() == publicacionId
                )
                .toList();

        if (calificacionesPublicacion.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        double promedio = calificacionesPublicacion.stream()
                .mapToInt(Calificacion::getPuntaje)
                .average()
                .orElse(0.0);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("publicacionId", publicacionId);
        respuesta.put(
                "cantidadCalificaciones",
                calificacionesPublicacion.size()
        );
        respuesta.put("promedio", promedio);

        return ResponseEntity.ok(respuesta);
    }
}