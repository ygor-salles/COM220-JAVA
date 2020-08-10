/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControlePrincipal;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class LimiteNovaMat extends JFrame{
    private ControlePrincipal objControlador;
    private JPanel painel,p1,p2,p3,p4,p5,p6,p7;
    private JLabel nomeJL,cpfJL,emailJL,dataNascJL,nomeRespJL,cpfRespJL;
    private JTextField nomeTF,cpfTF,emailTF,nomeRespTF,cpfRespTF;
    private JButton cadastrar;
    private JFormattedTextField dataNascTF;
    private int result, idade;

    public LimiteNovaMat(ControlePrincipal pControle) {
        objControlador = pControle;
        
        //Criar os objetos do tipo JLabel
        nomeJL = new JLabel("Nome:");
        cpfJL = new JLabel("CPF:");
        emailJL = new JLabel("Email:");
        dataNascJL = new JLabel("Data de nascimento:");
        nomeRespJL = new JLabel("Nome do responsável:");
        cpfRespJL = new JLabel("CPF do responsável:");
        
        //Criar os objetos do tipo TextField
        nomeTF = new JTextField(15);
        cpfTF = new JTextField(15);
        emailTF = new JTextField(15);
        dataNascTF = new JFormattedTextField(Mascara("##/##/####"));
        dataNascTF.setColumns(7);
        nomeRespTF = new JTextField(15);
        cpfRespTF = new JTextField(15);
        
        dataNascTF.addFocusListener(new FocusListener(){
            public void focusLost(FocusEvent e) {
                try {
                    Integer.parseInt(dataNascTF.getText().split("/")[0]);
                    Integer.parseInt(dataNascTF.getText().split("/")[1]);
                    Integer.parseInt(dataNascTF.getText().split("/")[2]);
                    
                    idade = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(dataNascTF.getText().split("/")[2]);
                    
                    if(idade < 18){
                        p6.setVisible(true); 
                        p7.setVisible(true);                    
                    }                    
                } catch (NumberFormatException nfex) {
                    JOptionPane.showMessageDialog(null, "Insira a data no formato dd/mm/aaaa.");
                    dataNascTF.requestFocus();
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });
        
        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Matricular");
        cadastrar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              // Evento
                if(nomeTF.getText().isEmpty() || cpfTF.getText().isEmpty() || emailTF.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Você deve preencher todos os campos!");
                else
                {
                    try {
                        Integer.parseInt(dataNascTF.getText().split("/")[0]);
                        Integer.parseInt(dataNascTF.getText().split("/")[1]);
                        Integer.parseInt(dataNascTF.getText().split("/")[2]);
                        
                        if(idade < 18){
                            if(nomeRespTF.getText().isEmpty() || cpfRespTF.getText().isEmpty())
                                JOptionPane.showMessageDialog(null, "Os campos Nome e CPF do responsável são obrigatórios!");
                            else
                                addAluno();
                        }
                        else{
                            addAluno();
                        }
                    } catch (NumberFormatException nfex) {
                        JOptionPane.showMessageDialog(null, "Insira a data no formato dd/mm/aaaa.");
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
        
        //Adicionar componentes aos paineis
        p1.add(nomeJL);
        p1.add(nomeTF);
        p2.add(cpfJL);
        p2.add(cpfTF);
        p4.add(emailJL);
        p4.add(emailTF);
        p3.add(dataNascJL);
        p3.add(dataNascTF);
        p6.add(nomeRespJL);
        p6.add(nomeRespTF);
        p7.add(cpfRespJL);
        p7.add(cpfRespTF);
        p6.setVisible(false);
        p7.setVisible(false);
        p5.add(cadastrar);

        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(p6);
        painel.add(p7);
        painel.add(p5);
        painel.add(Box.createVerticalGlue());
        
        super.setTitle("Nova Matrícula");
        super.add(painel);
        super.setSize(600,400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
    public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
    }
    
    public void addAluno(){
        result = objControlador.adicionaAluno(nomeTF.getText(), cpfTF.getText(), emailTF.getText(), dataNascTF.getText(), nomeRespTF.getText(), cpfRespTF.getText(), idade);
                        
        if(result == 0){
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
            nomeTF.setText("");                      
            cpfTF.setText("");
            emailTF.setText("");
            dataNascTF.setText(""); 
            nomeRespTF.setText("");
            cpfRespTF.setText("");
            p6.setVisible(false);
            p7.setVisible(false);
        }
        else if(result == 1)
            JOptionPane.showMessageDialog(null, "Cpf já existente! Informe outro.");
        else if(result == 2)
            JOptionPane.showMessageDialog(null, "Não há vagas no curso Kids na turma K1.");
        else if(result == 3)
            JOptionPane.showMessageDialog(null, "Não existe turmas K1 para o curso kids.");
        else if(result == 4)
            JOptionPane.showMessageDialog(null, "Não há vagas no curso Regular na turma R1.");
        else
            JOptionPane.showMessageDialog(null, "Não existe turmas R1 para o curso regular.");
    }
}

