
package Vendedor;

/**
 *
 * @author Jean
 */
public class Venda {

    private int codImovel;
    private int mesVenda;
    private int anoVenda;
    private double valorVenda;

    public Venda(int pCodImovel, int pMesVenda, int pAnoVenda, double pValorVenda) {
        codImovel = pCodImovel;
        mesVenda = pMesVenda;
        anoVenda = pAnoVenda;
        valorVenda = pValorVenda;
    }

    public int getCodImovel() {
        return codImovel;
    }

    public int getMesVenda() {
        return mesVenda;
    }

    public int getAnoVenda() {
        return anoVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    
}
