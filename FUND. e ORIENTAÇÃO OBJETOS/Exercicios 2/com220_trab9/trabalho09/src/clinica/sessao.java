package clinica;

/**
 *
 * @author Jean
 */
public class sessao {

    private int dia, mes;
    private String tipo;

    public static final String ORTOPEDICA = "Ortopédica";
    public static final String RESPIRATORIA = "Respiratória";
    public static final String PILATES = "Pilates";

    public sessao(int pDia, int pMes, String pTipo) throws Exception {

        if (pTipo.equals(ORTOPEDICA) || pTipo.equals(RESPIRATORIA) || pTipo.equals(PILATES)) {
            setDia(pDia);
            setMes(pMes);
            setTipo(pTipo);

        } else {
            throw new Exception("Tipo de sessão inválida.");
        }
    }

    public void setDia(int pDia) {
        dia = pDia;
    }

    public void setMes(int pMes) {
        mes = pMes;
    }

    public void setTipo(String pTipo) {
        tipo = pTipo;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValorSessao(String tipo) {
        Double valor = 0.0;
        if (tipo.equals(ORTOPEDICA)) {
            valor = 50.00;
        }
        if (tipo.equals(RESPIRATORIA)) {
            valor = 60.00;
        }
        if (tipo.equals(PILATES)) {
            valor = 70.00;
        }
        return valor;
    }
}
