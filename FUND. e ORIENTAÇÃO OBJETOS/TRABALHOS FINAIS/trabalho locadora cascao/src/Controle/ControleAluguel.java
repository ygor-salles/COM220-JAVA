/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import util.Conexao;



/**
 *
 * @author cascao
 */
public class ControleAluguel implements ActionListener {

    private Connection conexao;
    private PreparedStatement psmt;

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    public boolean setAluguel(int pCodDvd, int pCodCliente) {
        String strAluguel = "insert into ALUGUEL (CodDVD, CodCliente, DataRetirada) values(?,?,?)";
        try {
            conexao = Conexao.getConexao();
            psmt = (PreparedStatement) conexao.prepareStatement(strAluguel);
            psmt.setInt(1, pCodDvd);
            psmt.setInt(2, pCodCliente);
            java.util.Date dataJava = new java.util.Date();
            java.sql.Date data = new java.sql.Date(dataJava.getTime());
            psmt.setDate(3, data);
            psmt.executeUpdate();
            conexao.close();
           
           



            return true;


        } catch (Exception excep) {
            excep.printStackTrace();
            return false;
        }

    }
}
