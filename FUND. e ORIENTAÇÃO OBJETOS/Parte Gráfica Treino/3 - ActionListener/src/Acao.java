
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Acao extends JFrame implements ActionListener{
    JButton b = new JButton("Mensagem");
    JButton b1 = new JButton("Sair");
    
    public Acao() {
        
        //Botão
        setLayout(null);
        b.setBounds(250,150,100,50);
        b1.setBounds(350,150, 100, 50);
        add(b);
        add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
        
        //JFrame
        setTitle("Ação");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b)
            JOptionPane.showMessageDialog(null, "Botão clicado");
        if(e.getSource() == b1)
            System.exit(0);
    }
    
    public static void main(String[] args) {
        new Acao();
    }


    
}
