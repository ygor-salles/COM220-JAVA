/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;


import Controle.ControlePrincipal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Luan
 */
public class ConsultaAcervo extends JFrame implements ActionListener{
    private JTextArea t1;
    private ControlePrincipal objP;
    private JButton b1;
    
    public void setT1(JTextArea t1) {
        this.t1 = t1;
    }
    private String item;

    public String getItem() {
        return item;
    }
    public ConsultaAcervo(JComboBox c1){
       objP=new ControlePrincipal();
       b1=new JButton("Home");
       b1.addActionListener(this);
       this.setSize(200,200);
      this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       c1.setActionCommand("Combo1");
       c1.addActionListener(this);
       this.setLayout( new BorderLayout());
       t1=new JTextArea(20,40);
       this.add(c1,BorderLayout.PAGE_START);
       this.add(t1,BorderLayout.CENTER);
       this.add(b1,BorderLayout.PAGE_END);
       this.setLocationRelativeTo(null);
       this.pack();
       this.setVisible(true);
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Combo1")){
      item = ((JComboBox)e.getSource()).getSelectedItem().toString();
      t1.setText(objP.ConsultaAcervo(item));
        }
        else{
            this.setVisible(false);
            System.out.println("Menu");
        } 
    }
    
}
