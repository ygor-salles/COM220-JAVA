/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControlePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Luan
 */
public class Emprestimo extends JFrame implements ActionListener{
    private  ControlePrincipal objP;
    private JLabel lAssociado ,lCodigo,ldataRet, ldataEntrega,Vmulta,multa;
    private JTextField associado,codigo, dataRet, dataEntrega;        
    private JPanel p1;
    private JTextArea t1,t2;
    private SpringLayout l1;
    private JButton validar1,validar2, insere;
    
    public Emprestimo(){
        objP=new ControlePrincipal();
        
         
        lAssociado = new JLabel("Codigo Associado");
        lCodigo = new JLabel("Codigo Livro");        
        ldataRet= new JLabel("Data Retirada");
        ldataEntrega=new JLabel("Data Entrega");
        multa= new JLabel("Multa");
        Vmulta=new JLabel("0");
        associado= new JTextField(12);
        codigo = new JTextField(12);
        dataRet=new JTextField(12);
        dataEntrega=new JTextField(12);
        
        validar1=new JButton("Validar Associado");
        validar1.addActionListener(this);
        validar2=new JButton("Validar Livro");
        validar2.addActionListener(this);
        insere=new JButton("Insere");
        insere.addActionListener(this);
        insere.setEnabled(false);
        
       p1=new JPanel();
        p1.add(lAssociado);
        p1.add(associado);
         p1.add(validar1);
        p1.add(lCodigo);
        p1.add(codigo);
        p1.add(ldataRet);
        p1.add(dataRet);
        p1.add(ldataEntrega);
        p1.add(dataEntrega);
        
         p1.add(validar2);
         p1.add(multa);
         p1.add(Vmulta);
         p1.add(insere);
        
        l1= new SpringLayout();
        l1.putConstraint(SpringLayout.NORTH, lAssociado, 50, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lAssociado, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH,associado, 50, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, associado, 20, SpringLayout.EAST, lAssociado);

        l1.putConstraint(SpringLayout.NORTH, lCodigo,80, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lCodigo, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, codigo, 80, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, codigo, 20, SpringLayout.EAST, lCodigo);
        
        l1.putConstraint(SpringLayout.NORTH,validar1, 50, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, validar1, 20, SpringLayout.EAST, associado);
        l1.putConstraint(SpringLayout.NORTH,validar2, 80, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, validar2, 20, SpringLayout.EAST, codigo);
      
        l1.putConstraint(SpringLayout.NORTH, ldataRet,115, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, ldataRet, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, dataRet, 115, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, dataRet, 20, SpringLayout.EAST, ldataRet);
        
        l1.putConstraint(SpringLayout.NORTH, ldataEntrega,150, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, ldataEntrega, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, dataEntrega, 150, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, dataEntrega, 20, SpringLayout.EAST, ldataEntrega);
        
        l1.putConstraint(SpringLayout.NORTH,multa, 180, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, multa, 150, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH,Vmulta, 180, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, Vmulta, 10, SpringLayout.EAST, multa);
        
        l1.putConstraint(SpringLayout.NORTH,insere, 190, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, insere, 50, SpringLayout.WEST, p1);
        p1.setLayout(l1);
        this.add(p1);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setSize(500,300);
        this.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      ;
        if(((JButton)e.getSource()).getText().equalsIgnoreCase(validar1.getText())){
            objP.setCodAssociado(Integer.parseInt(associado.getText()));
            String ret= objP.ValidaAssociado();
            
       
        }else if(((JButton)e.getSource()).getText().equalsIgnoreCase(validar2.getText())){
           objP.setCodLivro(Integer.parseInt(codigo.getText()));
            String ret= objP.ValidaLivro();
             System.out.println("Insere: "+ret);
             if(objP.isV1()&&objP.isV2()){
                 insere.setEnabled(true);
             }
        }else{
            objP.setDataRetirada(dataRet.getText());
            if(dataEntrega.getText().isEmpty()){
               
                 String r=objP.SalvaEmprestimo();
                 insere.setEnabled(false);
                 objP.setV1(false);
                 objP.setV2(false);
            }
            else{
               
                objP.setDataEntrega(dataEntrega.getText());
               dataEntrega.setText("");
               objP.devolve(Vmulta);
               insere.setEnabled(false);
                 objP.setV1(false);
                 objP.setV2(false);
               
            }
        }
    }

    
}
