package Disciplina;

public class Disciplina {

    private int cod;
    private String nome;
    private int cargaHoraria;

    // Construtor completo de disciplina
    public Disciplina(int pCod, String pNome, int pCargaHoraria) {
        cod = pCod;
        nome = pNome;
        cargaHoraria = pCargaHoraria;
    }

    // Construtor vazio de disciplina
    public Disciplina() {
    }

    // Funcao para inserir um codigo na disciplina
    public void setCod(int pCod) {
        cod = pCod;
    }

    // Funcao para inserir um nome na disciplina
    public void setNome(String pNome) {
        nome = pNome;
    }

    // Funcao para inserir uma carga horaria
    public void setCargaHoraria(int pCH) {
        cargaHoraria = pCH;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
