
public class Aluno extends Pessoa{

    private String aCurso = "";
    
        //Construtor da classe
    public Aluno(String pNome, String pEndereco, String pSexo,
            int pIdade, String pCurso) {
        super(pNome, pEndereco, pSexo, pIdade);
        aCurso = pCurso;
    }

    //Construtor da classe
    public Aluno(String pNome, String pEndereco, String pSexo,
            int pIdade, String pCurso, Disciplina pDisc[]) {
        super(pNome, pEndereco, pSexo, pIdade, pDisc);
        aCurso = pCurso;
    }
    
    public Aluno(){
        
    }
    
    public void setCurso(String pCurso){
        if(!pCurso.equalsIgnoreCase(Util.CC) && !pCurso.equalsIgnoreCase(Util.SI)){
            System.out.println("\nNome do curso invalido!!!");
        }
        else{
            aCurso = pCurso;
        }
    }
    
    public String getCurso(){ return aCurso; }
}
