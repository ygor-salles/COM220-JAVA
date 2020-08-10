
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LimiteImprimeTurma extends JFrame implements ActionListener {

    ControleTurma ctrTurma;

    JTextField codDisc;
    JTextArea textArea;

    public LimiteImprimeTurma(ControleTurma pCtrTurma) {
        super("Impressão de Turmas");
        ctrTurma = pCtrTurma;

        // CAMPO DISCIPLINA
        JPanel frame = new JPanel();
        codDisc = new JTextField(10);
        codDisc.addActionListener(this);

        frame.add(new JLabel("Digite  o Código da disciplina:"));
        frame.add(codDisc);

        // JANELA DA DISCIPLINA
        textArea = new JTextArea(25, 30);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        //textArea.setBackground(Color.LIGHT_GRAY);

        this.setLayout(new FlowLayout());
        this.add(frame);
        this.add(textArea);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        textArea.setText("");
        if (ctrTurma.getCtrPrincipal().getCtrDisciplina().getDisciplina(Integer.parseInt(codDisc.getText())) != null) {
            ArrayList<Turma> listaTurma = ctrTurma.getListaTurma();
            ArrayList<Estudante> listaEstudantes;
            String lista = "Matricula\tNome\n";

            for (Turma t : listaTurma) {
                if (t.getDisc().getCodigo() == Integer.parseInt(codDisc.getText())) {
                    listaEstudantes = t.getListaEstudantes();
                    for (Estudante e : listaEstudantes) {
                        lista += e.getNroMatric() + "\t" + e.getNome() + "\n";
                    }
                    break;
                }
            }

            textArea.append(lista);
        } else {
            System.out.println("Não Existe");
        }
    }

}
