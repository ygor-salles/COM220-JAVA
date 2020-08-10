package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class NotaFiscal  implements Serializable{

    //atributos
    private int dia;
    private int mes;
    private int ano;
    private int codigonota;
    private String cpf = "";
    private ArrayList<Venda> listaVendas;
    private int cont = 0;
    private String nota = "";

    //construtor
    public NotaFiscal(int dia, int mes, int ano, int codigonota, String cpf) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.codigonota = codigonota;
        this.cpf = cpf;
        this.listaVendas = new ArrayList<>();
    }
    
    public NotaFiscal() {
        
    }

    //getters e setters
    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }
    
    public void setNota(String nota){
        this.nota = nota;
    }
    public void setListaVendas(ArrayList<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCodigonota() {
        return codigonota;
    }

    public void setCodNota() {
        cont++;
        this.codigonota = cont;
    }

}