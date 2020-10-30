
import javax.swing.JOptionPane; // import class JOptionPane

public class Media {

    public static void main(String args[]) {
        String primeiroNumero;// 1o string informado pelo usuário
        String segundoNumero; // 2o string informado pelo usuário
        int numero1; // primeiro operando da adição
        int numero2; // segundo operando da adição
        float media; // Resultado da Adição
        // ler o primeiro número (na forma string)
        primeiroNumero = JOptionPane.showInputDialog("Digite o Primeiro No Inteiro");
        // ler o segundo número (na forma string)
        segundoNumero = JOptionPane.showInputDialog("Digite o Segundo No Inteiro");
        // convertendo os strings em números inteiros
        numero1 = Integer.parseInt(primeiroNumero);
        numero2 = Integer.parseInt(segundoNumero);
        // Somando os números
        media = (float)( numero1 + numero2 ) / 2;
        // Apresentando os resultados
        JOptionPane.showMessageDialog(null, "A médio é " + media, "Resultado da Soma: ",
                JOptionPane.PLAIN_MESSAGE);
        System.exit(0); // termina a aplicação
    } // fim do método main()
} // fim da classe Adicao
