# Registro de inventario del estado de Vacunación de los empleados

Para el desarrollo de mi aplicación eh usado tecnologías como: Springboot del Lado del BackEnd y Java 8. Implementando para la seguridad Web el uso de Jason Web Token

## Requisitos

- Java 8
- Spring Boot 2.2.2
- MySQL
- Maven 

## Configuración
- Antes de Ejecutar el Programa ir a la ruta main\java\com\reto.inventario\util desmarcar lo comentado para que el proceso de creación de Roles y usuarios se realize de forma inmediata
- Tener una base de datos con el nombre reto``

### Base de Datos

- spring.datasource.url=jdbc:mysql://localhost/reto?
- serverTimezone=America/Guayaquil

#### nombre de usuario y contraseña
- spring.datasource.username = root
- spring.datasource.password = sasa

#### mostrar sentencias SQL en la consola
- spring.jpa.show-sql = true

#### actualizar base de datos y crear entidades
- spring.jpa.hibernate.ddl-auto = update

#### hibernate genera SQL optimizado
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

#### security
- jwt.secret = secret
- jwt.expiration = 36000

## security
- Dentro de la implementación de JWT luego de la creación de un usuario con su Rol, tomar en cuenta el token generado para hacer uso del mismo para bearer token
## creación de un usuario para login
- {
    "nombre":"admin",
    "nombreUsuario": "admin",
    "email":"correo@correo.com",
    "password":"admin",
    "roles":["admin"]
}
- En caso de no especificar el rol, este tomará en cuenta como el registro de un usuario normal
## datos para el login
- {
    "nombreUsuario": "admin",
    "password":"admin"
## 
