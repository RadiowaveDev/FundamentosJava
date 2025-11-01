package mundoPc.modelo;

public class Monitor {
    private final int monitorId;
    private String marca;
    private String medida;
    private static int contadorMonitores=0;

    private Monitor(){
        monitorId=++contadorMonitores;
    }
    public Monitor(String marca, String medida) {
        this(); // Llamada a constructor private
        this.marca = marca;
        this.medida = medida;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "monitorId=" + monitorId +
                ", marca='" + marca + '\'' +
                ", medida='" + medida + '\'' +
                '}';
    }
}
