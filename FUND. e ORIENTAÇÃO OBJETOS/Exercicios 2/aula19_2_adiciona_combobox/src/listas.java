
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class listas extends JFrame implements ActionListener {

    JTextField text;
    JComboBox cb1;
    JPanel p;

    String[] str1 = {"ATK", "DEF", "AGI", "DEX"};

    public listas() {
        super("Janela Combo Box");

        p = new JPanel();

        cb1 = new JComboBox(str1);
        text = new JTextField(20);
        text.addActionListener(this);

        p.add(text);
        p.add(cb1);

        /// WINDOW
        this.add(p);
        this.setLayout(new FlowLayout(10));
        this.setSize(350,80);
        //this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String args[]) {
        listas m = new listas();
    }

    public void actionPerformed(ActionEvent ae) {
        
        String texto = text.getText(); // pega o texto do jtextfield
        if (!texto.isEmpty()){
                cb1.addItem(texto); // adiciona no combobox
        }
        text.setText(null);
    }
}
