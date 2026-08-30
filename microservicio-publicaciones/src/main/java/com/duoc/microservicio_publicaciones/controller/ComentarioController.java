package com.duoc.microservicio_publicaciones.controller;

import com.duoc.microservicio_publicaciones.model.Comentario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final List<Comentario> comentarios = List.of(
            new Comentario(
                    1,
                    1,
                    "Camila Soto",
                    "Muy buena introducción a Spring Boot."
            ),
            new Comentario(
                    2,
                    1,
                    "Felipe González",
                    "La explicación fue clara y fácil de entender."
            ),
            new Comentario(
                    3,
                    2,
                    "Daniela Rojas",
                    "Java es un lenguaje muy útil para backend."
            ),
            new Comentario(
                    4,
                    3,
                    "Carlos Muñoz",
                    "Me gustaría aprender más sobre las API REST."
            ),
            new Comentario(
                    5,
                    4,
                    "Fernanda Díaz",
                    "Los controladores quedaron bien explicados."
            ),
            new Comentario(
                    6,
                    5,
                    "José Martínez",
                    "Ahora comprendo cómo se genera el JSON."
            ),
            new Comentario(
                    7,
                    6,
                    "Valentina Pérez",
                    "Git facilita mucho el trabajo colaborativo."
            ),
            new Comentario(
                    8,
                    8,
                    "Andrés Price",
                    "Los microservicios permiten organizar mejor una aplicación."
            )
    );

    @GetMapping
    public List<Comentario> obtenerComentarios() {
        return comentarios;
    }

    @GetMapping("/publicacion/{publicacionId}")
    public List<Comentario> obtenerComentariosPorPublicacion(
            @PathVariable int publicacionId
    ) {
        return comentarios.stream()
                .filter(comentario ->
                        comentario.getPublicacionId() == publicacionId
                )
                .toList();
    }
}