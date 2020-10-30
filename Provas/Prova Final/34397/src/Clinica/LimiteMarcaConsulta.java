
package Clinica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class LimiteMarcaConsulta extends JFrame implements ActionListener{
    
    JButton confirma;
    JTextField txtCodP, txtCodM;
    ControleConsulta ctrConsulta;
    
    public LimiteMarcaConsulta(ControleConsulta pctrConsulta){
        super("Marca Consulta");
        ctrConsulta = pctrConsulta;
        txtCodP = new JTextField(5);
        txtCodM = new JTextField(5);
        confirma = new JButton("Iniciar");
        JPanel p1 = new JPanel();
        p1.add(new JLabel("Cod Paciente: "));
        p1.add(txtCodP);
        p1.add(new JLabel("Cod Medico: "));
        p1.add(txtCodM);
        p1.add(confirma);
        add(p1);
        confirma.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int codPaciente = Integer.parseInt(txtCodP.getText());
        int codMedico = Integer.parseInt(txtCodM.getText());
        for(Medico m: ctrConsulta.getMedicos().getListaMedico()){
            System.out.println(m.getCodigo());
            if(m.getCodigo()==codMedico){
                for(Paciente p: ctrConsulta.getPacientes().getListaPaciente()){
                    if(p.getCod()==codPaciente){
                        new LimiteAgendaConsulta(ctrConsulta,p,m);
                        return;
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Medico ou Paciente não encontrado!");
        txtCodP.setText("");
        txtCodM.setText("");
    }
    
    
    
}
