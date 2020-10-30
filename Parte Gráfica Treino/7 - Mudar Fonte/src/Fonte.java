
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Fonte extends JFrame{

    JButton b1 = new JButton("Botão");
    Font fonte = new Font("Arial", Font.ITALIC | Font.BOLD, 100); //instancia o tipo da fonte
    Color cor = new Color(255,255,255);     //instancia a cor própria
    
    public Fonte(){
        setLayout(new FlowLayout());
        b1.setFont(fonte);
        b1.setBackground(Color.blue);           //muda a cor de fundo
        b1.setForeground(cor);          //muda a cor da fonte
        add(b1);
        
        //JFrame
        setTitle("Ação");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Fonte();
    }
    
}
