package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculas implements IServicioPeliculas{
    private final List<Pelicula> peliculaList;

    public ServicioPeliculas(){
        this.peliculaList = new ArrayList<>();
    }

    @Override
    public void listarPelicula() {
        System.out.println("** Listado de peliculas **");
        peliculaList.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculaList.add(pelicula);
        System.out.println("Se agrega la pelicula: "+pelicula.getNombre());
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresa el indice de la pelicula encontrada en lista
        var indice = peliculaList.indexOf(pelicula);
        if(indice == -1){
            System.out.println("No se encontro la pelicula buscada "+pelicula);
        }else{
            System.out.println("Pelicula encontrada en el indice "+indice);
        }
    }

    public static void main(String[] args) {
        var pelicula1 = new Pelicula("Batman begins");
        var pelicula2 = new Pelicula("El caballero de la noche");
        var pelicula3 = new Pelicula("Matrix revelaciones");
        var pelicula4 = new Pelicula("Liga de la Justicia");

        //Patron de diseño service
        IServicioPeliculas servicio = new ServicioPeliculas();
        servicio.agregarPelicula(pelicula1);
        servicio.agregarPelicula(pelicula2);
        servicio.agregarPelicula(pelicula3);
        servicio.listarPelicula();
        //buscar pelicula usando metodo equals y hashCode
        servicio.buscarPelicula(pelicula4);
    }
}
