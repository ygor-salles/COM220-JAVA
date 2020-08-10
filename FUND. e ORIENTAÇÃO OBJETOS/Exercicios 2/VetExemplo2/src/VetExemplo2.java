
import javax.swing.*;

public class VetExemplo2 {
    // função main

    public static void main(String args[]) {
        // declaração de vetor de inteiros com tamanho 10
        final int TAM_VET = 10;
        int vet[] = new int[TAM_VET];
        // calcula o valor para cada elemento do vetor
        for (int i = 0; i < vet.length; i++) {
            vet[i] = 2 + 2 * i;
        }
        String saidaStr = "Subscrito\tValor\n"; // string alocado e inicializado
        // adiciona cada valor dos elementos do vetor ao String de saída
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