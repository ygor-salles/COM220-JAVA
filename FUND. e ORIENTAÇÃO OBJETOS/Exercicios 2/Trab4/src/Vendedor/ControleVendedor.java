package Vendedor;

import java.util.*;

/**
 *
 * @author Jean
 */
public class ControleVendedor {

    private LimiteVendedor limite;
    private Vector vendedores;

    public ControleVendedor() {
        vendedores = new Vector();
        limite = new LimiteVendedor(this);
    }

    public void inserirVendedorComissionado(int pCod, String pNome, String pNroCPF, float pComissao) {
        vendedores.add(new Comissionado(pCod, pNome, pNroCPF, pComissao));
    }

    public void inserirVendedorContratado(int pCod, String pNome, String pNroCarteiraTrabalho, double pSalarioFixo) {
        vendedores.add(new Contratado( pCod, pNome, pNroCarteiraTrabalho, pSalarioFixo));
    }
    public void inserirVenda(int pCod, int pCodImovel, int pMes, int pAno, double pValor) {
        for (Object v : vendedores) {

            if (((Vendedor) v).getCod() == pCod) {
                ((Vendedor) v).adicionaVenda(pCodImovel, pMes, pAno, pValor);
            }
        }
    }

    public String relatorioVendedores(int pMes, int pAno) {
        String ven = "", com = "Comissionado", con = "Contratado";
        ven += "Codigo\tNome\tSalario\t Tipo\n";
        double soma=0;

        for (Object v : vendedores) {

            ven += ((Vendedor) v).getCod() + "\t"
                    + ((Vendedor) v).getNome() + "\t"
                    + ((Vendedor) v).calculaRenda(pMes, pAno);

            if (v instanceof Comissionado) {
                ven += "\tComissionado";
            } else {
                ven += "\tContratado";
            }
            
            soma+=((Vendedor) v).calculaRenda(pMes, pAno);
        }
        
        ven+="\nTotal pago no mes: "+soma+"\n";

        return ven;
    }
    
    public static void main(String args[]){
        new ControleVendedor();
    }

}
