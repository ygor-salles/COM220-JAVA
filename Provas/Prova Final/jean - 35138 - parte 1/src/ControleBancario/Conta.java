package ControleBancario;

import java.util.*;

/**
 *
 * @author Jean
 */
public class Conta {

    private int nroConta;
    private String nomeCorrent;
    private double limite;
    private String senha;
    private ArrayList<Transacao> transacoes;

    public Conta(int pNroConta, String pNomeCorrent, double pLimite, String pSenha) {
        transacoes = new ArrayList<Transacao>();
        nroConta = pNroConta;
        nomeCorrent = pNomeCorrent;
        limite = pLimite;
        senha = pSenha;
    }

    public int getNroConta() {
        return nroConta;
    }

    public String getNomeCorrent() {
        return nomeCorrent;
    }

    public double getLimite() {
        return limite;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Transacao> getTransacoes() {
        return transacoes;
    }

    public void adicionaDeposito(double pValor, Date pData, String pNomeDep) {
        transacoes.add(new Deposito(pValor, pData, pNomeDep));
    }

    public boolean adicionaSaque(double pValor, Date pData, String pSenha) {
        if (pValor <= calculaSaldo() && pSenha == getSenha()) {
            transacoes.add(new Saque(pValor, pData, pSenha));
            return true;
        }
        return false;
    }

    public boolean adicionaTransf(double pValor, Date pData, String pSenha, Conta pContaFav) {

        if (pValor <= calculaSaldo() && pSenha == getSenha()) {
            transacoes.add(new Transferencia(pValor, pData, pSenha, "D"));
            pContaFav.getTransacoes().add(new Transferencia(pValor, pData, pSenha, "C"));
            return true;
        }

        return false;
    }

    public double calculaSaldo() {
        double saldo = getLimite();

        for (Transacao t : transacoes) {
            if (t instanceof Transferencia) {
                Transferencia transf = (Transferencia) t;
                if (transf.getTipo().equals("C")) {
                    saldo += transf.getValor();
                } else {
                    saldo -= transf.getValor();
                }
            } else if (t instanceof Deposito) {
                Deposito dep = (Deposito) t;
                saldo += dep.getValor();

            } else if (t instanceof Saque) {
                Saque saq = (Saque) t;
                saldo -= saq.getValor();
            }
        }

        return saldo;
    }
}
