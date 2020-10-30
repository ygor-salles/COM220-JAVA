package view;

import controller.ControlePrincipal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LimiteCadProf extends JFrame{
    private ControlePrincipal objControlador;
    private JPanel painel, p1, p2, p3, p4;
    private JLabel nomeJL, cpfJL, cursosJL;
    private JTextField nomeTF, cpfTF;
    private JButton cadastrar;
    private JComboBox box = new JComboBox();

    public LimiteCadProf(ControlePrincipal pControle) {
        objControlador = pControle;

        //Criar os objetos do tipo JLabel
        nomeJL = new JLabel("Nome:");
        cpfJL = new JLabel("CPF:");
        cursosJL = new JLabel("Cursos:");

        //Criar os objetos do tipo TextField
        nomeTF = new JTextField(15);
        cpfTF = new JTextField(15);


//        box.addItem("--Adicione um Curso--");
        box.addItem("Kids");
        box.addItem("Regular");
        box.addItem("Ambos");

        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Cadastrar");
        cadastrar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              // Evento
               if(nomeTF.getText().isEmpty() || cpfTF.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!");
                else
                {
                    if(objControlador.adicionaProfessor(nomeTF.getText(), cpfTF.getText(), box.getSelectedItem().toString())){
                        JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
                        nomeTF.setText("");                       
                        cpfTF.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "CPF já existente! Informe outro.");
                }
           }
        });

        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Adicionar componentes aos paineis
        p1.add(nomeJL);
        p1.add(nomeTF);
        p2.add(cpfJL);
        p2.add(cpfTF);
        p3.add(cursosJL);
        p3.add(box);
        p4.add(cadastrar);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(Box.createVerticalGlue());

        super.setTitle("Cadastrar Professor");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
}

