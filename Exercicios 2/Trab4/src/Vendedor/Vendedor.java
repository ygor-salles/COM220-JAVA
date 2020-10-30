package Vendedor;

import java.util.*;

/**
 *
 * @author Jean
 */
public abstract class Vendedor {

    private int cod;
    private String Nome;
    private ArrayList<Venda> vendas;

    public Vendedor(int pCod, String pNome) {
        cod = pCod;
        Nome = pNome;
        vendas = new ArrayList<Venda>();
    }

    public void adicionaVenda(int pCodImovel, int pMes, int pAno, double pValor) {
        vendas.add(new Venda(pCodImovel, pMes, pAno, pValor));
    }

    public abstract String getDados();

    public abstract double calculaRenda(int pMes, int pAno);

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return Nome;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

}
