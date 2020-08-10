
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean
 */
public class JaneladeConfirmacao extends JFrame implements WindowListener {

    public JaneladeConfirmacao(String titulo) {
        super(titulo);
        JPanel p = new JPanel();
        p.add(new JLabel("Jogo de Par ou Impar"));
        this.add(p);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.setVisible(true);
    }


    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Abrindo");
    }


    public void windowClosing(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Fechando");
        int op = JOptionPane.showConfirmDialog(null, "Deseja fechar?");
        
        if(op == 0){
                System.exit(0);
        }
    }


    public void windowClosed(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Fechada");
    }


    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Minimizada");
    }


    public void windowDeiconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Maximizada");
    }


    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Ativada");
    }


    public void windowDeactivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Janela Desativada");
    }
    
    public static void main(String args[]){
        
        JaneladeConfirmacao jt = new JaneladeConfirmacao("Titulo da minha janela");
    }
    
}
