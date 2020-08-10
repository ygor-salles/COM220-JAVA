
import java.util.*;

public class ControleTurma {

    private ControlePrincipal ctrPrincipal;

    private ArrayList<Turma> listaTurma = new ArrayList<>();

    public ControleTurma(ControlePrincipal pCtrPrincipal) {
        ctrPrincipal = pCtrPrincipal;
    }

    public ControlePrincipal getCtrPrincipal() {
        return ctrPrincipal;
    }

    public ArrayList<Turma> getListaTurma() {
        return listaTurma;
    }

    public void criaTurma() {
        new LimiteCriaTurma(this);
    }

    public void addTurma(Disciplina pDisc, ArrayList<Estudante> pListaEstudantes) {
        Turma t = new Turma(pDisc, pListaEstudantes);
        listaTurma.add(t);
    }

    public void imprimeTurma() {
        new LimiteImprimeTurma(this);
    }
}
