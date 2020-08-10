
public class Aluno {
    private int codigo;
    private String nome;
    private String endereco;
    
    public Aluno(int pCodigo, String pNome, String pEndereco){
        codigo = pCodigo;
        nome = pNome;
        endereco = pEndereco;
    }
    
    public void setCodigo(int pCodigo){
        codigo = pCodigo;
    }
    
    public void setNome(String pNome){
        nome = pNome;
    }
    
    public void setEndereco(String pEndereco){
        endereco = pEndereco;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
}
