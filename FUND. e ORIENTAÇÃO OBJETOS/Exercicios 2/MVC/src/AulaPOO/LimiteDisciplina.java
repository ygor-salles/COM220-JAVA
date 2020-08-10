package AulaPOO;

import javax.swing.JOptionPane;

public class LimiteDisciplina {

    private ControleDisciplina ctrDisc;

    /**
     * Construtor da classe.
     *
     * @param objPControleDisc é uma referência do objeto ControleDisciplina.
     */
    public LimiteDisciplina(ControleDisciplina objPControleDisc) {
        ctrDisc = objPControleDisc;
        CapturaDados();
    }

    /**
     * É responsável por gerenciar o menu principal da aplicação.
     */
    private void CapturaDados() {
        int escolha;
        do {
            do {
                String escolhaInformada
                        = JOptionPane.showInputDialog(
                                "Escolha uma opção do menu:\n"
                                + "[1] Adiciona disciplina\n"
                                + "[2] Lista uma disciplina\n"
                                + "[3] Lista disciplinas\n"
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

    /**
     * Faz o tratamento da escolha da opção do usuário.
     *
     * @param intPEscolha opção escolhida pelo usuário.
     */
    private void execEscolha(int intPEscolha) {
        switch (intPEscolha) {
            case 1: {
                cadastraDisciplina();
                break;
            }
            case 2: {
                int intLCodigo = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Digite o código da disciplina"));
                imprimeDisciplina(intLCodigo);
                break;
            }
            case 3: {
                imprimeDisciplinas();
            }
        }
    }

    /**
     * Método responsável por fazer a chamada para cadastrar uma disciplina.
     */
    private void cadastraDisciplina() {
        String retorno = JOptionPane.showInputDialog(
                "Informe o código");
        int codigo = Integer.parseInt(retorno);
        String nome = JOptionPane.showInputDialog(
                "Informe o nome");
        retorno = JOptionPane.showInputDialog(
                "Informe o carga horária");
        int cargaHoraria = Integer.parseInt(retorno);
        ctrDisc.insereDisciplina(codigo, nome,
                cargaHoraria);
    }

    /**
     * Método reponsável por apresentar as informações das disciplinas.
     */
    public void imprimeDisciplinas() {
        JOptionPane.showMessageDialog(null,
                ctrDisc.imprimeDisciplinas(),
                "Relação de Disciplinas", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método responsável por apresentar as informações de uma única disciplina.
     *
     * @param pCodigo código de uma disciplina
     */
    public void imprimeDisciplina(int pCodigo) {
        JOptionPane.showMessageDialog(null,
                ctrDisc.imprimeDisciplina(pCodigo),
                "Informações da Disciplina", JOptionPane.INFORMATION_MESSAGE);
    }
}
