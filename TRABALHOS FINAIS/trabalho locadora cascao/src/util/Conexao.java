package util;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexao {
    
    public static Connection getConexao(){
       try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection c = DriverManager.getConnection("jdbc:mysql://localhost/Locadora", "root", "rac" );
           return c;
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco");
           e.printStackTrace();
           return null;
       }
 }
    public static void main(String[] args){
        if(Conexao.getConexao() == null){
           JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco.");
        }
          else JOptionPane.showMessageDialog(null, "Deu Certo.");
        
        
           
        
    }
    
}
