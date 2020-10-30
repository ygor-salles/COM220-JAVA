
package Clinica;



import java.awt.event.*;
import javax.swing.*;


public class LimitePrincipal extends JFrame{
    
    ControlePrincipal ctrPrincipal;
    
    public LimitePrincipal(ControlePrincipal pCtrPrincipal) {
        super("Clinica");
        ctrPrincipal = pCtrPrincipal;
        JMenuBar mb = new JMenuBar();
        this.setJMenuBar(mb);
        JMenu m = new JMenu("Funcão", true);
        mb.add(m);
        
        JMenuItem menuCria = new JMenuItem("Marcar Consulta");
        menuCria.setMnemonic(KeyEvent.VK_A);
        menuCria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrPrincipal.getCtrConsulta().MarcaConsulta();
            }
            
        });
        m.add(menuCria);
        
        JMenuItem menuCria2 = new JMenuItem("Listar Consulta");
        menuCria2.setMnemonic(KeyEvent.VK_L);
        menuCria2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrPrincipal.getCtrConsulta().ListaConsulta();
            }
            
        });
        m.add(menuCria2);
        
        
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
    
}
