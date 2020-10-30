
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import static javafx.scene.input.DataFormat.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class navegador extends JFrame implements ActionListener{

    JPanel header;
    JPanel footer;
    JTextField text;
    JButton button;
    JEditorPane editor;
    JLabel label;
    URL url;

    public navegador() {
        super("Internet Explorer 5.5");
        
        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        text = new JTextField(50);
        text.setText("http://");
        button = new JButton("Entrar");
        button.addActionListener(this);
        editor = new JEditorPane();
        label = new JLabel("Navegador");
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        header = new JPanel();
        footer = new JPanel();

        header.add(text);
        header.add(button);
        header.setBackground(Color.CYAN);

        container.add(header, BorderLayout.PAGE_START);
        container.add(editor, BorderLayout.CENTER);
        container.add(label, BorderLayout.PAGE_END);

        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        navegador n = new navegador();
    }

    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == button){
            try{
                url = new URL(text.getText());
            } catch(MalformedURLException e1){
                label.setText("Endereço da WEB mal formada");
                e1.printStackTrace();
            }
            try{
                editor.setPage(url);
            }catch(IOException e1){
                label.setText(null);
                label.setText("Erro ao abrir página");
                e1.printStackTrace();
            }
        }
    }

}
