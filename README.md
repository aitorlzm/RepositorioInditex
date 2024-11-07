# Proyecto de Gestión de Precios - Inditex

## Descripción
Este proyecto es una API REST desarrollada en **Java** con **Spring Boot** que permite gestionar y consultar los precios aplicables de productos en función de la marca, la fecha y la prioridad. 
Fue diseñado para ofrecer un servicio que devuelve el precio correcto en función de una serie de reglas comerciales predefinidas.

## Tecnologías
- **Java 17**: Versión del lenguaje utilizada.
- **Spring Boot**: Framework para la creación de la API REST y la gestión de dependencias.
- **H2 Database**: Base de datos en memoria para pruebas y almacenamiento temporal de los datos de precios.
- **Maven**: Herramienta de gestión de dependencias y construcción.
- **JUnit y MockMvc**: Para la implementación de pruebas unitarias del servicio.

## Estructura del Proyecto
- **controller**: Contiene el `PreciosController` para manejar las solicitudes REST.
- **service**: Contiene la lógica de negocio en `PreciosServiceImpl`, que interactúa con el repositorio.
- **repository**: Contiene `PreciosRepository`, que maneja las operaciones de acceso a datos para los precios.
- **dto**: Incluye `PreciosDTO`, una clase que representa la estructura de datos de respuesta de la API.
- **model**: Contiene la entidad `Precios` que representa la tabla de precios en la base de datos.

## Configuración
### Base de Datos
El proyecto utiliza una base de datos en memoria H2, que se configura automáticamente al iniciar la aplicación. Los datos de prueba se cargan mediante un `DataLoader` al inicio, 
para realizar consultas y pruebas con datos predefinidos.

### Propiedades Importantes (`application.properties`)
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.hibernate.ddl-auto=update

Estas propiedades permiten acceder a la consola de H2 en la URL http://localhost:8080/h2-console con los datos configurados para la conexión.
```

### Endpoints
Consultar Precio Aplicable
Método: GET
- **URL**: /api/precios/consultar
- **Descripción**: Devuelve el precio aplicable para un producto en función de la marca y la fecha.
- **Parámetros**:

  - fecha (formato yyyy-MM-dd-HH.mm.ss): La fecha para la cual se desea conocer el precio.

  - productoId: Identificador del producto.

  - marcaId: Identificador de la marca.

#### Ejemplo de Request

GET /api/precios/consultar?fecha=2020-06-14-10.00.00&productoId=35455&marcaId=1

## Pruebas Unitarias

La clase de prueba PreciosControllerTest contiene varios casos de prueba para validar la API REST. Estas pruebas verifican que los precios retornados son correctos en función de las fechas y
los identificadores proporcionados.

### Casos de Prueba
```
Petición a las 10:00 del día 14 de junio de 2020 para el producto 35455 y la marca 1.
Petición a las 16:00 del día 14 de junio de 2020 para el producto 35455 y la marca 1.
Petición a las 21:00 del día 14 de junio de 2020 para el producto 35455 y la marca 1.
Petición a las 10:00 del día 15 de junio de 2020 para el producto 35455 y la marca 1.
Petición a las 21:00 del día 16 de junio de 2020 para el producto 35455 y la marca 1.
Cada prueba verifica que la respuesta contiene los datos correctos del precio y la prioridad aplicables.
```

Ejecución del Proyecto

Clonar el Repositorio: Clona el proyecto en tu máquina local.

Compilar el Proyecto: Ejecuta mvn clean install para compilar el proyecto y descargar las dependencias.

Ejecutar la Aplicación: Usa mvn spring-boot:run o ejecuta la clase InditexApplication directamente desde tu IDE.

### Notas
El endpoint REST /api/precios/consultar está optimizado para retornar solo un resultado aplicable, ordenado por prioridad.
Asegúrate de que los datos de prueba estén cargados en H2 antes de ejecutar las pruebas.

La URL de acceso a la consola H2 es http://localhost:8080/h2-console.
