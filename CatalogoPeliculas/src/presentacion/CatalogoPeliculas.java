package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculas;
import servicio.ServicioPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPeliculas {
    public static void main(String[] args) {
        var salir=false;
        var sc = new Scanner(System.in);
        //IServicioPeliculas servicio = new ServicioPeliculas();
        IServicioPeliculas servicio = new ServicioPeliculasArchivo();
        while(!salir){
            try{
                mostrarMenu();
                salir = ejecutarOpciones(sc,servicio);
            }catch (Exception e){
                System.out.println("Ocurrio un error "+e.getMessage());
            }
        }
    }

    private static void mostrarMenu(){
        System.out.println("** Catalogo de peliculas **");
        System.out.println("""
                1.Agregar pelicula
                2.Listar pelicula
                3.Buscar pelicula
                4.Salir
                """);
        System.out.print("Opcion elegida: ");
    }

    private static boolean ejecutarOpciones(Scanner sc, IServicioPeliculas servicio){
        var opcion = Integer.parseInt(sc.nextLine());
        var salir = false;
        switch(opcion){
            case 1->{
                System.out.print("Ingrese el nombre de la pelicula: ");
                var nombrePelicula = sc.nextLine();
                var pelicula = new Pelicula(nombrePelicula);
                servicio.agregarPelicula(pelicula);
            }
            case 2 ->servicio.listarPelicula();
            case 3 ->{
                System.out.print("Introduzca la pelicula a buscar: ");
                var buscar = sc.nextLine();
                servicio.buscarPelicula(new Pelicula(buscar));
            }
            case 4 ->{
                System.out.println("Hasta luego ...");
                salir=true;
            }
            default -> System.out.println("Opcion no reconocida: "+opcion);
        }
        return salir;
    }
}
