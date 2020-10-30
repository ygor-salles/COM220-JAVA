
import javax.swing.*;
import java.lang.*;

/**
 *
 * @author Jean
 */
public class testeException {

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        String enter;

        enter = JOptionPane.showInputDialog("Insira num1: ");
        num1 = Integer.parseInt(enter);

        enter = JOptionPane.showInputDialog("Insira num2: ");
        num2 = Integer.parseInt(enter);
        try {
            num1 = num1 / num2;
        } catch (ArithmeticException m) {
            JOptionPane.showMessageDialog(null, "\nNão Erro: " + m.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Mesagem: " + num1);

    }
}
