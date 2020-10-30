package View;

import Control.CtrlCliente;
import Control.CtrlProduto;
import Control.CtrlVenda;
import Control.CtrlNotaFiscal;
import Model.NotaFiscal;
import Model.Produto;
import Model.Venda;
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

public class LimVenda extends JFrame implements ActionListener, Serializable{
    private CtrlVenda ctrlVenda;
    private Venda v;
    private Produto p;
    private NotaFiscal nf;
    private CtrlCliente ctrlCliente;
    private CtrlProduto ctrlProduto;
    private CtrlNotaFiscal ctrlNota;
    private LimNotaFiscal limNota;
    private JLabel JLvendas,JLvazio, JLcpf, JLcod, JLdescricao, JLpreco, JLquantidade, JLproduto, JLfaturamento;
    private JTextField JTcpf, JTcod, JTcompra, JTvenda, JTquantidade;
    private JButton JBproduto, JBsair, JBcpf, JBnota, JBpreco, JBcodigo, JBfaturamento;
    private JPanel JPcadastro, JPbotao, JPprincipal, JPfrente;
    private int cont = 0;
    
    public LimVenda(CtrlVenda controle, CtrlCliente ctrl, CtrlProduto ctrlp, Produto p, NotaFiscal nf,int n) {
        ctrlVenda = controle;
        ctrlCliente = ctrl;
        ctrlProduto = ctrlp;
        ctrlNota = new Control.CtrlNotaFiscal();
        
        //Cadastrar Cliente
        if (n==1) {
            cadastrarVenda1();
        }
        //Procurar Cliente
        if (n==2) {
           //procurarProduto();
        }
        //Produtos mais vendidos
        if (n==8) {
            faturamentoProduto1();
        }
        //Produtos mais vendidos
        if (n==13) {
            produtosMaisVendidos();
        }
        
    }

