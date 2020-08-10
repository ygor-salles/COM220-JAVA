
import javax.swing.*;

public class limPrincipal {

    public int montaMenu() {
        int escolha = -1;
        String escolhaInformada = "";
        do {
            try {
                escolhaInformada =
                        JOptionPane.showInputDialog(
                        "Escolha uma opção do menu:\n"
                        + "[1] Adiciona disciplina\n"
                        + "[2] Adiciona estudante\n"
                        + "[3] Adiciona turma\n"
                        + "[4] Finaliza");
                escolha = Integer.parseInt(escolhaInformada);
            } catch (Exception exc) {
            }
        } while ((escolha < 1) || (escolha > 4));
        return escolha;
    }
}
