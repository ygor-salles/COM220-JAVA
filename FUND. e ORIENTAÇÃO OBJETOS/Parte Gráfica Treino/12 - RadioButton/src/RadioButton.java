
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class RadioButton extends JFrame {

    JRadioButton radio = new JRadioButton("Masculino");
    JRadioButton radio1 = new JRadioButton("Feminino");
    
    ButtonGroup grupo = new ButtonGroup();          //para selecionar apenas 1

    public RadioButton() {
        add(radio);
        add(radio1);
        
        grupo.add(radio);
        grupo.add(radio1);
        
        setLayout(new FlowLayout());
        //JFrame
        setTitle("Título");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RadioButton();
    }

}
