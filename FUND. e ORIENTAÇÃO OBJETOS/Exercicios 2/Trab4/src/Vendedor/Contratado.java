
package Vendedor;

/**
 *
 * @author Jean
 */
public class Contratado extends Vendedor{
    private String nroCarteiraTrabalho;
    private double salarioFixo;
    private static final float comissao = 0.01f;

    public Contratado(int pCod, String pNome, String pNroCarteiraTrabalho, double pSalarioFixo) {
        super(pCod, pNome);
        nroCarteiraTrabalho = pNroCarteiraTrabalho;
        salarioFixo = pSalarioFixo;
    }

    public String getNroCarteiraTrabalho() {
        return nroCarteiraTrabalho;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public static float getComissao() {
        return comissao;
    }
    
    public double calculaRenda(int pMes, int pAno) {
        double var=0;
        
        for(Venda v: getVendas()){
            if(v.getAnoVenda() == pAno && v.getMesVenda() == pMes){
                var += v.getValorVenda()*getComissao();
            }
        }
        
        return (var+salarioFixo);
    }

    public String getDados() {
        String ven = "";
        
        ven+="Codigo\tNome\t\tNº de Trablho\tSalario\n";
        
        ven +=  getCod()+
                "\t"+getNome()+
                "\t"+getNroCarteiraTrabalho()+
                "\t\t"+getSalarioFixo()+"\n";   
        
        if(getVendas().size()>0)
            ven+="Vendas:\nCodigo\tData da Venda\tValor";
        
        for(Venda v: getVendas()){
            ven+="\n"+v.getCodImovel()+
                 "\t"+v.getMesVenda()+
                    "/"+v.getAnoVenda()+
                    "\t\t"+v.getValorVenda();
        }
        return  ven;             
    }
 }
