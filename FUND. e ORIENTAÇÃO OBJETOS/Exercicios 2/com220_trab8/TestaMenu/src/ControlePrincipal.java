
public class ControlePrincipal {

    private ControleEstudante ctrEstudante;
    private ControleDisciplina ctrDisciplina;
    private ControleTurma ctrTurma;
    private LimitePrincipal limPrincipal;

    public ControlePrincipal() {
        ctrEstudante = new ControleEstudante();
        ctrDisciplina = new ControleDisciplina();
        ctrTurma = new ControleTurma(this);
        limPrincipal = new LimitePrincipal(this);
    }

    public ControleEstudante getCtrEstudante() {
        return ctrEstudante;
    }

    public ControleDisciplina getCtrDisciplina() {
        return ctrDisciplina;
    }

    public ControleTurma getCtrTurma() {
        return ctrTurma;
    }
}
