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

public class LimNotaFiscal extends JFrame implements ActionListener, Serializable{
    
    private CtrlVenda ctrlVenda;
    private CtrlNotaFiscal ctrlNotaFiscal;
    private Venda v;
    private Produto p;
    private CtrlCliente ctrlCliente;
    private CtrlProduto ctrlProduto;
    private JLabel JLnota,JLvazio, JLdia, JLmes, JLano, JLvenda, JLfaturamento, JLcpf, JLvendas, Quantidade;
    private JLabel JLinicio, JLfim, JLfdia, JLfmes, JLfano;
    private JTextField JTdia, JTmes, JTano, JTvenda, JTquantidade, JTcpf, JTdiainicio, JTmesinicio, JTanoinicio;
    private JTextField JTdiafim, JTmesfim, JTanofim;
    private JButton JBnota, JBsair, JBprocurar, JBatualizar, JBfaturamento, JBperiodo, JBfatliquido, JBclienteperiodo;
    public JPanel JPcadastro, JPbotao, JPprincipal, JPfrente;
    private NotaFiscal nf;
    private String cpf;
    private JTextArea area;

    public LimNotaFiscal(CtrlVenda controle, CtrlCliente ctrl, CtrlProduto ctrlp, Produto p, int n) {
       
        ctrlVenda = controle;
        ctrlCliente = ctrl;
        ctrlProduto = ctrlp;
        nf = new NotaFiscal();
        
        gerarNotaFiscal();
    }
    
    public LimNotaFiscal(int n){
        
        //Faturamento Cliente
        if (n==9) {
          faturamentoCliente1();
        }
        //Faturamento Período
        if (n==10) {
          faturamentoPeriodo1();
        }
        //Lucro líquido por período
        if (n==11) {
          faturamentoLiquido1();
        }
        //Vendas para um cliente em um período
        if (n==12) {
          vendasClientePeriodo1();
        }
    }
    
    public LimNotaFiscal() {
        gerarNotaFiscal();
    }
    
