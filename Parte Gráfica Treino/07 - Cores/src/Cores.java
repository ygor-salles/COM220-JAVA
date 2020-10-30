
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Cores extends JFrame{

    JButton b1 = new JButton("Botão");
    Font fonte = new Font("Arial", Font.ITALIC | Font.BOLD, 100);
    
    public Cores(){
        setLayout(new FlowLayout());
        b1.setFont(fonte);
        add(b1);
        
        //JFrame
        setTitle("Ação");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Cores();
    }
    
}
