
import java.util.*;

public class controleConta {
        private Vector contas = new Vector();
        private limiteConta limite;

    public controleConta() {
        limite = new limiteConta(this);
    }
    
    public void criarConta(int pNroConta, String pNomeCorrent, double pLimite, String pSenha){
        contas.add(new Conta(pNroConta, pNomeCorrent, pLimite, pSenha));
    }
    
    public void adicionaDeposito(int pConta, double pValor, Date pData, String pNomeCorrent){
        for(Object v: contas){
            if(((Conta)(v)).getNroConta() == pConta){
                 ((Conta)(v)).adicionaDeposito(pValor, pData, pNomeCorrent);
            }
        }
    }
    
    public void adicionaSaque(int pConta, double pValor, Date pData, String pSenha){
        Conta c1 = null;
        for(Object v: contas){
            if(((Conta)(v)).getNroConta() == pConta){
                c1 = ((Conta)(v));
            }
        }
        
        c1.adicionaSaque(pValor, pData, pSenha);
    }
    
      public void adicionaTransferencia(int pConta, double pValor, String pSenha, int pNroConta){
          Conta c1 = null, c2=null;
          
          for(Object v: contas){
            if(((Conta)(v)).getNroConta() == pConta){
                c1 = ((Conta)(v));
            }
            if(((Conta)(v)).getNroConta() == pNroConta){
                c2 = ((Conta)(v));
            }
        }
         
         c1.adicionaTransf(pValor, new Date(), pSenha, c2);
    }
      
      public String getExtrato(int pConta){
          Conta c1 = null;
          String conta = "";
          
        for(Object v: contas){
            if(((Conta)(v)).getNroConta() == pConta){
                c1 = ((Conta)(v));
                System.out.println("Imprimindo aqui 1");
            }
          }
        
        if(c1 != null){
            ArrayList<Transacao> transacoes = c1.getTransacoes();
            
            for(Transacao t: transacoes){
                if(t instanceof Transferencia){
                     Transferencia transf = (Transferencia)t;
                         conta += t.getData()+ " " + t.getValor() + " "+transf.getTipo() + "\n";
                 }
                 else if(t instanceof Deposito){
                     Deposito dep = (Deposito)t;
                         conta +=  t.getData()+ " " + t.getValor() + " "+dep.getNomeDep() +" Depósito";
                 }
                else if(t instanceof Saque){
                     conta +=  t.getData()+ " " + t.getValor() + " "+"Saque ";
                }
            }
            

            System.out.println("Imprimindo aqui 2");
            conta += "\nSaldo: "+c1.calculaSaldo()+"\n";
        } 
        
        return conta;
      }
}
