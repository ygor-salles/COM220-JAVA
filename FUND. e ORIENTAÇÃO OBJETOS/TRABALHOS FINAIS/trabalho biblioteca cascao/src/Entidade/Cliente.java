/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author cascao
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
