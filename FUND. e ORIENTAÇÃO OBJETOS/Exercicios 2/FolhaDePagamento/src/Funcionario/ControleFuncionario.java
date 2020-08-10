package Funcionario;

import java.util.*;

/**
 *
 * @author Jean
 */
public class ControleFuncionario {

    private LimiteFuncionario limite;
    private Vector funcionarios;

    public ControleFuncionario() {
        funcionarios = new Vector();
        limite = new LimiteFuncionario(this);
    }

    public void inserirProfessor(int pCod, String pNome, String pTitulacao, double pSalarioHora, int pNAulas) {
        funcionarios.add(new Professor(pCod, pNome, pTitulacao, pSalarioHora, pNAulas));
    }

    public void inserirTecnicoAdministrativo(int pCod, String pNome, String pFuncao, double pSalarioMensal) {
        funcionarios.add(new TecnicoAdministrativo(pCod, pNome, pFuncao, pSalarioMensal));
    }

    public void adicionaPonto(int pCod, int pMes, int pAno) {
        for (Object v : funcionarios) {
            if (((Funcionario) v).getCod() == pCod) {
                ((Funcionario) v).adicionaPonto(pMes, pAno);
                return;
            }
        }
    }

    public void lancaFaltas(int pCod, int pMes, int pAno, int pFaltas) {
        for (Object v : funcionarios) {
            if (((Funcionario) v).getCod() == pCod) {
                ((Funcionario) v).lancaFaltas(pMes, pAno, pFaltas);
                return;
            }
        }
    }

    public void lancaAtrasos(int pCod, int pMes, int pAno, int pAtrasos) {
        for (Object v : funcionarios) {
            if (((Funcionario) v).getCod() == pCod) {
                ((Funcionario) v).lancaAtrasos(pMes, pAno, pAtrasos);
                return;
            }
        }
    }

    public String imprimeFolha(int pMes, int pAno) {
        String folha = "Folha de pagamento: " + pMes + "/" + pAno;

        for (Object v : funcionarios) {
            folha += ((Funcionario) v).imprimeFolha(pMes, pAno);
        }
        return folha;
    }
    
    public static void main(String args[]){
        new ControleFuncionario();
    }
}
