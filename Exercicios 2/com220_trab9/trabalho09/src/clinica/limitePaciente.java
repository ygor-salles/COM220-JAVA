package clinica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class limitePaciente extends JFrame implements ActionListener {

    private controlePaciente controle;
    private JButton btnAddPaciente;
    private JButton btnAddSessao;
    private JButton btnImpFichaPaciente;
    private JButton btnCalculoFat;
      
    public limitePaciente(controlePaciente pControle) {
        super("TRABALHO 9");
        controle = pControle;        
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
           
        btnAddPaciente = new JButton("Adicionar Paciente");
        btnAddPaciente.addActionListener(this);
        btnAddSessao = new JButton("Adicionar Sessao");
        btnAddSessao.addActionListener(this);
        btnImpFichaPaciente = new JButton("Imprimir Ficha");
        btnImpFichaPaciente.addActionListener(this);
        btnCalculoFat = new JButton("Calculo Faturamento");
        btnCalculoFat.addActionListener(this);
        p1.add(btnAddPaciente);
        p1.add(btnAddSessao);
        p1.add(btnImpFichaPaciente);
        p1.add(btnCalculoFat);

        add(p1);
        setSize(500, 150);
        setVisible(true);
        setLocationRelativeTo(null);        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        
        if(item == btnAddPaciente){
            System.out.println("AddPaciente");
            controle.openWindow(1);
        }else if(item == btnAddSessao){
            System.out.println("AddSessao");
            controle.openWindow(2);
        }else if(item == btnImpFichaPaciente){
            System.out.println("Ficha paciente");
            controle.openWindow(3);
        }else if(item == btnCalculoFat){
            System.out.println("Faturamento");
            controle.openWindow(4);
        }
    }
}
