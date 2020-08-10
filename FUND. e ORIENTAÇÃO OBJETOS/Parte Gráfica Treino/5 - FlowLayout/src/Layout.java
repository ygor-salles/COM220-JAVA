
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Layout extends JFrame{
    
    JButton b1 = new JButton("Botão");
    JButton b2 = new JButton("Botão");
    
    public Layout() {
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        
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
