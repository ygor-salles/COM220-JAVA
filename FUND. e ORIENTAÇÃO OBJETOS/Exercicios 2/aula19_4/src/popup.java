
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class popup extends JFrame implements MouseListener {

    public popup() {
        super("Pop up");

        addMouseListener(this);
        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        popup p = new popup();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != 1) {

            JPopupMenu popmenu = new JPopupMenu("Popup");

            JMenuItem it1 = new JMenuItem("Item 01");
            it1.setMnemonic(KeyEvent.VK_A);
            popmenu.add(it1);

            JMenuItem it2 = new JMenuItem("Item 02");
            it2.setMnemonic(KeyEvent.VK_S);
            popmenu.add(it2);

            JMenuItem it3 = new JMenuItem("Item 03");
            it3.setMnemonic(KeyEvent.VK_D);
            popmenu.add(it3);

            popmenu.show(this, e.getX(), e.getY());
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
