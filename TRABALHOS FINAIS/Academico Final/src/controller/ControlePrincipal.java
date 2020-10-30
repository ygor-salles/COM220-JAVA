package controller;

import java.util.ArrayList;
import model.Notas;
import model.Turma;
import view.*;

/**
 *
 * @author bruno
 */
public class ControlePrincipal {
    private ctrProfessor objCtrProfessor; 
    private ctrTurma objCtrTurma;
    private ctrAluno objCtrAluno;

    public ControlePrincipal() {
        try {
            objCtrProfessor = new ctrProfessor(this);
            objCtrTurma = new ctrTurma(this);
            objCtrAluno = new ctrAluno(this);
        } catch (Exception ex) {
            System.out.println("Erro na abertura de arquivo");
        }
        new LimitePrincipal(this);
    }
    
    public ctrProfessor getCtrProfessor(){
        return objCtrProfessor;
    }
    
    public ctrTurma getCtrTurma(){
        return objCtrTurma;
    }
    
    public ctrAluno getCtrAluno(){
        return objCtrAluno;
    }
    
    public boolean adicionaProfessor(String nome, String cpf, String curso){
        return objCtrProfessor.cadastrarProfessor(nome, cpf, curso);
    }
    
    public boolean adicionaTurma(String codigo, String semestre, String ano, String capacidade, String horario, String curso, String prof){
        return objCtrTurma.cadastrarTurma(codigo, semestre, ano, capacidade, horario, curso, prof);
    }
    
    public int adicionaAluno(String nome, String cpf, String email, String data, String nomeResp, String cpfResp, int idade){
        return objCtrAluno.cadastrarAluno(nome, cpf, email, data, nomeResp, cpfResp, idade);
    }
    
    public String rematricula(String cpf){
        return objCtrTurma.remat(cpf);
    }
    
    public boolean adicionaNota(ArrayList<String> table, ArrayList<Notas> listaNotas, String pNota, Turma t){
        return objCtrTurma.cadastrarNota(table, listaNotas, pNota, t);
    }
    
    public ArrayList relatorioTurma(String cod){
        return objCtrTurma.relatorioTurma(cod);
    }
    
    public ArrayList historicoAluno(String cod){
        return objCtrTurma.historicoAluno(cod);
    }
    
    public ArrayList relatorioConcluintes(){
        return objCtrTurma.relatorioConcluintes();
    }
    
    public ArrayList relatorioConcluintesRegular(){
        return objCtrTurma.relatorioConcluintesRegular();
    }

    public void interfaceCadProf() {
        new LimiteCadProf(this);
    }
    
    public void interfaceCadTurma() {
        new LimiteCadTurma(this);
    }
    
    public void interfaceNovaMat() {
        new LimiteNovaMat(this);
    }
    
    public void interfaceRematricula() {
        new LimiteRematricula(this);
    }
    
    public void interfaceNota() {
        new LimiteNota(this);
    }
    
    public void interfaceRelatorioTurma() {
        new LimiteRelatorioTurma(this);
    }
    
    public void interfaceHistorico() {
        new LimiteHistoricoAluno(this);
    }
    
    public void interfaceConcluintes() {
        new LimiteConcluintes(this);
    }
    
    public void finalize() {
        try {
            objCtrProfessor.finalize();
            objCtrTurma.finalize();
            objCtrAluno.finalize();
        } catch (Exception e) {
            System.err.println("Erro ao fechar arquivo!");
        }
        System.exit(0);
    }
}
