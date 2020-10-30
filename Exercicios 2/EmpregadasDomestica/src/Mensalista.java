
public class Mensalista extends EmpDomestica {

    private double valorMensal;

    public Mensalista(String pNome, int pTelefone, double vM) {
        setNome(pNome);
        setTelefone(pTelefone);

        valorMensal = vM;
    }

    public double getSalario() {
        return valorMensal;
    }
}
