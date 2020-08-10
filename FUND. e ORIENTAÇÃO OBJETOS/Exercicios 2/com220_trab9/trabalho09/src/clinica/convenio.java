package clinica;

/**
 *
 * @author Jean
 */
public class convenio extends paciente {

    private String nomeConvenio;
    private String nroCartao;

    public convenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        super(pNome, pEndereco);
        nomeConvenio = pNomeConvenio;
        nroCartao = pNroCartao;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public String getNroCartao() {
        return nroCartao;
    }

    public double calculaFaturamento(int pMes) {
        double fat = 0;
        for (sessao o : sessoes) {
            if(o.getMes() == pMes){
                fat += o.getValorSessao(o.getTipo());
            }
        }
        return fat;
    }

}
