
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class PainelAtivadorDeBotoes implements ItemListener {

    private JToggleButton b1, b2, b3, b4;

    public static void main(String[] args) {

        //Cria container e adiciona a ele elementos de interface
        PainelAtivadorDeBotoes painel = new PainelAtivadorDeBotoes();

        // OBJETO JANELA
        JFrame frame = new JFrame("BOTOES TOOGLE");

        // PAINEL PRINCIPAL PARA CONTER TUDO DENTRO
        JPanel p = new JPanel();

        // FUNCAO COM COMPONENTS EXTERNOS
        Component btnC = painel.btnComponents();

        /// ADICIONA MARGENS AO LADO EXTERNO
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ADICIONA OS COMPONENTE NO PAINEL
        p.add(btnC);

        /// ADICIONA OS OS CONTEUDOS DE UM OBJETO NO FRAME
        frame.getContentPane().add(p, BorderLayout.CENTER);

        // SIZE É O TAMANHO, PACK COMPRIME OS OBEJTOS PROXIMOS UM DOS OUTROS
        //frame.setSize(350, 250);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Component btnComponents() {
        // PAINEL PRINCIPAL
        JPanel pane = new JPanel();

        // BOTÕES
        b1 = new JToggleButton("ToggleButton 1");
        b2 = new JToggleButton("ToggleButton 2");
        b3 = new JToggleButton("ToggleButton 3");
        b4 = new JToggleButton("ToggleButton 3");

        // Adiciona o listener aos botoes
        b1.addItemListener(this);
        b2.addItemListener(this);
        b3.addItemListener(this);
        b4.addItemListener(this);

        pane.setLayout(new GridLayout(1, 3));
        pane.setBorder(BorderFactory.createEtchedBorder());
        pane.add(b1);
        pane.add(b2);
        pane.add(b3);
        pane.add(b4);
        return pane;
    }

    public void itemStateChanged(ItemEvent e) {
        JToggleButton button = (JToggleButton) e.getSource();
        if (b1 != button) {
            b1.setSelected(false);
        }
        if (b2 != button) {
            b2.setSelected(false);
        }
        if (b3 != button) {
            b3.setSelected(false);
        }
        if (b4 != button) {
            b4.setSelected(false);
        }

    }
}
