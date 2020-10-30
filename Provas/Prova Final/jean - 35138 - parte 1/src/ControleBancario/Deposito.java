package ControleBancario;

import java.util.*;

/**
 *
 * @author Jean
 */
public class Deposito extends Transacao {

    private String nomeDep;

    public Deposito(double pValor, Date pData, String pNomeDep) {
        super(pValor, pData);
        nomeDep = pNomeDep;
    }
}
