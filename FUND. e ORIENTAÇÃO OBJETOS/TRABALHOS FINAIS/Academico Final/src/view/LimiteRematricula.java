package view;

import controller.ControlePrincipal;
import controller.ctrTurma;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import model.Aluno;
import model.Turma;

public class LimiteRematricula extends JFrame{
    private ControlePrincipal objControlador;
    private ctrTurma objCtrTurma;
    private JPanel painel, p1, p2, p3, p4, painelNota;
    private JLabel labelAluno, labelNota, cursosJL, turmaJL, notaJL;
    private JTextField nomeTF, cpfTF;
    private JButton cadastrar, cancelar;
    private JComboBox box= new JComboBox();
    private JRadioButton n1, n2;
    private ButtonGroup bg;
    private JTextArea area;
    private Vector listaTurmas = new Vector();
    private String nota, listaAlunos;
    private ArrayList<JTextField> tf = new ArrayList<>();
//
    public LimiteRematricula(ControlePrincipal pControle) {
        objControlador = pControle;
        objCtrTurma = objControlador.getCtrTurma();

        //Criar os objetos do tipo JLabel
        turmaJL = new JLabel("Nome do aluno:");
//        notaJL = new JLabel("Nota:");
//        labelAluno = new JLabel("Aluno:");
//        labelNota = new JLabel("Nota:");
        
        cpfTF = new JTextField(15);
        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Renovar Matrícula"); 
//        cancelar = new JButton("Cancelar");
//        
        cadastrar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              // Evento
               if(cpfTF.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Digite o CPF do aluno");
               else{
                    JOptionPane.showMessageDialog(null, objControlador.rematricula(cpfTF.getText()));
                    dispose();
               }
           }
        });

        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Adicionar componentes aos paineis
        p1.add(turmaJL);
        p1.add(cpfTF);
        p2.add(cadastrar);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
//        painel.add(p3);
//        painel.add(p4);
        painel.add(Box.createVerticalGlue());

        super.setTitle("Rematrícula");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
}

