/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Jean
 */
public class listas extends JFrame implements ListSelectionListener {

    JList list1;
    JList list2;
    DefaultListModel dlm1, dlm2;

    public listas() {
        super("Transferencia por Janelas");

        JPanel pane = new JPanel();

        dlm1 = new DefaultListModel();
        dlm2 = new DefaultListModel();

        String[] ls1 = {"01","02","03","04","05"};
        String[] ls2 = {"aa","bb","cc","dd","ff"};
        
        for (int i = 0; i < ls1.length; i++) {
            dlm1.addElement(ls1[i]);
        }
        for (int i = 0; i < ls2.length; i++) {
            dlm2.addElement(ls2[i]);
        }
        
        list1 = new JList(dlm1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setFixedCellWidth(50);
        list1.setVisibleRowCount(5);
        list1.addListSelectionListener(this);

        list2 = new JList(dlm2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setFixedCellWidth(50);
        list2.setVisibleRowCount(5);
        list2.addListSelectionListener(this);

        JScrollPane scroll1 = new JScrollPane(list1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JScrollPane scroll2 = new JScrollPane(list2,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //this.add(list1);
        //this.add(list2);
        pane.add(scroll1);
        pane.add(scroll2);
        
        this.getContentPane().add(pane, BorderLayout.CENTER);
        //this.add(pane);
        this.pack();
        //this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == list1) { // LISTA 1 CLICADA 
            if (e.getValueIsAdjusting() == false) {
                int x = list1.getSelectedIndex();
                if (x != -1) {
                    dlm2.addElement(dlm1.getElementAt(x));// INSERE
                    dlm1.remove(x); // REMOVE
                }
            }
        } else if (e.getValueIsAdjusting() == false) {// LISTA 2 CLICADA
            int y = list2.getSelectedIndex();
            if (y != -1) {
                dlm1.addElement(dlm2.getElementAt(y)); // INSERE
                dlm2.remove(y); // REMOVE
            }
        }
    }
    
    
    public static void main(String args[]){
            listas l = new listas();
    }

}
