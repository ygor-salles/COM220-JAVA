
/**
 *
 * @author Jean
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonApplication implements ActionListener {

    private static String rotulo = "Número de cliques: ";
    private int numClicks = 0;
    private JLabel label;

    public Component createComponents() {
        label = new JLabel(rotulo + "0 ");
        JButton button1 = new JButton("Clique aqui");
        //Adicionando listener ao botao
        button1.addActionListener(this);
        label.setLabelFor(button1);
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.add(button1);
        pane.add(label);
        return pane;
    }

    public void actionPerformed(ActionEvent e) {
        numClicks++;
        label.setText(rotulo + numClicks);
    }
}
