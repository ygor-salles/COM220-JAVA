package meiosdetransporte;

public class Bicicleta extends TransporteTerrestre implements Conduzivel {

    private int numeroRaios;

    public Bicicleta(String pNome, String pTipo, int pNumeroRaios) {
        setNome(pNome);
        setTipo(pTipo);
        
        numeroRaios = pNumeroRaios;
    }

    public Bicicleta(int numeroRaios) {
        this.numeroRaios = numeroRaios;
    }

    
    public void curvar(double angulo) {
        System.out.println(getNome() + "- virou " + angulo + "graus");
    }

    public void pedalar() {
    }
}
