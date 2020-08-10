package view;

import controller.ControlePrincipal;
import controller.ctrProfessor;
import controller.ctrTurma;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import model.Professor;
import model.Turma;

public class LimiteCadTurma extends JFrame{
    private ControlePrincipal objControlador;
    private ctrProfessor objCtrProfessor;   
    private JPanel painel,p1,p2,p3,p4,p5,p6,p7,p8;
    private JLabel anoJL,capacidadeJL,horarioJL,cursoJL,professorJL,semestreJL;
    private JTextField codigoTF,anoTF,capacidadeTF,horarioTF;
    private JButton cadastrar;
    private JComboBox prof, boxCurso;
    private JRadioButton s1, s2;
    private ButtonGroup bg;
    private String[] arrayCursos = {"K1", "K2", "K3", "K4", "K5", "K6", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8"};
    private String letra;

    public LimiteCadTurma(ControlePrincipal pControle) {
        objControlador = pControle;
        objCtrProfessor = objControlador.getCtrProfessor();
        
        //Criar os objetos do tipo JLabel
        semestreJL = new JLabel("Semestre:\n");
        anoJL = new JLabel("Ano:");
        capacidadeJL = new JLabel("Capacidade:");
        horarioJL = new JLabel("Horário:");
        cursoJL = new JLabel("Cuso/Semestre:");
        professorJL = new JLabel("Professor:");
        
        //Criar os objetos do tipo TextField
        codigoTF = new JTextField(15);
        s1 = new JRadioButton("1º", false);
        s2 = new JRadioButton("2º", false);
        bg = new ButtonGroup();
        bg.add(s1);
        bg.add(s2);
        
        s1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              if (s1.isSelected()) 
                s2.setSelected(false);
           }
        });
        
        s2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              if (s2.isSelected()) 
                s1.setSelected(false);
           }
        });
        
        anoTF = new JTextField(11);
        capacidadeTF = new JTextField(11);
        horarioTF = new JTextField(11);
        boxCurso = new JComboBox();
        
        boxCurso.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                prof.removeAllItems();
                letra = boxCurso.getSelectedItem().toString().substring(0,1);
//                System.out.println("mudou - " + letra);
                if(letra.equalsIgnoreCase("K")){
                    for (int intIdx = 0; intIdx < objCtrProfessor.getListaProfessores().size();intIdx++) {
                        Professor objViewDis = (Professor)objCtrProfessor.getListaProfessores().elementAt(intIdx);
                        if(objViewDis.getCurso().equalsIgnoreCase("Ambos") || objViewDis.getCurso().equalsIgnoreCase("Kids"))
                            prof.addItem(objViewDis.getNome());
                    }
                }
                else{
                    for (int intIdx = 0; intIdx < objCtrProfessor.getListaProfessores().size();intIdx++) {
                        Professor objViewDis = (Professor)objCtrProfessor.getListaProfessores().elementAt(intIdx);
                        if(objViewDis.getCurso().equalsIgnoreCase("Ambos") || objViewDis.getCurso().equalsIgnoreCase("Regular"))
                            prof.addItem(objViewDis.getNome());
                    }
                }
            }
        });
        
        prof = new JComboBox();
        this.preencheComboCurso();
        this.preencheCombo();
        
        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              // Evento
//               System.out.println(semestreSelected());
               if(anoTF.getText().isEmpty() || capacidadeTF.getText().isEmpty() || horarioTF.getText().isEmpty() || semestreSelected().isEmpty())
                    JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!");
                else
                {
                    try{
                    int ano = Integer.parseInt(anoTF.getText());   
                    int capacidade = Integer.parseInt(capacidadeTF.getText());
                    if(objControlador.adicionaTurma(horarioTF.getText() + boxCurso.getSelectedItem().toString(), semestreSelected(), anoTF.getText(), capacidadeTF.getText(), horarioTF.getText(), boxCurso.getSelectedItem().toString(), prof.getSelectedItem().toString())){
                        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
                        codigoTF.setText("");                      
                        anoTF.setText("");
                        capacidadeTF.setText("");
                        horarioTF.setText("");
                        s1.setSelected(false);  
                        s2.setSelected(false);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Código já existente! Informe outro.");
                    }catch(Exception exc){
                        JOptionPane.showMessageDialog(null, "Os campos ano e capacidade devem ser numéricos!");
                    }
                }
           }
        });
        
        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel,BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p7 = new JPanel(new FlowLayout(FlowLayout.CENTER));      
        p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        //Adicionar componentes aos paineis
        p8.add(semestreJL);   
        p8.add(s1);    
        p8.add(s2);
        p2.add(anoJL);
        p2.add(anoTF);
        p4.add(capacidadeJL);
        p4.add(capacidadeTF);
        p3.add(horarioJL);
        p3.add(horarioTF);
        p6.add(cursoJL);
        p6.add(boxCurso);
        p7.add(professorJL);
        p7.add(prof);
        p5.add(cadastrar);
        painel.add(Box.createVerticalGlue());
//        painel.add(p1);  
        painel.add(p8);
        painel.add(p2);
        painel.add(p4);
        painel.add(p3);
        painel.add(p6);
        painel.add(p7);
        painel.add(p5);
        painel.add(Box.createVerticalGlue());
        
        super.setTitle("Cadastrar Turma");
        super.add(painel);
        super.setSize(600,400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }

    public void preencheCombo(){
        prof.removeAllItems();

        if (objCtrProfessor.getListaProfessores().size()==0)
           prof.addItem("Não há professores cadastrados");
        else{
            letra = boxCurso.getSelectedItem().toString().substring(0,1);
//            System.out.println(letra.equalsIgnoreCase("K"));
            if(letra.equalsIgnoreCase("K")){
                for (int intIdx = 0; intIdx < objCtrProfessor.getListaProfessores().size();intIdx++) {
                    Professor objViewDis = (Professor)objCtrProfessor.getListaProfessores().elementAt(intIdx);
                    if(objViewDis.getCurso().equalsIgnoreCase("Ambos") || objViewDis.getCurso().equalsIgnoreCase("Kids")){
//                        System.out.println(objViewDis.getCurso() + " - " + objViewDis.getNome());
                        prof.addItem(objViewDis.getNome());
                    }
                }
            }
            else{
                for (int intIdx = 0; intIdx < objCtrProfessor.getListaProfessores().size();intIdx++) {
                    Professor objViewDis = (Professor)objCtrProfessor.getListaProfessores().elementAt(intIdx);
                    if(objViewDis.getCurso().equalsIgnoreCase("Ambos") || objViewDis.getCurso().equalsIgnoreCase("Regular"))
                        prof.addItem(objViewDis.getNome());
                }
            }
        }
    }
    
    public void preencheComboCurso(){
        for(int i = 0; i < arrayCursos.length; i++)
                boxCurso.addItem(arrayCursos[i]);
    }
    
    public String semestreSelected(){
        if(s1.isSelected())
            return "1";
        else if(s2.isSelected())
            return "2";
        else
            return "";
    }
}

