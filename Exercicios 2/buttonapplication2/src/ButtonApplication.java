
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonApplication {

    private static String rotulo = "Número de cliques: ";
    private int numClicks = 0;

    public Component createComponents() {
        final JLabel label = new JLabel(rotulo + "0 ");
        JButton button1 = new JButton("Clique ++");
        //Adicionando listener ao botao
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(rotulo + numClicks);
            }
        });
        
        JButton button2 = new JButton("Clique --");
        //Adicionando listener ao botao
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks--;
                label.setText(rotulo + numClicks);
            }
        });

        label.setLabelFor(button1);
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.add(button1);
        pane.add(button2);
        pane.add(label);
        return pane;
    }

    public static void main(String[] args) {
//Cria container e adiciona a ele elementos de interface.
        JFrame frame = new JFrame("Primeira Aplicação Swing");
        ButtonApplication app = new ButtonApplication();
        Component conteudo = app.createComponents();
        frame.getContentPane().add(conteudo, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
