package meiosdetransporte;

public class Balao extends TransporteAereo {

    private int pesoLargado = 0;

    public Balao(String pNome) {
        setNome(pNome);
    }

    public void largarPeso(double peso) {
        pesoLargado -= peso;
        System.out.println(getNome() + " largou " + pesoLargado);
    }

    public void aquecerAr(double temp) {
        System.out.println(getNome() + " aqueceu " + temp + "graus");
    }
}
