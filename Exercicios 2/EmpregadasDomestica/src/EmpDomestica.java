
public abstract class EmpDomestica {

    private String nome = "";
    private int telefone = 0;

    public void setNome(String pNome) {
        nome = pNome;
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(int pTelefone) {
        telefone = pTelefone;
    }

    public int getTelefone() {
        return telefone;
    }

    public abstract double getSalario();
}
