/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.util.Date;

/**
 *
 * @author cascao
 */
public class Aluguel {
    private int codDvd;
    private int codCliente;
    private Date dataRetirada;
    private Date dataDevolucao;
    private float valorDev;

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodDvd() {
        return codDvd;
    }

    public void setCodDvd(int codDvd) {
        this.codDvd = codDvd;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public float getValorDev() {
        return valorDev;
    }

    public void setValorDev(float valorDev) {
        this.valorDev = valorDev;
    }
    
}
