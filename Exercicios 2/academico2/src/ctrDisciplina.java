
import java.util.*;
import java.io.*;

public class ctrDisciplina {

    private limDisciplina objALimDisciplina = new limDisciplina();
    private entDisciplina objAEntDisciplina;
    private String[] aDadosForm;
    private Vector vecADisciplinas = new Vector();
    private final String arquivo = "disc.dat";

    public ctrDisciplina() throws Exception {
        desserializaDisciplina();
    }

    public boolean cadDisciplina() {
        objAEntDisciplina = new entDisciplina();
        cadastra();
        objAEntDisciplina.setCodigo(aDadosForm[0]);
        objAEntDisciplina.setNome(aDadosForm[1]);
        addVetor(objAEntDisciplina);
        return true;
    }

    private void cadastra() {
        aDadosForm = objALimDisciplina.montaForm();
    }

    private void salva() {
    }

    public void addVetor(entDisciplina pDiscip) {
        vecADisciplinas.add(pDiscip);
    }

    private void serializaDisciplina() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream("disciplinas.dat");
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecADisciplinas);
        objOS.flush();
        objOS.close();
    }

    private void desserializaDisciplina() throws Exception {
        File objFile = new File("disciplinas.dat");
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream("disciplinas.dat");
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecADisciplinas = (Vector) objIS.readObject();
            objIS.close();
        }
    }

    public Vector getListaDisciplinas() {
        return vecADisciplinas;
    }

    public void finalize() throws Exception {
        serializaDisciplina();
    }
    
    public String listaDisciplina(){
        
    }
    
}