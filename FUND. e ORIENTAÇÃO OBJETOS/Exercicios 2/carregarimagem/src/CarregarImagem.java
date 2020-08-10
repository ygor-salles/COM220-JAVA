
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class CarregarImagem implements MouseListener {

    JLabel lbl1;

    public static void main(String[] args) {
        CarregarImagem imagem = new CarregarImagem();

        //Cria container e adiciona a ele elementos de interface.
        JFrame frame = new JFrame("Imagem e Mouse");
        JPanel p = new JPanel();

        // FUNCAO COM COMPONENTS EXTERNOS
        Component img = imagem.imagem();

        p.add(img);
        frame.getContentPane().add(p, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    Component imagem() {
        JPanel pane = new JPanel();

        // Cria um objeto contendo a imagem indicada
        ImageIcon icon = new ImageIcon("carlton_banks.gif");
        // Cria o primeiro rótulo, setando o texto e o alinhamento
        
        lbl1 = new JLabel("Posição do mouse:", JLabel.CENTER);
        lbl1.setIcon(icon); //Seta o ícone
        // Ajusta a posição do texto em relação ao ícone
        lbl1.setVerticalTextPosition(JLabel.BOTTOM);
        lbl1.setHorizontalTextPosition(JLabel.CENTER);
        lbl1.addMouseListener(this);
        pane.add(lbl1);
        return pane;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == lbl1){
            lbl1.setText("Posição do mouse: X:"+ me.getX()+" Y:"+me.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
