package clinica;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jean
 */
public class FrameFaturamento extends JFrame implements ActionListener {

    private controlePaciente controle;
    private JPanel painel, p1, p2, p3, p4, p5;
    private JLabel mesJL, convJL, partJL, totalJL, orcamentoJL;
    private JTextField mesTF, convTF, partTF, totalTF;
    private JButton calcular;

    public FrameFaturamento(controlePaciente pControle) {
        controle = pControle;

        //Criar objetos do tipo Jlabel
        mesJL = new JLabel("Mês de referência :");
        convJL = new JLabel("Pacientes sob convênio :");
        partJL = new JLabel("Pacientes particulares :");
        totalJL = new JLabel("Total arrecadado :");
        orcamentoJL = new JLabel(":::. Orçamento gerado na clínica .:::");

        //Criar objetos do tipo JTextField
        mesTF = new JTextField(5);
        convTF = new JTextField(9);
        convTF.setEditable(false);
        convTF.setText("R$ 00.00");
        partTF = new JTextField(9);
        partTF.setEditable(false);
        partTF.setText("R$ 00.00");
        totalTF = new JTextField(13);
        totalTF.setEditable(false);
        totalTF.setText("R$ 00.00");

        //Criar JButton e adicionar Listener a ele
        calcular = new JButton("Calcular orçamento");
        calcular.addActionListener(this);

        //Criar JPanel's
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p5 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        //Adicionar componentes aos paineis
        p1.add(mesJL);
        p1.add(mesTF);
        p1.add(calcular);
        p2.add(convJL);
        p2.add(convTF);
        p3.add(partJL);
        p3.add(partTF);
        p4.add(totalJL);
        p4.add(totalTF);
        p5.add(orcamentoJL);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(Box.createVerticalGlue());
        painel.add(p5);
        painel.add(Box.createVerticalGlue());
        painel.add(p1);
        painel.add(p2);
        painel.add(p3);
        painel.add(p4);
        painel.add(Box.createVerticalGlue());
        painel.add(Box.createVerticalGlue());

        add(painel);
        setSize(700, 400);
        setAlwaysOnTop(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double pConvenio, pParticular, total;
        int pMes;
        String mesRef;

        mesRef = mesTF.getText();

        if (mesRef.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você não informou um mês de referência!");
        } else {
            pMes = Integer.parseInt(mesRef);
            pConvenio = controle.calculoFaturamento(pMes);
            pParticular = controle.calculoFaturamento(pMes);
            total = pConvenio + pParticular;

            convTF.setText("R$" + pConvenio);
            partTF.setText("R$" + pParticular);
            totalTF.setText("R$" + total);
        }
    }
}
