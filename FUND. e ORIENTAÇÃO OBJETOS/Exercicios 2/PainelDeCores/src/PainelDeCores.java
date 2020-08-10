
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class PainelDeCores implements ActionListener {

    private JButton colorbtn;
    
    private JButton aplicar;
    private static JColorChooser color;
    private static JFrame frame;
    private static JFrame colors;
    private static JPanel p;

    public static void main(String[] args) {

        //Cria container e adiciona a ele elementos de interface
        PainelDeCores c = new PainelDeCores();

        // OBJETO JANELA
        JFrame frame = new JFrame("PAINEL DE CORES");
        // PAINEL PRINCIPAL PARA CONTER TUDO DENTRO
         p = new JPanel();

        // FUNCAO COM COMPONENTS EXTERNOS
        Component colorsC = c.mainComponents();

        /// ADICIONA MARGENS AO LADO EXTERNO
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // ADICIONA OS COMPONENTE NO PAINEL
        p.add(colorsC);

        /// ADICIONA OS OS CONTEUDOS DE UM OBJETO NO FRAME
        frame.getContentPane().add(p, BorderLayout.CENTER);

        // SIZE É O TAMANHO, PACK COMPRIME OS OBEJTOS PROXIMOS UM DOS OUTROS
        //frame.setSize(800, 600);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
        colors = new JFrame("CORES");
        Component cc = c.colorComponents();
        
        colors.getContentPane().add(cc, BorderLayout.CENTER);
        
        colors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colors.setVisible(false);
        colors.setSize(800, 600);
        

    }

    public Component mainComponents() {
        // PAINEL PRINCIPAL
        JPanel pane = new JPanel();

        /// CRIAÇÃO DO BOTÃO
        colorbtn = new JButton("Colorir");
        colorbtn.addActionListener(this);
        //pane.setLayout(new GridLayout(5, 1, 3, 3));
        pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pane.add(colorbtn);
        return pane;
    }

    public Component colorComponents(){
        JPanel pane = new JPanel();
        
        aplicar = new JButton("Aplicar Fundo");
        
        color = new JColorChooser();
        aplicar.addActionListener(this);
        pane.add(color);
        pane.add(aplicar);
        
        return pane;
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if (source == colorbtn) {
            if(colors.isVisible())
                colors.setVisible(false);
            else
                colors.setVisible(true);
        }
        
        if (source == aplicar){
            p.setBackground(color.getColor());
        }
    }
}
