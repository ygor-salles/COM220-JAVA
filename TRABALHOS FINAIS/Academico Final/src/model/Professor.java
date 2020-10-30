package model;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable{
    String curso;
    
    public Professor(String nome, String cpf, String pcurso) {
        super(nome, cpf);
//        curso = pcurso;
        setCurso(pcurso);
    }
    
    public Professor(){

    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
