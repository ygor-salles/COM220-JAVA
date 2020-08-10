
public class Controlavel extends Personagem{

    private String jogadorID;
    
    // Constructor
    public Controlavel(String nomePersonagem, String jogadorID) {
        super(nomePersonagem);
        this.jogadorID = jogadorID;
    }

    public String getNomePersonagem() {
        return "Personagem Controlável " + super.getNomePersonagem();
    }

    public String getID() {
        return "Nome do Jogador: " + jogadorID;
    }

}
