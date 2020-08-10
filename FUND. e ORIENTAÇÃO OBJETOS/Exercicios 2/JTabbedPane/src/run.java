
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

    public run() {
        super("JTABBEDPANE");
        tabbedPane = new JTabbedPane();

        p1 = new JPanel();
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));
        tabbedPane.addTab("Aba 1", p1);

        p2 = new JPanel();
        p2.add(new JTextField("TextField", 20));
        tabbedPane.addTab("Aba 2", p2);
        
        this.setLayout(new BorderLayout());
        this.add(tabbedPane, BorderLayout.CENTER);
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
