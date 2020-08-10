package Model;

public class TecAdmin extends Funcionario {
	
	private String aFuncao;
	private double aSalarioMensal;

	public TecAdmin(int pCodigo, String pNome, String pFuncao, double pSalarioMensal) {
		super(pCodigo, pNome);
		this.aFuncao = pFuncao;
		this.aSalarioMensal = pSalarioMensal;
	}

	public void setaFuncao(String aFuncao) {
		this.aFuncao = aFuncao;
	}

	public void setaSalarioMensal(double aSalarioMensal) {
		this.aSalarioMensal = aSalarioMensal;
	}

	@Override
	public double calculaSalario(int pMes, int pAno) {
		double salario = aSalarioMensal;
        for (int i = 0; i < getPontoMensal().size(); i++) {
            pontoFunc pf = getPontoMensal().elementAt(i);
            if (pf.getaAno() == pAno && pf.getaMes() == pMes) {
                salario -= (aSalarioMensal / 30) * pf.getaNroFaltas();
                salario += calculaBonus(pMes, pAno) * salario;
            
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
                if (pf.getaNroAtrasos() < 8) {
                    double bonus = pf.getaNroAtrasos();
                    return bonus/100;
                }
            }
            break;
        }
        return 0;
	}

}
