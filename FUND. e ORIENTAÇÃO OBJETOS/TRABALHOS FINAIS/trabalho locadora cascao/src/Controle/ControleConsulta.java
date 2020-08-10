/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidade.Dvd;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import util.Conexao;

/**
 *
 * @author cascao
 */
public class ControleConsulta {
    private Connection conexao;
    private PreparedStatement psmt;
    
    public Vector getComboBox() {
        String str="Select distinct Genero from DVD";
        Vector vet = new Vector();
        
        try{ 
            conexao = Conexao.getConexao();
        psmt = (PreparedStatement) conexao.prepareStatement(str);
        ResultSet rs = psmt.executeQuery();
        while(rs.next()){
            vet.add(rs.getString("Genero"));
        
        
        }
        return vet;
        
        
        }catch (Exception excep){
            excep.printStackTrace();
            return null;
        }
        
        
    }

    public String getConsDvd(String pGenero) {
        String strDvds="";
        String str="Select * from DVD where Genero = ?";
        Vector vecDvd = new Vector();
        Dvd dvd;
        
        
        try{ 
            conexao = Conexao.getConexao();
        psmt = (PreparedStatement) conexao.prepareStatement(str);
        psmt.setString(1, pGenero);
        ResultSet rs = psmt.executeQuery();
        while(rs.next()){
            dvd = new Dvd();
            dvd.setCodigoDvd(rs.getInt("Codigo"));
            dvd.setTitulo(rs.getString("Titulo"));
            dvd.setGenero(rs.getString("Genero"));
            dvd.setAno(rs.getInt("Ano"));
            vecDvd.add(dvd);
        
        
        }
        for(int i=0; i< vecDvd.size();i++){
            Dvd auxDvd= (Dvd) vecDvd.get(i);
            strDvds += "Código: "+ auxDvd.getCodigoDvd()+"\t\tTitulo: "+ auxDvd.getTitulo()
                    +"\nGenero: "+ auxDvd.getGenero()+"\tAno: "+auxDvd.getAno()+"\n\n";
            
        }
        return strDvds;
        }catch (Exception excep){
            excep.printStackTrace();
            return null;
        }
        
        
    }
    
}
