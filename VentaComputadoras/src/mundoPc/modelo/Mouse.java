package mundoPc.modelo;

public class Mouse extends DispositivoEntrada{
    private final int mouseId;
    private static int contadorMouses=0;

    public Mouse(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        mouseId = ++contadorMouses;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "mouseId=" + mouseId +
                "} "+ super.toString();
    }
}
