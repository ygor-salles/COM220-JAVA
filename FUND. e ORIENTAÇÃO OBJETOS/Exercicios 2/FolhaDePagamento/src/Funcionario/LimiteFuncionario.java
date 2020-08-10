
package Funcionario;

import javax.swing.*;

/**
 *
 * @author Jean
 */
public class LimiteFuncionario {
    private ControleFuncionario controle;

    public LimiteFuncionario(ControleFuncionario pControle) {
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
                                + "[1] Inserir Funcionario\n"
                                + "[2] Inseir Ponto\n"
                                + "[3] Total Folha de Pagamento\n"
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
                inserirFuncionario();
                break;
            }
            case 2: {
                int intLCodigo = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Digite o código do Funcionario"));
                adicionarPonto(intLCodigo);
                break;
            }
            case 3: {
                imprimirFolhadePagamento();
            }
        }
    }

    private void inserirFuncionario() {
        int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha:\n[1] Professor\n[2]Tecnico Administrativo"));

        int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o código"));
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");

        if (tipo == 1) {

            String titulo = JOptionPane.showInputDialog(
                    "Informe o Titulo do Professor");

            double salario = Double.parseDouble(JOptionPane.showInputDialog(
                    "Informe o salario/hora"));
            
            int aulas = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o numero de aulas"));
                    
            controle.inserirProfessor(codigo, nome, titulo, salario, aulas);
            
        } else if (tipo == 2) {

            String funcao = JOptionPane.showInputDialog(
                    "Informe a funcão");

            double salario = Double.parseDouble(JOptionPane.showInputDialog(
                    "Informe o salario mensal"));

            controle.inserirTecnicoAdministrativo(codigo, nome, funcao, salario);
            
        } else {
            JOptionPane.showMessageDialog(null, "Escolha Inválida.\nVoltando ao menu");
        }

    }

    public void adicionarPonto(int intLCodigo) {

        int pCod = Integer.parseInt(JOptionPane.showInputDialog(
                "Codigo do Funcionario"));

        int pMes = Integer.parseInt(JOptionPane.showInputDialog(
                "Mes da Venda"));

        int pAno = Integer.parseInt(JOptionPane.showInputDialog(
                "Ano da Venda"));
 
        controle.adicionaPonto(pCod, pMes, pAno);
    }

    public void imprimirFolhadePagamento() {
        int pMes = Integer.parseInt(JOptionPane.showInputDialog(
                "Mes da Folha"));

        int pAno = Integer.parseInt(JOptionPane.showInputDialog(
                "Ano da Folha"));
        
        JTextArea message = new JTextArea(controle.imprimeFolha(pMes, pAno));  
        message.setEditable(false);  
        JOptionPane.showMessageDialog(null, message);
    }
   
}
