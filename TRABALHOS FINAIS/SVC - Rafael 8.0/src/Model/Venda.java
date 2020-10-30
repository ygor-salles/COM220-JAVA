package Model;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable{
    
    //atributos
    private Produto prod;
    private int quantidade;
    private Date data;
    private String cpf;

    //construtor
    public Venda(Produto prod, int quantidade) {
        this.prod = prod;
        this.quantidade = quantidade;
    }
    
    public Venda() {
        
    }

    //getters e setters
    public Produto getProd() {
        return prod;
    }
    

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
  
}