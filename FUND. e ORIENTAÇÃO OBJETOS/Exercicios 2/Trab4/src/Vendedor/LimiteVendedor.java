package Vendedor;

import javax.swing.*;

/**
 *
 * @author Jean
 */
public class LimiteVendedor {

    private ControleVendedor controle;

    public LimiteVendedor(ControleVendedor pControle) {
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
                                + "[1] Inserir Vendedor\n"
                                + "[2] Inseir Venda de Vendedor\n"
                                + "[3] Total Pago no Mes\n"
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
                inserirVendedor();
                break;
            }
            case 2: {
                int intLCodigo = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Digite o código do Vendedor"));
                inserirVenda(intLCodigo);
                break;
            }
            case 3: {
                imprimiRelatorio();
            }
        }
    }

    private void inserirVendedor() {
        int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha:\n[1] Contratado\n[2]Comissionado"));

        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o código"));
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");

        if (tipo == 1) {

            String ctb = JOptionPane.showInputDialog(
                    "Informe o numero da carteira de trabalho");

            double salario = Double.parseDouble(JOptionPane.showInputDialog(
                    "Informe o salario"));
            controle.inserirVendedorContratado(codigo, nome, ctb, salario);
        } else if (tipo == 2) {

            String cpf = JOptionPane.showInputDialog(
                    "Informe o CPF");

            float comissao = Float.parseFloat(JOptionPane.showInputDialog(
                    "Informe a comissão. Ex: 7 (para 7%)"));

            controle.inserirVendedorComissionado(codigo, nome, cpf, comissao);
        } else {
            JOptionPane.showMessageDialog(null, "Escolha Inválida.\nVoltando ao menu");
        }

    }

    public void inserirVenda(int intLCodigo) {

        int pCodImovel = Integer.parseInt(JOptionPane.showInputDialog(
                "Codigo da Venda"));

        int pMes = Integer.parseInt(JOptionPane.showInputDialog(
                "Mes da Venda"));

        int pAno = Integer.parseInt(JOptionPane.showInputDialog(
                "Ano da Venda"));

        double pValor = Double.parseDouble(JOptionPane.showInputDialog(
                "Valor da Venda"));

        controle.inserirVenda(intLCodigo, pCodImovel, pMes, pAno, pValor);

    }

    public void imprimiRelatorio() {
        int pMes = Integer.parseInt(JOptionPane.showInputDialog(
                "Mes da Venda"));

        int pAno = Integer.parseInt(JOptionPane.showInputDialog(
                "Ano da Venda"));
        
        JTextArea message = new JTextArea(controle.relatorioVendedores(pMes, pAno));  
        message.setEditable(false);  
        JOptionPane.showMessageDialog(null, message);
    }

}
