
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleDialog extends JDialog implements ActionListener {

    JFrame parent;
    JTextField textField;
    JButton setButton;

    SimpleDialog(JFrame parent, String title) {
        super(parent, title, true);
        JLabel label = new JLabel("Entre o texto aqui: ");
        textField = new JTextField(25);
        setButton = new JButton("Ajusta título");
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(label);
        p.add(textField);
        p.add(setButton);
        this.add(p);
        setButton.addActionListener(this); //Adicionando listener ao botao
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == setButton) {
            this.setTitle(textField.getText());
        }
    }

    public static void main(String[] args) {
        // Código que cria uma caixa de diálogo e a torna visível
        JFrame parent = new JFrame();
        SimpleDialog dialog = new SimpleDialog(parent, "A Simple Dialog");
    }
}
