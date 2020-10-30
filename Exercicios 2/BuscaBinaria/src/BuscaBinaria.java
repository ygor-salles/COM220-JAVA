import javax.swing.*;

public class BuscaBinaria {

    public static void main(String[] args) {
        int array[] = new int[5], num;
        String entrada;

        for (int count = 0; count < array.length; count++) {
            entrada = JOptionPane.showInputDialog("Digite o " + (count + 1) + "º numero");
            array[count] = Integer.parseInt(entrada);
        }
        System.out.println("Baguncado");
        for (int count = 0; count < array.length; count++) {
            System.out.println(array[count] + ", ");
        }

        bubbleSort(array);
        System.out.println("\nOrganizado\n ");
        for (int count = 0; count < array.length; count++) {
            System.out.println(array[count] + ", ");
        }

        entrada = JOptionPane.showInputDialog("Digite o numero que deseja procurar:");
        num = Integer.parseInt(entrada);

        num = buscaBinaria(array, num);

        if (num != -1) {
            JOptionPane.showMessageDialog(null, "Posição " + num + " do vetor");
        } else {
            JOptionPane.showMessageDialog(null, "Não existe esse elemento no atual vetor");
        }

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

    public static int buscaBinaria(int array[], int num) {
        int m, ini = 0, fim = array.length;

        while (ini < fim) {
            m = (ini + fim) / 2;

            if (array[m] == num) {
                return m;
            }

            if (array[m] >= num) {
                fim = m - 1;

            } else {
                ini = m + 1;
            }
        }
        return -1;
    }
}
