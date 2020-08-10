
public class NaoControlavel extends Personagem{

    private String iaID;
// Constructor

    public NaoControlavel(String nomePersonagem, String iaID) {
        super(nomePersonagem);
        this.iaID = iaID;
    }

    public String getNomePersonagem() {
        return "Personagem NÃO Controlável " + super.getNomePersonagem();
    }

    public String getID() {
        return "Inteligencia Artifical do Tipo: " + iaID;
    }

}