    public void gerarNotaFiscal(){
        //JLabels
            JLnota = new JLabel("NOTA FISCAL");
            JLvazio = new JLabel();
            JLnota.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
            JLnota.setForeground(new Color(35,142,104));
            JLdia = new JLabel("Dia: ");
            JLdia.setForeground(new Color(35,142,104));
            JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLmes = new JLabel("Mês: ");
            JLmes.setForeground(new Color(35,142,104));
            JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLano = new JLabel("Ano: ");
            JLano.setForeground(new Color(35,142,104));
            JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));

            //JTextFields
            JTdia = new JTextField(8);
            JTmes = new JTextField(8);
            JTano = new JTextField(8);

            //JButtons
            JBnota = new JButton("Gerar nota");
            JBnota.setBorderPainted(false);
            JBnota.setForeground(Color.white);
            JBnota.setBackground(new Color(35,142,104));
            JBsair = new JButton("Sair");
            JBsair.setBorderPainted(false);
            JBsair.setForeground(Color.white);
            JBsair.setBackground(new Color(35,142,104));
            JBnota.addActionListener(this);
            JBsair.addActionListener(this);

            //Criar JPanel's
            JPcadastro = new JPanel(new GridLayout(5, 2, 10, 20));
            JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPfrente = new JPanel();
            BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
            JPfrente.setLayout(box);

            //Setando Paineis
            JPbotao.add(JBnota);
            JPbotao.add(JBsair);
            
            JPcadastro.add(JLnota);
            JPcadastro.add(JLvazio);
            JPcadastro.add(JLdia);
            JPcadastro.add(JTdia);
            JPcadastro.add(JLmes);
            JPcadastro.add(JTmes);
            JPcadastro.add(JLano);
            JPcadastro.add(JTano);
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
    
    public void nota(String n) {
        //JLabels
        JLnota = new JLabel("NOTA FISCAL");
        JLnota.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLnota.setForeground(new Color(35,142,104));
        JLvazio = new JLabel();
        
        //JTextArea
        JTextArea area = new JTextArea();
        area.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        Dimension s = new Dimension(600,600);
        area.setPreferredSize(new Dimension(100, area.getHeight()));
        area.setBounds(0, 33, 782, 540);
        area.setEditable(false);
        area.setText(n);
        
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
        JPprincipal = new JPanel(new BorderLayout());
        JPprincipal.add(BorderLayout.NORTH, JLnota);
        JPprincipal.add(BorderLayout.CENTER, area);
        JPprincipal.add(BorderLayout.SOUTH, JBsair);
//        area.setText(ctrlProduto.listaEstoque());

        //Setando o JFrame
        add(JPprincipal);
        setSize(800,600);
        setLocationRelativeTo(null);
//        setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void faturamentoCliente1(){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO POR CLIENTE");
        JLvazio = new JLabel();
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLcpf = new JLabel("CPF: ");
        JLcpf.setForeground(new Color(35,142,104));
        JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        //JTextFields
        JTcpf = new JTextField(20);
        //JButtons
        JBfaturamento = new JButton("Calcular faturamento");
        JBfaturamento.addActionListener(this);
        JBfaturamento.setBorderPainted(false);
        JBfaturamento.setForeground(Color.white);
        JBfaturamento.setBackground(new Color(35,142,104));        
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
        JPbotao.add(JBfaturamento);
        JPbotao.add(JBsair);

        JPcadastro.add(JLfaturamento);
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
    
    public void faturamentoCliente2(String cpf){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO CALCULADO");
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLcpf = new JLabel("Faturamento: "+ ctrlVenda);
        JLcpf.setForeground(new Color(35,142,104));
        JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
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
        JPcadastro = new JPanel(new GridLayout(3, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);
        
        //Setando Paineis
        JPbotao.add(JBsair);
        JPcadastro.add(JLfaturamento);
        JPcadastro.add(JLcpf);
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
    
    public void faturamentoPeriodo1(){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO POR PERÍODO");
        JLvazio = new JLabel();
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLinicio = new JLabel("INÍCIO: ");
        JLinicio.setForeground(new Color(35,142,104));
        JLinicio.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfim = new JLabel("FIM: ");
        JLfim.setForeground(new Color(35,142,104));
        JLfim.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfdia = new JLabel("DIA");
        JLfdia.setForeground(new Color(35,142,104));
        JLfdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfmes = new JLabel("MES: ");
        JLfmes.setForeground(new Color(35,142,104));
        JLfmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfano = new JLabel("ANO: ");
        JLfano.setForeground(new Color(35,142,104));
        JLfano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JTextFields
        JTdiainicio = new JTextField(2);
        JTmesinicio = new JTextField(2);
        JTanoinicio = new JTextField(4);
        JTdiafim = new JTextField(2);
        JTmesfim = new JTextField(2);
        JTanofim = new JTextField(4);
        
        //JButtons
        JBperiodo = new JButton("Calcular faturamento por período");
        JBperiodo.addActionListener(this);
        JBperiodo.setBorderPainted(false);
        JBperiodo.setForeground(Color.white);
        JBperiodo.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(10, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBperiodo);
        JPbotao.add(JBsair);

        JPcadastro.add(JLfaturamento);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLinicio);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLdia);
        JPcadastro.add(JTdiainicio);
        JPcadastro.add(JLmes);
        JPcadastro.add(JTmesinicio);
        JPcadastro.add(JLano);
        JPcadastro.add(JTanoinicio);
        JPcadastro.add(JLfim);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLfdia);
        JPcadastro.add(JTdiafim);
        JPcadastro.add(JLfmes);
        JPcadastro.add(JTmesfim);
        JPcadastro.add(JLfano);
        JPcadastro.add(JTanofim);
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
    
    public void faturamentoPeriodo2(int anofim, int mesfim , int diafim, int anoinicio, int mesinicio, int diainicio){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO CALCULADO");
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLinicio = new JLabel("Faturamento: "+ ctrlNotaFiscal.faturamentoPeriodo(anofim, mesfim, diafim, anoinicio, mesinicio, diainicio));
        JLinicio.setForeground(new Color(35,142,104));
        JLinicio.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
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
        JPcadastro.add(JLinicio);
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
    
    public void faturamentoLiquido1(){
        //JLabels
        JLfaturamento = new JLabel("FATURAMENTO LÍQUIDO");
        JLvazio = new JLabel();
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLinicio = new JLabel("INÍCIO: ");
        JLinicio.setForeground(new Color(35,142,104));
        JLinicio.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfim = new JLabel("FIM: ");
        JLfim.setForeground(new Color(35,142,104));
        JLfim.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfdia = new JLabel("DIA");
        JLfdia.setForeground(new Color(35,142,104));
        JLfdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfmes = new JLabel("MES: ");
        JLfmes.setForeground(new Color(35,142,104));
        JLfmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfano = new JLabel("ANO: ");
        JLfano.setForeground(new Color(35,142,104));
        JLfano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JTextFields
        JTdiainicio = new JTextField(20);
        JTmesinicio = new JTextField(20);
        JTanoinicio = new JTextField(20);
        JTdiafim = new JTextField(20);
        JTmesfim = new JTextField(20);
        JTanofim = new JTextField(20);
        
        //JButtons
        JBfatliquido = new JButton("Calcular faturamento líquido por período");
        JBfatliquido.addActionListener(this);
        JBfatliquido.setBorderPainted(false);
        JBfatliquido.setForeground(Color.white);
        JBfatliquido.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(10, 2, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBfatliquido);
        JPbotao.add(JBsair);

        JPcadastro.add(JLfaturamento);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLinicio);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLdia);
        JPcadastro.add(JTdiainicio);
        JPcadastro.add(JLmes);
        JPcadastro.add(JTmesinicio);
        JPcadastro.add(JLano);
        JPcadastro.add(JTanoinicio);
        JPcadastro.add(JLfim);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLfdia);
        JPcadastro.add(JTdiafim);
        JPcadastro.add(JLfmes);
        JPcadastro.add(JTmesfim);
        JPcadastro.add(JLfano);
        JPcadastro.add(JTanofim);
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
    
    public void faturamentoLiquido2(int anofim, int mesfim , int diafim, int anoinicio, int mesinicio, int diainicio){
    //JLabels
        JLfaturamento = new JLabel("FATURAMENTO CALCULADO");
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLinicio = new JLabel("Faturamento: "+ ctrlNotaFiscal.lucroLiquidoPeriodo(anoinicio, mesinicio, diainicio, anofim, mesfim, diafim));
        JLinicio.setForeground(new Color(35,142,104));
        JLinicio.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
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
        JPcadastro.add(JLinicio);
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
    
    public void vendasClientePeriodo1(){
        //JLabels
        JLfaturamento = new JLabel("VENDAS POR CLIENTE");
        JLvazio = new JLabel();
        JLfaturamento.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLfaturamento.setForeground(new Color(35,142,104));
        JLcpf = new JLabel("CPF: ");
        JLcpf.setForeground(new Color(35,142,104));
        JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLinicio = new JLabel("INÍCIO: ");
        JLinicio.setForeground(new Color(35,142,104));
        JLinicio.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfim = new JLabel("FIM: ");
        JLfim.setForeground(new Color(35,142,104));
        JLfim.setFont(new Font("Microsoft PhagsPa",Font.BOLD,20));
        JLdia = new JLabel("DIA: ");
        JLdia.setForeground(new Color(35,142,104));
        JLdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLmes = new JLabel("MES: ");
        JLmes.setForeground(new Color(35,142,104));
        JLmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLano = new JLabel("ANO: ");
        JLano.setForeground(new Color(35,142,104));
        JLano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfdia = new JLabel("DIA: ");
        JLfdia.setForeground(new Color(35,142,104));
        JLfdia.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfmes = new JLabel("MES: ");
        JLfmes.setForeground(new Color(35,142,104));
        JLfmes.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLfano = new JLabel("ANO: ");
        JLfano.setForeground(new Color(35,142,104));
        JLfano.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        
        //JTextFields
        JTcpf = new JTextField(20);
        JTdiainicio = new JTextField(2);
        JTmesinicio = new JTextField(2);
        JTanoinicio = new JTextField(4);
        JTdiafim = new JTextField(2);
        JTmesfim = new JTextField(2);
        JTanofim = new JTextField(4);
        //JButtons
        JBclienteperiodo = new JButton("Calcular faturamento do cliente por período");
        JBclienteperiodo.addActionListener(this);
        JBclienteperiodo.setBorderPainted(false);
        JBclienteperiodo.setForeground(Color.white);
        JBclienteperiodo.setBackground(new Color(35,142,104));        
        JBsair = new JButton("Sair");
        JBsair.setBorderPainted(false);
        JBsair.setForeground(Color.white);
        JBsair.setBackground(new Color(35,142,104));
        JBsair.addActionListener(this);
        
        //Criar JPanel's
        JPcadastro = new JPanel(new GridLayout(11, 1, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box);

        //Setando Paineis
        JPbotao.add(JBclienteperiodo);
        JPbotao.add(JBsair);
        
        JPcadastro.add(JLfaturamento);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLcpf);
        JPcadastro.add(JTcpf);
        JPcadastro.add(JLinicio);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLdia);
        JPcadastro.add(JTdiainicio);
        JPcadastro.add(JLmes);
        JPcadastro.add(JTmesinicio);
        JPcadastro.add(JLano);
        JPcadastro.add(JTanoinicio);
        JPcadastro.add(JLfim);
        JPcadastro.add(Box.createHorizontalGlue());
        JPcadastro.add(JLfdia);
        JPcadastro.add(JTdiafim);
        JPcadastro.add(JLfmes);
        JPcadastro.add(JTmesfim);
        JPcadastro.add(JLfano);
        JPcadastro.add(JTanofim);
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
    
    public void vendasClientePeriodo2(String cpf, int anoinicio, int mesinicio, int diainicio,
            int anofim, int mesfim, int diafim){
        //JLabels
        JLvendas = new JLabel("VENDAS PARA UM CLIENTE EM UM PERÍODO");
        JLvendas.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLvendas.setForeground(new Color(35,142,104));
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
        JPprincipal.add(BorderLayout.NORTH, JLvendas);
        JPprincipal.add(BorderLayout.CENTER, area);
        JPprincipal.add(BorderLayout.SOUTH, JBsair);
        JPprincipal.add(scroll);
        area.setText(ctrlNotaFiscal.faturamentoClientaData(cpf, anoinicio, mesinicio, diainicio, anofim, mesfim, diafim));

        //Setando o JFrame
        add(JPprincipal);
        setSize(800,600);
        setLocationRelativeTo(null);
        //setUndecorated(true);
        setAlwaysOnTop(true);
        setVisible(true);
    }
    
    public void limpaNota() {
        JTdia.setText("");
        JTmes.setText("");
        JTano.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        if(item == JBsair)
            dispose();
        if(item == JBnota){
            String gdia = JTdia.getText();
            String gmes = JTmes.getText();
            String gano = JTano.getText();
            if(gdia.isEmpty() || gmes.isEmpty() || gano.isEmpty())
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha todos os campos!");
            else {
                try{      
                    int ndia = Integer.parseInt(gdia);
                    int nmes = Integer.parseInt(gmes);
                    int nano = Integer.parseInt(gano);
                    nf = new NotaFiscal();
                    nf.setCodNota();
                    int x = nf.getCodigonota();
                    v = new Venda();
                    String cpf = v.getCpf();
                    ctrlNotaFiscal = new CtrlNotaFiscal();
                    ctrlNotaFiscal.cadastrarNotaFiscal(ndia, nmes, nano, x, cpf);
                    ctrlNotaFiscal.setNota();
                    String n = ctrlNotaFiscal.getNota();
                    nota(n);
                }catch(java.lang.RuntimeException e){
                    JOptionPane.showMessageDialog(JPfrente, "Por favor, use apenas números!!");
                    limpaNota();
                }
            }
        }
        if(item == JBfaturamento){
            String cpf = JTcpf.getText();
            
            if(cpf.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else{
                    faturamentoCliente2(cpf);
            } 
        }
        if(item == JBperiodo){
            String fdiainicio = JTdiainicio.getText();
            String fmesinicio = JTmesinicio.getText();
            String fanoinicio = JTanoinicio.getText();
            String fdiafim = JTdiafim.getText();
            String fmesfim = JTmesfim.getText();
            String fanofim = JTanofim.getText();
            
            if(fdiainicio.isEmpty() || fmesinicio.isEmpty() || fanoinicio.isEmpty() || fdiafim.isEmpty()
                    || fmesfim.isEmpty() || fanofim.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else{
                int diainicio = Integer.parseInt(fdiainicio);
                int mesinicio = Integer.parseInt(fmesinicio);
                int anoinicio = Integer.parseInt(fanoinicio);
                int diafim = Integer.parseInt(fdiafim);
                int mesfim = Integer.parseInt(fmesfim);
                int anofim = Integer.parseInt(fanofim);
                
                faturamentoPeriodo2(anofim,mesfim,diafim,anoinicio,mesinicio,diainicio);
                
                limpaNota();
                 
            }
        }
        if(item == JBfatliquido){
            String fdiainicio = JTdiainicio.getText();
            String fmesinicio = JTmesinicio.getText();
            String fanoinicio = JTanoinicio.getText();
            String fdiafim = JTdiafim.getText();
            String fmesfim = JTmesfim.getText();
            String fanofim = JTanofim.getText();
            
            if(fdiainicio.isEmpty() || fmesinicio.isEmpty() || fanoinicio.isEmpty() || fdiafim.isEmpty()
                    || fmesfim.isEmpty() || fanofim.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else{
                int diainicio = Integer.parseInt(fdiainicio);
                int mesinicio = Integer.parseInt(fmesinicio);
                int anoinicio = Integer.parseInt(fanoinicio);
                int diafim = Integer.parseInt(fdiafim);
                int mesfim = Integer.parseInt(fmesfim);
                int anofim = Integer.parseInt(fanofim);
                
                faturamentoLiquido2(anofim,mesfim,diafim,anoinicio,mesinicio,diainicio);
                
                limpaNota();
                 
            }
        }
        if(item == JBclienteperiodo){
            String cpf = JTcpf.getText();
            String fdiainicio = JTdiainicio.getText();
            String fmesinicio = JTmesinicio.getText();
            String fanoinicio = JTanoinicio.getText();
            String fdiafim = JTdiafim.getText();
            String fmesfim = JTmesfim.getText();
            String fanofim = JTanofim.getText();
            
            if(cpf.isEmpty() || fdiainicio.isEmpty() || fmesinicio.isEmpty() || fanoinicio.isEmpty() || fdiafim.isEmpty()
                    || fmesfim.isEmpty() || fanofim.isEmpty()) 
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha o campo!");
            else{
                int diainicio = Integer.parseInt(fdiainicio);
                int mesinicio = Integer.parseInt(fmesinicio);
                int anoinicio = Integer.parseInt(fanoinicio);
                int diafim = Integer.parseInt(fdiafim);
                int mesfim = Integer.parseInt(fmesfim);
                int anofim = Integer.parseInt(fanofim);
                
                vendasClientePeriodo2(cpf, anoinicio,mesinicio,diainicio,anofim,mesfim,diafim);
                
                limpaNota();
                JTcpf.setText("");
                 
            }
        }
    }
}
