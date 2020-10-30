/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Limite;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author cascao
 */

public class LimitePrincipal extends JFrame {
    
    private JTabbedPane tabbed;
    private LimiteAluguel limiteLoc;
    private LimiteDevolucao limiteDev;
    private LimiteConsulta limiteCons;
    private JPanel panelLoc, panelDev, panelCons;
    
    public LimitePrincipal(){
        super("Locadora");
        iniciaComponente();
    
    }
    
    public void iniciaComponente(){
        
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        limiteCons = new LimiteConsulta();
        limiteLoc = new LimiteAluguel();
        limiteDev = new LimiteDevolucao();
        
        panelLoc = new JPanel();
        panelLoc = limiteLoc.getPanelLoc();
        panelDev = new JPanel();
        panelDev = limiteDev.getPanelDev();
        panelCons = new JPanel();
        panelCons = limiteCons.getPanelCons();
        
        tabbed = new JTabbedPane();
        tabbed.addTab("Locação",  panelLoc);
        tabbed.addTab("Devolução", panelDev);
        tabbed.addTab("Consulta", panelCons);
        
        this.add(tabbed);
    }
    public static void main(String[] args){
        LimitePrincipal janela = new LimitePrincipal();
        janela.setVisible(true);
    
    }
    
}
