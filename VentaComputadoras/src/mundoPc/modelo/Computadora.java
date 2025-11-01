package mundoPc.modelo;

public class Computadora {
    private int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Mouse mouse;
    private static int contadorComputadoras=0;

    private Computadora(){
        idComputadora=++contadorComputadoras;
    }
    public Computadora(String nombre, Monitor monitor, Teclado teclado, Mouse mouse) {
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                "idComputadora=" + idComputadora +
                ", nombre='" + nombre + '\'' +
                ",\nmonitor=" + monitor +
                ",\nteclado=" + teclado +
                ",\nmouse=" + mouse +
                '}';
    }
}
