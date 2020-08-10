// CLASSE FILHO HERDADA DE VEICUO
public class Motocicleta extends Veiculo{
    String estilo;
    // MÉTODO CONSTRUTOR MOTOCICLETA
    public Motocicleta(String marca, String cor, boolean motorLigado, String estilo){
        this.marca           = marca;
        this.cor             = cor;
        this.motorLigado     = motorLigado;
        this.estilo          = estilo;
    }
    // MÉTODO CONSTRUTOR MOSTRA ATRIBUTOS
    public void mostraAtributos(){
        String motor;
        if(this.motorLigado == true){
            motor = "ligado";
        }else{
            motor = "desligado";
        }
        
        System.out.println("\nMoto: "+marca+"\nEstilo: "+this.estilo+" \nCor: "+cor+"\nO motor está "+motor);
    }
}