package view;

import controller.ControlePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bruno
 */
public class LimitePrincipal extends JFrame{
    private ControlePrincipal objControlador;
    private JMenuBar barraMenu;
    private JMenu menu,exibirFicha, exibirOrcamento;
    private JMenuItem adicionarSessao, cadastrarPacConv, cadastrarPacPart,nm,r,sair;

    public LimitePrincipal(ControlePrincipal pControle) {
        objControlador = pControle;

        //Criar objetos do tipo JMenuItem
        cadastrarPacConv = new JMenuItem("Cadastrar professor");
        cadastrarPacConv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceCadProf();
            }
        });
        
        cadastrarPacPart = new JMenuItem("Cadastrar turma");
        cadastrarPacPart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceCadTurma();
            }
        });
        
        exibirFicha = new JMenu("Matricular aluno");
        JMenuItem nm = new JMenuItem("Nova Matricula");
        exibirFicha.add(nm);
        nm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceNovaMat();
            }
        });
        
        JMenuItem r = new JMenuItem("Rematricula");
        exibirFicha.add(r);
        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceRematricula();
            }
        });
        
        
        adicionarSessao = new JMenuItem("Lançar notas");
        adicionarSessao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceNota();
            }
        });
        
        exibirOrcamento = new JMenu("Emitir");
        JMenuItem h = new JMenuItem("Histórico");
        exibirOrcamento.add(h);
        h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceHistorico();
            }
        });
        
         JMenuItem rc = new JMenuItem("Relatório de Concluinte");
        exibirOrcamento.add(rc);
        rc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceConcluintes();
            }
        });
        
        JMenuItem rt = new JMenuItem("Relatório de Turma");
        exibirOrcamento.add(rt);
        rt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objControlador.interfaceRelatorioTurma();
            }
        });
        
        sair = new JMenuItem("Sair");
        
        sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                JOptionPane.showMessageDialog(null, "Salvando dados...");  
                objControlador.finalize();
                   
            }
        });

        //Criar JMenu
        menu = new JMenu("Menu de gerencimento");

        //Criar JMenuBar
        barraMenu = new JMenuBar();

        //Adicionar componentes ao JMenu
        menu.add(cadastrarPacConv);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(cadastrarPacPart);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirFicha);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(adicionarSessao);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(exibirOrcamento);
        menu.add(new JSeparator(JSeparator.HORIZONTAL));
        menu.add(sair);

        //Adicionar menu a barra de menu
        barraMenu.add(menu);

        super.setTitle("Easy English");
        super.setJMenuBar(barraMenu);
        super.setSize(600, 400);
//        super.setLocationRelativeTo(null);
        super.setAlwaysOnTop(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        super.setVisible(true);
    }
}
