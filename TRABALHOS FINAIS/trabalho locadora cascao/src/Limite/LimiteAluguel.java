/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Limite;

import Controle.ControleAluguel;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author cascao
 */
public class LimiteAluguel implements ActionListener {

    private JPanel panel;
    private JLabel lCodCli, lCodigoDvd;
    private JTextField tfCodCli, tfCodigoDvd;
    private JButton bAluga, bLimpa;
    private ControleAluguel ctrlAluguel;

    public void iniciaComponenteLoc() {

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 25));
        lCodCli = new JLabel("Código Cliente");
        lCodigoDvd = new JLabel("  Código DVD   ");

        tfCodCli = new JTextField(20);
        tfCodigoDvd = new JTextField(20);

        bAluga = new JButton("Alugar");
        bAluga.addActionListener(this);
        bLimpa = new JButton("Limpar");
        bLimpa.addActionListener(this);

        panel.add(lCodCli);

        panel.add(tfCodCli);
        panel.add(lCodigoDvd);
        panel.add(tfCodigoDvd);
        panel.add(bAluga);
        panel.add(bLimpa);


    }

    public JPanel getPanelLoc() {
        iniciaComponenteLoc();
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bAluga) {
            int codDvd, codCliente;
            
            ctrlAluguel = new ControleAluguel();
            codDvd = Integer.parseInt(tfCodigoDvd.getText());
            codCliente = Integer.parseInt(tfCodCli.getText());
            if(ctrlAluguel.setAluguel(codDvd, codCliente)){
                JOptionPane.showMessageDialog(null, "Aluguel realizado com sucesso");
            
            }else{
                JOptionPane.showMessageDialog(null, "Aluguel não efetuado");
            }
            
        }
        if (ae.getSource() == bLimpa) {
            limpa();
        }


    }

    public void limpa() {
        tfCodCli.setText("");
        tfCodigoDvd.setText("");

    }
}
