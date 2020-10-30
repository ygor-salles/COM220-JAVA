package meiosdetransporte;

public class Carro extends TransporteTerrestre implements Conduzivel, Motorizado {

    private int numeroCilindrada = 0;

    public Carro(String pNome, String pTipo, int pNC) {
        setNome(pNome);
        setTipo(pTipo);
        
        numeroCilindrada = pNC;
    }
    
    public void abastecer() {
        System.out.println("Motor do " + getNome() + " foi abastecidoo");
    }

    public void ligarMotor() {
        System.out.println("Motor do " + getNome() + " foi ligado");
    }

    public void embrear() {
    }

    public void curvar(double angulo) {
        System.out.println(getNome() + " virou " + angulo + " graus");
    }
}
