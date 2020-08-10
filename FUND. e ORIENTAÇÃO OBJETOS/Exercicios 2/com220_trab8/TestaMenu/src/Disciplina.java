
public class Disciplina {
    int codigo;
    String nome;    

    public Disciplina(int pCodigo, String pNome){
        codigo = pCodigo;
        nome = pNome;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
