package mundoPc;

import mundoPc.modelo.Computadora;
import mundoPc.modelo.Monitor;
import mundoPc.modelo.Mouse;
import mundoPc.modelo.Teclado;
import mundoPc.servicio.Orden;


public class VentaComputadoras {

    public static void main(String[] args) {
        var mouseLenovo = new Mouse("Bluetooth","Lenovo");
        //System.out.println(mouseLenovo);
        var tecladoLenovo = new Teclado("USB","Lenovo");
        //System.out.println(tecladoLenovo);
        var monitorLenovo = new Monitor("Lenovo","27pulgadas");
        //System.out.println(monitorLenovo);
        Computadora computadoraLenovo = new Computadora("Computadora Lenovo",monitorLenovo,tecladoLenovo,mouseLenovo);
        //System.out.println(computadoraLenovo);

        Monitor monitorDell = new Monitor("Dell","15pulgadas");
        Teclado tecladoDell = new Teclado("USB","Dell");
        Mouse mouseDell = new Mouse("Usb","Dell");
        Computadora computadoraDell = new Computadora("computadora Dell",monitorDell,tecladoDell,mouseDell);

        var orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();
    }
}
