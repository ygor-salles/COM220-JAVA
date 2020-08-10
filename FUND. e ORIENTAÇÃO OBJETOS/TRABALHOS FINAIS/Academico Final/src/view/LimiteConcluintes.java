package view;

import controller.ControlePrincipal;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LimiteConcluintes extends JFrame{
    private ControlePrincipal objControlador;
    private JLabel tipoCurso;
    private JPanel painel, p3, painelLabel;
    private ArrayList<String> stringTable = new ArrayList<>();
    private int linha, coluna;
    private DefaultTableModel model;   
    private DefaultTableModel modelRegular;

    public LimiteConcluintes(ControlePrincipal pControle) {
        objControlador = pControle;
        
        tipoCurso = new JLabel("Kids                                                                                              Regular");
//        tipoCurso.setBounds(10,10,100,100);
        
        model = new DefaultTableModel();
        JTable table = new JTable(model); 

        // Create a couple of columns 
        model.addColumn("Aluno");      
        model.addColumn("CPF"); 

        JScrollPane areaScrollPane = new JScrollPane(table);
        areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(400, 250));
        
        modelRegular = new DefaultTableModel();
        JTable tableRegular = new JTable(modelRegular); 

        // Create a couple of columns 
        modelRegular.addColumn("Aluno");      
        modelRegular.addColumn("CPF"); 

        JScrollPane areaScrollPaneRegular = new JScrollPane(tableRegular);
        areaScrollPaneRegular.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPaneRegular.setPreferredSize(new Dimension(400, 250));
        
        //Criar os paineis
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); 
        painelLabel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        //Adicionar componentes aos paineis
        painelLabel.add(tipoCurso);
        p3.add(areaScrollPane); 
        p3.add(areaScrollPaneRegular);
        painel.add(Box.createVerticalGlue());
        painel.add(painelLabel);
        painel.add(p3);
        painel.add(Box.createVerticalGlue());
        
        preencheTabela();  
        preencheTabelaRegular();

        super.setTitle("Relatório de concluintes");
        super.add(painel);
        super.setSize(1000, 400);
//        super.setLocationRelativeTo(null);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
    public void preencheTabela(){
        stringTable = objControlador.relatorioConcluintes();
        linha = 0;
        coluna = 0;

//        String r = "";
//        for(String s: stringTable){
//            r += s + " - ";
//        }
//        System.out.println(r);

        for(int i = 0; i < stringTable.size()/2; i++)
            model.addRow(new Object[]{"", ""});

        for(String s: stringTable){
            model.setValueAt(s, linha, coluna);
            coluna++;
            if(coluna == 2){
                linha++;
                coluna = 0;
            }
        }
    }
    
    public void preencheTabelaRegular(){
        stringTable = objControlador.relatorioConcluintesRegular();
        linha = 0;
        coluna = 0;

//        String r = "";
//        for(String s: stringTable){
//            r += s + " - ";
//        }
//        System.out.println(r);

        for(int i = 0; i < stringTable.size()/2; i++)
            model.addRow(new Object[]{"", ""});

        for(String s: stringTable){
            model.setValueAt(s, linha, coluna);
            coluna++;
            if(coluna == 2){
                linha++;
                coluna = 0;
            }
        }
    }
}

