/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Limite;
import Controle.ControleDevolucao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author cascao
 */
public class LimiteDevolucao implements ActionListener {
    private ControleDevolucao ctrlDev;
    private JPanel panel, panelBusca;
    private JLabel label;
    private JTextArea area;
    private JTextField tfBusca;
    
    public LimiteDevolucao(){
    iniciaComponenteCons();
    }
    
    public void iniciaComponenteCons(){
        label = new JLabel("Forneça o código do DVD");
        tfBusca = new JTextField(15);
        tfBusca.addActionListener(this);
        area = new JTextArea();
        panelBusca = new JPanel(new FlowLayout());
        panel = new JPanel(new BorderLayout());
        panelBusca.add(label);
        panelBusca.add(tfBusca);
        panel.add(panelBusca, BorderLayout.PAGE_START);
        panel.add(area, BorderLayout.CENTER);
        
    }
    
    public JPanel getPanelDev() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== tfBusca){
            int intDev = Integer.parseInt(tfBusca.getText());
            ctrlDev = new ControleDevolucao();
            area.setText(ctrlDev.getAluguelDvd(intDev));
            
            
        
        }
    }
    
}
