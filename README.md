# Fintech Backend – Sistema de Transacciones

Backend desarrollado con **Spring Boot WebFlux**, encargado de exponer una API reactiva para la gestión de transacciones y cálculo de comisiones.

---

## Tecnologías usadas

- Java 17
- Spring Boot WebFlux
- Spring Data R2DBC
- Base de datos H2 (en memoria)
- Docker
- Maven
- JUnit / Mockito

---

## Arquitectura (muy básica)

- **Controller**: expone los endpoints REST.
- **Service**: contiene la lógica de negocio.
- **Repository**: acceso a datos reactivo (R2DBC).
- **Domain**: entidades del sistema.
- **Strategy**: cálculo de comisiones siguiendo SOLID.
- **Config**: configuración global (CORS, excepciones, OpenAPI).

Se aplican principios de **Clean Code** y **SOLID**.

---

## Ejecución en local (sin Docker)

```bash
mvn clean spring-boot:run
```

## Ejecución con Docker

mvn clean package -DskipTests
docker build -t fintech .
docker run -p 8080:8080 fintech
