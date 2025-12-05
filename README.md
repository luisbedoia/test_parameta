# Parameta APIs

Este proyecto contiene dos servicios Spring Boot (REST y SOAP) que se orquestan mediante Docker Compose.

## Requisitos previos
- Docker 18+ y Docker Compose 2+
- Maven 3.9+ y JDK 17 (solo si deseas compilar el código localmente)

## Cómo iniciar la aplicación
```bash
mvn clean package
docker compose up --build
```
- El comando de Maven genera los `jar` de `api-rest` y `api-soap`.
- `docker compose` levanta MySQL, el servicio SOAP (puerto 8081) y la API REST (puerto 8080).

Cuando los contenedores estén en estado `healthy`, la API REST quedará disponible en `http://localhost:8080/api/employees`.

## Cómo probar la API REST
Ejemplo con `curl` (todos los campos son obligatorios):
```bash
curl "http://localhost:8080/api/employees?firstName=Juan&lastName=Lopez&documentType=CC&documentNumber=12345678&birthDate=1990-01-01&companyEntryDate=2018-05-15&position=Developer&salary=4500"
```
La respuesta será un JSON con el resultado de la validación del empleado. Si algún dato es inválido, el servicio responde con un error 400 y el detalle correspondiente.

Para detener todos los contenedores, ejecuta:
```bash
docker compose down
```
