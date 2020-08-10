package View;

import javax.swing.JOptionPane;
import Controller.*;

public class limiteFuncionario {
	
	private controleFuncionario ctrFuncionario;
	
	public limiteFuncionario(controleFuncionario objPControleFuncionario){
		this.ctrFuncionario = objPControleFuncionario;
		capturaDados();
	}
	
	private void capturaDados() {
		int escolha;
		do {
			do {
				escolha = Integer.parseInt(JOptionPane.showInputDialog(	"Escolha uma opção do menu:\n" +
																		"[1] Adiciona Professor\n" +
																		"[2] Adiciona Tecnico Administrativo\n"+
																		"[3] Adiciona Ponto\n"+
																		"[0] Exit\n"
																		));
			} while ((escolha < 0) || (escolha > 2));
			
			if (escolha != 0) 
				execEscolha(escolha);
			else 
				System.exit(0);

		} while (true);
	}
	
	private void execEscolha(int intPEscolha) {
		switch (intPEscolha) {
		    case 1:{
		    	cadastraProfessor(); 
		    	break;
		    }
		    case 2:{
		    	cadastraTecnico(); 
		    	break;
		    }
		    case 3:{
		    	insertPontoMensal(); 
		    	break;
		    }
		}
	}
	
	private void cadastraProfessor() {
		int codigo =  Integer.parseInt(JOptionPane.showInputDialog("Informe a Matricula"));
		String nome = JOptionPane.showInputDialog("Informe o nome");
		String titulacao = JOptionPane.showInputDialog ("Informe a titulação");
		double salarioHora = Double.parseDouble(JOptionPane.showInputDialog ("Informe a Salario"));
		int nroAulas = Integer.parseInt(JOptionPane.showInputDialog ("Informe o numero de Aulas"));
		this.ctrFuncionario.insereFuncionarioProfessor(codigo,nome,titulacao,salarioHora,nroAulas);
	}
	
	private void cadastraTecnico() {
		int codigo =  Integer.parseInt(JOptionPane.showInputDialog("Informe a Matricula"));
		String nome = JOptionPane.showInputDialog("Informe o nome");
		String titulacao = JOptionPane.showInputDialog ("Informe a função");
		double salarioHora = Double.parseDouble(JOptionPane.showInputDialog ("Informe a Salario"));
		this.ctrFuncionario.insereFuncionarioTecnico(codigo,nome,titulacao,salarioHora);
	}
	
	private void insertPontoMensal(){
		
	}
	
}
