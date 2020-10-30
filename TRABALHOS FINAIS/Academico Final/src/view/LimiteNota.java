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

public class LimiteNota extends JFrame{
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

    public LimiteNota(ControlePrincipal pControle) {
        objControlador = pControle;
        objCtrTurma = objControlador.getCtrTurma();

        //Criar os objetos do tipo JLabel
        turmaJL = new JLabel("Turma:");
        notaJL = new JLabel("Nota:");
        labelAluno = new JLabel("Aluno:");
        labelNota = new JLabel("Nota:");

//        box.addItem("--Adicione um Curso--");
        preencheComboTurma();
        
        n1 = new JRadioButton("N1", false);
        n2 = new JRadioButton("N2", false);
        bg = new ButtonGroup();
        bg.add(n1);
        bg.add(n2);
        
        n1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              if (n1.isSelected()) {
                  n2.setSelected(false);
                  nota = "N1";
                  if(box.getSelectedItem().toString().equalsIgnoreCase("Selecione uma turma") || box.getSelectedItem().toString().equalsIgnoreCase("Não há turmas cadastradas") || !n1.isSelected() && !n2.isSelected())
                    JOptionPane.showMessageDialog(null, "Selecione uma turma");
                  else
                    preencheArea(pControle);
              }
              else
                  nota = "N2";
                System.out.println(nota);
           }
        });
        
        n2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              if (n2.isSelected()) {
                  n1.setSelected(false);
                  nota = "N2";
                  if(box.getSelectedItem().toString().equalsIgnoreCase("Selecione uma turma") || box.getSelectedItem().toString().equalsIgnoreCase("Não há turmas cadastradas") || !n1.isSelected() && !n2.isSelected())
                    JOptionPane.showMessageDialog(null, "Selecione uma turma");
                  else
                    preencheArea(pControle);
              }
              else
                  nota = "N1";
              System.out.println(nota);
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
        p1.add(box);
        p2.add(notaJL);
        p2.add(n1);
        p2.add(n2);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
//        painel.add(p3);
//        painel.add(p4);
        painel.add(Box.createVerticalGlue());

        super.setTitle("Lançar Notas");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
    public void preencheComboTurma(){
        listaTurmas = objCtrTurma.getListaTurma();
        
        if(listaTurmas.size() > 0){
            box.addItem("Selecione uma turma");
            
            for (int intIdx = 0; intIdx < listaTurmas.size();intIdx++) {
                Turma objViewDis = (Turma)listaTurmas.elementAt(intIdx);
                box.addItem(objViewDis.getCodigo());
            }
        }
        else
            box.addItem("Não há turmas cadastradas");
    }
    
    public void preencheArea(ControlePrincipal ctr){
        for (int intIdx = 0; intIdx < listaTurmas.size();intIdx++) {
            Turma objViewDis = (Turma)listaTurmas.elementAt(intIdx);
            if(objViewDis.getCodigo().equalsIgnoreCase(box.getSelectedItem().toString())){
                new LimiteExibeNota(ctr, objViewDis, nota);
            }
        }
    }
}

