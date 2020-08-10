package view;

import controller.ControlePrincipal;
import controller.ctrTurma;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Notas;
import model.Turma;

public class LimiteExibeNota extends JFrame{
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
    private ArrayList<Notas> listaNotas = new ArrayList<>(); 
    private ArrayList<String> stringTable = new ArrayList<>();
    private JTable tabela;
    private Notas n;
    private float num;
//    JScrollPane barraRolagem;
        
//    Object [][] dados = {
//        {"Ana Monteiro", "48 9923-7898"},
//        {"João da Silva", "48 8890-3345"},
//        {"Pedro Cascaes", "48 9870-5634"}
//    };
//    Object [][] dados = {
//        {"Ana Monteiro", "48 9923-7898"},
//        {"João da Silva", "48 8890-3345"},
//        {"Pedro Cascaes", "48 9870-5634"}
//    };
//    
//     
//    String [] colunas = {"Aluno", "Nota"}; 

    public LimiteExibeNota(ControlePrincipal pControle, Turma turma, String pNota) {
        objControlador = pControle;
        objCtrTurma = objControlador.getCtrTurma();

        //Criar os objetos do tipo JLabel
        turmaJL = new JLabel("Turma: " + turma.getCodigo());
        notaJL = new JLabel(pNota);

        //Criar JButton e adicionar Listener a ele
        cadastrar = new JButton("Salvar"); 
        cancelar = new JButton("Cancelar");
        
        cadastrar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
              // Evento
               if(stringTable.size() == 0)
                    JOptionPane.showMessageDialog(null, "Edite alguma nota para salvar");
               else{
//                   String r = "";
//                   for(String s:stringTable)
//                        r += s + "\n";
//                   System.out.println(r);
                    if(objControlador.adicionaNota(stringTable, turma.getListaNotas(), pNota, turma)){
                        JOptionPane.showMessageDialog(null, "Nota lançada com sucesso!");
                        dispose();                    
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Digite um valor numérico por favor");
               }
           }
        });
        
        cancelar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               dispose();
           }
        });
//        area = new JTextArea();

        painelNota = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DefaultTableModel model = new DefaultTableModel(0,0){
            @Override 
            public boolean isCellEditable(int row, int column){
                if(column == 0) return false;
                else return true;
            }
        };
        JTable table = new JTable(model); 

        // Create a couple of columns 
        model.addColumn("Aluno"); 
        model.addColumn("Nota"); 

        // Append a row 
        listaNotas = turma.getListaNotas();
        for(Aluno a: turma.getListaAlunos()){
            if(listaNotas.size() > 0){
                n = listaNotas.get(turma.getListaAlunos().indexOf(a));
                if(pNota.equalsIgnoreCase("N1"))
                    if(n.getN1() == -1)
                        model.addRow(new Object[]{a.getNome(), ""});
                    else
                        model.addRow(new Object[]{a.getNome(), n.getN1()});
                else
                    if(n.getN2() == -1)
                        model.addRow(new Object[]{a.getNome(), ""});
                    else
                        model.addRow(new Object[]{a.getNome(), n.getN2()});
            }
            else
                model.addRow(new Object[]{a.getNome(), ""});
        }
//        tabela = new JTable(dados, colunas);
        JScrollPane areaScrollPane = new JScrollPane(table);
        areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(400, 250));
        
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println(table.getModel().getValueAt(e.getFirstRow(), 0) + "-" + table.getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                try{
                    num = Float.parseFloat(table.getModel().getValueAt(e.getFirstRow(), e.getColumn()).toString());
                    stringTable.add(table.getModel().getValueAt(e.getFirstRow(), 0) + "-" + table.getModel().getValueAt(e.getFirstRow(), e.getColumn()));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Digite um valor numérico por favor");
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
        p1.add(turmaJL);
//        p1.add(box);
        p2.add(notaJL);
//        p2.add(n1);
//        p2.add(n2);
        p3.add(areaScrollPane);
        p4.add(cadastrar);     
        p4.add(cancelar);

        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(Box.createVerticalGlue());

        super.setTitle("Lançar Notas");
        super.add(painel);
        super.setSize(600, 400);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setVisible(true);
    }
    
}

