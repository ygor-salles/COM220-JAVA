package Funcionario;

import java.util.*;

/**
 *
 * @author Jean
 */
public abstract class Funcionario {

    private int cod;
    private String nome;
    private Vector pontoMensal;

    public Funcionario(int pCod, String pNome) {
        cod = pCod;
        nome = pNome;
        pontoMensal = new Vector();
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public Vector getPontoMensal() {
        return pontoMensal;
    }

    public void adicionaPonto(int pMes, int pAno) {
        pontoMensal.add(new PontoFuncionario(pMes, pAno));
    }

    public void lancaFaltas(int pMes, int pAno, int pFaltas) {
       for(Object v: pontoMensal){
           if(((PontoFuncionario)v).getMes() == pMes && ((PontoFuncionario)v).getAno() == pAno){
               ((PontoFuncionario)v).lancaFaltas(pFaltas);
           }
       }
    }

    public void lancaAtrasos(int pMes, int pAno, int pAtrasos) {
        for(Object v: pontoMensal){
           if(((PontoFuncionario)v).getMes() == pMes && ((PontoFuncionario)v).getAno() == pAno){
               ((PontoFuncionario)v).lancaAtrasos(pAtrasos);
           }
       }
    }

    public String imprimeFolha(int pMes, int pAno) {
        String folha = "";
        
        folha +="\nNome: "+getNome()
                +"\nSalário líquido: "+calculaSalario(pMes, pAno)
                +"\nBonus: "+calculaBonus(pMes, pAno);

        return folha;
    }

    public abstract double calculaSalario(int pMes, int pAno);
    public abstract double calculaBonus(int pMes, int pAno);    

}
