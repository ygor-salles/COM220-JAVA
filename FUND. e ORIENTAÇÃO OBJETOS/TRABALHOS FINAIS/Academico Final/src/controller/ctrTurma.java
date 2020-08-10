package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import model.Aluno;
import model.Notas;
import model.Professor;
import model.Turma;
import view.LimiteCadProf;

public class ctrTurma {
    //Declaração dos atributos
    private ControlePrincipal objCtrPrincipal;
    private Turma objEntTurma;    
    private Aluno objEntAluno;
    private Notas objEntNota;
    private Vector vecTurma = new Vector();
    private ArrayList<Notas> listaN = new ArrayList<>();
    private ArrayList<Aluno> listaA = new ArrayList<>();
    private final String arquivo = "turma.dat";
    private String letra;
    private int periodo;
    private boolean achou;
    
    public ctrTurma(ControlePrincipal cPrincipal) throws Exception {
        objCtrPrincipal = cPrincipal;
        desserializaTurma();
        imprimeTurma();
    }
    
    public boolean cadastrarTurma(String codigo, String semestre, String ano, String capacidade, String horario, String curso, String prof) {
        objEntTurma = new Turma();
        objEntTurma.setCodigo(codigo);
        if (VerificaCodigo(objEntTurma.getCodigo()) != null){
            return false;
        }
        objEntTurma.setCurso(curso);
//        if (!VerificaCurso(objEntTurma.getCurso())){
//            return false;
//        }
        objEntTurma.setSemestre(Integer.parseInt(semestre));  
        objEntTurma.setAno(Integer.parseInt(ano));   
        objEntTurma.setNumMaxAlu(Integer.parseInt(capacidade));
        objEntTurma.setHorario(curso);
        objEntTurma.setProf(prof);
        vecTurma.add(objEntTurma);
        return true;
    }
    
    public boolean cadastrarNota(ArrayList<String> table, ArrayList<Notas> listaNotas, String pNota, Turma t){
//        System.out.println(t.getCodigo());
        listaN = t.getListaNotas();
        if(listaNotas.size() > 0){
            for(Notas n:listaNotas){
                for(String s:table){
                    if(n.getCodAlu().equalsIgnoreCase(s.split("-")[0])){
                        if(pNota.equalsIgnoreCase("N1"))
                            n.setN1(Float.parseFloat(s.split("-")[1]));
                        else
                            n.setN2(Float.parseFloat(s.split("-")[1]));
                    }
                }
            }
        }
        return true;
    }
    
