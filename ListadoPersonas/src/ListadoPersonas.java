import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonas {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        List<Persona> personaList = new ArrayList<>();
        var salir=false;
        while(!salir){
            mostrarMenu();
            try{
                salir= ejecutarOperacion(sc,personaList);
            }catch (Exception e){
                System.out.println("Ocurrio un error "+e.getMessage());
            }
        }
    }
    private static void mostrarMenu (){
        System.out.println("*** Listado de personas ***");
        System.out.println("""
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Opcion elegida: ");
    }

    private static boolean ejecutarOperacion(Scanner sc,List<Persona> personaList){
        var opcion = Integer.parseInt(sc.nextLine());
        var salir=false;
        switch (opcion){
            case 1 ->{
                System.out.print("Ingrese nombre de la persona: ");
                var name = sc.nextLine();
                System.out.print("Ingrese telefono: ");
                var phone = sc.nextLine();
                System.out.print("Ingrese email: ");
                var email = sc.nextLine();
                var persona = new Persona(name,phone,email);
                personaList.add(persona);
                System.out.println("La lista tiene "+personaList.size()+" personas registradas.");
            }
            case 2 ->{
                System.out.println("* Lista de personas registradas *");
                //Mejora usando Lambda y metodos de referencia
                //personaList.forEach((persona -> System.out.println(persona)));
                personaList.forEach(System.out::println); //metodo de referencia ::
            }
            case 3 ->{
                System.out.println("Hasta luego ...");
                salir=true;
            }
            default -> {
                System.out.println("Opcion errada: "+opcion);
            }
        }
        return salir;
    }

}
