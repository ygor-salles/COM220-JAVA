package model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    String nome, cpf;

    public Pessoa(String nome, String cpf){
        setNome(nome);
        setCpf(cpf);
    }
    
    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
