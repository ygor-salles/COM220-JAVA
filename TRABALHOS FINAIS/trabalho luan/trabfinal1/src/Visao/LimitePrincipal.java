/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControlePrincipal;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Luan
 */
public class LimitePrincipal extends JFrame implements ActionListener{
    private ControlePrincipal objP;

    
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton bSalva;
    private JButton bCancela;
    private JButton bmenu;
    
    private JPanel jMenu;
   private JLabel t1=new JLabel(" Menu Principal:"+"\n");
   
   private JFrame mInsere, mConsulta,jEmprestimo;
    private JLabel lCodigo;
    private JLabel lautor;
    private JLabel lTitulo;
    private JLabel leditora;
    private JLabel lnropaginas;
    private JLabel lcategoria;
    private JTextField codigo;
    private JTextField titulo;
    private JTextField autor;
    private JTextField editora;
    private JTextField nropaginas;
    private JTextField categoria;
    private SpringLayout l1;
    
    private JComboBox combBox;
    private ConsultaAcervo j1;
   public LimitePrincipal() {
       objP= new ControlePrincipal();
        setSize(300,200);
        b1 = new JButton("Inserir publicação");
        b1.addActionListener(this);
        b2 = new JButton("Consultar acervo");
        b2.addActionListener(this);
        b3 = new JButton("Empréstimo de livros");
        b3.addActionListener(this);
        b4 = new JButton("Sair");
        b4.addActionListener(this);
        bSalva=new JButton("Salvar");
        bSalva.addActionListener(this);
        bCancela=new JButton("Cancela");
        bCancela.addActionListener(this);
        bmenu=new JButton("Home");
        bmenu.addActionListener(this);
        
        jMenu = new JPanel();
        jMenu.setLayout(new GridLayout(3,1));
        
        jMenu.add(b1);
        jMenu.add(b2);
        jMenu.add(b3);
        jMenu.add(b4);
        
        this.setLayout(new BorderLayout());
      this.add(t1,BorderLayout.BEFORE_FIRST_LINE);
        this.add(jMenu,BorderLayout.CENTER);
        this.setTitle("Sistema Gerenciamento Biblioteca");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }
   
   public void menuInsere(){
       mInsere=new JFrame();
         mInsere.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel p1 = new JPanel(new SpringLayout());
        lCodigo = new JLabel("Codigo");
        lautor = new JLabel("Autor");
        lTitulo = new JLabel("Título");
        leditora = new JLabel("Editora");
        lnropaginas = new JLabel("Nro Páginas");
        lcategoria= new JLabel("Categoria");
        
        codigo = new JTextField(12);
        titulo= new JTextField(12);
        autor= new JTextField(12);
        editora= new JTextField(12);
        nropaginas= new JTextField(12);
        categoria= new JTextField(12);
       
        p1.add(lCodigo);
        p1.add(codigo);
        p1.add(lTitulo);
        p1.add(titulo);
        p1.add(leditora);
        p1.add(editora);
        p1.add(lautor);
        p1.add(autor);
        p1.add(lnropaginas);
        p1.add(nropaginas);
        p1.add(lcategoria);
        p1.add(categoria);
        p1.add(bSalva);
        p1.add(bCancela);
        p1.add(bmenu);
        l1= new SpringLayout();
        l1.putConstraint(SpringLayout.NORTH, lCodigo, 15, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lCodigo, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, codigo, 15, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, codigo, 20, SpringLayout.EAST, lCodigo);

        l1.putConstraint(SpringLayout.NORTH, lTitulo, 50, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lTitulo, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, titulo, 50, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, titulo, 20, SpringLayout.EAST, lTitulo);

        l1.putConstraint(SpringLayout.NORTH,leditora, 85, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, leditora, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, editora, 85, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, editora, 20, SpringLayout.EAST, leditora);
      
        l1.putConstraint(SpringLayout.NORTH, lautor, 115, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lautor, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, autor, 115, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, autor, 20, SpringLayout.EAST, lautor);
    
        l1.putConstraint(SpringLayout.NORTH, lnropaginas, 150, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lnropaginas, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, nropaginas, 150, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, nropaginas, 20, SpringLayout.EAST, lnropaginas);
        
        l1.putConstraint(SpringLayout.NORTH, lcategoria, 185, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, lcategoria, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, categoria, 185, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, categoria, 20, SpringLayout.EAST, lcategoria);
        
        l1.putConstraint(SpringLayout.NORTH, bSalva, 220, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, bSalva, 15, SpringLayout.WEST, p1);
        l1.putConstraint(SpringLayout.NORTH, bCancela, 220, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, bCancela, 20, SpringLayout.EAST, bSalva);
        l1.putConstraint(SpringLayout.NORTH, bmenu, 220, SpringLayout.NORTH, p1);
        l1.putConstraint(SpringLayout.WEST, bmenu, 20, SpringLayout.EAST, bCancela);
              
        p1.setLayout(l1);
        mInsere.setLocationRelativeTo(null);
        mInsere.setTitle("Formulário");
        mInsere.add(p1);
        pack();
        mInsere.setSize(300, 350);
        mInsere.setVisible(true);
   }
    
   
   public void consultaAcervo (){
       Vector categorias=objP.montaForm();
       combBox=new JComboBox();
       for(int i=0;i<categorias.size();i++){
       combBox.addItem(categorias.elementAt(i).toString());
       }
       j1=new ConsultaAcervo(combBox);  //84037338
       
       
       
       
   }
   
