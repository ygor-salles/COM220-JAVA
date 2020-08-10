/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class FrameAddPaciente extends JFrame implements ActionListener {

    private controlePaciente controle;
    private JTextField bNome;
    private JTextField bEndereco;
    private JTextField bNome2;
    private JTextField bEndereco2;
    private JTextField bCpf;
    private JTextField bConvenio;
    private JTextField bNroCartao;
    private JComboBox cb;
    private JButton btn;
    private JButton btn1;
    private JPanel cards;

//    public void addParticular(String pNome, String pEndereco, String pCpf) {
    //  public void addConvenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
    public FrameAddPaciente(controlePaciente pControle) {
        controle = pControle;

        // COMBOX DE SELECAO
        JPanel panel = new JPanel();
        cb = new JComboBox();
        cb.addItem("PACIENTE CONVENIO");
        cb.addItem("PACIENTE PARTICULAR");
        cb.addActionListener(this);
        panel.add(cb);

        //// PACIENTE CONVENIO
        JPanel p1 = new JPanel();

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        JPanel p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p9 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        bNome = new JTextField(30);
        p6.add(new JLabel("Nome: "));
        p6.add(bNome);
        bEndereco = new JTextField(30);
        bEndereco.setAlignmentY(0.5f);
        p7.add(new JLabel("Endereco: "));
        p7.add(bEndereco);
        bConvenio = new JTextField(30);
        p8.add(new JLabel("Convenio: "));
        p8.add(bConvenio);
        bNroCartao = new JTextField(10);
        p9.add(new JLabel("Num. Cartão: "));
        p9.add(bNroCartao);
        btn = new JButton("    Cadastrar    ");
        btn.addActionListener(this);

        p1.add(Box.createVerticalGlue());
        p1.add(p6);
        p1.add(p7);
        p1.add(p8);
        p1.add((p9));
        p1.add(btn);

        /// PACIENTE PARTICULAR
        JPanel p2 = new JPanel();

        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        JPanel p12 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p14 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel p16 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        bNome2 = new JTextField(30);
        p12.add(new JLabel("Nome: "));
        p12.add(bNome2);
        bEndereco2 = new JTextField(30);
        bEndereco2.setAlignmentY(0.5f);
        p14.add(new JLabel("Endereco: "));
        p14.add(bEndereco2);
        bCpf = new JTextField(30);
        p16.add(new JLabel("CPF: "));
        p16.add(bCpf);
        btn1 = new JButton("    Cadastrar    ");
        btn1.addActionListener(this);

        p2.add(Box.createVerticalGlue());
        p2.add(p12);
        p2.add(p14);
        p2.add(p16);
        p2.add(btn1);

        // PAINEIS DE EXIBICAO
        cards = new JPanel();
        cards.setLayout(new CardLayout());
        cards.add("PACIENTE CONVENIO", p1);
        cards.add("PACIENTE PARTICULAR", p2);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);

        setSize(600, 300);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cb) {
            // Obtém o nome selecionado e mostra o cartão
            String option = (String) cb.getSelectedItem();
            CardLayout layout = (CardLayout) cards.getLayout();
            layout.show(cards, option);

            //{
        } else if (ae.getSource() == btn1) {System.out.println("1");
            if (bNome2.getText().isEmpty() || bEndereco2.getText().isEmpty() || bCpf.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Há campos em branco.");
            } else {

                controle.addParticular(bNome.getText(), bEndereco.getText(), bCpf.getText());
                JOptionPane.showMessageDialog(this, "Paciente cadastrado!");
                super.dispose();
            }
        } else if (ae.getSource() == btn) {System.out.println("0");
            if(bNome.getText().isEmpty() || bEndereco.getText().isEmpty() || bConvenio.getText().isEmpty() || bNroCartao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Há campos em branco.");
            } else {

                controle.addConvenio(bNome.getText(), bEndereco.getText(), bConvenio.getText(), bNroCartao.getText());
                JOptionPane.showMessageDialog(this, "Paciente cadastrado!");
                super.dispose();
            }
        }
    }
}
