package Controller;

import java.util.Vector;

import Model.*;
import View.limiteFuncionario;

public class controleFuncionario {
	private Vector listFuncionarios = new Vector();
	private limiteFuncionario objCViewFuncionario;
	
	public controleFuncionario() {
		objCViewFuncionario = new limiteFuncionario(this);
	}
	
	public void insereFuncionarioProfessor(int pCodigo, String pNome, String pTitulacao, double pSalarioHora, int pNroAulas) {
	    Funcionario disc = new Professor(pCodigo, pNome, pTitulacao, pSalarioHora, pNroAulas);
	    listFuncionarios.add(disc);
	}
	
	public void insereFuncionarioTecnico(int pCodigo, String pNome, String pTitulacao, double pSalarioHora) {
	    Funcionario disc = new TecAdmin(pCodigo, pNome, pTitulacao, pSalarioHora);
	    listFuncionarios.add(disc);
	}
}
