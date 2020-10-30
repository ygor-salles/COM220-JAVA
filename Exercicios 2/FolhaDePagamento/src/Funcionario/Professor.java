package Funcionario;

import java.util.Vector;

/**
 *
 * @author Jean
 */
public class Professor extends Funcionario {

    private String titulacao;
    private double salarioHora;
    private int nAulas;

    public Professor(int pCod, String pNome, String pTitulacao, double pSalarioHora, int pNAulas) {
        super(pCod, pNome);
        titulacao = pTitulacao;
        salarioHora = pSalarioHora;
        nAulas = pNAulas;
    }

    public double calculaSalario(int pMes, int pAno) {
        int faltas = 0;

        for (Object v : getPontoMensal()) {
            
            if(((PontoFuncionario) v).getMes() == pMes && ((PontoFuncionario) v).getAno() == pAno) {
                faltas += ((PontoFuncionario) v).getNFaltas();
            }
        }

        return ((salarioHora * nAulas) - (salarioHora * faltas));
    }

    public double calculaBonus(int pMes, int pAno) {
        int pont = 0;
        double bonus = 10, porc = 1000;
        
        for (Object v : getPontoMensal()) {
            if (((PontoFuncionario) v).getMes() == pMes && ((PontoFuncionario) v).getAno() == pAno) {
                pont = ((PontoFuncionario) v).getNAtrasos();
            }
        }

        if (pont >= 10 || pont < 0) {
           return 0;
        }
        return (calculaSalario(pMes, pAno) * ((10 - pont)*((bonus-pont)/porc)));
    }

}
