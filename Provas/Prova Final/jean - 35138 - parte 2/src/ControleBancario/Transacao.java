package ControleBancario;

import java.util.*;

/**
 *
 * @author Jean
 */
public abstract class Transacao {

    private double valor;
    private Date data;

    public Transacao(double pValor, Date pData) {
        valor = pValor;
        data = pData;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }
}
