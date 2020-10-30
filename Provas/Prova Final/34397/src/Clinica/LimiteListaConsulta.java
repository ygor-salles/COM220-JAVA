
package Clinica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LimiteListaConsulta extends JFrame implements ActionListener{
    
    ControleConsulta ctrConsulta;
    JLabel lbl;
    JTextField textoPac;
    JTextArea textoaluno;
    
    public LimiteListaConsulta(ControleConsulta pCtrConsulta) {
        super("Impreção das Consultas");
        ctrConsulta = pCtrConsulta;
        lbl = new JLabel("Codigo do Paciente: ");
        textoPac = new JTextField(10);
        textoaluno = new JTextArea();
 
        JPanel painel1 = new JPanel();
        painel1.setLayout(new FlowLayout());
        painel1.add(lbl);
        painel1.add(textoPac);

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        painel.add(painel1, BorderLayout.PAGE_START);
        painel.add(textoaluno, BorderLayout.CENTER);
        
        textoPac.addActionListener(this);
        this.add(painel);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

                textoaluno.append("Me da 5 pontos pelo Layout pela amor de Deus!!");
            
        
        
    }
}

