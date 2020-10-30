package View;

import Control.CtrlProduto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LimProduto extends JFrame implements ActionListener, Serializable {
    
    private CtrlProduto ctrlProduto;
    private JLabel JLproduto,JLvazio, JLcod, JLdescricao, JLcompra, JLvenda, Quantidade;
    private JTextField JTcod, JTdescricao, JTcompra, JTvenda, JTquantidade;
    private JButton JBcadastrar, JBsair, JBprocurar, JBatualizar;
    public JPanel JPcadastro, JPbotao, JPprincipal, JPfrente;
    private JTextArea area;
    private JScrollPane scroll;
   
    public LimProduto(CtrlProduto controle,  int n) {
        ctrlProduto = controle;
        //Cadastrar Cliente
        if (n==1) {
            cadastrarProduto();
        }
        //Procurar Cliente
        if (n==2) {
           procurarProduto();
        }
        //Atualizar Estoque
        if (n==3)
           atualizarEstoque();
        //Estoque
        if (n==4)
            estoque();
        
    }
    
    public void cadastrarProduto(){
            //JLabels
            JLproduto = new JLabel("CADASTRO DE PRODUTOS");
            JLvazio = new JLabel();
            JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
            JLproduto.setForeground(new Color(35,142,104));
            JLcod = new JLabel("Código: ");
            JLcod.setForeground(new Color(35,142,104));
            JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLdescricao = new JLabel("Descrição: ");
            JLdescricao.setForeground(new Color(35,142,104));
            JLdescricao.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLcompra = new JLabel("Preço de Compra: ");
            JLcompra.setForeground(new Color(35,142,104));
            JLcompra.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLvenda = new JLabel("Preço de Venda: ");
            JLvenda.setForeground(new Color(35,142,104));
            JLvenda.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            Quantidade = new JLabel("Quantidade: ");
            Quantidade.setForeground(new Color(35,142,104));
            Quantidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));

            //JTextFields
            JTcod = new JTextField(20);
            JTdescricao = new JTextField(20);
            JTcompra = new JTextField(20);
            JTvenda = new JTextField(20);
            JTquantidade = new JTextField(20);

            //JButtons
            JBcadastrar = new JButton("Cadastrar Produto");
            JBcadastrar.setBorderPainted(false);
            JBcadastrar.setForeground(Color.white);
            JBcadastrar.setBackground(new Color(35,142,104));
            JBsair = new JButton("Sair");
            JBsair.setBorderPainted(false);
            JBsair.setForeground(Color.white);
            JBsair.setBackground(new Color(35,142,104));
            JBcadastrar.addActionListener(this);
            JBsair.addActionListener(this);

            //Criar JPanel's
            JPcadastro = new JPanel(new GridLayout(8, 2, 10, 20));
            JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPfrente = new JPanel();
            BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
            JPfrente.setLayout(box);

            //Setando Paineis
            JPbotao.add(JBcadastrar);
            JPbotao.add(JBsair);

            JPcadastro.add(JLproduto);
            JPcadastro.add(JLvazio);
            JPcadastro.add(JLcod);
            JPcadastro.add(JTcod);
            JPcadastro.add(JLdescricao);
            JPcadastro.add(JTdescricao);
            JPcadastro.add(JLcompra);
            JPcadastro.add(JTcompra);
            JPcadastro.add(JLvenda);
            JPcadastro.add(JTvenda);
            JPcadastro.add(Quantidade);
            JPcadastro.add(JTquantidade);
            JPcadastro.add(Box.createHorizontalGlue());
            JPcadastro.add(JPbotao);

            JPprincipal.add(JPcadastro);

            JPfrente.add(Box.createGlue());
            JPfrente.add(JPprincipal);
            JPfrente.add(Box.createGlue());

            //Setando o JFrame
            add(JPfrente);
            setSize(800,600);
            setLocationRelativeTo(null);
            setUndecorated(true);
            setAlwaysOnTop(true);
            setVisible(true);
    }

    public void procurarProduto() {
        //JLabels
        JLproduto = new JLabel("CONSULTAR PRODUTOS");
        JLvazio = new JLabel();
        JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLproduto.setForeground(new Color(35,142,104));
        JLcod = new JLabel("Código: ");
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JTextFields
        JTcod = new JTextField(20);

        //JButtons
        JBprocurar = new JButton("Consultar");
        JBprocurar.setBorderPainted(false);
        JBprocurar.setForeground(Color.white);
        JBprocurar.setBackground(new Color(35,142,104));
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBprocurar.addActionListener(this);
        JBsair.addActionListener(this);

        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(3, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box); 

        //Setando Paineis
        JPbotao.add(JBprocurar);
        JPbotao.add(JBsair);
        JPcadastro.add(JLproduto);
        JPcadastro.add(JLvazio);
        JPcadastro.add(JLcod);
        JPcadastro.add(JTcod);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JPbotao);

        JPprincipal.add(JPcadastro);

        JPfrente.add(Box.createGlue());
        JPfrente.add(JPprincipal);
        JPfrente.add(Box.createGlue());

        //Setando o JFrame
        add(JPfrente);
        setSize(800,600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void procurarProduto2(int i) {
        //JLabels
        JLproduto = new JLabel("PRODUTO CONSULTADO");
        JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLproduto.setForeground(new Color(35,142,104));
        JLcod = new JLabel("Código: "+ ctrlProduto.arrayProduto.get(i).getCodigo());
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLdescricao = new JLabel("Descrição: "+ ctrlProduto.arrayProduto.get(i).getDescricao());
        JLdescricao.setForeground(new Color(35,142,104));
        JLdescricao.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLvenda = new JLabel("Preço de Venda: R$ "+ ctrlProduto.arrayProduto.get(i).getPreco_venda());
        JLvenda.setForeground(new Color(35,142,104));
        JLvenda.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        Quantidade = new JLabel("Quantidade em Estoque: "+ ctrlProduto.arrayProduto.get(i).getQuantidade());
        Quantidade.setForeground(new Color(35,142,104));
        Quantidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JButtons
        JPbotao.removeAll();
        JPcadastro.removeAll();
        JPprincipal.removeAll();
        JPfrente.removeAll();
        JBsair = new JButton("Ok");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(6, 1, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);
        
        //Setando Paineis
        JPbotao.add(JBsair);
        JPcadastro.add(JLproduto);
        JPcadastro.add(JLcod);
        JPcadastro.add(JLdescricao);
        JPcadastro.add(JLvenda);
        JPcadastro.add(Quantidade);
        JPcadastro.add(JPbotao);

        JPprincipal.add(JPcadastro);

        JPfrente.add(Box.createGlue());
        JPfrente.add(JPprincipal);
        JPfrente.add(Box.createGlue());

        //Setando o JFrame
        add(JPfrente);
        setSize(800,600);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void atualizarEstoque(){
        //JLabels
        JLproduto = new JLabel("ATUALIZAR ESTOQUE");
        JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLproduto.setForeground(new Color(35,142,104));
        JLvazio = new JLabel();
        JLcod = new JLabel("Código: ");
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        Quantidade = new JLabel("Quantidade a mais: ");
        Quantidade.setForeground(new Color(35,142,104));
        Quantidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JTextFields
        JTcod = new JTextField(20);
        JTquantidade = new JTextField(20);
        
        //JButtons
        /*JPbotao.removeAll();
        JPcadastro.removeAll();
        JPprincipal.removeAll();
        JPfrente.removeAll();*/
        JBatualizar = new JButton("Adicionar");
        JBatualizar.setBorderPainted(false);
        JBatualizar.setForeground(Color.white);
        JBatualizar.setBackground(new Color(35,142,104));
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBatualizar.addActionListener(this);
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(4, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);
        
        //Setando Paineis
        JPbotao.add(JBatualizar);
        JPbotao.add(JBsair);
        JPcadastro.add(JLproduto);
        JPcadastro.add(JLvazio);
        JPcadastro.add(JLcod);
        JPcadastro.add(JTcod);
        JPcadastro.add(Quantidade);
        JPcadastro.add(JTquantidade);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JPbotao);

        JPprincipal.add(JPcadastro);

        JPfrente.add(Box.createGlue());
        JPfrente.add(JPprincipal);
        JPfrente.add(Box.createGlue());

        //Setando o JFrame
        add(JPfrente);
        setSize(800,600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void estoque() {
        //JLabels
        JLproduto = new JLabel("ESTOQUE COMPLETO");
        JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLproduto.setForeground(new Color(35,142,104));
        JLvazio = new JLabel();
        
        //JTextArea
        JTextArea area = new JTextArea();
        area.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        Dimension s = new Dimension(600,600);
        area.setPreferredSize(new Dimension(100, area.getHeight()));
        area.setBounds(0, 33, 782, 540);
        area.setEditable(false);
        area.setText("");
        
        //Barra de Rolagem
        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //JButtons
        JBsair = new JButton("Ok");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's  
        JPprincipal = new JPanel(new BorderLayout());
        JPprincipal.add(BorderLayout.NORTH, JLproduto);
        JPprincipal.add(BorderLayout.CENTER, area);
        JPprincipal.add(BorderLayout.SOUTH, JBsair);
        JPprincipal.add(scroll);
        area.setText(ctrlProduto.listaEstoque());

        //Setando o JFrame
        add(JPprincipal);
        setSize(800,600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void limpa(){
        JTcod.setText("");
        JTdescricao.setText("");
        JTcompra.setText("");
        JTvenda.setText("");
        JTquantidade.setText("");
    }
    
    public void limpaErro(){
        JTcompra.setText("");
        JTvenda.setText("");
        JTquantidade.setText("");
    }
    
    public void limpaProc(){
        JTcod.setText("");
    }
    
    public void limpaAtualiza(){
        JTcod.setText("");
        JTquantidade.setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        if(item == JBsair)
            dispose();
        if(item == JBcadastrar){
            String gcodigo = JTcod.getText();
            String gdescricao = JTdescricao.getText();
            String gprecocompra = JTcompra.getText();
            String gprecovenda = JTvenda.getText();
            String gquantidade = JTquantidade.getText();
            int i = ctrlProduto.verificaProduto(gcodigo);
            if(i!=-1) {
                JOptionPane.showMessageDialog(JPfrente, "Produto já cadastrado");
                dispose();
            }
            else if(gcodigo.isEmpty() || gdescricao.isEmpty() || gprecocompra.isEmpty() || gprecovenda.isEmpty() ||
                    gquantidade.isEmpty()) {
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha todos os campos!");
            }
            else {
                try{
                    double ggcompra = Double.parseDouble(gprecocompra);
                    double ggvenda = Double.parseDouble(gprecovenda);
                    int ggquantidade = Integer.parseInt(gquantidade);
                    ctrlProduto.cadastrarProduto(gcodigo, gdescricao, ggcompra, ggvenda, ggquantidade);
                    JOptionPane.showMessageDialog(JPfrente, "Produto cadastrado com sucesso!");
                    dispose();
                }catch(java.lang.RuntimeException e){
                    JOptionPane.showMessageDialog(JPfrente, "Por favor, use apenas números!!");
                    limpaErro();
                }

            }
        }
        if(item == JBprocurar){
            String gcod = JTcod.getText();
            int i = ctrlProduto.verificaProduto(gcod);
            
            if(gcod.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else {if(i != -1) {
                    procurarProduto2(i);
                }
                else {
                    JOptionPane.showMessageDialog(JPfrente, "Produto não cadastrado!");
                    limpaProc();
                }
            }
        }
        if(item == JBatualizar) {
            String gcod = JTcod.getText();
            String gquant = JTquantidade.getText();
            int i = ctrlProduto.verificaProduto(gcod);
            if(gcod.isEmpty() || gquant.isEmpty())
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha os campos!");
            else {
                try{
                    if(i!=-1) {
                        JOptionPane.showMessageDialog(JPfrente, "Estoque atualizado com sucesso!");
                        ctrlProduto.atualizaQuantidade(gquant, i);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(JPfrente, "Produto não cadastrado!");
                        limpaAtualiza();
                    }
                }catch(java.lang.RuntimeException e){
                    JOptionPane.showMessageDialog(JPfrente, "Por favor, coloque números ao invés de letras!!");
                    limpaErro();
                }
            }
        }
    }
}
