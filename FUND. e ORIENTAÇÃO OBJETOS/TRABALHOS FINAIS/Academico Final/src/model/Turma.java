package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable{
    String codigo, horario, curso, prof;
    int semestre, ano, numMaxAlu;
    ArrayList<Aluno> listaAlunos = new ArrayList<>();
    ArrayList<Notas> listaNotas = new ArrayList<>();

    public Turma(String codigo, String horario, String curso, String cpfProf, int semestre, int ano, int numMaxAlu) {
        setCodigo(codigo);
        setHorario(horario);
        setCurso(curso);
        setProf(cpfProf);
        setSemestre(semestre);
        setAno(ano);
        setNumMaxAlu(numMaxAlu);
    }
    
    public Turma(){
    
    }
    
    public ArrayList<Aluno> getListaAlunos(){
        return listaAlunos;
    }
    
    public void setListaAlunos(ArrayList lista){
        listaAlunos = lista;
    }
    
    public ArrayList<Notas> getListaNotas(){
        return listaNotas;
    }
    
    public void setListaNotas(ArrayList<Notas> notas){
        listaNotas = notas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCpfProf() {
        return prof;
    }

    public void setProf(String cpfProf) {
        this.prof = cpfProf;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumMaxAlu() {
        return numMaxAlu;
    }

    public void setNumMaxAlu(int numMaxAlu) {
        this.numMaxAlu = numMaxAlu;
    }
}
