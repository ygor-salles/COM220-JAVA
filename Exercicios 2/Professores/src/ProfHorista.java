// CLASSE PROFESSOR HORISTA

public class ProfHorista extends Professor {

    private double aSalarioHora;

    // CONSTRUTOR COM SALARIO
    public ProfHorista(String pNome, int pMatricula, int pCargaHoraria, double pSalarioHora) {
        super(pNome, pMatricula, pCargaHoraria);

        aSalarioHora = pSalarioHora;
    }

    // CONSTRUTOR SEM SALARIO
    public ProfHorista(String pNome, int pMatricula, int pCargaHoraria) {
        super(pNome, pMatricula, pCargaHoraria);
    }

    // CONSTRUTOR VAZIO
    public void ProfDE() {
    }

    // INSERIR SALARIO HORA
    public void setSalarioHora(double pSalarioHora) {
        aSalarioHora = pSalarioHora;
    }

    // RETORNAR SALARIO HORA
    public int getSalarioHora() {
        return (int)aSalarioHora;
    }

    // RETORNAR SALARIO
    public double getSalario() {
        return (aSalarioHora * this.getCargaHoraria());
    }
}
