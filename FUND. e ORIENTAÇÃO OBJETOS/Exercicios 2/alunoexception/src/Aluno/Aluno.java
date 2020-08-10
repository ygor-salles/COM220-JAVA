package Aluno;

/**
 *
 * @author Jean
 */
public class Aluno {

    private int codigo;
    private String nome;
    private int idade;

    public Aluno(int pCodigo, String pNome, int pIdade) {
        codigo = pCodigo;
        nome = pNome;
        idade = pIdade;
    }

    public void setCodigo(int pCodigo) {
        codigo = pCodigo;
    }

    public void setNome(String pNome) {
        nome = pNome;
    }

    public void setIdade(int pIdade) {
        idade = pIdade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
}
