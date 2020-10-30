package clinica;


import java.util.*;

/**
 *
 * @author Jean
 */
public abstract class paciente {

    protected String nome;
    protected String endereco;
    protected ArrayList<sessao> sessoes;

    public paciente(String pNome, String pEndereco) {
        nome = nome;
        endereco = endereco;
        sessoes = new ArrayList<sessao>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<sessao> getSessoes() {
        return sessoes;
    }

    String geraFichaPaciente() {
        String ficha = "";

        return ficha;
    }

    public abstract double calculaFaturamento(int pMes);   
}
