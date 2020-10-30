
import javax.swing.JButton;
import javax.swing.JFrame;

public class Botao extends JFrame{
    
    JButton b1 = new JButton("Botão");
    
    public Botao() {
        //Botão
        setLayout(null);                //trabalhando sem layout
        b1.setBounds(300,200,100,50);   //definindo x, y, largura, altura por não ter layout
        add(b1);                        //adicionando o botão a janela
        
        //JFrame
        setTitle("Botão");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
         
         
         
    }
    public static void main(String[] args) {
        new Botao();
    }
    
}
