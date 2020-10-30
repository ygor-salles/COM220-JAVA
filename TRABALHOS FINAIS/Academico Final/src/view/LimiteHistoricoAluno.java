package view;

import controller.ControlePrincipal;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LimiteHistoricoAluno extends JFrame{
    private ControlePrincipal objControlador;
    private JPanel painel, p1, p3;
    private JLabel turmaJL;
    private JTextField codTurma;
    private ArrayList<String> stringTable = new ArrayList<>();
    private int linha, coluna;
    private DefaultTableModel model;

    public LimiteHistoricoAluno(ControlePrincipal pControle) {
        objControlador = pControle;

        turmaJL = new JLabel("CPF do aluno:");   
        codTurma = new JTextField(15);
        
        codTurma.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if(codTurma.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Informe o CPF do aluno");
               else{
                   preencheTabela();
               }
           }
        });
        
        model = new DefaultTableModel();
        JTable table = new JTable(model); 

        // Create a couple of columns 
        model.addColumn("Ano/Semestre"); 
        model.addColumn("Curso");      
        model.addColumn("Nota"); 

        JScrollPane areaScrollPane = new JScrollPane(table);
        areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(400, 250));
        
        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Adicionar componentes aos paineis
        p1.add(turmaJL);
        p1.add(codTurma);
        p3.add(areaScrollPane);
        p3.setVisible(false);

        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p3);
        painel.add(Box.createVerticalGlue());

        super.setTitle("Emitir Histórico do aluno");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
    public void preencheTabela(){
//       System.out.println("Entrou");
       stringTable = objControlador.historicoAluno(codTurma.getText());
       if(stringTable.size() == 0){
           JOptionPane.showMessageDialog(null, "CPF inválido!Tente novamente");
           p3.setVisible(false);
       }
       else{
            linha = 0;
            coluna = 0;
            
            p3.setVisible(true);
            model.setNumRows(0);

            for(int i = 0; i < (stringTable.size()/3); i++)
                model.addRow(new Object[]{"", "",""});
           
            for(String s: stringTable){
                model.setValueAt(s, linha, coluna);
                coluna++;
                if(coluna == 3){
                    linha++;
                    coluna = 0;
                }
            }
       }
    }
}

