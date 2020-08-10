
import javax.swing.JOptionPane;
public class LimiteAluno {
	private ControleAluno ctrAluno;

	public LimiteAluno( ControleAluno objPControleAluno) {
	   ctrAluno = objPControleAluno;
	   CapturaDados();
	}
        
	private void CapturaDados() {
	    int escolha;
	    do {
	        do {
	          String escolhaInformada =
 	              JOptionPane.showInputDialog(
	               "Escolha uma opção do menu:\n" +
	               "[1] Adiciona aluno\n" +
                       "[2] Lista um aluno\n" +
	               "[3] Lista todos os alunos\n" + 
		 "[4] Finaliza");
	             escolha =
		             Integer.parseInt(escolhaInformada);
	          } while ((escolha < 1) || (escolha > 4));
	          if (escolha != 4) {
	              execEscolha(escolha);
	          } else {
	              System.exit(0);
	        }
	    } while (true);
	}
        
	private void execEscolha(int intPEscolha) {
		switch (intPEscolha) {
		    case 1: {
		        cadastraAluno(); break;
		    }
		     case 2: {
		         int intLCodigo = Integer.parseInt(
		               JOptionPane.showInputDialog(
		               "Digite o código do aluno"));
		         imprimeAluno(intLCodigo);
		         break;
		      }
		       case 3: {
		           imprimeAlunos();
		        }
		}
	}

        private void cadastraAluno() {
	    int codigo = Integer.parseInt(JOptionPane.showInputDialog(
		"Informe o código"));
	    String nome = JOptionPane.showInputDialog(
		"Informe o nome");
	    String endereco = JOptionPane.showInputDialog (
		"Informe o endereco");
            ctrAluno.insereAluno(codigo, nome,
		endereco);
	}
        
	public void imprimeAlunos() {
	    JOptionPane.showMessageDialog(null,
		ctrAluno.imprimeAlunos(), 
		"Relação de Alunos", 	JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Método responsável por apresentar as
	 * informações de uma única disciplina.
	 * @param pCodigo código de uma disciplina
	 */
	public void imprimeAluno(int pCodigo) {
	    JOptionPane.showMessageDialog(null,
		 ctrAluno.imprimeAluno(pCodigo), 
		"Informações do Aluno",	JOptionPane.INFORMATION_MESSAGE);
	}
}
