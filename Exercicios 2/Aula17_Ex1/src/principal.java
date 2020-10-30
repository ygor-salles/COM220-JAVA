
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;

public class principal extends JFrame implements ActionListener {

    public principal(String titulo) {
        super(titulo);
        JPanel p = new JPanel();
        //p.add(new JLabel("Vamos jogar?"));
        //this.add(p);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String args[]) {
        principal j = new principal("Par ou impar");

        int r = (int) (Math.random() * 10);

        Object[] options = {"PAR", "IMPAR"};
        int opUser = JOptionPane.showOptionDialog(null,
                "Par ou Ímpar?",
                "Jogo do para ou ímpar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);


        int escolha = Integer.parseInt(JOptionPane.showInputDialog(j, "Digite sua jogada: "));
        String frase = "";
        
        int soma = escolha + r;

        if(soma%2 == 0){
            if(opUser == 0){
                frase = "Voce venceu. \nVoce: "+escolha+"\nEle: "+r+"Soma: ";
            }else{
                frase = "Voce perdeu. \nVoce: "+escolha+"\nEle: "+r+"Soma: ";
            }
        }else{
            if(opUser == 0){
                frase = "Voce perdeu. \nVoce: "+escolha+"\nEle: "+r+"Soma: ";
            }else{
                frase = "Voce venceu. \nVoce: "+escolha+"\nEle: "+r+"Soma: ";
            }
            
        }
        JOptionPane.showMessageDialog(j, frase+soma);

    }

}
