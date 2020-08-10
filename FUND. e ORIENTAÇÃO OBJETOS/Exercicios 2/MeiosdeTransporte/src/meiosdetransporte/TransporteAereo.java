package meiosdetransporte;

public abstract class TransporteAereo extends Transporte {

    private int altitudeAtual = 0;

    public void subir(int m) {
        altitudeAtual += m;
    }

    public void descer(int m) {
        altitudeAtual -= m;
    }
}
