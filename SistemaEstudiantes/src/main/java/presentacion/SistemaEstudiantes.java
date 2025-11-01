package presentacion;

import datos.EstudianteDao;
import dominio.Estudiante;

import java.util.List;
import java.util.Scanner;

public class SistemaEstudiantes {
    public static void main(String[] args) {
        var salir=false;
        var scan = new Scanner(System.in);
        var estudianteDao = new EstudianteDao();
        while(!salir){
            try{
                mostrarMenu();
                salir=ejecutarOperaciones(scan, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error "+e.getMessage());
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("** Sistema de estudiantes **");
        System.out.print("""
                1. Listar estudiantes
                2. Buscar estudiante
                3. Agregar estudiante
                4. Modificar estudiante
                5. Eliminar estudiante
                6. Salir
                Elige una opcion:
                """);
    }

    public static boolean ejecutarOperaciones(Scanner scan, EstudianteDao estudianteDao){
        var salir=false;
        var opcion = Integer.parseInt(scan.nextLine());
        switch (opcion){
            case 1 -> {
                System.out.println("* Listado de estudiantes *");
                List<Estudiante> estudianteList = estudianteDao.listarEstudiantes();
                estudianteList.forEach(System.out::println);
                System.out.println("==============================================");
            }
            case 2 -> {
                System.out.println("** Busqueda por Id **");
                System.out.print("Introduce el id del estudiante a buscar: ");
                var estudianteId = Integer.parseInt(scan.nextLine());
                var estudiante = new Estudiante(estudianteId);
                var encontrado = estudianteDao.findById(estudiante);
                if(encontrado){
                    System.out.println("Estudiante encontrado: "+estudiante);
                }else{
                    System.out.println("Estudiante no encontrado "+estudiante.getIdEstudiante());
                }
                System.out.println("==============================================");
            }
            case 3 ->{
                System.out.println("* Agregar estudiante *");
                System.out.print("Nombre: ");
                var nombre = scan.nextLine();
                System.out.print("Apellido: ");
                var apellido = scan.nextLine();
                System.out.print("Telefono: ");
                var telefono = scan.nextLine();
                System.out.print("Email: ");
                var email = scan.nextLine();
                var nuevoEstudiante = new Estudiante(nombre,apellido,telefono,email);
                var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
                if(agregado){
                    System.out.println("Estudiante agregado: "+nuevoEstudiante);
                }else{
                    System.out.println("No se agrego el estudiante "+nuevoEstudiante);
                }
                System.out.println("==============================================");
            }
            case 4 ->{
                System.out.println("* Modificar estudiante *");
                System.out.print("Id estudiante: ");
                var id = Integer.parseInt(scan.nextLine());
                System.out.print("Nombre: ");
                var nombre = scan.nextLine();
                System.out.print("Apellido: ");
                var apellido = scan.nextLine();
                System.out.print("Telefono: ");
                var telefono = scan.nextLine();
                System.out.print("Email: ");
                var email = scan.nextLine();
                var estudiante = new Estudiante(id,nombre,apellido,telefono,email);
                var modificado = estudianteDao.modificarEstudiante(estudiante);
                if(modificado){
                    System.out.println("Estudiante modificado "+estudiante);
                }else{
                    System.out.println("No se modifico el estudiante: "+estudiante);
                }
                System.out.println("==============================================");
            }
            case 5 ->{
                System.out.println("* Eliminar estudiante *");
                System.out.print("Id estudiante: ");
                var id = Integer.parseInt(scan.nextLine());
                var estudiante = new Estudiante(id);
                var eliminado = estudianteDao.eliminarEstudiante(estudiante);
                if(eliminado){
                    System.out.println("Estudiante eliminado: "+estudiante);
                }else{
                    System.out.println("No se elimino el estudiante "+estudiante);
                }
                System.out.println("==============================================");
            }
            case 6 ->{
                System.out.println("Hasta luego ...");
                salir=true;
            }
            default -> System.out.println("Opcion no reconocida: "+opcion);
        }
        return salir;
    }
}