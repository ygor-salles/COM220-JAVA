package academico;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class limiteAluno extends JFrame implements ActionListener{

    private ctrAluno controle;

    private JPanel p1;
    private JPanel p2;
    private JPanel panel;
    private JPanel cards;
    private JMenuBar mb;
    private JComboBox cb;
    private JTextField nome;
    private JTextField matricula;
    private JTextField dia;
    private JTextField mes;
    private JTextField ano;
    private JButton btn;
    private JTextArea txtArea;
    private JMenu m;
    private JMenuItem sr;

    public limiteAluno(ctrAluno pControle) {
        super("TRABALHO 10");
        controle = pControle;

        // COMBOX DE SELECAO
        panel = new JPanel();
        cb = new JComboBox();
        cb.addItem("INSERIR NOVO ALUNO");
        cb.addItem("LISTAR ALUNOS CADASTRADOS");
        cb.addActionListener(this);
        panel.add(cb);
        
        // MENU
        
        mb = new JMenuBar();
        setJMenuBar(mb);
        // Constrói um menu e o adiciona a barra
        m = new JMenu("Arquivo", true);
        m.setMnemonic(KeyEvent.VK_A);
        mb.add(m);
        // Cria um submenu e o adiciona
        sr = new JMenuItem("Sair");
        sr.setMnemonic(KeyEvent.VK_S);
        sr.addActionListener(this);
        m.add(sr);

        // ELEMENTOS DA P1
        p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setAlignmentY(0.5f);

        nome = new JTextField(15);
        matricula = new JTextField(13);
        dia = new JTextField(2);
        mes = new JTextField(2);
        ano = new JTextField(4);
        btn = new JButton("    OK    ");
        btn.addActionListener(this);

        JPanel lb1 = new JPanel();
        JPanel lb2 = new JPanel();
        JPanel lb3 = new JPanel();

        lb1.add(new Label("Nome:"));
        lb1.add(nome);
        
        lb2.add(new Label("Matricula:"));
        lb2.add(matricula);
        
        lb3.add(new Label("Data de Nasc:"));
        lb3.add(dia);
        lb3.add(new Label("/"));
        lb3.add(mes);
        lb3.add(new Label("/"));
        lb3.add(ano);
        
        p1.add(Box.createVerticalGlue());
        p1.add(Box.createVerticalGlue());
        p1.add(lb1); 
        p1.add(lb2);
        p1.add(lb3);
        p1.add(btn);
        p1.add(Box.createVerticalGlue());
        p1.add(Box.createVerticalGlue());
        
        // ELEMENTOS DA P2
        p2 = new JPanel();
        txtArea = new JTextArea();
        txtArea = new JTextArea(12,35);
        txtArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Alunos cadastrados :"));
        txtArea.setEditable(false);
        p2.add(txtArea);
        
        cards = new JPanel();
        cards.setLayout(new CardLayout());
        cards.add("INSERIR NOVO ALUNO", p1);
        cards.add("LISTAR ALUNOS CADASTRADOS", p2);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.PAGE_START);
        add(cards, BorderLayout.CENTER);
        
        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cb) {
            // Obtém o nome selecionado e mostra o cartão
            String option = (String) cb.getSelectedItem();
            CardLayout layout = (CardLayout) cards.getLayout();
            layout.show(cards, option);
            
            if(cb.getSelectedIndex() == 1){
                String msg = controle.getDadosAlunos();
                
                if(msg.isEmpty()) {
                        txtArea.setText("Não há alunos cadastrados!");
                    }
                    else{
                        txtArea.setText(msg);
                    }
            }
        }else if(ae.getSource() == btn){
            String pnome,pdia,pmes,pmatricula,pano;
            int pDia,pMes,pAno;

            pnome = nome.getText();
            pdia = dia.getText();
            pmes = mes.getText();
            pano = ano.getText();

            if(pnome.isEmpty() || pdia.isEmpty() || pmes.isEmpty() || pano.isEmpty()){
                JOptionPane.showMessageDialog(this, "todos os Campos devem ser preenchidos!");
                
            }else{
                pmatricula = matricula.getText();
                pDia = Integer.parseInt(pdia);
                pMes = Integer.parseInt(pmes);
                pAno = Integer.parseInt(pano);

                try{
                    controle.addAluno(pnome, pmatricula, pDia, pMes, pAno);
                    nome.setText("");
                    mes.setText("");
                    matricula.setText("");
                    dia.setText("");
                    ano.setText("");
                    JOptionPane.showMessageDialog(this, "Aluno cadastrado!");
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(this, "Erro: "+exc.getMessage());
                }
             }
        }else if(ae.getSource() == sr){
            int op = JOptionPane.showConfirmDialog(this, "Deseja fechar aplicação?");
                System.out.println("Entrou");
                if(op == JOptionPane.YES_OPTION){
                    try{
                        controle.saveDados();
                        System.exit(0);
                    }catch(Exception exc){
                        System.out.println("Falha ao salvar os dados");
                    }
                }
        }
    }
}
