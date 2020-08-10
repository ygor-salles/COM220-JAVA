
public class Estudante {

    int nroMatric;
    String nome;

    public Estudante(int pNroMatric, String pNome) {
        nroMatric = pNroMatric;
        nome = pNome;
    }

    public int getNroMatric() {
        return nroMatric;
    }

    public void setNroMatric(int nroMatric) {
        this.nroMatric = nroMatric;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
