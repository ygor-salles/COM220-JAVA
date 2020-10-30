package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import model.Aluno;
import model.Notas;
import model.Professor;
import model.Responsavel;
import model.Turma;
import view.LimiteCadProf;

public class ctrAluno {
    //Declaração dos atributos
    private ControlePrincipal objCtrPrincipal; 
    private ctrTurma objCtrTurma;
    private Turma entTurma;
    private Aluno objEntAluno;
    private Vector vecAluno = new Vector();   
    private ArrayList<Aluno> vecTurmaListaAluno = new ArrayList<>();
    private ArrayList<Notas> listaN = new ArrayList<>();
    private final String arquivo = "aluno.dat";
    private int result;
    private ArrayList<Responsavel> listaR = new ArrayList<>();
    private boolean vagas;

    
    public ctrAluno(ControlePrincipal cPrincipal) throws Exception {
        objCtrPrincipal = cPrincipal;
        desserializaAluno();
//        imprimeAluno();
    }
    
    public int cadastrarAluno(String nome, String cpf, String email, String data, String nomeResp, String cpfResp, int idade) {
//        System.out.println("cad");
        objEntAluno = new Aluno();
        objEntAluno.setCpf(cpf);
        if (!VerificaCpf(objEntAluno.getCpf()))
            return 1;
        
        result = VerificaTurmaExist(idade);
//        System.out.println(result);
        if(result == 0){
//           System.out.println("Cria aluno");
           objEntAluno.setNome(nome);     
           objEntAluno.setEmail(email);
           objEntAluno.setDataNasc(data);
           
           if(idade < 18){
                listaR = objEntAluno.getListaResponsavel();
                listaR.add(new Responsavel(nomeResp, cpfResp));
                objEntAluno.setListaResponsavel(listaR);
           }
           
           vecAluno.add(objEntAluno);
           entTurma = buscaTurmaAluno(idade);
           
           vecTurmaListaAluno = entTurma.getListaAlunos();
           vecTurmaListaAluno.add(objEntAluno);
           entTurma.setListaAlunos(vecTurmaListaAluno);
           
           listaN = entTurma.getListaNotas();
           listaN.add(new Notas(-1,-1,nome));
           entTurma.setListaNotas(listaN);
           
           return 0;
        }
        
        return result;
    }
    
    public boolean VerificaCpf(String pCod) {
        for (int i = 0; i < this.getListaAluno().size(); i++){
             if(pCod.equals(((Aluno)this.getListaAluno().elementAt(i)).getCpf()))
                 return false;
        }
        return true;
    }
    
    public int VerificaTurmaExist(int pIdade) {
        vagas = true;
        
        objCtrTurma = objCtrPrincipal.getCtrTurma();
        if(pIdade <= 12){
            for (int i = 0; i < objCtrTurma.getListaTurma().size(); i++){
                Turma objViewDis = (Turma)objCtrTurma.getListaTurma().elementAt(i);

                if(objViewDis.getCurso().equalsIgnoreCase("K1")){
                    if(objViewDis.getNumMaxAlu() == objViewDis.getListaAlunos().size())
                        vagas = false;
                    else{
                        entTurma = objViewDis;
                        return 0;
                    }
                }
            }
            if(!vagas)//Encontrou turma, mas está lotada
                return 2;
            return 3;
        }
        else{
            for (int i = 0; i < objCtrTurma.getListaTurma().size(); i++){
                Turma objViewDis = (Turma)objCtrTurma.getListaTurma().elementAt(i);

//                System.out.println(objViewDis.getNumMaxAlu());
                if(objViewDis.getCurso().equals("R1")){
                    if(objViewDis.getNumMaxAlu() == objViewDis.getListaAlunos().size())
                        vagas = false;
                    else{
                        entTurma = objViewDis;
                        return 0;
                    }
                }
            }
            
            if(!vagas)
                return 4;
            return 5;
        }
    }
    
    public Turma buscaTurmaAluno(int pIdade) {
        objCtrTurma = objCtrPrincipal.getCtrTurma();
        
        if(pIdade <= 12){
            for (int i = 0; i < objCtrTurma.getListaTurma().size(); i++){
                Turma objViewDis = (Turma)objCtrTurma.getListaTurma().elementAt(i);

                if(objViewDis.getCurso().equals("K1"))
                   return objViewDis;
            }
        }
        else{
            for (int i = 0; i < objCtrTurma.getListaTurma().size(); i++){
                Turma objViewDis = (Turma)objCtrTurma.getListaTurma().elementAt(i);

                if(objViewDis.getCurso().equals("R1"))
                    return objViewDis;
            }
        }
        return null;
    }
    
    public Vector getListaAluno() {
        return vecAluno;
    }
    
    private void serializaAluno() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecAluno);
        objOS.flush();
        objOS.close();
    }
    
    private void desserializaAluno() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecAluno = (Vector) objIS.readObject();
            objIS.close();
        }
        return;
    }
    
    public void finalize() throws Exception {
        serializaAluno();
    }
    
    public void imprimeAluno() {
        String result = "";
        if (vecAluno.size()==0)
           result+="Não existem alunos cadastrados";
        else{
            for (int intIdx = 0; intIdx < vecAluno.size();intIdx++) {
                Aluno objViewDis = (Aluno)vecAluno.elementAt(intIdx);
                result +=  objViewDis.getNome() + " - " +  objViewDis.getCpf() + "\n";
            }
        }
        System.out.println(result);
    }
}