    public void cadastrarVenda1() {
        //1 Parte
        //JLabels
        JLvendas = new JLabel("VENDAS");
        JLvazio = new JLabel();
        JLvendas.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLvendas.setForeground(new Color(35,142,104));
        JLcpf = new JLabel("CPF: ");
        JLcpf.setForeground(new Color(35,142,104));
        JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        //JTextFields
        JTcpf = new JTextField(20);
        //JButtons
        JBcpf = new JButton("Verificar CPF");
        JBcpf.addActionListener(this);
        JBcpf.setBorderPainted(false);
        JBcpf.setForeground(Color.white);
        JBcpf.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(3, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBcpf);
        JPbotao.add(JBsair);

        JPcadastro.add(JLvendas);
        JPcadastro.add(JLvazio);
        JPcadastro.add(JLcpf);
        JPcadastro.add(JTcpf);
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
    
    public void cadastrarVenda2() {
        //JLabels
        JLvendas = new JLabel("PRODUTOS A COMPRAR");
        JLvazio = new JLabel();
        JLvendas.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLvendas.setForeground(new Color(35,142,104));
        JLcod = new JLabel("Código: ");
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLquantidade = new JLabel("Quantidade: ");
        JLquantidade.setForeground(new Color(35,142,104));
        JLquantidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLdescricao = new JLabel();
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLpreco = new JLabel();
        JLquantidade.setForeground(new Color(35,142,104));
        JLquantidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        //JTextFields
        JTcod = new JTextField(20);
        JTquantidade = new JTextField(20);
        //JButtons
        JPbotao.removeAll();
        JPcadastro.removeAll();
        JPprincipal.removeAll();
        JPfrente.removeAll();
        JBproduto = new JButton("Comprar");
        JBproduto.addActionListener(this);
        JBproduto.setBorderPainted(false);
        JBproduto.setForeground(Color.white);
        JBproduto.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        JBnota = new JButton("Emitir Nota");
        JBnota.setBorderPainted(false);
        JBnota.setForeground(Color.white);
        JBnota.setBackground(new Color(35,142,104));
        JBnota.addActionListener(this);
        JBpreco = new JButton("Ver Produto");
        JBpreco.setBorderPainted(false);
        JBpreco.setForeground(Color.white);
        JBpreco.setBackground(new Color(35,142,104));
        JBpreco.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(5, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBpreco);
        JPbotao.add(JBproduto);
        JPbotao.add(JBsair);
        JPbotao.add(JBnota);

        JPcadastro.add(JLvendas);
        JPcadastro.add(JLvazio);
        JPcadastro.add(JLcod);
        JPcadastro.add(JTcod);
        JPcadastro.add(JLquantidade);
        JPcadastro.add(JTquantidade);
        JPcadastro.add(JLdescricao);
        JPcadastro.add(JLpreco);
        //JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JPbotao);

        JPprincipal.add(JPcadastro);

        JPfrente.add(Box.createGlue());
        JPfrente.add(JPprincipal);
        JPfrente.add(Box.createGlue());

        //Setando o JFrame
        add(JPfrente);
        setSize(800,600);
        setLocationRelativeTo(null);
        //setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
        
    }
    
    
    public void faturamentoProduto1(){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO POR PRODUTO");
        JLvazio = new JLabel();
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLcod = new JLabel("CÓDIGO: ");
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        //JTextFields
        JTcod = new JTextField(20);
        //JButtons
        JBcodigo = new JButton("Calcular faturamento");
        JBcodigo.addActionListener(this);
        JBcodigo.setBorderPainted(false);
        JBcodigo.setForeground(Color.white);
        JBcodigo.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(4, 1, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBcodigo);
        JPbotao.add(JBsair);

        JPcadastro.add(JLfaturamento);
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
    
    public void faturamentoProduto2(String codigo){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO CALCULADO");
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLcod = new JLabel("Faturamento: "+ ctrlVenda.faturamentoProduto(codigo));
        JLcod.setForeground(new Color(35,142,104));
        JLcod.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
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
        JPcadastro = new JPanel(new GridLayout(3, 1, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);
        
        //Setando Paineis
        JPbotao.add(JBsair);
        JPcadastro.add(JLfaturamento);
        JPcadastro.add(JLcod);
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
    
    public void produtosMaisVendidos(){
        //JLabels
        JLproduto = new JLabel("10 PRODUTOS MAIS VENDIDOS");
        JLproduto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLproduto.setForeground(new Color(35,142,104));
        JLvazio = new JLabel();
        
        //JTextArea
        JTextArea areavendidos = new JTextArea();
        areavendidos.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        Dimension s = new Dimension(600,600);
        areavendidos.setPreferredSize(new Dimension(100, areavendidos.getHeight()));
        areavendidos.setBounds(0, 33, 782, 540);
        areavendidos.setEditable(false);
        areavendidos.setText("");
        
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
        JPprincipal.add(BorderLayout.CENTER, areavendidos);
        JPprincipal.add(BorderLayout.SOUTH, JBsair);
        JPprincipal.add(scroll);
        areavendidos.setText(ctrlVenda.produtosMaisVendidos());

        //Setando o JFrame
        add(JPprincipal);
        setSize(800,600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void limpaCpf() {
        JTcpf.setText("");
    } 
    
    public void limpaVenda() {
        JTcod.setText("");
        JTquantidade.setText("");
    }
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        if(item == JBsair)
            dispose();
        if(item == JBcpf) {
            String gcpf = JTcpf.getText();
            int i = ctrlCliente.verificaCliente(gcpf);
            if(gcpf.isEmpty())
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else if(i==-1) {
                JOptionPane.showMessageDialog(JPfrente, "Cliente não cadastrado!");
                limpaCpf();
            }
            else {
                v = new Venda();
                v.setCpf(gcpf);
                nf = new NotaFiscal();
                nf.setCpf(gcpf);
                cadastrarVenda2();
                
            }
        }
        if(item == JBproduto){
            String gcodigo = JTcod.getText();
            String gquantidade = JTquantidade.getText();
            int i = ctrlProduto.verificaProduto(gcodigo);
            if(gcodigo.isEmpty() || gquantidade.isEmpty())
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha os campos!");
            else if(i==-1){
                JOptionPane.showMessageDialog(JPfrente, "Esse produto não está cadastrado!");
                limpaVenda();
            }
            else if(ctrlProduto.verificaQuantidade(gcodigo, gquantidade)) {
                JOptionPane.showMessageDialog(JPfrente, "Não existe estoque suficiente desse produto!");
                limpaVenda();
            }
            else {
                if(cont<=10) {
                    p = new Produto();
                    p = ctrlProduto.retornaProd(gcodigo);
                    int q = Integer.parseInt(gquantidade);
                    ctrlVenda.cadastraVenda(p, q);
                    cont++;
                    String prec = Double.toString(p.getPreco_venda());
                    JOptionPane.showMessageDialog(JPfrente, "Produto adicionado ao carrinho!");
                    limpaVenda();
                }
                else if (cont>10)
                    JOptionPane.showMessageDialog(JPfrente, "Você ultrapassou o limite permitido de compra!");
            }
        }
        if(item==JBnota) {
            limNota = new LimNotaFiscal();
        }
        if(item==JBpreco) {
            String gcod = JTcod.getText();
            p = new Produto();
            p = ctrlProduto.retornaProd(gcod);
            String d = p.getDescricao();
            String pr = Double.toString(p.getPreco_venda());
            JOptionPane.showMessageDialog(JPfrente, "Descrição: "+d+"\nPreço: R$ "+pr);
        }
        if(item==JBcodigo){
            String codigo = JTcod.getText();
            
            if(codigo.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else{
                    faturamentoProduto2(codigo);
            }   
            
        }
    }
}