
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class run extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;
    JPanel p1;
    JPanel p2;
    JPanel p3;

    JPanel pane;
    JTextField nomeT;
    JTextField endT;
    JTextField telT;
    JTextField emailT;

    public run() {
        nomeT = new JTextField(25);
        endT = new JTextField(25);
        telT = new JTextField(25);
        emailT = new JTextField(25);

        SpringLayout layout = new SpringLayout();

        pane = new JPanel();
        JLabel nome = new JLabel("Nome: ");
        JLabel end = new JLabel("Endereço: ");
        JLabel tel = new JLabel("Telefone: ");
        JLabel email = new JLabel("E-mail: ");
      
        layout.putConstraint(SpringLayout.WEST , nome, 15, SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , nome, 20, SpringLayout.NORTH , this);
        layout.putConstraint(SpringLayout.WEST, nomeT, 95, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, nomeT, 20, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST , end, 15, SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , end, 60, SpringLayout.NORTH , this);
        layout.putConstraint(SpringLayout.WEST, endT, 95, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, endT, 60, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST , tel, 15, SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , tel, 100, SpringLayout.NORTH , this);
        layout.putConstraint(SpringLayout.WEST, telT, 95, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, telT, 100, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST , email, 15, SpringLayout.WEST , this);
        layout.putConstraint(SpringLayout.NORTH , email, 140, SpringLayout.NORTH , this);
        layout.putConstraint(SpringLayout.WEST, emailT, 95, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, emailT, 140, SpringLayout.NORTH, this);
        
        
        add(nome);
        add(nomeT);
        add(end);
        add(endT);
        add(tel);
        add(telT);
        add(email);
        add(emailT);
        
        setLayout(layout);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String args[]) {
        run r = new run();
    }
}
