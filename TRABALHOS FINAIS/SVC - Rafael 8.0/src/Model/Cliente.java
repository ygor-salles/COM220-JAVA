package Model;

import java.io.Serializable;

public class Cliente  implements Serializable {

    //atributos
    private String Nome;
    private String email;
    private String estado,cidade,rua,numero;
    private String CPF;

    //construtores
    public Cliente(String Nome, String email, String estado, String cidade,
            String rua, String numero, String CPF) {
        this.Nome = Nome;
        this.email = email;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
        this.CPF = CPF;
    }

    public Cliente() {
    }

    //getters e setters
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
        public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
