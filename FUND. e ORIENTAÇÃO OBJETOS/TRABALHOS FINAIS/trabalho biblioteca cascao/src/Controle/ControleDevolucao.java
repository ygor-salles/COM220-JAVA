/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Entidade.Aluguel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.util.Date;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 *
 * @author cascao
 */
public class ControleDevolucao {

    private Connection conexao;
    private PreparedStatement psmt;

    public String getAluguelDvd(int pCodDvd) {
        long multa = 0;
        String str = "SELECT * FROM ALUGUEL WHERE CodDVD = ? AND DataDevolucao IS NULL";

        Aluguel aluguel;
        try {
            conexao = Conexao.getConexao();
            psmt = (PreparedStatement) conexao.prepareStatement(str);
            psmt.setInt(1, pCodDvd);

            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                aluguel = new Aluguel();
                aluguel.setCodCliente(rs.getInt("CodCliente"));
                aluguel.setCodDvd(rs.getInt("CodDVD"));
                aluguel.setDataRetirada(rs.getDate("DataRetirada"));

                java.util.Date dataJava = new java.util.Date();
                java.sql.Date data = new java.sql.Date(dataJava.getTime());


                aluguel.setDataDevolucao(data);

                multa = ((aluguel.getDataDevolucao()).getTime() - (aluguel.getDataRetirada()).getTime());
                int tempoDia = 1000 * 60 * 60 * 24;
                multa = (multa / tempoDia) * 5;
                if(multa == 0) multa = 5;
                aluguel.setValorDev(multa);
                if (setAluguelValor(aluguel)) {
                    JOptionPane.showMessageDialog(null, "Devolução realizada com sucesso");
                    String nomeClienteAluguel = getClienteAluga(aluguel.getCodCliente());
                    String strDev = "Cliente: "+ nomeClienteAluguel +"\nValor a ser pago: R$" + multa;
                    return strDev;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao efetuar a devolução");
                }

            }



            conexao.close();


        } catch (Exception excep) {
            excep.printStackTrace();
        }
        return "DVD não foi alugado";
    }

    public boolean setAluguelValor(Aluguel pAluguel) {
        String strAluguel = "update ALUGUEL set DataDevolucao = ?, ValorLocacao =? WHERE CodDvd = ? AND CodCliente = ?";

        java.util.Date dataDev = pAluguel.getDataDevolucao();
        java.sql.Date dataDevolucao = new java.sql.Date(dataDev.getTime());
        int codDvd = pAluguel.getCodDvd();
        int codCli = pAluguel.getCodCliente();
        float valorDev = pAluguel.getValorDev();
        try {
            conexao = Conexao.getConexao();
            psmt = (PreparedStatement) conexao.prepareStatement(strAluguel);
            psmt.setDate(1, dataDevolucao);
            psmt.setFloat(2, valorDev);
            psmt.setInt(3, codDvd);
            psmt.setInt(4, codCli);
            psmt.executeUpdate();
            conexao.close();





            return true;


        } catch (Exception excep) {
            excep.printStackTrace();
            return false;
        }

    }

    private String getClienteAluga(int codCliente) {
        String retorno = "";
        String str = "Select Nome from CLIENTE where Codigo = ?";
        try {
            conexao = Conexao.getConexao();
            psmt = (PreparedStatement) conexao.prepareStatement(str);
            psmt.setInt(1, codCliente);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                retorno = rs.getString("Nome");
            }

            //psmt.close();



        } catch (Exception excep) {
            excep.printStackTrace();
        }
        return retorno;
    }
}
