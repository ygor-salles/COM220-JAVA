
public class Horista extends EmpDomestica{

    private double horasTrabalhadas;
    private double valorPorHora;

    public Horista(String pNome, int pTelefone, double hT, double vPH) {
        setNome(pNome);
        setTelefone(pTelefone);
        
        horasTrabalhadas = hT;
        valorPorHora = vPH;
        
    }
    public double getSalario() {
        return (horasTrabalhadas * valorPorHora);
    }
}
