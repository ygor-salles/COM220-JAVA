package Aluno;

import java.util.*;

/**
 *
 * @author Jean
 */
public class ControleAluno {

    private Vector alunos = new Vector();
    private LimiteAluno objLimite;

    public ControleAluno() {
        objLimite = new LimiteAluno(this);
    }

    public void insereAluno(int pCodigo, String pNome, int pIdade) {
        Aluno aluno = new Aluno(pCodigo, pNome, pIdade);
        alunos.add(aluno);
    }

    public String imprimeAlunos() {
        String result = "";
        for (int intIdx = 0; intIdx < alunos.size();
                intIdx++) {
            Aluno objLAluno
                    = (Aluno) alunos.elementAt(intIdx);
            result += "Código: "
                    + objLAluno.getCodigo() + "  Nome: " + objLAluno.getNome()
                    + "  Idade: "
                    + objLAluno.getIdade() + "\n";
        }
        return result;
    }

    public String imprimeAluno(int pCodigo) {
        for (int intIdx = 0; intIdx < alunos.size();
                intIdx++) {
            Aluno objLAluno
                    = (Aluno) alunos.elementAt(intIdx);
            if (objLAluno.getCodigo() == pCodigo) {
                return "Código: " + objLAluno.getCodigo()
                        + "  Nome: " + objLAluno.getNome()
                        + "  Idade: "
                        + objLAluno.getIdade();
            }
        }
        return "";
    }

    public static void main(String args[]) {
        new ControleAluno();
    }
}
