/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControlePrincipal;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Luan
 */
public class LimitePrincipal extends JFrame implements ActionListener{
    private JButton bInsere,bDevolucao,bOK;
    private  JTextField codFilme;
    private  JTextField codCliente;
    private  JTextField codDevolucao;
    private  JComboBox c1;
    private  JTextArea filmes;
    private  JTextField dataFat;
    private  JTextArea faturamento;
    private  JLabel valor;
    private ControlePrincipal objP;
    
    public LimitePrincipal(){
        objP=new ControlePrincipal(); 
        JPanel pLocacao = new JPanel();
        pLocacao.setSize(10, 30);
        pLocacao.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
        pLocacao.add(new JLabel("Código do Filme: "));
        pLocacao.add(codFilme = new JTextField(5));
        pLocacao.add(new JLabel("Código do Cliente: "));
        pLocacao.add(codCliente = new JTextField(5));
        
        pLocacao.add(bInsere = new JButton("Insere"));
        bInsere.addActionListener(this);
        bInsere.setActionCommand("Insere");

        JPanel pDevolucao = new JPanel();
        pDevolucao.setSize(10, 30);
        pDevolucao.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        pDevolucao.add(new JLabel("Código do Filme: "));
       pDevolucao.add(codDevolucao = new JTextField(5));
        pDevolucao.add(bDevolucao = new JButton("Consulta"));
        pDevolucao.add(new JLabel("Valor a Pagar"));
        pDevolucao.add(valor=new JLabel("R$ 0"));
       bDevolucao.addActionListener(this);
       bDevolucao.setActionCommand("Devolucao");


        JPanel pCons2 = new JPanel();
        pCons2.setSize(10, 30);
        pCons2.setSize(10, 30);
        pCons2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        c1=new JComboBox();
        montaCombo();
        pCons2.add(c1);
        pCons2.add(filmes = new JTextArea(12, 40));
        
        JPanel pFat = new JPanel();
        pFat.setSize(10, 30);
       pFat.setSize(10, 30);
        pFat.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
        pFat.add(new JLabel("Data: "));
        pFat.add(dataFat=new JTextField(8));
        dataFat.setText("MM/DD/AAAA");
                
        bOK=new JButton("OK");
        bOK.addActionListener(this);
        bOK.setActionCommand("OK");
        pFat.add(bOK);
        pFat.add(faturamento = new JTextArea(10,10));
        faturamento.setText("R$ 0.0");
        
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        tab.addTab("Locação", pLocacao);
        tab.addTab("Devolução", pDevolucao);
        tab.addTab("Consulta Genero", pCons2);
        tab.addTab("Faturamento",pFat);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setSize(500, 400);
        setLocation(400, 250);
        setResizable(false);
        setDefaultLookAndFeelDecorated(true);
        getContentPane().add(tab, BorderLayout.CENTER);
        setVisible(true);
    }
    public void montaCombo(){
       
        try{
            Vector v1= objP.montaForm();
        for(int i=0;i<v1.size();i++){
            c1.addItem(v1.elementAt(i).toString());
        }
        c1.addActionListener(this);
        c1.setActionCommand("ComboBox");
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    public void locaDvd(){
        try{
            objP.setCodCliente(Integer.parseInt(codCliente.getText()));
            objP.setCodDvd(Integer.parseInt(codFilme.getText()));
            objP.locaDvd();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    public void entregaDvd(){
        try{
            objP.setCodDvd(Integer.parseInt(codDevolucao.getText()));
            String valor=objP.entregaDvd();
            this.valor.setText(valor);
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    public void calculaFaturamento(){
        try{
            java.util.Date utilDate = new java.util.Date(dataFat.getText());        
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                String ret=objP.calcFat(sqlDate);
                faturamento.setText(ret);
                System.out.println("data "+sqlDate.toString());
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(c1.getActionCommand())){
            System.out.println(((JComboBox)e.getSource()).getSelectedItem().toString());
            filmes.setText(objP.buscaFilme(((JComboBox)e.getSource()).getSelectedItem().toString()));
        }else if(e.getActionCommand().equalsIgnoreCase(bInsere.getActionCommand())){
            locaDvd();
        }else if(e.getActionCommand().equals(bDevolucao.getActionCommand())){
            entregaDvd();
        }else if(e.getActionCommand().equals(bOK.getActionCommand())){
        System.out.println("OK");
            calculaFaturamento();
    }
    }
}
