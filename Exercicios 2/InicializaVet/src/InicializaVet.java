
import javax.swing.*;

public class InicializaVet {
    // função main

    public static void main(String args[]) {
        // declaração com inicialização (dispensando operador new)
        int vet[] = {11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        String saidaStr = "Subscrito\tValor\n"; // string alocado e inicializado
        // adiciona cada valor dos elementos do array ao String de saída
        for (int i = 0; i < vet.length; i++) {
            saidaStr += i + "\t" + vet[i] + "\n";
        }
        JTextArea saidaArea = new JTextArea();
        saidaArea.setText(saidaStr);
        JOptionPane.showMessageDialog(null, saidaArea,
                "Inicializando um Array de valores inteiros",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
