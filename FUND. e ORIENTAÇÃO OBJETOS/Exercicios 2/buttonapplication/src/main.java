
import java.awt.*;
import javax.swing.*;

public class main {

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
