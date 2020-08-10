
import java.util.*;
import java.io.*;

public class ctrTurma {

    private entTurma objAEntTurma;
    private limTurma objALimTurma;
    private ctrPrincipal objCtrPrincipal;
    private Vector vecATurmas = new Vector();
    private Vector vecAListaEstudantes = new Vector();
    private Vector vecAListaDisciplinas = new Vector();
    private Vector vecADadosForm = new Vector();

    public ctrTurma(ctrPrincipal pCtrPrincipal) throws Exception {
        objCtrPrincipal = pCtrPrincipal;
        objALimTurma = new limTurma();
        desserializaTurma();
    }

    public boolean cadTurma() {
        objAEntTurma = new entTurma();
        cadastra();
        objAEntTurma.setCodigoTurma((String) vecADadosForm.elementAt(0));
        objAEntTurma.setNomeTurma((String) vecADadosForm.elementAt(1));
        objAEntTurma.setCodDisciplina((String) vecADadosForm.elementAt(2));
        objAEntTurma.setAlunos((Vector) vecADadosForm.elementAt(3));
        vecATurmas.add(objAEntTurma);
        return true;
    }

    private void cadastra() {
        vecADadosForm = objALimTurma.montaForm(objCtrPrincipal.getObjCtrDisciplina().getListaDisciplinas(),
                objCtrPrincipal.getObjCtrEstudante().getListaEstudantes());
    }

    private void salva() {
    }

    public void addVetor(entTurma pTurma) {
        vecATurmas.add(pTurma);
    }

    private void serializaTurma() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("turmas.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecATurmas);
        objOS.flush();
        objOS.close();
    }

    private void desserializaTurma() throws Exception {
        File objFile = new File("turmas.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("turmas.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecATurmas = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    public void finalize() throws Exception {
        serializaTurma();
    }
}