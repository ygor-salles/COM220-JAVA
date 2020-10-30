
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Label extends JFrame{

    JLabel label = new JLabel("Texto");
    Font fonte = new Font("Serife", Font.BOLD, 50); //instancia o tipo da fonte
    
    public Label(){
        label.setFont(fonte);
        label.setText("Outro Texto");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
        //JFrame
        setTitle("Ação");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Label();
    }
    
}
