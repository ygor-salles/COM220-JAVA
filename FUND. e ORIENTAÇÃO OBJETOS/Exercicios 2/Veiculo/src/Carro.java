// CLASSE FILHO HERDADA DE VEICULO
public class Carro extends Veiculo{
    private boolean portaMalasCheio;
    // MÉTODO CONSTRUTOR DO CARRO
    public Carro(String marca, String cor, boolean motorLigado, boolean portaMalasCheio){
        this.marca           = marca;
        this.cor             = cor;
        this.motorLigado     = motorLigado;
        this.portaMalasCheio = portaMalasCheio;
    }
    // MÉTODO PARA ENCHER/ESVAZIAR PORTA MALAS
    public void portaMalasCheio(boolean estado){
        if(estado){
            if(this.portaMalasCheio == true){
                System.out.println("\nPorta malas da "+marca+" está cheio");
            }else{
                this.portaMalasCheio = true;
                System.out.println("\nO porta malas da "+marca+" foi cheio");
            }
        }else{
            if(this.portaMalasCheio == false){
                System.out.println("O porta malas da "+marca+" não está cheio");
            }else{
                this.portaMalasCheio = false;
                System.out.println("O porta malas da "+marca+" foi esvaziado");
            }
        }
    }
    // MÉTODO PARA MOSTRAR OS ATRIBUTOS
    public void mostraAtributos(){
        String motor, portaMalas;
        if(this.motorLigado == true){
            motor = "ligado";
        }else{
            motor = "desligado";
        }if(this.portaMalasCheio == true){
            portaMalas = "Cheio";
        }else{
            portaMalas = "Não está cheio";
        }
        
        System.out.println("\nCarro: "+marca+"\ncor: "+cor+"\nO motor esta "+motor+"\nO porta malas está "+portaMalas);
    }
}