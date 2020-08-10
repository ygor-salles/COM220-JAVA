package Model;

import java.util.*;

public abstract class Funcionario {
	private int aCodigo;
	private String aNome;
	private Vector<pontoFunc> aPontoMensal;
	
	public Funcionario(int pCodigo, String pNome){
		this.aCodigo = pCodigo;
		this.aNome = pNome;
		this.aPontoMensal = new Vector<pontoFunc>();
	}
	
	public int getCodigo() { return aCodigo; }
	public String getNome() { return aNome; }
	public Vector<pontoFunc> getPontoMensal() { return aPontoMensal; }
	
	public void adicionaPonto(int pMes, int pAno){
		pontoFunc pf = new pontoFunc(pMes, pAno);
        aPontoMensal.add(pf);
	}
	
	public void lancaFaltas(int pMes, int pAno, int pFaltas){
		for (int i = 0; i < aPontoMensal.size(); i++) {
            pontoFunc pf = aPontoMensal.elementAt(i);
            if (pf.getaMes() == pMes && pf.getaAno() == pAno) {
                aPontoMensal.elementAt(i).lancaFaltas(pFaltas);
            }
        }
	}
	
	public void lancaAtrasos(int pMes, int pAno, int pAtrasos){
		for (int i = 0; i < aPontoMensal.size(); i++) {
            pontoFunc pf = aPontoMensal.elementAt(i);
            if (pf.getaMes() == pMes && pf.getaAno() == pAno) {
                aPontoMensal.elementAt(i).lancaAtrasos(pAtrasos);
            }
        }
	}
	
	public String imprimeFolha(int pMes, int pAno){
		String retorno ="";
		for (int i=0; i< aPontoMensal.size(); i++){
	        pontoFunc pf = aPontoMensal.elementAt(i);
	        if (pf.getaMes() == pMes && pf.getaAno() == pAno) {
	            retorno = "Codigo: " + getCodigo()
                         +"\nPonto do Mes: "+ pMes+ "/"+pAno
                         +"\nNome: "+ getNome()
                         +"\nNumero de Faltas: "+pf.getaNroFaltas()
                         +"\nNumero de Atrasos: "+pf.getaNroAtrasos()
                         +"\nSalario: "+ calculaSalario(pMes, pAno)
                         +"\n----------------------------";
	        }
	        return retorno;
		}
	    return retorno="Não fora encontrado dados.";    
	}

	public abstract double calculaSalario(int pMes, int pAno);
	public abstract double calculaBonus(int pMes, int pAno);
}
