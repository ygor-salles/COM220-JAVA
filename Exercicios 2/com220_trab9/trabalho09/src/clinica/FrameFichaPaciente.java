/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class FrameFichaPaciente extends JFrame implements ActionListener {

    private controlePaciente controle;
    private JPanel centro, painel, p1;
    private JLabel identificadorJL;
    private JTextField identificadorTF;
    private JTextArea exibicao;
    private JButton buscar;

    public FrameFichaPaciente(controlePaciente pControle) {
        super("ficha de paciente");
        controle = pControle;

        //Criar os objetos do tipo JLabel
        identificadorJL = new JLabel("Cartão Convenio ou CPF:");

        //Criar os objetos do tipo TextField
        identificadorTF = new JTextField(15);
        identificadorTF.addActionListener(this);

        //Criar os os objetos do tipo JButton
        buscar = new JButton("Buscar Paciente");
        buscar.addActionListener(this);

        //Criar os objetos do tipo JTextArea
        exibicao = new JTextArea(15, 25);
        exibicao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Resultado da Pesquisa :"));
        exibicao.setEditable(false);

        //Criar os objetos do tipo JPanel
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painel = new JPanel(new BorderLayout(0, 10));
        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        //Adicionar componentes aos paineis
        p1.add(identificadorJL);
        p1.add(identificadorTF);
        p1.add(buscar);
        centro.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centro.add(exibicao);
        painel.add(p1, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);

        add(painel);
        setSize(700, 400);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buscar || ae.getSource() == identificadorTF) {
            String pDado;

            pDado = identificadorTF.getText();
            if (pDado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Você não informou nenhum\nidentificador de paciente!");

            } else if (!controle.validaRegistro(pDado)) {
                exibicao.setText("Não foi encontrado nenhum paciente com esse identificador");
            } else {System.out.println("ficha");
                exibicao.setText(controle.geraFichaPaciente(pDado));
                System.out.println("Gerando ficha");
            }
        }
    }
}
