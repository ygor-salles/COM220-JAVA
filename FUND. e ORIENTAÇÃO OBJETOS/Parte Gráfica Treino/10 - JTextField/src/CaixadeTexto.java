
import java.awt.FlowLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;


public class CaixadeTexto extends JFrame{
    
    JTextField caixa = new JTextField(30);
    
    public CaixadeTexto(){
        setLayout(new FlowLayout());
        add(caixa);
        caixa.setText("JTextField");
        System.out.println(caixa.getText());
        
        
        //JFrame
        setTitle("Título");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CaixadeTexto();
    }
    
}
