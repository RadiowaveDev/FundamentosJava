package mundoPc.modelo;

public class Teclado extends DispositivoEntrada{
    private final int tecladoId;
    private static int contadorTeclados=0;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        tecladoId = ++contadorTeclados;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "tecladoId=" + tecladoId +
                "} "+super.toString();
    }
}
