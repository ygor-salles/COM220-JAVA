
package Clinica;

import java.io.*;
import java.util.ArrayList;


public class Paciente implements Serializable{
    
    private int cod;
    private String nome;
    private ArrayList<Paciente> listaPaciente = new ArrayList();
    
    
    public void cadPaciente(){
        this.listaPaciente.add(new Paciente(101,"José da Silva"));
        this.listaPaciente.add(new Paciente(102,"João de Souza"));
        this.listaPaciente.add(new Paciente(103,"Marcelo dos Santos"));
        this.listaPaciente.add(new Paciente(104,"Jonas Henrique"));
        this.listaPaciente.add(new Paciente(105,"Maria Helena"));
        this.listaPaciente.add(new Paciente(106,"José Ribeiro"));
        this.listaPaciente.add(new Paciente(107,"Chico Xavier"));
        this.listaPaciente.add(new Paciente(108,"Jesus Antônio"));
    }

    public Paciente(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public ArrayList<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public void setListaPaciente(ArrayList<Paciente> listaPaciente) {
        this.listaPaciente = listaPaciente;
    }
    
    public Paciente(){
        cadPaciente();
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
