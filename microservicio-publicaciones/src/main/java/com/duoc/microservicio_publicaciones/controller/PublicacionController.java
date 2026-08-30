package com.duoc.microservicio_publicaciones.controller;

import com.duoc.microservicio_publicaciones.model.Publicacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    private final List<Publicacion> publicaciones = List.of(
            new Publicacion(
                    1,
                    "Introducción a Spring Boot",
                    "Conceptos básicos para comenzar a desarrollar microservicios.",
                    "Andrés Price"
            ),
            new Publicacion(
                    2,
                    "Aprendiendo Java",
                    "Principales características del lenguaje Java.",
                    "Camila Soto"
            ),
            new Publicacion(
                    3,
                    "Creando una API REST",
                    "Pasos iniciales para construir una API REST.",
                    "Felipe González"
            ),
            new Publicacion(
                    4,
                    "Uso de controladores",
                    "Funcionamiento de los controladores en Spring Boot.",
                    "Daniela Rojas"
            ),
            new Publicacion(
                    5,
                    "Respuestas en formato JSON",
                    "Cómo Spring Boot transforma objetos Java en JSON.",
                    "Carlos Muñoz"
            ),
            new Publicacion(
                    6,
                    "Trabajo colaborativo con Git",
                    "Uso de Git para registrar los cambios de un proyecto.",
                    "Fernanda Díaz"
            ),
            new Publicacion(
                    7,
                    "Organización con Trello",
                    "Cómo organizar las tareas de desarrollo en un tablero.",
                    "José Martínez"
            ),
            new Publicacion(
                    8,
                    "Microservicios básicos",
                    "Características principales de una arquitectura de microservicios.",
                    "Valentina Pérez"
            )
    );

    @GetMapping
    public List<Publicacion> obtenerPublicaciones() {
        return publicaciones;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(
            @PathVariable int id
    ) {
        return publicaciones.stream()
                .filter(publicacion -> publicacion.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}