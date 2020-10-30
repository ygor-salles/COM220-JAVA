package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Aluno extends Pessoa implements Serializable{
    String email, dataNasc;
    ArrayList<Responsavel> listaResponsavel = new ArrayList<>();
    
    public Aluno(String nome, String cpf, String pemail, String pdataNasc) {
        super(nome, cpf);
        setEmail(pemail);
        setDataNasc(pdataNasc);
    }
    
    public Aluno(){
    
    }
    
    public ArrayList<Responsavel> getListaResponsavel(){
        return listaResponsavel;
    }
    
    public void setListaResponsavel(ArrayList lista){
        listaResponsavel = lista;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}
