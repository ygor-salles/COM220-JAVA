package ControleBancario;

import javax.swing.*;

/**
 *
 * @author Jean
 */
public class LimiteConta {

    private ControleConta controle;

    public LimiteConta(ControleConta pControle) {
        controle = pControle;
        CapturaDados();
    }

    private void CapturaDados() {
        int escolha;
        do {
            do {
                String escolhaInformada
                        = JOptionPane.showInputDialog(
                                "Escolha uma opção do menu:\n"
                                + "[1] Criar uma conta\n"
                                + "[2] Realizar uma Transação\n"
                                + "[3] Imprimir Extrato\n"
                                + "[4] Finaliza");
                escolha
                        = Integer.parseInt(escolhaInformada);
            } while ((escolha < 1) || (escolha > 4));
            if (escolha != 4) {
                execEscolha(escolha);
            } else {
                System.exit(0);
            }
        } while (true);
    }

    private void execEscolha(int intPEscolha) {
        switch (intPEscolha) {
            case 1: {
                criarConta();
                break;
            }
            case 2: {
                realizarTransacao();
                break;
            }
            case 3: {
                extrato();
            }
        }
    }

    private void criarConta() {
        int nroConta = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe um numero para a conta"));
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");
        double limite = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe o limite"));
        String senha = JOptionPane.showInputDialog(
                "Informe a senha");

        controle.criarConta(nroConta, nome, limite, senha);
    }

    private void realizarTransacao() {
        int cod = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o codigo da conta"));
        double valor = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe valor"));

        int action = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o codigo operacao:\n"
                + "[1] Sacar esse valor\n"
                + "[2] Depositar \n"
                + "[3] Transferir \n"));

        /// SACAR
        if (action == 1) {

            String senha = JOptionPane.showInputDialog(
                    "Informe a senha");
            controle.sacar(cod, valor, senha);

            /// DEPOSITAR    
        } else if (action == 2) {
            String nomeDep = JOptionPane.showInputDialog(
                    "Informe o nome do Depositante");
            controle.depositar(cod, valor, nomeDep);

        } else if (action == 3) {
            int cred = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o codigo da conta Credito"));
            controle.realizarTransferencia(cod, cred, valor);
        }
    }

    private void extrato() {
        int ext = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o codigo da conta"));

        JOptionPane.showMessageDialog(null, controle.extrato(ext));
    }

}
