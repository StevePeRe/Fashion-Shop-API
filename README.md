# Fashion Shop API 🛍️

API REST para tienda de moda con **arquitectura hexagonal** y patrones avanzados.

## 🏗️ Arquitectura & Tecnologías

**Estructura del proyecto**
```
📁 Estructura hexagonal
├── application/ (Commands, Queries, Handlers)
├── domain/ (Entidades, Value Objects, Repositorios)
└── infrastructure/ (REST, JPA, Mappers)
```

**Patrones implementados**
- ✅ **Arquitectura Hexagonal** (Ports & Adapters)
- ✅ **CQRS** (Commands vs Queries separadas)
- ✅ **Mediator Pattern** (Handlers desacoplados)
- ✅ **MapStruct** (Mappers type-safe)
- ✅ **Spring Boot 4.0.2**

**Tecnologías principales**
- Spring Boot 4.0.2 - Framework principal
- Java 21 - Lenguaje de programación
- Maven - Gestión de dependencias y construcción

**Dependencias del Proyecto**
- `spring-boot-starter-web` - Para crear aplicaciones web RESTful
- `spring-boot-starter-validation` - Validación de datos
- `spring-boot-devtools` - Herramientas de desarrollo (hot reload)
- `spring-boot-starter-test` - Testing framework

**Herramientas de Desarrollo**
- *Lombok* - Reducción de código boilerplate mediante anotaciones
- *MapStruct 1.6.3* - Mapeo automático entre DTOs y entidades
- *lombok-mapstruct-binding 0.2.0* - Integración entre Lombok y MapStruct

**Documentación API**
- SpringDoc OpenAPI 2.8.6 - Generación automática de documentación Swagger/OpenAPI

## 🚀 Características principales

- **Create, Read, Update, Delete** productos completos
- **Separación clara** Dominio ↔ Aplicación ↔ Infraestructura
- **DTOs específicos** por caso de uso
- **Testeabilidad** nativa (cada capa independiente)
- **Código limpio** y mantenible

## 🎯 Roadmap futuro

- [ ] Autenticación JWT + Autorización
- [ ] Carrito de compras + Pedidos
- [ ] Paginación + Filtros avanzados
- [ ] Docker + Docker Compose
- [ ] Testing unitario/integration completo
- [ ] Documentación OpenAPI/Swagger

## 📝 Requisitos Previos
- Java 21 JDK
- Maven 3.6+ (o usar el wrapper incluido)
- Docker (opcional)

## 🖥️ Despliegue
  **Clonación**
```
git clone https://github.com/StevePeRe/Fashion-Shop-API.git
cd Fashion-Shop-API
```
  **Ejecución Local**
```
# Usando Maven Wrapper
./mvnw spring-boot:run

# O usando Maven instalado
mvn spring-boot:run
```
  **Ejecución con Docker**
  ```
# Construir imagen
docker build -t spring-boot-web-app .

# Ejecutar contenedor
docker run -p 8080:8080 spring-boot-web-app

# O usando Docker Compose
docker-compose up
```

## 📄 Documentación Swagger
- URL: http://localhost:8080/swagger-ui.html
- Especificación OpenAPI: http://localhost:8080/v3/api-docs
  

