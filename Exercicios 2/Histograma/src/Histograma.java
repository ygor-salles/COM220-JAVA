
import javax.swing.*;

public class Histograma {

    public static void main(String args[]) {
        int vet[] = {19, 3, 15, 7, 11, 9, 13, 5, 17, 1};
        String saidaStr = "Elemento\tValor\tHistograma";
        // para cada elemento do vetor, apresentar barra em histrograma
        for (int i = 0; i < vet.length; i++) {
            saidaStr += "\n" + i + "\t" + vet[i] + "\t";
            // apresenta barra de asteriscos
            for (int estrelas = 0; estrelas < vet[i]; estrelas++) {
                saidaStr += "*";
            }
        }
        JTextArea outputArea = new JTextArea();
        outputArea.setText(saidaStr);
        JOptionPane.showMessageDialog(null, outputArea,
                "Programa de Impressão de Histrogramas",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
