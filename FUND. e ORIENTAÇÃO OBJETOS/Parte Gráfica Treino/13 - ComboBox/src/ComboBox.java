
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class ComboBox extends JFrame  {
    
    JComboBox<String> cbox = new JComboBox<>();

    public ComboBox() {
        
        add(cbox);
        cbox.addItem("Flávio");
        cbox.addItem("Eduardo");
        cbox.addItem("Oliveira");
        cbox.setSelectedIndex(2);           //inicializa no index x
        System.out.println(cbox.getSelectedIndex());
        cbox.addActionListener(cbox);
        
        setLayout(new FlowLayout());
        //JFrame
        setTitle("Título");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBox();
    }

}
