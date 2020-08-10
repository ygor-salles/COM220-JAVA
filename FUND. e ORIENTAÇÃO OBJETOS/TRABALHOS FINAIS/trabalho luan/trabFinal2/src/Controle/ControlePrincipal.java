/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Visao.LimitePrincipal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */
public class ControlePrincipal {

    private int CodDvd;
    private int CodCliente;
    private LimitePrincipal lPrinc;
    Statement stmt;
    private java.util.Date Ent;

    public ControlePrincipal() {

        String hostname, database, user, pass;
        hostname = "localhost";
        database = "locadora";
        user = "root";
        pass = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c;
            c = DriverManager.getConnection("jdbc:mysql://" + hostname + "/" + database, user, pass);
            stmt = c.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Aplicativo não conectado ao banco"
                    + " de dados.");
        }
    }

    public void run() {
        lPrinc = new LimitePrincipal();
    }

    public String buscaFilme(String genero) {

        String resultado = new String();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT *  FROM dvd WHERE genero = " + "'" + genero + "'" + ";");

            Vector vCod = new Vector();
            while (rs.next()) {
                vCod.add(rs.getInt(1));
                for (int i = 2; i < 4; i++) {
                    vCod.add(rs.getString(i));
                }
                vCod.add(rs.getInt(4));

            }
            Iterator i = vCod.iterator();

            while (i.hasNext()) {
                for (int n = 1; n < 5; n++) {
                    resultado += i.next() + " - ";
                }
                resultado += "\n";
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return resultado;



    }

    public Vector montaForm() throws SQLException {
        Vector novo = new Vector();
        ResultSet rs;

        rs = stmt.executeQuery("SELECT distinct genero FROM dvd;");
        if (!rs.next()) {
           throw new SQLException("Erro: nenhuma categoria encontrada");

        } else {
            do {
                novo.add(rs.getString(1));
            } while (rs.next());

        }



        return novo;
    }

    public void locaDvd() throws SQLException {
        ResultSet rs;
        rs = stmt.executeQuery("SELECT codigo FROM cliente where codigo=" + CodCliente + ";");
        if (rs.next()) {
            rs = stmt.executeQuery("SELECT codigo FROM dvd where codigo=" + CodDvd + ";");
            if (rs.next()) {
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                stmt.executeUpdate("INSERT INTO aluguel (CodDVD,CodCliente,DataRetirada)VALUES (" + CodDvd + "," + CodCliente + ",'" + sqlDate + "');");
               throw new SQLException("Cadastro Efetuado com Sucesso");
            }
        }
    }
    public float calcula(java.sql.Date sqlDRet,java.sql.Date sqlDEnt){
        float valor=5,meses=0,dias=0;
        if(sqlDRet.getMonth()!=sqlDEnt.getMonth()){
            if((sqlDEnt.getMonth()-sqlDRet.getMonth())<0){
                meses=(sqlDEnt.getMonth()-sqlDRet.getMonth()+12)*30;
            }else{
            meses=(sqlDEnt.getMonth()-sqlDRet.getMonth())*30;
            }
            }
        
            dias+=(sqlDEnt.getDay()-sqlDRet.getDay()+1);
        
        return valor=valor*(dias+meses);
         
    }
    public String entregaDvd()throws SQLException{
        ResultSet rs;
        float locacao=0;
        rs = stmt.executeQuery("SELECT * FROM ALUGUEL WHERE CodDVD ="+CodDvd+" AND DataDevolucao IS NULL;");
        if (rs.next()) {
            java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        locacao=calcula(rs.getDate(3),sqlDate);
        System.out.println(locacao+sqlDate.getTime());
        stmt.executeUpdate("UPDATE aluguel SET DataDevolucao='"+sqlDate.toString()+"',ValorLocacao='"+locacao+"'where CodDVD="+CodDvd+";");
        throw new SQLException("Entrega Realizada Com Sucesso");
        
        }
        
        
        return ""+locacao;
    }

    
    public String calcFat(java.sql.Date sqlDate)throws SQLException{
        float faturamento=0;
        System.out.println(sqlDate.toString());
        ResultSet rs=stmt.executeQuery("SELECT Valorlocacao  FROM aluguel WHERE DataDevolucao = '" +  sqlDate.toString() + "';");;
        
        if (!rs.next()) {
           throw new SQLException("Erro: nenhuma categoria encontrada");
        }
        else{
        
          while(rs.next()){
              faturamento+=rs.getFloat(1);
            
        }
        }
        return "R$ "+faturamento;
    }
    //-------------------geter------seter--------------------
    public int getCodDvd() {
        return CodDvd;
    }

    public void setCodDvd(int CodDvd) {
        this.CodDvd = CodDvd;
    }

    public int getCodCliente() {
        return CodCliente;
    }

    public void setCodCliente(int CodCliente) {
        this.CodCliente = CodCliente;
    }
}
