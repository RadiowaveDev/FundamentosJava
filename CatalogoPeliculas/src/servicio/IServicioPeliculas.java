package servicio;

import dominio.Pelicula;

public interface IServicioPeliculas {
    public void listarPelicula();
    public void agregarPelicula(Pelicula pelicula);
    public void buscarPelicula(Pelicula pelicula);
}
