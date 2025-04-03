# Proyecto API Libros

Este proyecto es una aplicación que permite visualizar información de libros a través del consumo, mapeo, deserialización y conversión de JSON a objetos Java, utilizando Spring Boot.

## Requisitos

- Java 11 o superior
- Maven 3.6.0 o superior
- Spring Boot 2.5.0 o superior

## Instalación

1. Clona el repositorio:
    ```sh
    git clone https://github.com/tu-usuario/tu-repositorio.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    cd tu-repositorio
    ```
3. Compila el proyecto con Maven:
    ```sh
    mvn clean install
    ```

## Uso

1. Ejecuta la aplicación:
    ```sh
    mvn spring-boot:run
    ```
2. Sigue las instrucciones en la consola para interactuar con el menú principal.

## Funcionalidades

- **Mostrar información general de la API de libros**: Muestra datos generales de la API.
- **Mostrar objetos de información de libros**: Muestra información detallada de los libros.
- **Mostrar el top 10 de libros más descargados**: Muestra los 10 libros más descargados.
- **Buscar un libro por nombre**: Permite buscar un libro por su nombre y muestra información detallada del mismo.

## Clases Principales

### `EstructuraPrincipal`

Esta clase se encarga de unir las principales funcionalidades de la aplicación, permitiendo visualizar información de libros a través del consumo, mapeo, deserialización y conversión de JSON a objetos Java, utilizando Spring Boot.

- **Métodos principales**:
  - `menuPrincipal()`: Crea una estructura de menús utilizando un `switch`.
  - `obtenerDatosLibroGeneral()`: Obtiene datos generales del libro y los almacena en una lista.
  - `top10LibrosMasDescargados()`: Clasifica y muestra los 10 libros más descargados.
  - `buscarLibro()`: Permite buscar un libro por nombre y muestra información detallada del mismo.

### `InformacioLibro`

Esta clase representa la información de un libro.

- **Atributos**:
  - `tituloLibro`: Título del libro.
  - `autoresLibro`: Lista de autores del libro.
  - `numeroDescargasLibro`: Número de descargas del libro.

### `InformacionAutor`

Esta clase representa la información de un autor.

- **Atributos**:
  - `nombreAutor`: Nombre del autor.

### `NoSeEncontroLibro`

Esta clase representa una excepción personalizada que se lanza cuando no se encuentra un libro.

- **Atributos**:
  - `mensaje`: Mensaje de error.

### `Consumo`

Clase encargada de consumir datos de la API.

- **Métodos principales**:
  - `obtenerDatos(String url)`: Obtiene datos de la API a partir de una URL.

### `ConvierteDatos`

Clase encargada de convertir datos JSON a objetos Java.

- **Métodos principales**:
  - `fromJson(String json, Class<T> classOfT)`: Convierte un JSON a un objeto Java.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
