
public class Diarista extends EmpDomestica {

    private int diasTrabalhados;
    private double valorPorDia;

    public Diarista(String pNome, int pTelefone, int dT, double vPD) {
        setNome(pNome);
        setTelefone(pTelefone);

        diasTrabalhados = dT;
        valorPorDia = vPD;
    }

    public double getSalario() {
        return (diasTrabalhados * valorPorDia);
    }

}
