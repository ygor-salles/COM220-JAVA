
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class TeladeLogin implements ActionListener {

    private ArrayList<String> nomes = new ArrayList<String>();
    private ArrayList<String> senhas = new ArrayList<String>();
    private JTextField nome;
    private JPasswordField senha;
    JButton loginbtn;

    TeladeLogin() {
        nomes.add("Jean");
        nomes.add("Antonio");
        nomes.add("Felipe");
        nomes.add("Baldochi");

        senhas.add("1234");
        senhas.add("1234");
        senhas.add("1234");
        senhas.add("1234");

    }

    public static void main(String[] args) {

        //Cria container e adiciona a ele elementos de interface
        TeladeLogin login = new TeladeLogin();

        // OBJETO JANELA
        JFrame frame = new JFrame("LOGIN");
        // PAINEL PRINCIPAL PARA CONTER TUDO DENTRO
        JPanel p = new JPanel();

        // FUNCAO COM COMPONENTS EXTERNOS
        Component loginC = login.loginComponents();

        /// ADICIONA MARGENS AO LADO EXTERNO
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ADICIONA OS COMPONENTE NO PAINEL
        p.add(loginC);

        /// ADICIONA OS OS CONTEUDOS DE UM OBJETO NO FRAME
        frame.getContentPane().add(p, BorderLayout.CENTER);

        // SIZE É O TAMANHO, PACK COMPRIME OS OBEJTOS PROXIMOS UM DOS OUTROS
        frame.setSize(350, 250);
        //frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Component loginComponents() {
        // PAINEL PRINCIPAL
        JPanel pane = new JPanel();

        // TEXTOS
        JLabel nometxt = new JLabel("Nome: ");
        JLabel senhatxt = new JLabel("Senha ");

        // CAMPOS DE TEXTO E SENHA
        nome = new JTextField(25);
        senha = new JPasswordField(25);

        /// CRIAÇÃO DO BOTÃO
        loginbtn = new JButton("Conectar");
        loginbtn.addActionListener(this);
        pane.setLayout(new GridLayout(5, 1, 3, 3));
        pane.setBorder(BorderFactory.createEtchedBorder());
        pane.add(nometxt);
        pane.add(nome);
        pane.add(senhatxt);
        pane.add(senha);
        pane.add(loginbtn);
        return pane;
    }

    public int loginScript() {
        int status = 0;

        return status;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == loginbtn) {
            if (!nome.getText().isEmpty()) {
                for (String a : nomes) {
                    if (a.equals(nome.getText())) {
                        for (String b : senhas) {
                            if (b.equals(senha.getText())) {
                                JOptionPane.showMessageDialog(null, "Você foi logado!");
                                return;
                            }
                        }

                        JOptionPane.showMessageDialog(null, "Senha incorreta!");
                        return;
                    }

                }

                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
                return;
            }
            JOptionPane.showMessageDialog(null, "Campo nome em branco!");
        }
    }
}
