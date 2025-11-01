package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{
    private final String NOMBRE_ARCHIVO="peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Si existe el archivo, no se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //Si no existe, se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo "+e.getMessage());
        }
    }

    @Override
    public void listarPelicula() {
        //volvemos abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("** Listado de peliculas **");
            var input = new BufferedReader(new FileReader(archivo));
            //Leemos linea a linea el archivo
            String linea;
            linea = input.readLine();
            //leemos todas las lineas disponibles
            while(linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = input.readLine();
            }
            input.close();
        }catch(Exception e){
            System.out.println("Ocurrio un error "+e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar=false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar=archivo.exists();
            var output = new PrintWriter(new FileWriter(archivo,anexar));
            //se agrega la pelicula(toString)
            output.println(pelicula);
            output.close();
            System.out.println("Se agrego al archivo: "+pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error "+e.getMessage());
        }

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            var input =  new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto=input.readLine();
            var indice=1;
            var encontrada=false;
            var peliculaBuscar=pelicula.getNombre();
            while(lineaTexto != null){
                //Se busca sin importar minuscula o mayuscula
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada=true;
                    break;
                }
                lineaTexto=input.readLine();
                indice++;
            }
            if(encontrada){
                System.out.println("Pelicula "+lineaTexto+" encontrada - linea "+indice);
            }else{
                System.out.println("No se ha encontrado la pelicula "+pelicula.getNombre());
            }
            input.close();
        }catch (Exception e){
            System.out.println("Se encontro el error "+e.getMessage());
        }
    }
}
