
import javax.swing.*;

public class LancamentoDado{

    public static void main(String args[]) {
        int face, frequencia[] = new int[7];
        // lança o dado 6000 vezes
        for (int lancamento = 1; lancamento <= 6000; lancamento++) {
            face = 1 + (int) (Math.random() * 6);
            // utilizando o valor da variável face como subscrito do array
            ++frequencia[face];
        }
        String output = "Face\tFrequencia\tPercentual";
        // Adiciona freqüências ao String de Saída
        for (face = 1; face < frequencia.length; face++) {
            output += "\n" + face + "\t" + frequencia[face] + "\t"
                    + 100 * frequencia[face] / 6000;
        }
        JTextArea outputArea = new JTextArea();
        outputArea.setText(output);
        JOptionPane.showMessageDialog(null, outputArea,
                "Lançando um dado 6000 Vezes",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
