package controller;

import java.io.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Professor;
import view.LimiteCadProf;

public class ctrProfessor {
    //Declaração dos atributos
    private ControlePrincipal objCtrPrincipal;
    private Professor objEntProfessor;
    private LimiteCadProf objLimiteCadProf;
    private Vector vecProfessor = new Vector();
    private final String arquivo = "professor.dat";
    
    public ctrProfessor(ControlePrincipal cPrincipal) throws Exception {
        objCtrPrincipal = cPrincipal;
        desserializaProfessor();
//        imprimeProfessor();
    }
    
    public boolean cadastrarProfessor(String pNome, String pCpf, String pCurso) {
        objEntProfessor = new Professor();
        objEntProfessor.setCpf(pCpf);
        if (!VerificaCpf(objEntProfessor.getCpf())){
            return false;
        }   
        objEntProfessor.setNome(pNome);  
        objEntProfessor.setCurso(pCurso);
        vecProfessor.add(objEntProfessor);
        return true;
    }
    
    public boolean VerificaCpf(String pCod) {
        Vector professores = new Vector();
        professores =  this.getListaProfessores();
        for (int i = 0; i < professores.size(); i++){
             if(pCod.equals(((Professor)professores.elementAt(i)).getCpf()))
                 return false;
        }
        return true;
    }
    
    public Vector getListaProfessores() {
        return vecProfessor;
    }
    
    private void serializaProfessor() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecProfessor);
        objOS.flush();
        objOS.close();
    }
    
    private void desserializaProfessor() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecProfessor = (Vector) objIS.readObject();
            objIS.close();
        }
        return;
    }
    
    public void finalize() throws Exception {
        serializaProfessor();
    }
    
    public void imprimeProfessor() {
        String result = "";
        if (vecProfessor.size()==0)
           result+="Não existem professores cadastrados";
        else{
            for (int intIdx = 0; intIdx < vecProfessor.size();intIdx++) {
                Professor objViewDis = (Professor)vecProfessor.elementAt(intIdx);
                result +=  objViewDis.getCpf() + " - " +  objViewDis.getNome()+ " - " + objViewDis.getCurso() + "\n";
            }
        }
        System.out.println(result);
    }
}