    public String remat(String nome){
        objEntNota = null;
        Turma objViewDis = null;
        achou = false;
        float media = 0;
        
        for (int intIdx = 0; intIdx < vecTurma.size();intIdx++) {
            Turma t = (Turma)vecTurma.elementAt(intIdx);
            for(Notas n: t.getListaNotas()){
                if(n.getCodAlu().equalsIgnoreCase(nome)){
                    achou = true;
                    media = (n.getN1() + n.getN2()) /2;//cálculo da média
                    objEntNota = n;
                    objViewDis = t;
                }
            }
        }
            
        if(!achou) return "Aluno não encontrado";
        else{
//            System.out.println(objEntNota.getN1());
            if(media >= 6){
//                  System.out.println(n.getCodAlu().equalsIgnoreCase(nome));
                    letra = objViewDis.getCurso().substring(0,1);
                    periodo = Integer.parseInt(objViewDis.getCurso().substring(1,2));
//                    System.out.println("Letra " + letra + " periodo " + periodo);

                    if(letra.equalsIgnoreCase("K")){//curso Kids
                        if(periodo == 6){//último período
                            objEntTurma = buscaTurmaCodigo("R5");

                            if(objEntTurma != null){
                                listaA = objEntTurma.getListaAlunos();
                                objEntAluno = buscaTurmaAluno(objViewDis.getListaAlunos(), nome);
                                listaA.add(objEntAluno);
                                objEntTurma.setListaAlunos(listaA);
                                listaN = objEntTurma.getListaNotas();
                                listaN.add(new Notas(-1,-1,nome));
                                objEntTurma.setListaNotas(listaN);
                                return "Aluno concluiu o curso Kids!\nRematrícula no curso R5 realizada com sucesso!";
                            }
                            else
                                return "Não há turmas do curso R5 com vagas";
                        }
                        else{
                            periodo++;
                            letra = letra + periodo;
                            objEntTurma = buscaTurmaCodigo(letra);//verificar se existe próximo curso

                            if(objEntTurma != null){
                                listaA = objEntTurma.getListaAlunos();
                                objEntAluno = buscaTurmaAluno(objViewDis.getListaAlunos(), nome);
                                listaA.add(objEntAluno);
                                objEntTurma.setListaAlunos(listaA);
                                listaN = objEntTurma.getListaNotas();
                                listaN.add(new Notas(-1,-1,nome));
                                objEntTurma.setListaNotas(listaN);
                                return "Rematrícula no curso " + letra + " realizada com sucesso!";
                            }
                            else
                                return "Não há turma do curso " + letra + " com vagas";
                        }
                    }
                    else{//curso Regular
                        if(periodo == 8)//último período
                            return "Aluno matriculado no último período do curso regular";
                        else{
                            periodo++;
                            letra = letra + periodo;
                            objEntTurma = buscaTurmaCodigo(letra);//verificar se existe próximo curso

                            if(objEntTurma != null){
                                listaA = objEntTurma.getListaAlunos();
                                objEntAluno = buscaTurmaAluno(objViewDis.getListaAlunos(), nome);
                                listaA.add(objEntAluno);
                                objEntTurma.setListaAlunos(listaA);
                                listaN = objEntTurma.getListaNotas();
                                listaN.add(new Notas(-1,-1,nome));
                                objEntTurma.setListaNotas(listaN);
                                return "Rematrícula no curso " + letra + " realizada com sucesso!";
                            }
                            else
                                return "Não há turma do curso " + letra + " com vagas";
                        }
                    }
                }
                else
                    return "Média inferior à 6.\nO aluno não concluiu o curso atual " + objViewDis.getCurso();
        }
    }
    
    public Turma VerificaCodigo(String pCod) {
        for (int i = 0; i < this.getListaTurma().size(); i++){
             if(pCod.equalsIgnoreCase(((Turma)this.getListaTurma().elementAt(i)).getCodigo()))
                 return (Turma)this.getListaTurma().elementAt(i);
        }
        return null;
    }
    
    public Turma buscaTurmaCodigo(String pCurso) {
        System.out.println(pCurso);
        for (int i = 0; i < this.getListaTurma().size(); i++){
            Turma t = (Turma)this.getListaTurma().elementAt(i);
             if(pCurso.equalsIgnoreCase(t.getCurso())){
                if(t.getNumMaxAlu() != t.getListaAlunos().size())
                    return t;
             }
                 
        }
        return null;
    }
    
    public Aluno buscaTurmaAluno(ArrayList<Aluno> lista, String nome) {
        System.out.println(nome + " - " + lista.toString());
        for(Aluno a: lista){
            if(a.getNome().equalsIgnoreCase(nome))
                return a;
        }
        return null;
    }
    
    public Vector getListaTurma() {
        return vecTurma;
    }
    
