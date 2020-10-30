
import java.util.*;

public class Turma {

    private Disciplina disc;
    private ArrayList<Estudante> listaEstudantes;

    public Turma(Disciplina pDisc, ArrayList<Estudante> pListaEstudantes) {
        disc = pDisc;
        listaEstudantes = pListaEstudantes;
    }

    public Disciplina getDisc() {
        return disc;
    }

    public void setDisc(Disciplina disc) {
        this.disc = disc;
    }

    public ArrayList<Estudante> getListaEstudantes() {
        return listaEstudantes;
    }

    public void setListaEstudantes(ArrayList<Estudante> listaEstudantes) {
        this.listaEstudantes = listaEstudantes;
    }

}
