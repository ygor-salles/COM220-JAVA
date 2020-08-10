
import java.util.*;


public class Conta {
    private int nroConta;
    private String nomeCorrent;
    private double limite = 0;
    private String senha;
    private ArrayList<Transacao> transacoes = new ArrayList<>();

    public Conta(int pNroConta, String pNomeCorrent, double pLimite, String pSenha){
        nroConta = pNroConta;
        nomeCorrent = pNomeCorrent;
        limite = pLimite;
        senha = pSenha;
    }
    
    public int getNroConta() {
        return nroConta;
    }

    public String getNomeCorrent() {
        return nomeCorrent;
    }

    public double getLimite() {
        return limite;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList getTransacoes() {
        return transacoes;
    }
    
    public void adicionaDeposito(double pValor, Date pData, String pNomeDep){
        Transacao t = new Deposito(pValor, pData, pNomeDep);
        transacoes.add(t);
    }

    public boolean adicionaSaque(double pValor, Date pData, String pSenha){
        if (pSenha.equals(senha) && calculaSaldo() >= pValor){
            Transacao t = new Saque(pValor, pData, pSenha);
            transacoes.add(t);
            return true;
        }
        else return false;
    }    
    
    public boolean adicionaTransf(double pValor, Date pData, String pSenha, Conta pContaFav){
        if (!pSenha.equals(senha) || calculaSaldo() < pValor)
            return false;
        Transacao t1 = new Transferencia (pValor, pData, pSenha, "D");
        Transacao t2 = new Transferencia (pValor, pData, pSenha, "C");
        transacoes.add(t1);
        pContaFav.transacoes.add(t2);        
        return true;
    }
    
    public double calculaSaldo(){
        double saldo = getLimite();
        for(Transacao t: transacoes){
            if(t instanceof Transferencia){
                Transferencia transf = (Transferencia)t;
                if(transf.getTipo().equals("C"))
                    saldo += t.getValor();
                else
                    saldo -= t.getValor();
            }
            else 
                if(t instanceof Deposito)
                    saldo += t.getValor();
                else
                    saldo -= t.getValor();
        }
        return saldo;
    }
    
}
