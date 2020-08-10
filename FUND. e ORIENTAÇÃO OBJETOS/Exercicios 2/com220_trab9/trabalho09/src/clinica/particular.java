package clinica;

import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public class particular extends paciente {

    private String cpf;

    public particular(String pNome, String pEndereco, String pCpf) {
        super(pNome, pEndereco);
        cpf = pCpf;
    }

    public void insereSessao(int pDia, int pMes, String pTipo, double pValor) {
        //sessao s = new sessao(pDia, pDia, pTipo, pValor);

    }

    public String getCpf() {
        return cpf;
    }

    public double calculaFaturamento(int pMes) {
        double fat = 0.0;

        for (sessao o : sessoes) {
            if(o.getMes() == pMes){
                fat += o.getValorSessao(o.getTipo());
            }
        }
        return fat;
    }

}
