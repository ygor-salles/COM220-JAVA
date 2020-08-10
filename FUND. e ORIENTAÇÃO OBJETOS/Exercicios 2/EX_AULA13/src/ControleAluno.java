
import java.util.Vector;

public class ControleAluno {
    
    private Vector listaAlunos = new Vector();
    private LimiteAluno objCLimiteAluno;
    
    public ControleAluno(){
        objCLimiteAluno = new LimiteAluno(this);
    }
    
    public void insereAluno(int pCodigo, String pNome, String pEndereco){
        Aluno aluno = new Aluno (pCodigo, pNome, pEndereco);
        listaAlunos.add(aluno);
    }
    
    public String imprimeAlunos() {
        String result = "";
        for (int intIdx = 0; intIdx < listaAlunos.size();
                intIdx++) {
            Aluno objLAluno
                    = (Aluno) listaAlunos.elementAt(intIdx);
            result += "Código: "
                    + objLAluno.getCodigo() + "  Nome: " + objLAluno.getNome()
                    + "  Endereco: "
                    + objLAluno.getEndereco() + "\n";
        }
        return result;
    }
    
    public String imprimeAluno(int pCodigo){
        for (int intIdx = 0; intIdx < listaAlunos.size();
		 intIdx++) {
	        Aluno objLAluno =
		              (Aluno)listaAlunos.elementAt(intIdx); 
  	        if (objLAluno.getCodigo() == pCodigo) {
	    	return "Código: " + objLAluno.getCodigo()+
		                         "  Nome: " + objLAluno.getNome()+
		                         "  Endereço: " +
		                            objLAluno.getEndereco();
	       }
	    }
	    return "";
    }
    
    public static void main(String args[]) {
	  	new ControleAluno();
	}
}
