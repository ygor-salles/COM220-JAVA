
/**
 *
 * @author Jean
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonApplication implements MouseListener {

    private static String rotulo = "Número de cliques: ";
    private int numClicks = 0;
    private JLabel label;

    public Component createComponents() {
        label = new JLabel(rotulo + "0 ");
        JButton button1 = new JButton("Clique aqui");
        //Adicionando listener ao botao
        button1.addMouseListener(this);
        label.setLabelFor(button1);
        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        pane.add(button1);
        pane.add(label);
        return pane;
    }

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getButton() == MouseEvent.BUTTON1) {
            //label.setText(rotulo+me.getClickCount());
            numClicks++;
        } else if(me.getButton() == MouseEvent.BUTTON3){
            numClicks--;
        }else if(me.getButton() == MouseEvent.BUTTON2){
            numClicks = 0;
        }

        label.setText(rotulo + numClicks);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("Precionou o botão do mouse");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("Soltou o botão do mouse");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("Entrou o botão do mouse");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("Saiu o botão do mouse");
    }

    public static void main(String[] args) {
//Cria container e adiciona a ele elementos de interface.
        JFrame frame = new JFrame("Primeira Aplicação Swing");
        ButtonApplication app = new ButtonApplication();
        Component conteudo = app.createComponents();
        frame.getContentPane().add(conteudo, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
