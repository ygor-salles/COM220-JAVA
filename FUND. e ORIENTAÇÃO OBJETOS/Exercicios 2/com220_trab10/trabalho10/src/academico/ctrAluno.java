package academico;

import java.awt.event.*;
import java.io.*;
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean
 */
public class ctrAluno{

    private limiteAluno limite;
    private ArrayList<aluno> alunos;

    public ctrAluno() throws Exception{
        alunos = new ArrayList<aluno>();
        loadDados();
        limite = new limiteAluno(this);
    }

    public void addAluno(String pNome, String pNroMatricula, int dia, int mes, int ano) throws Exception {
        alunos.add(new aluno(pNome, pNroMatricula, dia, mes, ano));
    }
    
    public String getDadosAlunos(){
        String txt = "";
        
        for(aluno a: alunos){
            txt += "Nome: "+a.getNome()+" Matricula: " + a.getNroMatricula()+"Data de Nasc." + a.getDataNasc().getDate() +"/" + a.getDataNasc().getMonth()+"/"  + a.getDataNasc().getYear()+"\n";
        }
        
        return txt;
    }
    
    public void saveDados() throws Exception
    {
        FileOutputStream fileOs = new FileOutputStream("alunos.dat");
        ObjectOutputStream objOs = new ObjectOutputStream(fileOs);
        objOs.writeObject(alunos);
        objOs.flush();
        objOs.close();
    }
    
    public void loadDados() throws Exception
    {
        File arquivo = new File("alunos.dat");
        
        if(arquivo.exists()){
            FileInputStream fileIs = new FileInputStream(arquivo);
            ObjectInputStream objIs = new ObjectInputStream(fileIs);
            alunos = (ArrayList<aluno>) objIs.readObject();
            objIs.close();
        }
    }
    
    public static void main(String args[]) {
        ctrAluno app;
        try{
            app = new ctrAluno();
        }catch(Exception exp){
                JOptionPane.showMessageDialog(null, "Não foi possivel carregar o arquivo!");
        }       
        
    }


}
