
import java.util.*;
import javax.swing.*;


public class limiteConta {
    private controleConta controle;

    public limiteConta(controleConta pControle) {
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
                                + "[1] Criar conta\n"
                                + "[2] Realizar transação\n"
                                + "[3] Imprimir extrato\n"
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
                transacao();
                break;
            }
            case 3: {
                imprimeExtrato();
            }
        }
    }

    private void criarConta() {
        
        int pNroConta = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o numero da conta"));
        
        String pNomeCorrent = JOptionPane.showInputDialog(
                "Informe o nome");
        double pLimite = Double.parseDouble(JOptionPane.showInputDialog(
                "Informe o limite"));
        
        String pSenha = JOptionPane.showInputDialog(
                "Informe a senha");
        
      //  controle.criarConta(pNroConta, pNomeCorrent, pLimite, pSenha);
    }
    
    private void transacao() {
        int escolha, pConta;
        String pSenha;
 
            do {
                String escolhaInformada
                        = JOptionPane.showInputDialog(
                                "Escolha uma opção do menu:\n"
                                + "[1] Depositar\n"
                                + "[2] Sacar\n"
                                + "[3] Transferência\n"
                                + "[4] Finaliza");
                escolha = Integer.parseInt(escolhaInformada);
            } while ((escolha < 1) || (escolha > 4));
                        
            double pValor = Double.parseDouble(JOptionPane.showInputDialog(
                            "Informe o valor"));
             
            switch(escolha){
               case 1:
                   String pNomeCorrent = JOptionPane.showInputDialog(
                            "Informe seu nome");
                   
                   pConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o numero da conta para deposito"));
                   
                   controle.adicionaDeposito(pConta, pValor, new Date(), pNomeCorrent);
                   break;
               case 2:
                    pConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o numero da sua conta "));
                   
                    pSenha = JOptionPane.showInputDialog(
                            "Digite a senha");

                    controle.adicionaSaque(pConta, pValor, new Date(), pSenha);
                    break;
               case 3:
                    pConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o numero da sua conta "));
                    
                    pSenha = JOptionPane.showInputDialog(
                            "Digite a senha");
                    
                    int pNroConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o numero da conta favorevida"));
  
                    controle.adicionaTransferencia(pConta, pValor, pSenha, pNroConta); 
           }
    }

    public void imprimeExtrato() {
        
        String conta;
        
        int pConta = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o numero da sua conta "));
        
        JOptionPane.showMessageDialog(null, controle.getExtrato(pConta));
    }
}