    private void serializaTurma() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(vecTurma);
        objOS.flush();
        objOS.close();
    }
    
    private void desserializaTurma() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            vecTurma = (Vector) objIS.readObject();
            objIS.close();
        }
        return;
    }
    
    public void finalize() throws Exception {
        serializaTurma();
    }
    
    public void imprimeTurma() {
        String result = "";
        float media;
        if (vecTurma.size()==0)
           result+="Não existem turmas cadastradas";
        else{
            for (int intIdx = 0; intIdx < vecTurma.size();intIdx++) {
                Turma objViewDis = (Turma)vecTurma.elementAt(intIdx);
                result +=  objViewDis.getCurso() + "\n";
                
                if(objViewDis.getListaAlunos().size() > 0)
                    result += "Alunos\n";
                for(Aluno a:objViewDis.getListaAlunos()){
                    result += a.getNome() + " - " ;
                }
                result += "\n";
                
                for(Notas n:objViewDis.getListaNotas()){
                    media = (n.getN1() + n.getN2())/2;
                    result += "Média:" + media + " - ";
                }
                result += "\n";
            }
        }
        System.out.println(result);
    }
    
    public ArrayList relatorioTurma(String cod) {
        objEntTurma = VerificaCodigo(cod);
//        System.out.println(objEntTurma + " - " +objEntTurma.getListaAlunos().size());
//        String result = "";
        ArrayList<String> result = new ArrayList<>();

        if(objEntTurma == null){
            System.out.println(result);
            return result;
        }
        float media;
        
        for(Aluno a: objEntTurma.getListaAlunos()){
            media = -1;
            result.add(a.getNome());  
            result.add(a.getCpf());

            if(objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN1() == -1)
                result.add("");
            else
                result.add(String.valueOf(objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN1()));
            
            if(objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN2() == -1)
                result.add("");
            else
                result.add(String.valueOf(objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN2()));
            
            if(objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN1() != -1 &&
               objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN2() != -1){
                media = (objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN1() +
                          objEntTurma.getListaNotas().get(objEntTurma.getListaAlunos().indexOf(a)).getN2()) / 2;
            }
            else 
                result.add("");
            
            if(media == -1)
                result.add("");
            else{
                result.add(String.valueOf(media));
                
                if(media >= 6)
                    result.add("Aprovado");
                else
                    result.add("Reprovado");
            }
        }
//        System.out.println(result);
        
        return result;
    }
    
    public ArrayList historicoAluno(String cod) {
        ArrayList<String> result = new ArrayList<>();
        float media;
        
        for (int intIdx = 0; intIdx < vecTurma.size();intIdx++) {
            Turma objViewDis = (Turma)vecTurma.elementAt(intIdx);
            
            for(Aluno a: objViewDis.getListaAlunos()){
                if(a.getCpf().equalsIgnoreCase(cod)){
                    media = -1;
 
                    result.add(objViewDis.getAno() + "/" + objViewDis.getSemestre());
                    result.add(objViewDis.getCurso()); 
                    
                    if(objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() != -1 &&
                        objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2() != -1){
                         media = (objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() +
                                   objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2()) / 2;
                    }
                    
                    if(media == -1)
                        result.add("");
                    else
                        result.add(String.valueOf(media));
                }
            }
        }
        
        return result;
    }
    
    public ArrayList relatorioConcluintes() {
        ArrayList<String> result = new ArrayList<>();
        float media;
        
        for (int intIdx = 0; intIdx < vecTurma.size();intIdx++) {
            Turma objViewDis = (Turma)vecTurma.elementAt(intIdx);
            
            if(objViewDis.getCurso().equalsIgnoreCase("K6")){
                for(Aluno a: objViewDis.getListaAlunos()){
                    media = -1;

                    if(objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() != -1 &&
                        objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2() != -1){
                         media = (objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() +
                                   objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2()) / 2;

                        if(media >= 6){
                            result.add(a.getNome());   
                            result.add(a.getCpf()); 
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    public ArrayList relatorioConcluintesRegular() {
        ArrayList<String> result = new ArrayList<>();
        float media;
        
        for (int intIdx = 0; intIdx < vecTurma.size();intIdx++) {
            Turma objViewDis = (Turma)vecTurma.elementAt(intIdx);
            
            if(objViewDis.getCurso().equalsIgnoreCase("R8")){
                for(Aluno a: objViewDis.getListaAlunos()){
                    media = -1;

                    if(objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() != -1 &&
                        objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2() != -1){
                         media = (objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN1() +
                                   objViewDis.getListaNotas().get(objViewDis.getListaAlunos().indexOf(a)).getN2()) / 2;

                        if(media >= 6){
                            result.add(a.getNome());   
                            result.add(a.getCpf()); 
                        }
                    }
                }
            }
        }
        
        return result;
    }
}