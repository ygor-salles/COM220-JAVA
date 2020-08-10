
public class ProfDE extends Professor {

    private double aSalario;

    // CONSTRUTOR COM SALARIO
    public ProfDE(String pNome, int pMatricula, int pCargaHoraria, double pSalario) {
        super(pNome, pMatricula, pCargaHoraria);

        aSalario = pSalario;
    }

    // CONSTRUTOR SEM SALARIO
    public ProfDE(String pNome, int pMatricula, int pCargaHoraria) {
        super(pNome, pMatricula, pCargaHoraria);
    }

    // CONSTRUTOR VAZIO
    public void ProfDE() {
    }

    // INSERIR SALARIO
    public void setSalario(double pSalario) {
        aSalario = pSalario;
    }

    // RETORNAR SALARIO
    public double getSalario() {
        return aSalario;
    }
}
