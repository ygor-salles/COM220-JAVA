package Model;

public class Professor extends Funcionario	 {
	private String aTitulacao;
	private double aSalarioHora;
	private int aNroAulas;
	
	public Professor(int pCodigo, String pNome, String pTitulacao, double pSalarioHora, int pNroAulas){
		super(pCodigo,pNome);
		this.aTitulacao = pTitulacao;
		this.aSalarioHora = pSalarioHora;
		this.aNroAulas = pNroAulas;
	}

	public String getaTitulacao() {
		return aTitulacao;
	}

	public double getaSalarioHora() {
		return aSalarioHora;
	}

	public int getaNroAulas() {
		return aNroAulas;
	}

	@Override
	public double calculaSalario(int pMes, int pAno) {
		double salario = this.aSalarioHora * this.aNroAulas;
        for (int i = 0; i < getPontoMensal().size(); i++) {
            pontoFunc pf = getPontoMensal().elementAt(i);
            if (pf.getaAno() == pAno && pf.getaMes() == pMes) {
                salario -= (pf.getaNroFaltas() * this.aSalarioHora);
                salario += (calculaBonus(pMes, pAno)) * salario;
                System.out.println((calculaBonus(pMes, pAno)));
                break;
            }
        }
        return salario;
	}

	@Override
	public double calculaBonus(int pMes, int pAno) {
		for (int i = 0; i < getPontoMensal().size(); i++) {
            pontoFunc pf = getPontoMensal().elementAt(i);
            if (pf.getaAno() == pAno && pf.getaMes() == pMes) {
                if (pf.getaNroAtrasos() < 10){
                    double bonus = 10 - pf.getaNroAtrasos();
                    return bonus/100;
                }
                break;
         }
        }
        return 0;
	}
}
