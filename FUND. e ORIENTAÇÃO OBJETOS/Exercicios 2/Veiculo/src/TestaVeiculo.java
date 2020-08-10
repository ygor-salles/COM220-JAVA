// CLASSE PRINCIPAL PARA TESTAR AS CLASSES
public class TestaVeiculo{
    public static void main(String[] args){
        Carro carro = new Carro("Ford", "Preto", false, false);
        Motocicleta moto = new Motocicleta("Honda", "Vermelha", false, "Trail");

        moto.ligaDesligaMotor(true);
        moto.mostraAtributos();

        carro.portaMalasCheio(true);
        carro.ligaDesligaMotor(true);
        carro.mostraAtributos();
    }
}