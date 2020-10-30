
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Layout extends JFrame{
    
    JButton b1 = new JButton("Norte");
    JButton b2 = new JButton("Sul");
    JButton b3 = new JButton("Leste");
    JButton b4 = new JButton("Oeste");
    JButton b5 = new JButton("Centro");
    
    public Layout() {
        setLayout(new BorderLayout());
        add(BorderLayout.NORTH, b1);
        add(BorderLayout.SOUTH, b2);
        add(BorderLayout.EAST, b3);
        add(BorderLayout.WEST, b4);
        add(BorderLayout.CENTER, b5);
        
        
        //JFrame
        setTitle("Ação");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Layout();
    }
    
}
