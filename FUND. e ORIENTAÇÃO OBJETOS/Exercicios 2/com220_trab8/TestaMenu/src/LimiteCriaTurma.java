
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class LimiteCriaTurma extends JFrame implements ActionListener {

    ControleTurma ctrTurma;
    JComboBox comboTurma;
    JTextField matricAluno;
    ArrayList<Estudante> listaEstudMatric = new ArrayList<>();

    public LimiteCriaTurma(ControleTurma pCtrTurma) {
        super("Criação de turmas");
        ctrTurma = pCtrTurma;
        comboTurma = new JComboBox();
        ArrayList<Disciplina> l = ctrTurma.getCtrPrincipal().getCtrDisciplina().getListaDisciplina();
        for (Disciplina d : l) {
            comboTurma.addItem(d.getCodigo() + " - " + d.getNome());
        }
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(new JLabel("Escolha a disciplina: "));
        p1.add(comboTurma);
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(new JLabel("Digite o nro de matrícula: "));
        matricAluno = new JTextField(5);
        matricAluno.addActionListener(this);
        p2.add(matricAluno);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(p1);
        p.add(p2);
        this.add(p);
        //this.pack();
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (matricAluno.getText().equalsIgnoreCase("0")) {
            if (listaEstudMatric.size() > 0) {
                Disciplina d = getDiscip(comboTurma.getSelectedItem().toString());
                ctrTurma.addTurma(d, listaEstudMatric);
                JOptionPane.showMessageDialog(this, "Turma criada com sucesso");
            }
            this.dispose();
        } else {
            Estudante est = validaMatric(Integer.parseInt(matricAluno.getText()));
            if (est != null) {
                listaEstudMatric.add(est);
                matricAluno.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Número de matrícula inválido");
                matricAluno.setText("");
            }
        }
    }

    private Estudante validaMatric(int nroMatric) {
        return ctrTurma.getCtrPrincipal().getCtrEstudante().getEstudante(nroMatric);
    }

    private Disciplina getDiscip(String discip) {        
        return ctrTurma.getCtrPrincipal().getCtrDisciplina().getDisciplina(Integer.parseInt(discip.substring(0, 3)));
    }
}
