
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class CheckBox extends JFrame{
    
    JCheckBox box = new JCheckBox("Confirma", true); //inicializa nome e boolean
    
    public CheckBox(){
        setLayout(new FlowLayout());
        add(box);
        box.setText("Confirma");                //seta o nome
        box.setSelected(false);                 //inicializa true ou false
        System.out.println(box.isSelected());   //verifica se está marcado
        
        //JFrame
        setTitle("Título");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CheckBox();
    }
    
}