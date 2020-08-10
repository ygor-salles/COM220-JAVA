package meiosdetransporte;

public class Aviao extends TransporteAereo implements Conduzivel, Motorizado {

    private int numeroMotores = 0;

    public Aviao(String pNome, int pNumeroMotores) {
        setNome(pNome);
        
        numeroMotores = pNumeroMotores;
    }

    public void curvar(double angulo) {
        System.out.println(getNome() + " virou " + angulo + "graus");
    }

    public void abastecer() {
        System.out.println(getNome() + " foi abastecido");
    }

    public void ligarMotor() {
        System.out.println("Motor do " + getNome() + " foi ligado");
    }

}
