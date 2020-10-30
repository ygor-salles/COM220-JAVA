package View;

import Control.CtrlCliente;
import java.awt.Color;
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
import javax.swing.JTextField;

public class LimCliente extends JFrame implements ActionListener, Serializable {
    
    private CtrlCliente ctrlCliente;
    private JLabel JLcliente,JLvazio, JLnome, JLemail, JLestado, JLcidade, JLrua, JLnumero , JLcpf;
    private JTextField JTnome, JTemail, JTestado, JTcidade, JTrua, JTnumero, JTcpf;
    private JButton JBcadastrar, JBsair, JBprocurar;
    public JPanel JPcadastro, JPbotao, JPprincipal, JPfrente;
    
    public LimCliente(CtrlCliente controle, int n) {
        ctrlCliente = controle;
        //Cadastrar Cliente
        if (n==1) {
            cadastrarCliente(controle);
        }
        //Procurar Cliente
        if (n==2) {
           procurarCliente(controle);
        }
    }

    public void cadastrarCliente(CtrlCliente controle) {
            ctrlCliente = controle;
            //super("Cadastro de Clientes");
            //JLabels
            JLcliente = new JLabel("CADASTRO DE CLIENTES");
            JLvazio = new JLabel();
            JLcliente.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
            JLcliente.setForeground(new Color(35,142,104));
            JLnome = new JLabel("Nome: ");
            JLnome.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLnome.setForeground(new Color(35,142,104));
            JLemail = new JLabel("Email: ");
            JLemail.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLemail.setForeground(new Color(35,142,104));
            JLestado = new JLabel("Estado: ");
            JLestado.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLestado.setForeground(new Color(35,142,104));
            JLcidade = new JLabel("Cidade: ");
            JLcidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLcidade.setForeground(new Color(35,142,104));
            JLrua = new JLabel("Rua: ");
            JLrua.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLrua.setForeground(new Color(35,142,104));
            JLnumero = new JLabel("Número: ");
            JLnumero.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLnumero.setForeground(new Color(35,142,104));
            JLcpf = new JLabel("CPF: ");
            JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
            JLcpf.setForeground(new Color(35,142,104));

            //JTextFields
            JTnome = new JTextField(20);
            JTemail = new JTextField(20);
            JTestado = new JTextField(20);
            JTcidade = new JTextField(20);
            JTrua = new JTextField(20);
            JTnumero = new JTextField(20);
            JTcpf = new JTextField(20);

            //JButtons
            JBcadastrar = new JButton("Cadastrar Cliente");
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
            JPcadastro = new JPanel(new GridLayout(9, 2, 10, 20));
            JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPfrente = new JPanel();
            BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
            JPfrente.setLayout(box);

            //Setando Paineis
            JPbotao.add(JBcadastrar);
            JPbotao.add(JBsair);

            JPcadastro.add(JLcliente);
            JPcadastro.add(JLvazio);
            JPcadastro.add(JLnome);
            JPcadastro.add(JTnome);
            JPcadastro.add(JLemail);
            JPcadastro.add(JTemail);
            JPcadastro.add(JLestado);
            JPcadastro.add(JTestado);
            JPcadastro.add(JLcidade);
            JPcadastro.add(JTcidade);
            JPcadastro.add(JLrua);
            JPcadastro.add(JTrua);
            JPcadastro.add(JLnumero);
            JPcadastro.add(JTnumero);
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

    public void procurarCliente(CtrlCliente controle) {
        ctrlCliente = controle;
        //JLabels
        JLcliente = new JLabel("CONSULTAR CLIENTES");
        JLvazio = new JLabel();
        JLcliente.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLcliente.setForeground(new Color(35,142,104));
        JLcpf = new JLabel("CPF: ");
        JLcpf.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLcpf.setForeground(new Color(35,142,104));
        
        //JTextFields
        JTcpf = new JTextField(20);

        //JButtons
        JBprocurar = new JButton("Pesquisar");
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
        JPcadastro.add(JLcliente);
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
    
    public void procurarCliente2(int i) {
        //JLabels
        JLcliente = new JLabel("CLIENTE CONSULTADO");
        JLcliente.setFont(new Font("Microsoft PhagsPa",Font.BOLD,25));
        JLcliente.setForeground(new Color(35,142,104));
        JLnome = new JLabel("Nome: "+ ctrlCliente.arrayCliente.get(i).getNome());
        JLnome.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLnome.setForeground(new Color(35,142,104));
        JLemail = new JLabel("Email: "+ ctrlCliente.arrayCliente.get(i).getEmail());
        JLemail.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLemail.setForeground(new Color(35,142,104));
        JLestado = new JLabel("Estado: "+ ctrlCliente.arrayCliente.get(i).getEstado());
        JLestado.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLestado.setForeground(new Color(35,142,104));
        JLcidade = new JLabel("Cidade: "+ ctrlCliente.arrayCliente.get(i).getCidade());
        JLcidade.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLcidade.setForeground(new Color(35,142,104));
        JLrua = new JLabel("Rua: "+ ctrlCliente.arrayCliente.get(i).getRua());
        JLrua.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLrua.setForeground(new Color(35,142,104));
        JLnumero = new JLabel("Número: "+ ctrlCliente.arrayCliente.get(i).getNumero());
        JLnumero.setFont(new Font("Microsoft PhagsPa",Font.PLAIN,17));
        JLnumero.setForeground(new Color(35,142,104));
        
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
        
        JPcadastro = new JPanel(new GridLayout(9, 1, 10, 20));
        JPbotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPprincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPfrente = new JPanel();
        BoxLayout box = new BoxLayout(JPfrente, BoxLayout.Y_AXIS);
        JPfrente.setLayout(box); 
        
        //Setando Paineis
        JPbotao.add(JBsair);
        JPcadastro.add(JLcliente);
        JPcadastro.add(JLnome);
        JPcadastro.add(JLemail);
        JPcadastro.add(JLestado);
        JPcadastro.add(JLcidade);
        JPcadastro.add(JLrua);
        JPcadastro.add(JLnumero);
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
    
    public void limpa() {
        JTnome.setText("");
        JTemail.setText("");
        JTestado.setText("");
        JTcidade.setText("");
        JTrua.setText("");
        JTnumero.setText("");
        JTcpf.setText("");
    }
    
    public void limpaProc() {
        JTcpf.setText("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object item = ae.getSource();
        if (item == JBsair)
            dispose();
        if (item == JBcadastrar) {
            String gnome = JTnome.getText();
            String gemail = JTemail.getText();
            String gestado = JTestado.getText();
            String gcidade = JTcidade.getText();
            String grua = JTrua.getText();
            String gnumero = JTnumero.getText();
            String gcpf = JTcpf.getText();
            if(gnome.isEmpty() || gemail.isEmpty() || gestado.isEmpty() || gcidade.isEmpty() ||
                    grua.isEmpty() || gnumero.isEmpty() || gcpf.isEmpty()) {
                JOptionPane.showMessageDialog(JPfrente, "Por favor, preencha todos os campos!");
            }
            else {
                ctrlCliente.cadastrarCliente(gnome, gemail, gestado, gcidade, grua, gnumero, gcpf, gcpf);
                JOptionPane.showMessageDialog(JPfrente, "Cliente cadastrado com sucesso!");
                dispose();
            }
        }
        if (item == JBprocurar) {
            String gcpf = JTcpf.getText();
            int i = ctrlCliente.verificaCliente(gcpf);
            if(i!=-1) {
                procurarCliente2(i);
            }
            else {
                JOptionPane.showMessageDialog(JPfrente, "Cliente não cadastrado!");
                limpaProc();
            }
        }
    }
}
