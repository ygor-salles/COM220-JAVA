package academico;

import java.io.*;
import java.util.*;

/**
 *
 * @author Jean
 */
public class aluno implements Serializable{

    private String nome, nroMatricula;
    private Date dataNasc;

    public aluno(String pNome, String pNroMatricula, int dia, int mes, int ano) throws Exception {
        setDataNasc(dia, mes, ano);
        setNome(pNome);
        setNroMatricula(pNroMatricula);
    }

    public aluno() {
    }

    public void setNome(String pNome) {
        nome = pNome;
    }

    public void setNroMatricula(String pNroMatricula) {
        nroMatricula = pNroMatricula;

    }

    public void setDataNasc(int dia, int mes, int ano) throws Exception {
        if (ano >= 1950 && ano <= 2000) {
            dataNasc = new Date(ano, mes, dia);
        } else {
            throw new Exception("Data inválida.\nAno deve ser\n1950 < ano < 2000");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getNroMatricula() {
        return nroMatricula;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
}
