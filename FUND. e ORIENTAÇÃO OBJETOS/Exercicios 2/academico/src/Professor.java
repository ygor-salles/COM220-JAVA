
public class Professor extends Pessoa {

    private String aTitMaxima = "";

    //Construtor da classe
    public Professor(String pNome, String pEndereco, String pSexo,
            int pIdade, String pTitMaxima) {
        super(pNome, pEndereco, pSexo, pIdade);
        aTitMaxima = pTitMaxima;
    }

    //Construtor da classe
    public Professor(String pNome, String pEndereco, String pSexo,
            int pIdade, String pTitMaxima, Disciplina pDisc[]) {
        super(pNome, pEndereco, pSexo, pIdade, pDisc);
        aTitMaxima = pTitMaxima;
    }

    //Construtor default
    public Professor() {
    }

    //Atribui a titulação máxima
    public void setTitMaxima(String pTitMaxima) {
        //Realiza o controle para verificar se a titulação é válida
        if ((!pTitMaxima.equalsIgnoreCase(Util.GRADUACAO))
                && (!pTitMaxima.equalsIgnoreCase(Util.ESPECIALIZACAO))
                && (!pTitMaxima.equalsIgnoreCase(Util.MESTRADO))
                && (!pTitMaxima.equalsIgnoreCase(Util.DOUTORADO))) {
            System.out.println("A titulação informada não é válida!!!");
        } else {
            aTitMaxima = pTitMaxima;
        }
    }

    //Recupera a titulação máxima
    public String getTitMaxima() {
        return aTitMaxima;
    }

}
