# Actividad Sumativa Semana 3 - Microservicios

## Información del estudiante

- Estudiante: Andrés Price Lohmayer
- Asignatura: Desarrollo Full Stack I
- Código: DSY2201
- Actividad: Experiencia 1 - Semana 3

## Descripción

Este repositorio contiene dos microservicios desarrollados con Java y Spring Boot.

De acuerdo con las indicaciones entregadas por el profesor, solamente se implementan consultas HTTP de tipo GET. Los datos se almacenan en listas en memoria y no se utiliza una base de datos.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Maven
- Spring Web
- Git y GitHub
- Trello

## Estructura

El repositorio contiene dos proyectos Spring Boot independientes:

- microservicio-publicaciones
- microservicio-mascotas

## Microservicio de publicaciones

Funciona en el puerto 8081.

Permite consultar publicaciones, comentarios y calificaciones.

### Endpoints

- GET /publicaciones
- GET /publicaciones/{id}
- GET /comentarios
- GET /comentarios/publicacion/{id}
- GET /calificaciones
- GET /calificaciones/publicacion/{id}
- GET /calificaciones/publicacion/{id}/promedio

## Microservicio de tienda de mascotas

Funciona en el puerto 8082.

Permite consultar productos, ventas y ganancias.

### Endpoints

- GET /productos
- GET /productos/{id}
- GET /productos/animal/{tipoAnimal}
- GET /ventas
- GET /ganancias/diarias?fecha=2026-08-30
- GET /ganancias/mensuales?anio=2026&mes=8
- GET /ganancias/anuales?anio=2026

## Cálculo de ganancias

La ganancia se calcula mediante la siguiente fórmula:

(precio de venta - precio de compra) x cantidad vendida

## Repositorio

https://github.com/Lohmayer/actividad-sumativa-microservicios