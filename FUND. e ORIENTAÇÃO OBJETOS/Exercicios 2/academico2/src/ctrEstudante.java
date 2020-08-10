
import java.util.*;
import java.io.*;

public class ctrEstudante {

    private limEstudante objALimEstudante = new limEstudante();
    private entEstudante objAEntEstudante;
    private String[] aDadosForm;
    private Vector vecAEstudantes = new Vector();

    public ctrEstudante() throws Exception {
        desserializaEstudante();
    }

    public boolean cadEstudante() {
        objAEntEstudante = new entEstudante();
        cadastra();
        objAEntEstudante.setCodigo(aDadosForm[0]);
        objAEntEstudante.setNome(aDadosForm[1]);
        addVetor(objAEntEstudante);
        return true;
    }

    private void cadastra() {
        aDadosForm = objALimEstudante.montaForm();
    }

    private void salva() {
    }

    public void addVetor(entEstudante pEst) {
        vecAEstudantes.add(pEst);
    }

    private void serializaEstudante() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("estudantes.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecAEstudantes);
        objOS.flush();
        objOS.close();
    }

    private void desserializaEstudante() throws Exception {
        File objFile = new File("estudantes.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("estudantes.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecAEstudantes = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    public Vector getListaEstudantes() {
        return vecAEstudantes;
    }

    public void finalize() throws Exception {
        serializaEstudante();
    }
}