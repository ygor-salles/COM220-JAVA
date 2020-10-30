
import javax.swing.*;

public class ClassificaArray extends JApplet {

    public static void main(String args[]) {
        JTextArea saidaArea = new JTextArea();
        int array[] = {2, 6, 4, 8, 10, 12, 89, 68, 45, 37};

        String saida = "Itens do array na ordem original\n";
        // acrescenta valores originais do array ao String saida
        for (int counter = 0; counter < array.length; counter++) {
            saida += " " + array[counter];
        }
        bubbleSort(array); // ordena o array
        saida += "\n\nItens do array em ordem ascendente\n";
        // acrescenta valores ordenados do array ao String saida
        for (int counter = 0; counter < array.length; counter++) {
            saida += " " + array[counter];
        }
        
        saidaArea.setText(saida);
        JOptionPane.showMessageDialog(null, saidaArea,
                "Programa de ordenação dos elementos de um array",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
// ordena os elementos de um array considerando o algoritmo da Bolha

    public static void bubbleSort(int array2[]) {
        // laço para controlar o número de passagens
        for (int passagem = 1; passagem < array2.length; passagem++) {
            // laço para controlar o número de comparações
            for (int elemento = 0; elemento < array2.length - 1;
                    elemento++) {
                // compara elementos adjacentes e os troca de lugar se
                // o primeiro elemento for maior que o segundo elemento
                if (array2[elemento] > array2[elemento + 1]) {
                    troca(array2, elemento, elemento + 1);
                }
            } // fim do laço para controlar comparações
        } // fim do laço para controlar passagens
    } // fim do método bubleSort
    // troca dois elmentos de um array

    public static void troca(int array3[], int prim, int sec) {
        int elemento; // área de armazenamento temporário para troca
        elemento = array3[prim];
        array3[prim] = array3[sec];
        array3[sec] = elemento;
    }
} // fim da classe ClassificaArray
