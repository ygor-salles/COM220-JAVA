
import java.io.*;
import java.util.*;

// CLASSE PRINCIPAL PARA EXECUÇÃO DO CÓDIGO
public class Professores {

    public static void main(String[] args) {

        String text = "";
        ArrayList<Professor> cadProfs = new ArrayList<Professor>();

        cadProfs.add(new ProfHorista("Antonio", 1200, 32, 234.5));
        cadProfs.add(new ProfDE("Marcia", 1201, 64, 1200));
        cadProfs.add(new ProfDE("Juliana", 1202, 18, 11000));
        cadProfs.add(new ProfHorista("Wallace", 1203, 20, 157.50));
        cadProfs.add(new ProfDE("Marcos", 1204, 32, 16000));
        cadProfs.add(new ProfHorista("Jessica", 1205, 32, 177.50)) ;  
        cadProfs.add(new ProfHorista("Jean", 1206, 56, 210.50));
        
        // IMPRIMIR OS NOMES DE TODOS OS PROFESSORES
        text = "\t |NOMES DOS PROFESSORES: \n\t\t";
        for(Professor temp : cadProfs){
                text+= (temp.getNome()+", ");
        }
       
        System.out.println(text);
        
        // IMPRIMIR SALARIO/HORA DOS PROFESSORES HORISTAS
        text = "\n\t |SALARIO/HORA DOS PROFESSORES HORISTAS:\n";
        for(Professor temp : cadProfs){
            if(temp instanceof ProfHorista){
                text+= "\t\t- "+temp.getNome()+"\n\t\t\tSalário: "+((ProfHorista)temp).getSalario()+"\n";
            }
        }
        
        System.out.println(text);
                
        // IMPRIMIR SALARIO/HORA DOS PROFESSORES HORISTAS
        text = "\n\t |SALARIO/HORA DOS PROFESSORES HORISTAS:\n";
        for(Professor temp : cadProfs){
            if(temp instanceof ProfHorista){
                text+= "\t\t- "+temp.getNome()+"\n\t\t\tSalário: "+((ProfHorista)temp).getSalario()+"\n";
            }
        }
        
        System.out.println(text);
        
        // SALÁRIO MENSASAL DOS PROFESSORES DE
        text = "\n\t |SALÁRIO MENSAL DOS PROFESSORES\n";
        for(Professor temp : cadProfs){
            if(temp instanceof ProfDE){
                text+= "\t\t- "+temp.getNome()+"\n\t\t\tSalário Menssal: "+((ProfDE)temp).getSalario()+"\n";
            }
        }
        
        System.out.println(text);
    }
}
