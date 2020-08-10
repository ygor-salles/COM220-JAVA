
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class lista extends JFrame implements ListSelectionListener {

    DefaultListModel listModel;
    JList lista;

    public lista() {
        super("Lista JList");

        // lista dinamica
        listModel = new DefaultListModel();
        listModel.addElement("Um");
        listModel.addElement("Dois");
        listModel.addElement("Tres");
        listModel.addElement("Quatro");
        listModel.addElement("Cinco");
        listModel.addElement("Seis");
        listModel.addElement("Sete");
        listModel.addElement("Oito");
        listModel.addElement("Nove");
        listModel.addElement("Dez");

        lista = new JList(listModel);
        lista.addListSelectionListener(this);

        this.add(lista);
        //this.setSize(300,200);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {

        lista l = new lista();
    }

    public void valueChanged(ListSelectionEvent lse) {
        // VERIFICA SE A LISTA FOI CLICADA
        if (lse.getValueIsAdjusting() == false) {
            // PEGA O VALOR DO INDEX CLICADO. DIFERENTE DE -1.
            if (lista.getSelectedIndex() != -1){
                int index = lista.getSelectedIndex(); // SALVA O INDEX CLICADO NUMA VARIVAVEL
                System.out.println("Numero " + index); // PRINT APENAS PARA VERIFICAR O VALOR DO INDEX
                listModel.removeElementAt(index); // REMOVE O ELEMENTO CORRESPONDENTE AO INDEX
            }
        }
    }

}
