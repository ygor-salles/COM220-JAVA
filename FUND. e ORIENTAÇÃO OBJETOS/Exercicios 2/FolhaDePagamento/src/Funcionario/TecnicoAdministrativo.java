package Funcionario;

/**
 *
 * @author Jean
 */
public class TecnicoAdministrativo extends Funcionario {

    private String funcao;
    private double salarioMensal;

    public TecnicoAdministrativo(int pCod, String pNome, String pFuncao, double pSalarioMensal) {
        super(pCod, pNome);
        funcao = pFuncao;
        salarioMensal = pSalarioMensal;
    }

    public double calculaSalario(int pMes, int pAno) {
        int faltas = 0;

        for (Object v : getPontoMensal()) {

            if (((PontoFuncionario) v).getMes() == pMes && ((PontoFuncionario) v).getAno() == pAno) {
                faltas += ((PontoFuncionario) v).getNFaltas();
            }
        }
        return (salarioMensal - ((salarioMensal / 30) * faltas));
    }

    public double calculaBonus(int pMes, int pAno) {
        int pont = 0;
        double bonus = 10, porc = 1000;
        
        for (Object v : getPontoMensal()) {
            if (((PontoFuncionario) v).getMes() == pMes && ((PontoFuncionario) v).getAno() == pAno) {
                pont = ((PontoFuncionario) v).getNAtrasos();
            }
        }

        if (pont >= 8 || pont < 0) {
           return 0;
        }
        return (calculaSalario(pMes, pAno) * ((8 - pont)*((bonus-pont)/porc)));
    }

}
