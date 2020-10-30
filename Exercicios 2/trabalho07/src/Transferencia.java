
import java.util.Date;


public class Transferencia extends Transacao {
    private String tipo;
    private String senha;
    
    public Transferencia(double pValor, Date pData, String pSenha, String pTipo){
        super(pValor, pData);
        tipo = pTipo;
        senha = pSenha;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public String getSenha(){
        return senha;
    }
    
}
