package mundoPc.servicio;

import mundoPc.modelo.Computadora;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final int ordenId;
    private final List<Computadora> computadoraList;
    private static int contadorOrdenes=0;

    public Orden() {
        ordenId=++contadorOrdenes;
        computadoraList = new ArrayList<>();
    }

    public void agregarComputadora(Computadora computadora){
        computadoraList.add(computadora);
    }

    public void mostrarOrden(){
        System.out.println("Orden #: "+ordenId);
        System.out.println("Total computadoras: "+computadoraList.size());
        System.out.println();
        computadoraList.forEach(System.out::println);
    }
}
