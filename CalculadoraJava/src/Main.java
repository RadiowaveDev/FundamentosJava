import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var condicion=true;
        var sc = new Scanner(System.in);
        while(condicion){
            mostrarMenu();
            try{
                condicion=ejecutarOperacion(sc);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("*** Aplicacion Claculadora ***");
        System.out.println("""
                        1.Suma
                        2.Resta
                        3.Multiplicacion
                        4.Division
                        5.Salir
                        """);
        System.out.print("Operacion a realizar: ");
    }

    public static boolean ejecutarOperacion(Scanner sc){
        var condicion=true;
        var operacion = Integer.parseInt(sc.nextLine());
        if(operacion >=1 && operacion<5){
            System.out.print("Ingrese el primer numero: ");
            var num1=Integer.parseInt(sc.nextLine());
            System.out.print("Ingrese el segundo numero: ");
            var num2=Integer.parseInt(sc.nextLine());
            switch (operacion) {
                case 1-> sumar(num1, num2);
                case 2 -> restar(num1, num2);
                case 3 -> multiplicar(num1, num2);
                case 4-> dividir(num1, num2);
            }
        } else if (operacion==5){
            System.out.println("Hasta pronto ...");
            System.out.println("=======================================");
            condicion=false;
        }else {
            System.out.println("Opcion erronea: "+operacion);
        }
        return condicion;
    }
    public static void sumar(int a, int b){
        int res=a+b;
        System.out.println("La suma de "+a+" con "+b+" es igual a "+res);
        System.out.println("=======================================");
    }
    public static void restar(int a, int b){
        int res=a-b;
        System.out.println("La resta de "+a+" con "+b+" es igual a "+res);
        System.out.println("=======================================");
    }
    public static void multiplicar(int a, int b){
        int res=a*b;
        System.out.println("La multiplicacion de "+a+" con "+b+" es igual a "+res);
        System.out.println("=======================================");
    }
    public static void dividir(int a, int b){
        if(b!=0){
            var res=a/b;
            System.out.println("La division de "+a+" con "+b+" es igual a "+res);
        }else{
            int res=0;
            System.out.println("La division entre cero no esta determinada");
        }
        System.out.println("=======================================");
    }
}
