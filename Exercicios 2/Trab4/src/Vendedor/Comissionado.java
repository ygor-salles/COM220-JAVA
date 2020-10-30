package Vendedor;

/**
 *
 * @author Jean
 */
public class Comissionado extends Vendedor{
    private String nroCPF;
    private float comissao;

    public Comissionado( int pCod, String pNome, String pNroCPF, float pComissao) {
        super(pCod, pNome);
        nroCPF = pNroCPF;
        comissao = pComissao/100;
    }

    public String getNroCPF() {
        return nroCPF;
    }

    public float getComissao() {
        return comissao;
    }    
    
    public double calculaRenda(int pMes, int pAno) {
        double var=0;
        
        for(Venda v: getVendas()){
            if(v.getAnoVenda() == pAno && v.getMesVenda() == pMes){
                var += v.getValorVenda()*getComissao();
            }
        }
        
        return var;
    }
    
    public String getDados() {
        
        String ven="";
        
        ven+="Codigo\tNome\t\tCPF\tComissao\n";
        ven += getCod()+
                "\t"+getNome()+
                "\t"+getNroCPF()+
                "\t"+(getComissao()*100)+"%\n";
                
        if(getVendas().size()>0)
            ven+="Vendas:\nCodigo\tData da Venda\tValor";
        
        for(Venda v: getVendas()){
            ven+="\n"+v.getCodImovel()+
                 "\t"+v.getMesVenda()+
                    "/"+v.getAnoVenda()+
                    "\t\t"+v.getValorVenda();
        }
        
        return ven;
    }    
}
