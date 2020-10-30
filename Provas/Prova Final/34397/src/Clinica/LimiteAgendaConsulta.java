
package Clinica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LimiteAgendaConsulta extends JFrame implements ActionListener {
    
    JTextField txtdia, txtmes, txtano, txthora;
    JButton Confirmar;
    ControleConsulta ctrConsulta;
    Paciente pac;
    Medico med;
    
    public LimiteAgendaConsulta(ControleConsulta pctrConsulta,Paciente pPac, Medico pMed){
        super("Agenda Consulta");
        this.ctrConsulta = pctrConsulta;
        this.pac = pPac;
        this.med = pMed;
        txtdia = new JTextField(2);
        txtmes = new JTextField(2);
        txtano = new JTextField(2);
        txthora = new JTextField(2);
        Confirmar = new JButton("Confirmar");
        JPanel geral = new JPanel();
        geral.setLayout(new GridLayout(3,1));
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Paciente: "));
        p1.add(new JLabel(pPac.getNome()));
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Medico: "));
        p2.add(new JLabel(pMed.getNome()));
        JPanel painel = new JPanel();
        painel.add(new JLabel("Data: "));
        painel.add(txtdia);
        painel.add(txtmes);
        painel.add(txtano);
        painel.add(new JLabel("Hora: "));
        painel.add(txthora);
        painel.add(Confirmar);
        Confirmar.addActionListener(this);
        geral.add(p1);
        geral.add(p2);
        geral.add(painel);
        add(geral);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dia = Integer.parseInt(txtdia.getText());
        int mes = Integer.parseInt(txtmes.getText());
        int ano = Integer.parseInt(txtano.getText());
        int hora = Integer.parseInt(txthora.getText());
        if((hora==8)||(hora==9)||(hora==10)||(hora==11)||(hora==13)||(hora==14)||(hora==15)||(hora==16)||(hora==17)){
        ctrConsulta.marcaConsulta(pac.getCod(), med.getCodigo(), dia , mes, ano, hora);
        JOptionPane.showMessageDialog(null,"Marcado Com Sucesso!");
        }else{
        JOptionPane.showMessageDialog(null,"Hora Invalida!");
        txthora.setText("");
        }
        
    }
    
}
