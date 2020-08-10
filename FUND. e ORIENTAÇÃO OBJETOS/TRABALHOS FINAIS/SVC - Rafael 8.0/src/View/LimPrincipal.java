package View;

import Control.CtrlPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class LimPrincipal extends JFrame implements ActionListener, WindowListener {

    CtrlPrincipal controle;

    private final ImageIcon icoAdd = new ImageIcon("img/adicionar.png");
    private final ImageIcon icoAddCli = new ImageIcon("img/adicionarCliente.png");
    private final ImageIcon icoProc = new ImageIcon("img/procurarPessoa.png");
    private final ImageIcon icoAtu = new ImageIcon("img/atualizar.png");
    private final ImageIcon icoConf = new ImageIcon("img/configurar.png");
    private final ImageIcon icoGra = new ImageIcon("img/grafico.png");
    private final ImageIcon icoVen = new ImageIcon("img/vendas.png");
    private final ImageIcon icoHis = new ImageIcon("img/historico.png");
    private final ImageIcon icoProd = new ImageIcon("img/procurarProduto.png");
    private final ImageIcon icoEsto = new ImageIcon("img/estoque.png");
    private JLabel showName, showFuncao, credito;
    
    private JMenuItem inserirCliente, procurarCliente, inserirProduto, procurarProduto,
            atualizarProduto,estoque, inserirVenda, historicoVenda,
            fatProduto,fatCli,fatPer,lucLiq,venPer,top10;
    
    private JMenu cliente, produto, item, consultas;
    private JMenuBar menubar;


    public LimPrincipal(CtrlPrincipal ctrl) {

        super("Sistema de Controle de Vendas - UaiVendas");
        controle = ctrl;

        setLayout(new BorderLayout());
        this.addWindowListener(this);
       
        //Criar Menu
        cliente = new JMenu("Cliente");
        cliente.setForeground(Color.white);
        cliente.setFont(new Font("Microsoft PhagsPa",Font.BOLD,15));
        
        produto = new JMenu("Produto");
        produto.setForeground(Color.white);
        produto.setFont(new Font("Microsoft PhagsPa",Font.BOLD,15));
        
        item = new JMenu("Vendas");
        item.setForeground(Color.white);
        item.setFont(new Font("Microsoft PhagsPa",Font.BOLD,15));
        
        consultas = new JMenu("Consultas");
        consultas.setForeground(Color.white);
        consultas.setFont(new Font("Microsoft PhagsPa",Font.BOLD,15));
        
        //Criar itens do Menu
        //Cliente
        inserirCliente = new JMenuItem("Cadastrar Cliente", icoAddCli);
        inserirCliente.setBackground(Color.white);
        inserirCliente.addActionListener(this);
        procurarCliente = new JMenuItem("Procurar Cliente", icoProc);
        procurarCliente.setBackground(Color.white);
        procurarCliente.addActionListener(this);
        
        //Produto
        inserirProduto = new JMenuItem("Cadastrar Produto", icoAdd);
        inserirProduto.setBackground(Color.white);
        inserirProduto.addActionListener(this);
        procurarProduto = new JMenuItem("Procurar Produto", icoProd);
        procurarProduto.setBackground(Color.white);
        procurarProduto.addActionListener(this);
        atualizarProduto = new JMenuItem("Atualizar Estoque", icoAtu);
        atualizarProduto.setBackground(Color.white);
        atualizarProduto.addActionListener(this);
        estoque = new JMenuItem("Estoque Completo", icoEsto);
        estoque.setBackground(Color.white);
        estoque.addActionListener(this);
        
        //Vendas
        inserirVenda = new JMenuItem("Realizar Venda", icoVen);
        inserirVenda.setBackground(Color.white);
        inserirVenda.addActionListener(this);
        
        //Consultas
        fatProduto = new JMenuItem("Faturamento por Produto", icoGra);
        fatProduto.setBackground(Color.white);
        fatProduto.addActionListener(this);
        fatCli = new JMenuItem("Faturamento por Cliente", icoGra);
        fatCli.setBackground(Color.white);
        fatCli.addActionListener(this);
        fatPer = new JMenuItem("Faturamento por Período", icoGra);
        fatPer.setBackground(Color.white);
        fatPer.addActionListener(this);
        lucLiq = new JMenuItem("Lucro Líquido por Período", icoGra);
        lucLiq.setBackground(Color.white);
        lucLiq.addActionListener(this);
        venPer = new JMenuItem("Vendas por Cliente em um Período", icoGra);
        venPer.setBackground(Color.white);
        venPer.addActionListener(this);
        top10 = new JMenuItem("10 Produtos Mais Vendidos", icoGra);
        top10.setBackground(Color.white);
        top10.addActionListener(this);
        
        //Adicionar itens ao menu
        cliente.add(inserirCliente);
        cliente.add(procurarCliente);
        produto.add(inserirProduto);
        produto.add(procurarProduto);
        produto.add(atualizarProduto);
        produto.add(estoque);
        item.add(inserirVenda);
        consultas.add(fatProduto);
        consultas.add(fatCli);
        consultas.add(fatPer);
        consultas.add(lucLiq);
        consultas.add(venPer);
        consultas.add(top10);
        
        //Criar JMenuBar e adicionar submenus
        menubar = new JMenuBar();
        
        BoxLayout box = new BoxLayout(menubar, BoxLayout.X_AXIS);
        //FlowLayout box = new FlowLayout(FlowLayout.LEFT, 10, 10);
        menubar.setLayout(box);
        menubar.setPreferredSize(new Dimension(60, 60));
        
        //Botão de Sair
        JButton sair = new JButton(new ImageIcon("img/sair.png"));
        JLabel exit = new JLabel("Sair");
        exit.setForeground(Color.white);
        exit.setFont(new Font("Microsoft PhagsPa",Font.BOLD,15));
        sair.setBorderPainted(false);
        sair.setBackground(new Color(35,142,104));
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //objCtrl.finaliza();
                System.exit(0);
            }
        });

        //Configurações barramenu
        menubar.setBackground(new Color(35,142,104));
        menubar.add(cliente);
        menubar.add(produto);
        menubar.add(item);
        menubar.add(consultas);
        menubar.add(Box.createGlue());
        menubar.add(exit);
        menubar.add(sair);
        
        //Créditos na parte de baixo
        JPanel creditos = new JPanel();
        creditos.setBackground(new Color(35,142,104)); // cor do painel
        creditos.setLayout(new BoxLayout(creditos, BoxLayout.X_AXIS));
        creditos.add(Box.createHorizontalGlue());
        credito = new JLabel("UNIFEI © 2018 - "
                + "Sistema de Controle de Vendas - UaiVendas"
                + " | Desenvolvido por Flávio Eduardo, Rafael Greca e Sandro Ricardo");
        credito.setForeground(Color.WHITE); //cor da fonte
        credito.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,13));
        creditos.add(credito);
        creditos.add(Box.createHorizontalGlue());
        add(creditos, BorderLayout.PAGE_END);
        
        //JFrame configurações
        //setResizable(false); // IMPEDE DE REDIMENSIONAR
        setBackground(new Color(229, 239, 202));
        setUndecorated(true); // remove as barras 
        setVisible(true);
        //setAlwaysOnTop(true);
        //setSize(width, height);
        setJMenuBar(menubar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH); // TELA INICIA MAXIMIZADA
        setLocationRelativeTo(null);
    }

    public void showMessage(String string) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        if(item == inserirCliente) 
            controle.abrirJanela(1);
        if(item == procurarCliente)
            controle.abrirJanela(2);
        if(item == inserirProduto)
            controle.abrirJanela(3);
        if(item == procurarProduto)
            controle.abrirJanela(4);
        if(item == atualizarProduto)
            controle.abrirJanela(5);
        if(item == estoque)
            controle.abrirJanela(6);
        if(item == inserirVenda)
            controle.abrirJanela(7);
        if(item == fatProduto)
            controle.abrirJanela(8);
        if(item == fatCli)
            controle.abrirJanela(9);
        if(item == fatPer)
            controle.abrirJanela(10);
        if(item == lucLiq)
            controle.abrirJanela(11);
        if(item == venPer)
            controle.abrirJanela(12);
        if(item == top10)
            controle.abrirJanela(13);
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

}
