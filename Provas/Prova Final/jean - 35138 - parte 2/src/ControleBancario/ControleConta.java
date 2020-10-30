package ControleBancario;

import java.util.*;
import java.util.*;

/**
 *
 * @author Jean
 */
public class ControleConta {

    private LimiteConta limite;
    private Vector Contas;

    public ControleConta() {
        Contas = new Vector();
        limite = new LimiteConta(this);
    }

    public void criarConta(int nroConta, String nome, double limite, String senha) {
        Contas.add(new Conta(nroConta, nome, limite, senha));
    }

    public void sacar(int cod, double pValor, String senha) {
        for (Object o1 : Contas) {
            if (((Conta) o1).getNroConta() == cod) {
                ((Conta) o1).adicionaSaque(pValor, new Date(), senha);
            }
        }
    }

    public void depositar(int cod, double pValor, String pNomeDep) {
        for (Object o1 : Contas) {
            if (((Conta) o1).getNroConta() == cod) {
                ((Conta) o1).adicionaDeposito(pValor, new Date(), pNomeDep);
            }
        }

    }

    public void realizarTransferencia(int deb, int cred, double valor) {

        for (Object o1 : Contas) {
            if (((Conta) o1).getNroConta() == deb) {
                for (Object o2 : Contas) {
                    if (((Conta) o2).getNroConta() == cred) {
                        ((Conta) o1).adicionaTransf(5000, new Date(), "senha2", ((Conta) o2));
                    }
                }

            }
        }

    }

    public String extrato(int ext) {
        String extrato = "";

        for (Object o : Contas) {
            if (((Conta) o).getNroConta() == ext) {
                extrato += "Numero: " + ((Conta) o).getNroConta()
                        + "\nNome: " + ((Conta) o).getNomeCorrent()
                        + "\nLimite: " + ((Conta) o).getLimite()
                        + "Saldo: " + ((Conta) o).calculaSaldo();

            }
        }

        return extrato;
    }
}
