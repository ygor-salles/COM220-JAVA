/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Limite;

import Controle.ControleConsulta;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author cascao
 */
public class LimiteConsulta implements ActionListener {
    private ControleConsulta ctrlCons;
    private JPanel panel, panelCombo;
    private JComboBox combo;
    private JLabel label;
    private JTextArea area;
    
    public LimiteConsulta(){
    iniciaComponenteCons();
    }
    
    public void iniciaComponenteCons(){
        label = new JLabel("Selecione o Genero para Consulta");
        ctrlCons = new ControleConsulta();
        combo = new JComboBox(ctrlCons.getComboBox());
        combo.addActionListener(this);
        area = new JTextArea();
        JScrollPane scrool = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        panelCombo = new JPanel(new FlowLayout());
        panel = new JPanel(new BorderLayout());
        panelCombo.add(label);
        panelCombo.add(combo);
        panel.add(panelCombo, BorderLayout.PAGE_START);
        panel.add(scrool, BorderLayout.CENTER);
        
    }
    public JPanel getPanelCons() {
        iniciaComponenteCons();
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == combo){
            String cbStr = (String)combo.getSelectedItem();
            ctrlCons = new ControleConsulta();
            area.setText(ctrlCons.getConsDvd(cbStr));
        
        }
    }
    
}
