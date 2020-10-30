package pkg14.menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener {

    JMenuBar barra = new JMenuBar();        //barra de menu
    
    JMenu menu1 = new JMenu("Opções");      //menu
    JMenu menu2 = new JMenu("Sair");
    
    JMenuItem item1 = new JMenuItem("Exit");    //itens do menu
    
    public Menu() {
        setJMenuBar(barra);
        barra.add(menu1);
        barra.add(menu2);
        
        menu2.add(item1);
        item1.addActionListener(this);
        
        setLayout(new FlowLayout());
        //JFrame
        setTitle("Título");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(item1))
            System.exit(0);
    }
    
    public static void main(String[] args) {
        new Menu();
            
    }

}
