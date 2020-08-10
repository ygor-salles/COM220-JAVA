
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class calculadora extends JFrame implements ActionListener {

    JTextField visor;

    JPanel container;
    JPanel tecladoP;
    JPanel visorP;
    
    JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btMult, btDiv, btSom, btSub, btCls, btIgual;
 
    int result;
    boolean flag; // ele diita se é a vez do sinal ou do nuemro para nao ter repetição de sinal ou de numero
    ArrayList<Integer> valores;
    ArrayList<String> sinais;

    public calculadora() {
        super("Calculadora");
        
        result  = 0;
        flag    = false;
        valores = new ArrayList<Integer>();
        sinais = new ArrayList<String>();

        container = new JPanel();
        visorP = new JPanel();

        container.setLayout(new GridLayout(2, 0));
        visorP.setLayout(new GridLayout(1, 1));

        visor = new JTextField();
        visor.setEditable(false);
        visor.setPreferredSize(new Dimension(270, 50));
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setBackground(Color.white);
        visorP.add(visor);

        tecladoP = new JPanel();
        tecladoP.setLayout(new GridLayout(4, 5));
        tecladoP.add(bt7 = new JButton("7"));
        tecladoP.add(bt8 = new JButton("8"));
        tecladoP.add(bt9 = new JButton("9"));
        tecladoP.add(btDiv = new JButton("/"));
        tecladoP.add(bt4 = new JButton("4"));
        tecladoP.add(bt5 = new JButton("5"));
        tecladoP.add(bt6 = new JButton("6"));
        tecladoP.add(btMult = new JButton("*"));
        tecladoP.add(bt3 = new JButton("3"));
        tecladoP.add(bt2 = new JButton("2"));
        tecladoP.add(bt1 = new JButton("1"));
        tecladoP.add(btSub = new JButton("-"));
        tecladoP.add(btCls = new JButton("CE"));
        tecladoP.add(bt0 = new JButton("0"));
        tecladoP.add(btSom = new JButton("+"));
        tecladoP.add(btIgual = new JButton("="));
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);
        bt0.addActionListener(this);
        btMult.addActionListener(this);
        btDiv.addActionListener(this);
        btSom.addActionListener(this);
        btSub.addActionListener(this);
        btCls.addActionListener(this);
        btIgual.addActionListener(this);

        container.add(visorP);
        container.add(tecladoP);

        this.add(container);
        this.setSize(300, 250);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) {
        calculadora c = new calculadora();

    }

    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();

        if ((button.getText().equals("1") || button.getText().equals("2") || button.getText().equals("3")
                || button.getText().equals("4") || button.getText().equals("5") || button.getText().equals("6")                || button.getText().equals("7")
                || button.getText().equals("8") || button.getText().equals("9") || button.getText().equals("0"))& !flag){
            
            visor.setText(visor.getText()+ " " +button.getText());
            valores.add(Integer.parseInt(button.getText()));
            
            flag = true;
            
        }else if ((button.getText().equals("+") || button.getText().equals("*") 
                || button.getText().equals("-") || button.getText().equals("/")) & flag) {
           
            visor.setText(visor.getText()+ " " +button.getText());
            sinais.add(button.getText());
            
            flag = false;
            
        }else if (button.getText().equals("=") & flag) {
            System.out.println("=");
            sinais.add(button.getText());
            int num=0, result=0;
            String eq;
            
            for(int i=0; i < valores.size(); i++){
                
                if(i < valores.size())
                    num = valores.get(i);
                
                if(i != 0){
                    eq = sinais.get(i-1);
                    
                    if(eq == "+")
                        result += num;
                    else if(eq == "-")
                        result -= num;
                    else if(eq == "/")
                        result /= num;
                    else if(eq == "*")
                        result *= num;
                    else if(eq == "=")
                        break;
                }else{
                    result = num;
                }
            }
        
            valores.clear();
            sinais.clear();
            
            visor.setText(""+result);
            flag = false;
            
        }else if (button.getText().equals("CE")) {
            System.out.println("CE");
            valores.clear();
            sinais.clear();
            visor.setText("");
        }
    }
}
