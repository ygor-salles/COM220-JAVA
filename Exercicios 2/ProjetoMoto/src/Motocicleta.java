public class Motocicleta {
    private String marca;
    private String cor;
    private boolean motorLigado;
    
    public Motocicleta(String marca, String cor, boolean motorLigado){
        this.marca          = marca;
        this.cor            = cor;
        this.motorLigado    = motorLigado;
    }
    
    private void ligaMotor(){
        if(motorLigado == true){
            System.out.println("\nO motor já está ligado!");
        }else{
           motorLigado = true;
           System.out.println("\nMotor acaba de ser ligado!");
        }
    }
    
    private void mostraAtributos(){
        System.out.println("\nEsta motocicleta é uma "+marca+" "+cor);
        if(motorLigado == true){
            System.out.println("\nSeu motor está ligado!");
        }else{
            System.out.println("\nSeu motor está desligado!");
        }
    }
    
    public static void main(String args[]){
        Motocicleta m = new Motocicleta("Susuki", "Vermelha", false);
        //m.marca = "Suzuki";
        //m.cor   = "Vermelha";
        
       m.mostraAtributos();
       
       System.out.println("-----------------");
       m.ligaMotor();
       
       System.out.println("-----------------");
       m.mostraAtributos();
       
       System.out.println("-----------------");
       m.ligaMotor();        
    }
}