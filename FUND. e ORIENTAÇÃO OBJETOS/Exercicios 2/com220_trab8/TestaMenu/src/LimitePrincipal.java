
import java.awt.event.*;
import javax.swing.*;

public class LimitePrincipal extends JFrame {

    ControlePrincipal ctrPrincipal;

    public LimitePrincipal(ControlePrincipal pCtrPrincipal) {
        super("Sistema Acadêmico");
        ctrPrincipal = pCtrPrincipal;
        JMenuBar mb = new JMenuBar();
        this.setJMenuBar(mb);
        JMenu m = new JMenu("Menu", true);
        mb.add(m);
        JMenuItem menuCria = new JMenuItem("Cria Turma");
        menuCria.setMnemonic(KeyEvent.VK_C);
        menuCria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrPrincipal.getCtrTurma().criaTurma();
            }
        });
        m.add(menuCria);
        JMenuItem menuImprime = new JMenuItem("Imprime Turma");
        menuImprime.setMnemonic(KeyEvent.VK_I);
        menuImprime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ctrPrincipal.getCtrTurma().imprimeTurma();
            }
        });
        m.add(menuImprime);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);  
        this.setVisible(true);
    }
}
