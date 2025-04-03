package com.alura.apiLibros.principal;
import com.alura.apiLibros.exceptions.NoSeEncontroLibro;
import com.alura.apiLibros.service.*;
import java.io.IOException;
import java.util.*;
/**
 * Esta clase se encarga de unir las principales funcionalidades de la aplicacion,
 * que nos permite vizualizar informacion de libros a travez del consumo, mapeo, deserializacion, y conversion de Json a
 * Objetos java, utilizando SpringBoot.
 *
 */
public class EstructuraPrincipal {
    private final String URL_BASE = "http://gutendex.com/books";
    private Consumo consumo = new Consumo();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner scanner = new Scanner(System.in);
    private String Json;
    /**
     * Llama a todas las funciones para crear una estructura de menus utilizando un switch()
     * @throws IOException
     * @throws InterruptedException
     */
    public void menuPrincipal() throws IOException, InterruptedException {
        String menu = """
                
                
                
                |1| Datos generales de la Api de Libros
                |2| Objetos Informacion libro
                |3| Top 10 libros mas descargados
                |4| Buscar un libro por nombre
                |5| Salir
                
                Ingrese una opcion disponible:
                """;
        //objetos de informacion libro
        List<Results> informacioLibro = obtenerDatosLibroGeneral();
        while (true){
            System.out.println(menu);
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    //Datos generales de la API
                    System.out.println(consumo.obtenerDatos(URL_BASE));

                break;
                case 2:
                    //obejtos de infomracion libro
                    System.out.println("Mostrando informacion de libro");
                    informacioLibro.stream()
                            .flatMap(e -> e.arrayLibros().stream())
                            .forEach(System.out::println);
                break;
                case 3:
                    //top 10 libros mas descargados
                    System.out.println("\n\t\tTOP 10 LIBROS MAS DESCARGADOS");
                    top10LibrosMasDescargados(informacioLibro);
                break;
                case 4:
                    //buscar libro por nombre
                    try {
                        buscarLibro();
                    }catch (NoSeEncontroLibro e){
                        System.out.println(e.getMessage());
                    }finally {
                        System.out.println("Ejecucion finalizada");
                    }
                break;
            }
        }
    }
    /**
     * Este metodo se encarga de obtener generales del libro para almacenarlas en una List<> del tipo de dato Results
     * esta lista almacena el Json consumido a travez del metodo fromJson
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public List<Results> obtenerDatosLibroGeneral() throws IOException, InterruptedException {
        Json = consumo.obtenerDatos(URL_BASE);
        List<Results> informacioLibro = new ArrayList<>();
        informacioLibro.add(convierteDatos.fromJson(Json, Results.class));
        return informacioLibro;
    }
    /**
     *
     * @param informacionLibro recibe un paramtro List<Results> con el objetico de que dentro de la funcion se utiliza
     *                         un stream para utilizar operaciones itermedias, que permitan clasificar los 10 libros mas
     *                         descargados.
     */
    public void top10LibrosMasDescargados(List<Results> informacionLibro){
        informacionLibro.stream()
                .flatMap(e -> e.arrayLibros().stream())
                .sorted(Comparator.comparing(InformacioLibro::numeroDescargasLibro).reversed())
                .limit(10)
                .forEach(e -> System.out.println("Nombre libro: " + e.tituloLibro() +
                                                           "   Cantidad descargas: " + e.numeroDescargasLibro()));
    }

    /**
     * Este metodo permite realizar una busqueda personalida de un libro a travez de consola en la que el usuario
     * puede ingresar el nombre del libro requerido, mostrando asi la informacion basica detallada que este tiene.
     * @throws IOException
     * @throws InterruptedException
     */
    public void buscarLibro() throws IOException, InterruptedException {
        System.out.print("Ingrese el nombre del libro que desea buscar: ");
        String busqueda = scanner.nextLine();
        Json = consumo.obtenerDatos(URL_BASE + "?search=" + busqueda.replace(" ", "+"));

        List<Results> results = new ArrayList<>();
        results.add(convierteDatos.fromJson(Json, Results.class));

        if(Json.contains("null")){
            throw new NoSeEncontroLibro("Libro no disponible");
        }else {
            System.out.println("Informacion del libro buscado");
            results.stream()
                    .flatMap(e -> e.arrayLibros().stream())
                    .limit(5)
                    .sorted(Comparator.comparing(InformacioLibro::numeroDescargasLibro).reversed())
                    .forEach(n -> {
                        String autores = n.autoresLibro().stream()
                                .map(InformacionAutor::nombreAutor)
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("No authors");
                        System.out.println("Nombre Libro: " + n.tituloLibro() + "     Autor: " + autores + "   Cant. descargas: " + n.numeroDescargasLibro());
                    });
        }
    }
}
