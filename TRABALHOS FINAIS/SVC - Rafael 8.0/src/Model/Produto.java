package Model;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Produto  implements Serializable{
    
    //atributos
    private String codigo;
    private String descricao;
    private double preco_compra;
    private double preco_venda;
    private int quantidade;

    //construtores
    public Produto() {
        this.codigo = "";
        this.descricao = "";
        this.preco_compra = 0;
        this.preco_venda = 0;
        this.quantidade = 0;
    }

    public Produto(String codigo, String descricao, double preco_compra, double preco_venda, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
    }

    //getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(float preco_compra) {
        this.preco_compra = preco_compra;
    }

    public double getPreco_venda() {
        DecimalFormat formato = new DecimalFormat("#.##");      
        preco_venda = Double.valueOf(formato.format(preco_venda));
        return preco_venda;
    }

    public void setPreco_venda(float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

}
