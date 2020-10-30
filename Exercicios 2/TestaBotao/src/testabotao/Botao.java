
package testabotao;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Jean
 */
public class Botao extends JFrame implements ActionListener {
    
    JButton b1, b2, b3;
    
    public Botao() {
        super("Testa botao");
        b1 = new JButton(); // Cria o botao esquerdo
        b1.setText("Disable middle button"); // Seta o texto
        b1.setActionCommand("DISABLE"); // Define o comando
        b1.setMnemonic(KeyEvent.VK_D); // Seta a tecla de atalho

        b2 = new JButton("Middle button"); // Cria o botao do meio
        b2.setMnemonic(KeyEvent.VK_M); // Seta o atalho
        b2.setVerticalTextPosition(JLabel.BOTTOM); // Ajusta a posicao
        b3 = new JButton("Enable middle button"); // Cria o botao direito
        b3.setEnabled(false); // Desabilita o botao
        b3.setActionCommand("ENABLE"); // Seta o commando
        b3.setMnemonic(KeyEvent.VK_E); // Seta o atalho
        b1.addActionListener(this); // Adiciona o listener ao botao
        b3.addActionListener(this); // Adiciona o listener ao botao
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b1);
        p.add(b2);
        p.add(b3);
        this.add(p);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // Se clicou em desabilitar
        if ("DISABLE".equals(command)) {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(true);
        } // Senao, clicou em habilitar
        else {
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(false);
        }
    }
    
    public static void main(String args[]) {
        Botao b = new Botao();

    }
}
