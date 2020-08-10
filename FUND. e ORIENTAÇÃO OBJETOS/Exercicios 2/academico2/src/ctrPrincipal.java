
public class ctrPrincipal {

    private int intAOperacao = -1;
    private ctrDisciplina objACtrDisciplina;
    private limPrincipal objALimPrincipal;
    private ctrEstudante objACtrEstudante;
    private ctrTurma objACtrTurma;

    public ctrPrincipal() {
        objALimPrincipal = new limPrincipal();
        try {
            objACtrDisciplina = new ctrDisciplina();
            objACtrEstudante = new ctrEstudante();
            objACtrTurma = new ctrTurma(this);
        } catch (Exception e) {
            System.out.println("Erro na abertura de arquivo");
        }

    }

    public ctrEstudante getObjCtrEstudante() {
        return objACtrEstudante;
    }

    public ctrDisciplina getObjCtrDisciplina() {
        return objACtrDisciplina;
    }

    public void run() {
        while (true) {
            intAOperacao = objALimPrincipal.montaMenu();
            switch (intAOperacao) {
                case 1:
                    cadDisciplina();
                    break;
                case 2:
                    cadEstudante();
                    break;
                case 3:
                    cadTurma();
                    break;
                case 4:
                    finalize();
            }
        }
    }

    private boolean cadDisciplina() {
        return objACtrDisciplina.cadDisciplina();
    }

    private boolean cadEstudante() {
        return objACtrEstudante.cadEstudante();
    }

    private boolean cadTurma() {
        return objACtrTurma.cadTurma();

    }

    public void finalize() {
        try {
            objACtrEstudante.finalize();
            objACtrDisciplina.finalize();
            objACtrTurma.finalize();
        } catch (Exception e) {
            System.err.println("Erro ao fechar arquivo!");
        }
        System.exit(0);
    }
}