   public void emprestimo(){
       jEmprestimo=new Emprestimo();
   }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(((JButton) e.getSource()).getText().equalsIgnoreCase(b1.getText())){
            System.out.println("B1");
            this.setVisible(false);
             menuInsere();
    }else if(((JButton) e.getSource()).getText().equalsIgnoreCase(b2.getText())){
       System.out.println("B2");
        consultaAcervo();
    
        
    }
       else if(((JButton) e.getSource()).getText().equalsIgnoreCase(bSalva.getText())){
            System.out.println("BSalva");
            objP.setCategoria(categoria.getText());
            objP.setCodigo(Integer.parseInt(codigo.getText()));
            objP.setAutor(autor.getText());
            objP.setEditora(editora.getText());
            objP.setNroPaginas(Integer.parseInt(nropaginas.getText()));
            objP.setTitulo(titulo.getText());
            int ret=objP.inserePublicacao();
            if(ret==0){
                JOptionPane.showMessageDialog(null, "Livro Cadastrado!");
            }
            else{
                switch (ret){
                    case 1062: //Violação chave primária
                        JOptionPane.showMessageDialog(null, "Já existe um livro cadastrado neste código");
                        break;
                    case 1216:
                    case 1217:
                    case 1451:
                    case 1452: //Violação chave estrangeira
                        JOptionPane.showMessageDialog(null, "Erro de chave estrangeira");
                        break;
                    case 1064: //Campos em branco
                        JOptionPane.showMessageDialog(null, "Não é permitido deixar campos em branco");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Oooops! Erro inesperado");
                }
            objP.setCategoria("");
            objP.setCodigo(0);
            objP.setEditora("");
            objP.setNroPaginas(0);
            objP.setTitulo("");
            }
           
            mInsere.setVisible(false);
            this.setVisible(true);
            
        }
          else if(((JButton) e.getSource()).getText().equalsIgnoreCase(bCancela.getText())){
            System.out.println("Cancela");
            JOptionPane.showMessageDialog(null, "Cadastro Não Efetuado");
             objP.setCategoria("");
            objP.setCodigo(0);
            objP.setEditora("");
            objP.setNroPaginas(0);
            objP.setTitulo("");
            mInsere.setVisible(false);
             this.setVisible(true);
        }
          else if(((JButton) e.getSource()).getText().equalsIgnoreCase(bmenu.getText())){
            System.out.println("Home");
             mInsere.setVisible(false);
            this.setVisible(true);
          
          }
          else if(((JButton) e.getSource()).getText().equalsIgnoreCase(b3.getText())){
              System.out.println("Empréstimo");
              emprestimo();
          }
        else{
            System.out.println("Sair");
            System.exit(0);
        }
    
    
}

   
}
