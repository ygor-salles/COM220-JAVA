import java.io.*;
import java.lang.*;
import java.util.*;
import Disciplina.*;
import javax.swing.*;

public class testeVetorDisciplina {
    
    public static void main(String[] args){
        testeVetorDisciplina teste = new testeVetorDisciplina();
        
        teste.menu();
    }
    
    public void menu() {
        int escolha = 0;
        int codigo = 0;
        int cargaHoraria = 0;
        
        String escolhaInformada = "";
        String nome = "";
        
        VetorDisciplina objDisciplina = new VetorDisciplina();
        
        do {
            do {
                escolhaInformada = JOptionPane.showInputDialog(
                                "Escolha uma opção do menu:\n"
                                + "[1] Adiciona disciplina\n"
                                + "[2] Remove disciplina\n"
                                + "[3] Lista disciplinas\n"
                                + "[4] Finaliza");

                escolha = Integer.parseInt(escolhaInformada);
            } while ((escolha < 1) || (escolha > 4));

            switch (escolha) {

                case 1:
                    //Requisita o Código
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código: "));
                    //Requisita o Nome
                    nome = JOptionPane.showInputDialog("Informe o nome: ");
                    //Requisita a Carga Horária
                    cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe o carga horária"));

                    //Cria objeto disciplina 
                    objDisciplina.insereDisciplina(codigo, nome, cargaHoraria);
                    //inserir objDisciplina no vetor
                    break;
                case 2:
                    //Código para remoção de uma disciplina
                    nome = JOptionPane.showInputDialog("Informe o nome da disciplina a ser removida: ");
                    //Requisita a Carga Horária                    
                    objDisciplina.removeDisciplina(nome);
                    JOptionPane.showMessageDialog(null, nome+" Removido com sucesso");
                    break;
                case 3:
                    //Código para impressão da grade curricular
                    JTextArea textArea = new JTextArea();
                    textArea.setText(objDisciplina.toString());
                    JOptionPane.showMessageDialog(null, textArea,"Disciplinas Cadastradas", 1);                    
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}