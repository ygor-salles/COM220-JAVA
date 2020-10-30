
import java.awt.BorderLayout;
import javax.swing.*;

public class run extends JFrame {

    public run() {
// Cria os painéis e seta os layouts
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.X_AXIS));
        p1.setAlignmentX(0.5f);
        JPanel p2 = new JPanel();
        p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
        p2.setAlignmentX(0.5f);
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.X_AXIS));
        p3.setAlignmentX(0.5f);
        
        JButton b10 = new JButton(" TOP LEFT");
        b10.setAlignmentX(0.0f);
        JButton b11 = new JButton(" TOP ");
        b11.setAlignmentX(0.5f);
        JButton b12 = new JButton(" TOP RIGHT ");
        b12.setAlignmentX(5.0f);

        JButton b20 = new JButton("BOTTOM LEFT");
        b20.setAlignmentY(0.5f);
        JButton b21 = new JButton("BOTTOM");
        b21.setAlignmentY(0.5f);
        JButton b22 = new JButton("BOTTOM RIGHT");
        b22.setAlignmentY(0.5f);
        
        JButton b3 = new JButton(" LEFT ");
        b3.setAlignmentY(0.5f);
        JButton b4 = new JButton("CENTER");
        b4.setAlignmentY(0.5f);
        JButton b5 = new JButton("RIGHT");
        b5.setAlignmentY(0.5f);


        p1.add(b10);
        p1.add(Box.createHorizontalGlue());
        p1.add(b11);
        p1.add(Box.createHorizontalGlue());
        p1.add(b12);

        p2.add(b3);
        p2.add(Box.createHorizontalGlue());
        p2.add(b4);
        p2.add(Box.createHorizontalGlue());
        p2.add(b5);
        
        p3.add(b20);
        p3.add(Box.createHorizontalGlue());
        p3.add(b21);
        p3.add(Box.createHorizontalGlue());
        p3.add(b22);
        
        container.add(p1);
        container.add(Box.createVerticalGlue());
        container.add(p2);
        container.add(Box.createVerticalGlue());
        container.add(p3);
        
        // Inicializa o frame
        add(container);
        setSize(300, 170);
        setTitle("BoxLayoutDemo");
        setVisible(true);

        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        run r = new run();
    }
}
